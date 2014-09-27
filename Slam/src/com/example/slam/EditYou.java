 package com.example.slam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class EditYou extends Activity implements View.OnClickListener
{

    EditText name = null, nick_name = null, contact = null, address = null, email_id = null, best_friends = null, friends = null, love = null, money = null, dress = null, idol = null, everything = null,
    		 fav_cuisine = null, fav_restro = null, fav_chaupaty = null, fast_food = null, fav_desert = null, fav_drink = null,
    		 fav_song = null, fav_movie = null, fav_singer = null, fav_actor = null, fav_actress = null, fav_dance = null, fav_dancer = null, fav_dialogue = null,
    		 call_me = null, my_strength = null, my_weakness = null, words = null, change = null,
    		 fav_book = null, fav_auth = null,  fav_desti = null, fav_island = null, fav_male = null, fav_female = null,
    		 fav_outd = null, fav_ind = null, fav_team = null, fav_spm = null, achieve = null;
   
    Spinner taste = null;
    
    String get_name, Ename, Enick_name, Econtact, Eaddress, Eemail, Ebest_friends, Efriends, Elove, Emoney, Edress, Eidol, Eeverything,
    		Efav_cuisine, Efav_restro, Efav_chaupaty, Efast_food, Efav_desert, Efav_drnk,
    		Efav_song, Efav_movie, Efav_singer, Efav_actor, Efav_actress, Efav_dance, Efav_dancer, Efav_dialog,
    		Ecall_me, Emy_strength, Emy_weakness, Ewords, Echange,
    		Efav_book, Efav_auth, Efav_desti, Efav_island, Efav_male, Efav_female,
       		Efav_outd, Efav_ind, Efav_team, Efav_spm, Eachieve;

    Button update_edit = null;

    TextView watch = null;

    ImageView image = null;
    
    SQLiteDatabase myDatabase = null;
	
    @Override
	protected void onCreate(Bundle savedInstanceState)
    {
		try
		{
			setTheme(General.CurTheme);
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_edit_you);
			myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
			
			get_name = getIntent().getExtras().getString("getname");
			
			General.QUERY = " Select * from "+General.DATABASE_TABLE+" where name = '"+get_name+"';";
			Cursor rs = myDatabase.rawQuery(General.QUERY, null);
			
			name = (EditText)findViewById(R.id.name);
			update_edit = (Button) findViewById(R.id.update_edit);
			update_edit.setOnClickListener(this);
			
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
        	
        	fav_cuisine = (EditText) findViewById(R.id.fav_cuisine);
	    	fav_restro = (EditText) findViewById(R.id.fav_resto);
	    	fav_chaupaty = (EditText) findViewById(R.id.fav_chaupaty);
	    	fast_food = (EditText) findViewById(R.id.fast_food);
	    	fav_desert = (EditText) findViewById(R.id.fav_desert);
	    	fav_drink = (EditText) findViewById(R.id.fav_drink);
		    taste = (Spinner) findViewById(R.id.taste);
		    
		    fav_song = (EditText) findViewById(R.id.fav_song);
	    	fav_movie = (EditText) findViewById(R.id.fav_movie);
	    	fav_singer = (EditText) findViewById(R.id.fav_singer);
	    	fav_actor = (EditText) findViewById(R.id.fav_actor);
	    	fav_actress = (EditText) findViewById(R.id.fav_actress);
	    	fav_dance = (EditText) findViewById(R.id.fav_dance);
	    	fav_dancer = (EditText) findViewById(R.id.fav_dancer);
	    	fav_dialogue = (EditText) findViewById(R.id.fav_dialogue);
	    	
	    	call_me = (EditText) findViewById(R.id.call_me);
	    	my_strength = (EditText) findViewById(R.id.my_strength);
	    	my_weakness = (EditText) findViewById(R.id.my_weakness);
	    	words = (EditText) findViewById(R.id.words);
	    	change = (EditText) findViewById(R.id.change);
	    	
	    	fav_book = (EditText) findViewById(R.id.fav_book);
	    	fav_auth = (EditText) findViewById(R.id.fav_auth);	    	
	    	fav_island = (EditText) findViewById(R.id.fav_island);
	    	fav_desti = (EditText) findViewById(R.id.fav_desti);
	    	fav_male = (EditText) findViewById(R.id.fav_male);
	    	fav_female = (EditText) findViewById(R.id.fav_female);
		    
        	fav_outd = (EditText) findViewById(R.id.fav_outd);
	    	fav_ind = (EditText) findViewById(R.id.fav_ind);
	    	fav_spm = (EditText) findViewById(R.id.fav_spm);
	    	fav_team = (EditText) findViewById(R.id.fav_team);
	    	achieve = (EditText) findViewById(R.id.achieve);
	    	
        
        	if( rs != null )
        	{
        		rs.moveToFirst();
        		name.setText(rs.getString(0));
        		
        		nick_name.setText(rs.getString(1));
        		
        		contact.setText(rs.getString(2));
        		
        		address.setText(rs.getString(3));
        		
        		email_id.setText(rs.getString(4));
        		
        		best_friends.setText(rs.getString(5));
        		
        		friends.setText(rs.getString(6));
        		
        		love.setText(rs.getString(7));
        		
        		money.setText(rs.getString(8));
        		
        		dress.setText(rs.getString(9));
        		
        		idol.setText(rs.getString(10));
        		
        		everything.setText(rs.getString(11));
        		
        		
        		fav_cuisine.setText(rs.getString(13));
        		
        		fav_restro.setText(rs.getString(14));
        		
        		fav_chaupaty.setText(rs.getString(15));
        		
        		fast_food.setText(rs.getString(16));
        	
        		fav_desert.setText(rs.getString(18));
        		
        		fav_drink.setText(rs.getString(19));
        		
        		
        		fav_song.setText(rs.getString(20));
        		
        		fav_singer.setText(rs.getString(21));
        		
        		fav_movie.setText(rs.getString(22));
        		
        		fav_actor.setText(rs.getString(23));
        		
        		fav_actress.setText(rs.getString(24));
        		
        		fav_dance.setText(rs.getString(25));
        		
        		fav_dancer.setText(rs.getString(26));
        		
        		fav_dialogue.setText(rs.getString(27));
        		
        		
        		call_me.setText(rs.getString(28));
        		
        		my_strength.setText(rs.getString(29));
        		
        		my_weakness.setText(rs.getString(30));
        		
        		words.setText(rs.getString(31));
        		
        		change.setText(rs.getString(32));
        		
        		
        		fav_book.setText(rs.getString(39));
        		
        		fav_auth.setText(rs.getString(40));
        		
        		fav_desti.setText(rs.getString(41));
        		
        		fav_island.setText(rs.getString(42));
        		
        		fav_male.setText(rs.getString(43));
        		
        		fav_female.setText(rs.getString(44));
        		
        		
        		fav_outd.setText(rs.getString(34));
        		
        		fav_team.setText(rs.getString(35));
        		
        		fav_ind.setText(rs.getString(36));
        		
        		fav_spm.setText(rs.getString(37));
        		
        		achieve.setText(rs.getString(38));
        		
        		
        		
        	}
        	InputFilter filter = new InputFilter() 
            { 
            	@Override
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) 
            	{ 
                        for (int i = start; i < end; i++)
                        { 
                        	if (!Character.isLetterOrDigit(source.charAt(i)) && !Character.isSpaceChar(source.charAt(i))) { 
                        		return ""; 
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
     		
     		fav_cuisine.setFilters(new InputFilter[]{filter});
     		 fav_restro.setFilters(new InputFilter[]{filter});
     		 fav_chaupaty.setFilters(new InputFilter[]{filter});
     		 fast_food.setFilters(new InputFilter[]{filter});
     		 fav_desert.setFilters(new InputFilter[]{filter});
     		 fav_drink.setFilters(new InputFilter[]{filter});
     		 
     		 fav_song.setFilters(new InputFilter[]{filter});
     		 fav_movie.setFilters(new InputFilter[]{filter});
     		 fav_singer.setFilters(new InputFilter[]{filter});
     		 fav_actor.setFilters(new InputFilter[]{filter});
     		 fav_actress.setFilters(new InputFilter[]{filter});
     		 fav_dance.setFilters(new InputFilter[]{filter});
     		 fav_dancer.setFilters(new InputFilter[]{filter});
     		 fav_dialogue.setFilters(new InputFilter[]{filter});
     		    	
     		call_me.setFilters(new InputFilter[]{filter});
     		 my_strength.setFilters(new InputFilter[]{filter});
     		 my_weakness.setFilters(new InputFilter[]{filter});
     		 words.setFilters(new InputFilter[]{filter});
     		 change.setFilters(new InputFilter[]{filter});
     		 
     		fav_outd.setFilters(new InputFilter[]{filter});
     		 fav_ind.setFilters(new InputFilter[]{filter});
     		 fav_spm.setFilters(new InputFilter[]{filter});
     		 fav_team.setFilters(new InputFilter[]{filter});
     		 achieve.setFilters(new InputFilter[]{filter});   	
     				
     		fav_book.setFilters(new InputFilter[]{filter});
     		 fav_auth.setFilters(new InputFilter[]{filter});
     		 fav_island.setFilters(new InputFilter[]{filter});
     		 fav_desti.setFilters(new InputFilter[]{filter});
     		 fav_male.setFilters(new InputFilter[]{filter});
     		 fav_female.setFilters(new InputFilter[]{filter});
        	
       
  		}
		catch(Exception ex)
		{
			Log.i("You error", ex.toString());
		}

		
	}
	@Override
	public void onClick(View arg0) 
	{
		Ename = name.getText().toString();
		Enick_name = nick_name.getText().toString();
		Econtact = contact.getText().toString();
		Eaddress = address.getText().toString();
		Eemail = email_id.getText().toString();
		Ebest_friends = best_friends.getText().toString();
		Efriends = friends.getText().toString();
		Elove = love.getText().toString();
		Emoney = money.getText().toString();
		Edress = dress.getText().toString();
		Eidol = idol.getText().toString();
		Eeverything = everything.getText().toString();
		Efav_cuisine = fav_cuisine.getText().toString();
		Efav_restro = fav_restro.getText().toString();
		Efav_chaupaty = fav_chaupaty.getText().toString();
		Efast_food = fast_food.getText().toString();
		Efav_desert = fav_desert.getText().toString();
		Efav_drnk = fav_drink.getText().toString();
		Efav_song = fav_song.getText().toString();
		Efav_singer = fav_singer.getText().toString();
		Efav_movie = fav_movie.getText().toString();
		Efav_actor = fav_actor.getText().toString();
		Efav_actress = fav_actress.getText().toString();
		Efav_dance = fav_dance.getText().toString();
		Efav_dancer = fav_dancer.getText().toString();
		Efav_dialog = fav_dialogue.getText().toString();
		Ecall_me = call_me.getText().toString();
		Emy_strength = my_strength.getText().toString();
		Emy_weakness = my_weakness.getText().toString();
		Ewords = words.getText().toString();
		Echange = change.getText().toString();
		Efav_book = fav_book.getText().toString();
		Efav_auth = fav_actor.getText().toString();
		Efav_desti = fav_desti.getText().toString();
		Efav_island = fav_island.getText().toString();
		Efav_male = fav_male.getText().toString();
		Efav_female = fav_female.getText().toString();
		Efav_outd = fav_outd.getText().toString();
		Efav_team = fav_team.getText().toString();
		Efav_ind = fav_ind.getText().toString();
		Efav_spm = fav_spm.getText().toString();
		Eachieve = achieve.getText().toString();
		
		myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
		General.QUERY = " update " +General.DATABASE_TABLE+ " set name = '"+Ename+"', nick_name = '"+Enick_name+"', contact ='"+Econtact+"' , address = '"+Eaddress+"', email = '"+Eemail+"', best_friends ='"+Ebest_friends+"' , friends = '"+Efriends+"', love = '"+Elove+"', money = '"+Emoney+"', dress ='"+Edress+"' , idol = '"+Eidol+"', everything = '"+Eeverything+"', fav_cuisine = '"+Efav_cuisine+"' , fav_restro = '"+Efav_restro+"', fav_chaupaty ='"+Efav_chaupaty+"' , fast_food ='"+Efast_food+"' , taste = '"+taste+"', fav_desert ='"+Efav_desert+"' , fav_drink = '"+Efav_drnk+"',fav_song ='"+Efav_song+"' , fav_movie ='"+Efav_movie+"' , fav_singer ='"+Efav_singer+"' , fav_actor = '"+Efav_actor+"', fav_actress ='"+Efav_actress+"' , fav_dance ='"+Efav_dance+"' , fav_dancer = '"+Efav_dancer+"', fav_dialogue = '"+Efav_dialog+"', call_me = '"+Ecall_me+"', my_strength ='"+Emy_strength+"' , my_weakness =  '"+Emy_weakness+"', words = '"+Ewords+"' , change ='"+Echange+"', fav_book ='"+Efav_book+"' ,fav_auth ='"+Efav_auth+"' , fav_desti ='"+Efav_desti+"' , fav_island ='"+Efav_island+"' , fav_male = '"+Efav_male+"', fav_female ='"+Efav_female+"' , fav_outd ='"+Efav_outd+"' , fav_team ='"+Efav_team+"' , fav_ind ='"+Efav_ind+"' ,fav_spm = '"+Efav_spm+"' , achieve ='"+Eachieve+"'  " +
			 				"where name = '"+get_name+"' "  ;
		Toast.makeText(this, "UPDATED", Toast.LENGTH_SHORT).show();
		myDatabase.execSQL(General.QUERY);
		Intent i1 = new Intent(this, SelectAct.class);
		startActivity(i1);
	}
}