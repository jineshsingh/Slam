package com.example.slam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MediaActivity extends Activity implements OnClickListener
{

		EditText fav_song = null, fav_movie = null, fav_singer = null, fav_actor = null, fav_actress = null, fav_dance = null, fav_dancer = null, fav_dialogue = null;   
	    
	    Button update = null;
	    SQLiteDatabase myDatabase = null;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		
		
		try
	   	{
	    	setTheme(General.CurTheme);
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.activity_media);
		
	    	fav_song = (EditText) findViewById(R.id.fav_song);
	    	fav_movie = (EditText) findViewById(R.id.fav_movie);
	    	fav_singer = (EditText) findViewById(R.id.fav_singer);
	    	fav_actor = (EditText) findViewById(R.id.fav_actor);
	    	fav_actress = (EditText) findViewById(R.id.fav_actress);
	    	fav_dance = (EditText) findViewById(R.id.fav_dance);
	    	fav_dancer = (EditText) findViewById(R.id.fav_dancer);
	    	fav_dialogue = (EditText) findViewById(R.id.fav_dialogue);
		    
		 
		 
	    	update = (Button) findViewById(R.id.updatemedia);
		
	    	update.setOnClickListener(this);
	    	
	    	Typeface attribute = Typeface.createFromAsset(getAssets(), "editfont.ttf");
	    	fav_song.setTypeface(attribute);
	    	fav_movie.setTypeface(attribute);
	    	fav_singer.setTypeface(attribute);
	    	fav_actor.setTypeface(attribute);
	    	fav_actress.setTypeface(attribute);
	    	fav_dance.setTypeface(attribute);
	    	fav_dancer.setTypeface(attribute);
	    	fav_dialogue.setTypeface(attribute);
	    	
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
	 
	 fav_song.setFilters(new InputFilter[]{filter});
	 fav_movie.setFilters(new InputFilter[]{filter});
	 fav_singer.setFilters(new InputFilter[]{filter});
	 fav_actor.setFilters(new InputFilter[]{filter});
	 fav_actress.setFilters(new InputFilter[]{filter});
	 fav_dance.setFilters(new InputFilter[]{filter});
	 fav_dancer.setFilters(new InputFilter[]{filter});
	 fav_dialogue.setFilters(new InputFilter[]{filter});
	    	
	   	}
	    catch(Exception ex)
	    {
	    	Log.i("Media Error", ex.toString());
	    	
	    }
	}

	@Override
	public void onClick(View v)
	{
		
			updateDb();
	}
	@Override
	public void onBackPressed()
    {
	    startActivity(new Intent(this, SelectAct.class));
	}
			
		public void updateDb()
		{
			try
			{
		    	 String Contact = String.valueOf(General.CurContactNo);
				 String Sfav_song = fav_song.getText().toString();
				 String Sfav_movie = fav_movie.getText().toString();
				 String Sfav_singer = fav_singer.getText().toString();
				 String Sfav_actor = fav_actor.getText().toString();
				 String Sfav_actress = fav_actress.getText().toString();
				 String Sfav_dance = fav_dance.getText().toString();
				 String Sfav_dancer = fav_dancer.getText().toString();
				 String Sfav_dialogue = fav_dialogue.getText().toString();
				
				 myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
				
				 General.QUERY = " update "+General.DATABASE_TABLE+ " set fav_song = '"+Sfav_song+"', fav_movie = '"+Sfav_movie+"',fav_singer = '"+Sfav_singer+"', fav_actor = '"+Sfav_actor+"',  fav_actress = '"+Sfav_actress+"', fav_dance = '"+Sfav_dance+"', fav_dancer = '"+Sfav_dancer+"', fav_dialogue = '"+Sfav_dialogue+"' " +
				 		   "where contact = '"+Contact+"' "  ;
				
			
				 myDatabase.execSQL(General.QUERY);
				 Toast.makeText(getApplicationContext(), " Data Inserted", Toast.LENGTH_SHORT).show();
				
			}
			catch(Exception ex)
			{
			    Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
				
			}
		}
}