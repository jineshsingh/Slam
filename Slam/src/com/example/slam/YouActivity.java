package com.example.slam;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class YouActivity extends Activity implements View.OnClickListener
{
    private static final int CAMERA_PIC_REQUEST = 0;

    EditText name = null, nick_name = null, contact = null, address = null,email_id = null, best_friends = null, friends = null, love = null, money = null, dress = null, idol = null, everything = null;
    
    String imagePath;
    
    Button update = null;

    
    ImageView image = null, new_img = null;
    
    Context context;
    
    SQLiteDatabase myDatabase = null;
	
    @Override
	protected void onCreate(Bundle savedInstanceState)
    {
		try
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_you);

        update  = (Button) findViewById(R.id.updatebutton);
        name = (EditText)findViewById(R.id.name);
        nick_name = (EditText)findViewById(R.id.nick_name);
        contact = (EditText)findViewById(R.id.contact_num);
        address = (EditText)findViewById(R.id.address);
        email_id = (EditText)findViewById(R.id.email_id);
        best_friends = (EditText)findViewById(R.id.best_friends);
        friends = (EditText)findViewById(R.id.friends);
        love = (EditText)findViewById(R.id.love);
        money = (EditText)findViewById(R.id.money);
        idol = (EditText)findViewById(R.id.idol);
        everything = (EditText)findViewById(R.id.everything);
        dress = (EditText)findViewById(R.id.dress);
        
        
       

        update.setOnClickListener(this);

        image = (ImageView)findViewById(R.id.cameraClick);
        new_img = (ImageView)findViewById(R.id.imageView1);
        image.setOnClickListener(this);
        
        Typeface attribute = Typeface.createFromAsset(getAssets(), "editfont.ttf");
        
        name.setTypeface(attribute);
        nick_name.setTypeface(attribute);
        contact.setTypeface(attribute);
        address.setTypeface(attribute);
        email_id.setTypeface(attribute);
        best_friends.setTypeface(attribute);
        friends.setTypeface(attribute);
        love.setTypeface(attribute);
        money.setTypeface(attribute);
        idol.setTypeface(attribute);
        everything.setTypeface(attribute);
        dress.setTypeface(attribute);
        
        InputFilter filter = new InputFilter() 
        { 
        	@Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) 
        	{ 
                    for (int i = start; i < end; i++)
                    { 
                    	if (!Character.isLetterOrDigit(source.charAt(i)) && !Character.isSpaceChar(source.charAt(i))) { 
                    		return " ,"; 
                   	} 
            } 
            return null; 
       	}
 }; 

 		name.setFilters(new InputFilter[]{filter});
 		nick_name.setFilters(new InputFilter[]{filter});
 		contact.setFilters(new InputFilter[]{filter});;
 		address.setFilters(new InputFilter[]{filter});
 		
 		best_friends.setFilters(new InputFilter[]{filter});
 		friends.setFilters(new InputFilter[]{filter});
 		love.setFilters(new InputFilter[]{filter});
 		idol.setFilters(new InputFilter[]{filter});
 		everything.setFilters(new InputFilter[]{filter});
 		dress.setFilters(new InputFilter[]{filter});
        
 	
        
		}
		catch(Exception ex)
		{
			Log.i("You error", ex.toString());
		}

	}


    @Override
    public void onClick(View view)
    {
    	try
    	{	
    		 if(!contact.getText().toString().equals(""))
    		 {
    			 General.CurContactNo = Long.parseLong(contact.getText().toString());
    		 }
            switch(view.getId())
            {
                case R.id.updatebutton:
                    insertIntoDB();
                    break;
                
                case R.id.cameraClick:
                	Toast.makeText(this, "camera", Toast.LENGTH_LONG).show();
                	startActivityForResult( new Intent( MediaStore.ACTION_IMAGE_CAPTURE ), CAMERA_PIC_REQUEST );
                    break;
                   
            }
             
           
        }
    	catch(Exception ex)
    	{
    		Log.i("Error On Click", ex.toString());
    	}
    }
    @Override
	public void onBackPressed()
    {
	    startActivity(new Intent(this, SelectAct.class));
	}
    
    

    public void insertIntoDB()
    {
        try
        {
        	General.name = name.getText().toString();
            myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
            
            General.QUERY = " create table if not exists "+General.DATABASE_TABLE+"(name text not null,"+"nick_name text not null,"+"contact text primary key,"+"address text not null,"+"email text not null,"+"best_friends text not null,"+"friends text not null,"+"love text not null,"+"money text not null,"+"dress text not null,"+"idol text not null,"+"everything text not null,"+"image text not null," +
            		""+"fav_cuisine text not null,"+"fav_restro text not null,"+"fav_chaupaty text not null,"+"fast_food text not null,"+"taste text not null,"+"fav_desert text not null,"+"fav_drink text not null," +
            		""+"fav_song text not null,"+"fav_singer text not null,"+"fav_movie text not null,"+"fav_actor text not null,"+"fav_actress text not null,"+"fav_dance text not null,"+"fav_dancer text not null,"+"fav_dialogue text not null," +
            		""+"call_me text not null,"+"my_strength text not null,"+"my_weakness text not null,"+"words text not null,"+"change text not null,"+"record_uri text not null," +
            		""+"fav_book text not null,"+"fav_auth text not null,"+"fav_desti text not null,"+"fav_island text not null,"+"fav_male text not null,"+"fav_female text not null," +
            		""+"fav_outd text not null,"+"fav_team text not null,"+"fav_ind text not null,"+"fav_spm text not null,"+"achieve text not null);";
          
            myDatabase.execSQL(General.QUERY);
            
            String Sname = name.getText().toString();
            String Snick_name = nick_name.getText().toString();
            String Scontact = contact.getText().toString();
            String Saddress = address.getText().toString();
            String Semail = email_id.getText().toString();
            String Sbset_friends = best_friends.getText().toString();
            String Sfriend = friends.getText().toString();
            String Slove = love.getText().toString();
            String Smoney = money.getText().toString();
            String Sdress = dress.getText().toString();
            String Sidol = idol.getText().toString();
            String Severything = everything.getText().toString();
            

            General.QUERY = " INSERT INTO "+General.DATABASE_TABLE+" ('name', 'nick_name', 'contact', 'address', 'email', 'best_friends', 'friends', 'love', 'money', 'dress', 'idol', 'everything', 'image', " +
            															"'fav_cuisine', 'fav_restro', 'fav_chaupaty', 'fast_food', 'taste', 'fav_desert', 'fav_drink'," +
            															"'fav_song', 'fav_movie', 'fav_singer', 'fav_actor', 'fav_actress', 'fav_dance', 'fav_dancer', 'fav_dialogue', " +
            															"'call_me', 'my_strength', 'my_weakness', 'words', 'change', 'record_uri', " +
            															" 'fav_book', 'fav_auth', 'fav_desti', 'fav_island', 'fav_male', 'fav_female', " +
            															"'fav_outd', 'fav_team', 'fav_ind','fav_spm', 'achieve') " +
            													"VALUES('"+Sname+"','"+Snick_name+"','"+Scontact+"','"+Saddress+"','"+Semail+"','"+Sbset_friends+"','"+Sfriend+"','"+Slove+"','"+Smoney+"','"+Sdress+"','"+Sidol+"','"+Severything+"','"+imagePath+"', " +
            															"'null', 'null', 'null', 'null', 'null', 'null', 'null'," +
            															" 'null', 'null', 'null', 'null', 'null', 'null', 'null', 'null', " +
            															"'null', 'null', 'null', 'null', 'null', 'null', " +
            															"'null', 'null', 'null', 'null', 'null', 'null', " +
            															"'null', 'null', 'null', 'null', 'null');";
            myDatabase.execSQL(General.QUERY);
            Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
            
            
        }
        catch(Exception ex)
        {
           Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        try
        {
            super.onActivityResult(requestCode, resultCode, data);
            if( requestCode == CAMERA_PIC_REQUEST)
            {
                Bitmap thumbnail = (Bitmap) data.getExtras().get("data");

                image.setImageBitmap(thumbnail);
                               
                String root = Environment.getExternalStorageDirectory().toString();
                File myDir = new File(root + "/slambook");
                myDir.mkdirs();
                
                String fname = name.getText().toString()+".jpg";
                File file = new File (myDir, fname);
                if (file.exists ())
                	file.delete (); 
                try 
                {
                       FileOutputStream out = new FileOutputStream(file);
                       thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, out);
                
                       imagePath = file.getPath();
                       out.flush();
                       out.close();

                } 
                catch (Exception e) 
                {
                       Log.i("File Creation", e.toString());
                }
                
            }
            else
            {
                Toast.makeText(this, "Picture Not taken", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e)
        {
            Log.i(" :You Error :", e.toString() );
        }
    }


}
