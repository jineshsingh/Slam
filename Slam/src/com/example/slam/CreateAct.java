package com.example.slam;

import android.os.Bundle;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.Menu;

import android.widget.TabHost;
import android.widget.Toast;

import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class CreateAct extends TabActivity
{
	private static final String FOOD_SPEC = "Food";
	private static final String MEDIA_SPEC = "Media";
    private static final String YOU_SPEC = "You";
    private static final String ME_SPEC = "Me";
    private static final String OTHER_SPEC = "Other";
    private static final String SPORT_SPEC = "Sport";

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setTheme(General.CurTheme);
    try
    {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create);

		Resources resources = getResources();
		TabHost tabHost = getTabHost();

		//Inbox Tab
        TabSpec foodSpec = tabHost.newTabSpec(FOOD_SPEC);
        // Tab Icon
        foodSpec.setIndicator("", resources.getDrawable(R.drawable.food72));
    	Intent foodIntent = new Intent(this, FoodActivity.class);
    	foodSpec.setContent(foodIntent);

        
        TabSpec mediaSpec = tabHost.newTabSpec(MEDIA_SPEC);
        mediaSpec.setIndicator("", resources.getDrawable(R.drawable.media72));
        Intent mediaIntent = new Intent(this, MediaActivity.class);
    	mediaSpec.setContent(mediaIntent);
    	
        TabSpec youSpec = tabHost.newTabSpec(YOU_SPEC);
        youSpec.setIndicator("", resources.getDrawable(R.drawable.you72));
        Intent youIntent = new Intent(this, YouActivity.class);
    	youSpec.setContent(youIntent);

        TabSpec meSpec = tabHost.newTabSpec(ME_SPEC);
        meSpec.setIndicator("", resources.getDrawable(R.drawable.me));
        Intent meIntent = new Intent(this, MeActivity.class);
    	meSpec.setContent(meIntent);
    	
        TabSpec othrSpec = tabHost.newTabSpec(OTHER_SPEC);
        othrSpec.setIndicator("", resources.getDrawable(R.drawable.other));
        Intent othrIntent = new Intent(this, OtherActivity.class);
    	othrSpec.setContent(othrIntent);

        TabSpec sportSpec = tabHost.newTabSpec(SPORT_SPEC);
        sportSpec.setIndicator("", resources.getDrawable(R.drawable.sports72));
      	Intent sportIntent = new Intent(this, SportActivity.class);
       	sportSpec.setContent(sportIntent);
 
        // Adding all TabSpec to TabHosts
        tabHost.addTab(youSpec);    // Adding About You tab
        tabHost.addTab(foodSpec);   // Adding Food tab
        tabHost.addTab(mediaSpec);  // Adding Media tab
        tabHost.addTab(meSpec);     //Adding ME tab
        tabHost.addTab(sportSpec);  //Adding Sport Tab
        tabHost.addTab(othrSpec);   //Adding Other Tab



    }
    catch(Exception ex)
    {
	    Log.i("Create Error", ex.toString());
    }
 }

	


}
