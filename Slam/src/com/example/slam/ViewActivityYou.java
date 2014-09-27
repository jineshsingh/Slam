package com.example.slam;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewActivityYou extends Activity implements OnClickListener
{
	String image_uri = null, audio_uri= null, name = null, nick_name = null, contact = null, address = null, email_id = null, best_friends = null, friends = null, love = null, money = null, dress = null, idol = null, everything = null,
			 fav_cuisine = null, fav_restro = null, fav_chaupaty = null, fast_food = null,  taste = null, fav_desert = null, fav_drink = null,
			fav_song = null, fav_movie = null, fav_singer = null, fav_actor = null, fav_actress = null, fav_dance = null, fav_dancer = null, fav_dialogue = null,
			call_me = null, my_strength = null, my_weakness = null, words = null, change = null,
			fav_outd = null, fav_ind = null, fav_team = null, fav_spm = null, achieve = null,
			fav_book = null, fav_auth = null,  fav_desti = null, fav_island = null, fav_male = null, fav_female = null;
							 ;
	ExpandableListAdapter listAdapter;
	
	String get_name, audio_path;
	Button play = null;
	ImageView view_image = null;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    
    
    SQLiteDatabase myDatabase = null;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
    	setTheme(General.CurTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activity_you);
        view_image = (ImageView) findViewById(R.id.imageView01);
        
        myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
        
        play = (Button) findViewById(R.id.playButton);
        get_name = getIntent().getExtras().getString("getname");
        General.QUERY = " Select * from "+General.DATABASE_TABLE+" where name = '"+get_name+"';";
        Cursor rs = myDatabase.rawQuery(General.QUERY, null);
       try
       {
        if( rs != null )
        {
        	
        	rs.moveToFirst();
        	name = rs.getString(0);
        	nick_name = rs.getString(1);
        	contact = rs.getString(2) ;
        	address = rs.getString(3);
        	email_id = rs.getString(4);
        	best_friends = rs.getString(5);
        	friends = rs.getString(6);
        	love = rs.getString(7);
        	money = rs.getString(8);
        	dress = rs.getString(9);
        	idol = rs.getString(10);
        	everything = rs.getString(11);
        	image_uri = rs.getString(12);
        	
        	fav_cuisine = rs.getString(13);
        	fav_restro= rs.getString(14);
        	fav_chaupaty = rs.getString(15) ;
        	fast_food = rs.getString(16);
        	taste = rs.getString(17);
        	fav_desert = rs.getString(18);
        	fav_drink = rs.getString(19);
        	
        	fav_song= rs.getString(20);
        	fav_singer= rs.getString(21) ;
        	fav_movie= rs.getString(22);
        	fav_actor= rs.getString(23);
        	fav_actress= rs.getString(24);
        	fav_dance= rs.getString(25);
        	fav_dancer= rs.getString(26);        	
        	fav_dialogue= rs.getString(27) ;
        	
        	call_me = rs.getString(28);
        	my_strength = rs.getString(29);
        	my_weakness= rs.getString(30);
        	words = rs.getString(31);
        	change= rs.getString(32);
        	audio_uri = rs.getString(33);
        	
        	fav_book= rs.getString(34) ;
        	fav_auth = rs.getString(35);
        	fav_desti = rs.getString(36);
        	fav_island = rs.getString(37);
        	fav_male = rs.getString(38);
        	fav_female= rs.getString(39);
        	
        	fav_outd= rs.getString(40) ;
        	fav_team= rs.getString(41);
        	fav_ind= rs.getString(42);
        	fav_spm= rs.getString(43);
        	achieve= rs.getString(44);
        }
         view_image.setImageURI(Uri.fromFile(new File(image_uri)));
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.xpandable);
        audio_path = audio_uri;
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);  
        play.setOnClickListener(this);
        view_image.setOnClickListener(this);
      
       }
       catch(Exception ex)
       {
    	   Log.i("View Error", ex.toString());
       }
                 
    }
    
    
    
    /*
     * Preparing the list data
     */
    private void prepareListData()
    {
    	try
    	{
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding child data
        listDataHeader.add("It's My Name:");
        listDataHeader.add("I'm Also Called As:");
        listDataHeader.add("Contact Me On:");
        listDataHeader.add("I Live At: :");
        listDataHeader.add("Email ME: ");
        listDataHeader.add("These Are My Best Friends: ");
        listDataHeader.add("A freind is: ");
        listDataHeader.add("For me, Money is: ");
        listDataHeader.add("I like tu get in: ");
        listDataHeader.add("My Idol:");
        listDataHeader.add("This Is Something More:");
        
        listDataHeader.add("My Favourite Cuisine:");
        listDataHeader.add("My Favourite Restaurant:");
        listDataHeader.add("At Chaupaty, I gulp in:");
        listDataHeader.add("Fast Food I Like TO have:");
        listDataHeader.add("My Tongue Likes:");
        listDataHeader.add("My Favourite desert:");
        listDataHeader.add("Drinks I Like: ");
 
        listDataHeader.add("Songs that I listen to the most:");
        listDataHeader.add("My Favourite Voice:");
        listDataHeader.add("Movie that drive me crazy:");
        listDataHeader.add("Favourite actor:");
        listDataHeader.add("My eyes hang when I see:");
        listDataHeader.add("I like to do:");
        listDataHeader.add("My Favourite Dancer: ");
        listDataHeader.add("I like to chant:");
        
        listDataHeader.add("I call u as:");
        listDataHeader.add("These are your strengths:");
        listDataHeader.add("You are weak @:");
        listDataHeader.add("My Golden Words For You:");
        listDataHeader.add("You Should bring this change:");
        
        listDataHeader.add("I like to read:");
        listDataHeader.add("Person With a speaking pen:");
        listDataHeader.add("I would like to reach:");
        listDataHeader.add("My all time favourite male personality:");
        listDataHeader.add("My all time favourite female personality:");
        
        listDataHeader.add("I can spend my day out, playing:");
        listDataHeader.add("As a team, they are the best:");
        listDataHeader.add("Sitting uder roof, i like to play:");
        listDataHeader.add("My favourite sportsperson:");
        listDataHeader.add("I have achieved all these while playing:");
        
 
 
        // Adding child data
        List<String> _name = new ArrayList<String>();
                _name.add(name);
        
         List<String> _nick_name = new ArrayList<String>();
        _nick_name.add(nick_name);
        
 
        List<String> _contact = new ArrayList<String>();
        _contact.add(contact);
        
        List<String> _address = new ArrayList<String>();
        _address.add(address);
        
        List<String> _email = new ArrayList<String>();
        _email.add(email_id);
        
        List<String> _best_friends = new ArrayList<String>();
        _best_friends.add(best_friends);
        
        List<String> _friends = new ArrayList<String>();
        _friends.add(friends);
        
        List<String> _money = new ArrayList<String>();
        _money.add(money);
        
        List<String> _dress = new ArrayList<String>();
        _dress.add(dress);
        
        List<String> _idol = new ArrayList<String>();
        _idol.add(idol);
        
        List<String> _everything = new ArrayList<String>();
        _everything.add(everything);
        
        List<String> _fav_cuisine = new ArrayList<String>();
                _fav_cuisine.add(fav_cuisine);
        
        
        List<String> _fav_restro = new ArrayList<String>();
        _fav_restro.add(fav_restro);
        
 
        List<String> _fav_chaupaty = new ArrayList<String>();
        _fav_chaupaty.add(fav_chaupaty);
        
        List<String> _fast_food = new ArrayList<String>();
        _fast_food.add(fast_food);
        
        List<String> _taste = new ArrayList<String>();
        _taste.add(taste);
        
        List<String> _fav_desert = new ArrayList<String>();
        _fav_desert.add(fav_desert);
        
        List<String> _fav_drink = new ArrayList<String>();
        _fav_drink.add(fav_drink);
        
        List<String> _fav_song = new ArrayList<String>();
        
        _fav_song.add(fav_song);
        
         List<String> _fav_singer = new ArrayList<String>();
        _fav_singer.add(fav_singer);
        
 
        List<String> _fav_movie = new ArrayList<String>();
        _fav_movie.add(fav_movie);
        
        List<String> _fav_actor = new ArrayList<String>();
        _fav_actor.add(fav_actor);
        
        List<String> _fav_actress = new ArrayList<String>();
        _fav_actress.add(fav_actress);
        
        List<String> _fav_dance = new ArrayList<String>();
        _fav_dance.add(fav_dance);
        
        List<String> _fav_dancer = new ArrayList<String>();
        _fav_dancer.add(fav_dancer);
        
        List<String> _fav_dialog = new ArrayList<String>();
        _fav_dialog.add(fav_dialogue);
        
        List<String> _call_me = new ArrayList<String>();
        _call_me.add(call_me);
        
        List<String> _my_strength = new ArrayList<String>();
        _my_strength.add(my_strength);
        
        List<String> _my_weakness = new ArrayList<String>();
        _my_weakness.add(my_weakness);
        
        List<String> _words = new ArrayList<String>();
        _words.add(words);
        
        List<String> _change = new ArrayList<String>();
        
        _change.add(change);
        
        
 
        List<String> _fav_book = new ArrayList<String>();
        _fav_book.add(fav_book);
        
 
        List<String> _fav_auth = new ArrayList<String>();
        _fav_auth.add(fav_auth);
        
        List<String> _fav_desti = new ArrayList<String>();
        _fav_desti.add(fav_desti);
        
        List<String> _fav_island = new ArrayList<String>();
        _fav_island.add(fav_island);
        
        List<String> _male = new ArrayList<String>();
        _male.add(fav_male);
        
        List<String> _female = new ArrayList<String>();
        _female.add(fav_female);
        
        List<String> _fav_outd = new ArrayList<String>();
        _fav_outd.add(fav_outd);
        
        List<String> _fav_team = new ArrayList<String>();
        _fav_team.add(fav_team);
        
        List<String> _fav_ind = new ArrayList<String>();
        _fav_ind.add(fav_ind);
        
        List<String> _fav_spm = new ArrayList<String>();
        _fav_spm.add(fav_spm);
        
        List<String> _achieve = new ArrayList<String>();
        _achieve.add(achieve);
        
        
        
        
        listDataChild.put(listDataHeader.get(0), _name); // Header, Child data
        listDataChild.put(listDataHeader.get(1), _nick_name);
        listDataChild.put(listDataHeader.get(2), _contact);
        listDataChild.put(listDataHeader.get(3), _address);
        listDataChild.put(listDataHeader.get(4), _email);
        listDataChild.put(listDataHeader.get(5), _best_friends);
        listDataChild.put(listDataHeader.get(6), _friends);
        listDataChild.put(listDataHeader.get(7), _money);
        listDataChild.put(listDataHeader.get(8), _dress);
        listDataChild.put(listDataHeader.get(9), _idol);
        listDataChild.put(listDataHeader.get(10), _everything);
        
        listDataChild.put(listDataHeader.get(11), _fav_cuisine); 
        listDataChild.put(listDataHeader.get(12), _fav_restro);
        listDataChild.put(listDataHeader.get(13), _fav_chaupaty);
        listDataChild.put(listDataHeader.get(14), _fast_food);
        listDataChild.put(listDataHeader.get(15), _taste);
        listDataChild.put(listDataHeader.get(16), _fav_desert);
        listDataChild.put(listDataHeader.get(17), _fav_drink);
        
        listDataChild.put(listDataHeader.get(18), _fav_song); // Header, Child data
        listDataChild.put(listDataHeader.get(19), _fav_singer);
        listDataChild.put(listDataHeader.get(20), _fav_movie);
        listDataChild.put(listDataHeader.get(21), _fav_actor);
        listDataChild.put(listDataHeader.get(22), _fav_actress);
        listDataChild.put(listDataHeader.get(23), _fav_dance);
        listDataChild.put(listDataHeader.get(24), _fav_dancer);
        listDataChild.put(listDataHeader.get(25), _fav_dialog);
      
        listDataChild.put(listDataHeader.get(26), _call_me);
        listDataChild.put(listDataHeader.get(27), _my_strength);
        listDataChild.put(listDataHeader.get(28), _my_weakness);
        listDataChild.put(listDataHeader.get(29), _words); 
        listDataChild.put(listDataHeader.get(30), _change);
        
        
        listDataChild.put(listDataHeader.get(32), _fav_book);
        listDataChild.put(listDataHeader.get(33), _fav_auth);
        listDataChild.put(listDataHeader.get(34), _fav_desti);
        listDataChild.put(listDataHeader.get(35), _fav_island);
        listDataChild.put(listDataHeader.get(36), _male);
        listDataChild.put(listDataHeader.get(37), _female); 
        listDataChild.put(listDataHeader.get(38), _fav_outd);
        listDataChild.put(listDataHeader.get(39), _fav_team);
        listDataChild.put(listDataHeader.get(40), _fav_ind);
        listDataChild.put(listDataHeader.get(41), _fav_spm);
        listDataChild.put(listDataHeader.get(42), _achieve);
    	}
    	catch(Exception ex)
    	{
    		Log.i("list prepare", ex.toString());
    	}
        
    }



	@Override
	public void onClick(View arg0) 
	{
		try{
		
			switch(arg0.getId())
			{
			case R.id.playButton:
				MediaPlayer mp = new MediaPlayer();
				mp = MediaPlayer.create(this, Uri.fromFile(new File(audio_path)));
				mp.start();
				Toast.makeText(this, "Playing", Toast.LENGTH_LONG).show();
				break;
			case R.id.imageView01:
				Intent i1 = new Intent(this, View_image.class);
				i1.putExtra("uri", image_uri);
				startActivity(i1);
			}	
		}
		catch(Exception ex)
		{
		
		}
	}
	

}
