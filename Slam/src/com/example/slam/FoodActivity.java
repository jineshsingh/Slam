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
import android.widget.Spinner;
import android.widget.Toast;

public class FoodActivity extends Activity implements OnClickListener

{
	
	    EditText fav_cuisine = null, fav_restro = null, fav_chaupaty = null, fast_food = null, fav_desert = null, fav_drink = null;
	    Spinner taste = null;
	    Button update = null;
	   
	    SQLiteDatabase myDatabase = null;
	    @Override
	protected void onCreate(Bundle savedInstanceState)
	{
	    try
	   	{
	    	setTheme(General.CurTheme);
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.activity_food);
		
	    	fav_cuisine = (EditText) findViewById(R.id.fav_cuisine);
	    	fav_restro = (EditText) findViewById(R.id.fav_resto);
	    	fav_chaupaty = (EditText) findViewById(R.id.fav_chaupaty);
	    	fast_food = (EditText) findViewById(R.id.fast_food);
	    	fav_desert = (EditText) findViewById(R.id.fav_desert);
	    	fav_drink = (EditText) findViewById(R.id.fav_drink);
		    taste = (Spinner) findViewById(R.id.taste);
		 
		 
	    	update = (Button) findViewById(R.id.updatefood);
		
	    	update.setOnClickListener(this);
	    	
	    	Typeface attribute = Typeface.createFromAsset(getAssets(), "editfont.ttf");
	    	
	    	fav_cuisine.setTypeface(attribute);
	    	fav_restro.setTypeface(attribute);
	    	fav_chaupaty.setTypeface(attribute);
	    	fast_food.setTypeface(attribute);
	    	fav_desert.setTypeface(attribute);
	    	fav_drink.setTypeface(attribute);
	    	
	    	
	    	
	    	
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
	 
	 fav_cuisine.setFilters(new InputFilter[]{filter});
	 fav_restro.setFilters(new InputFilter[]{filter});
	 fav_chaupaty.setFilters(new InputFilter[]{filter});
	 fast_food.setFilters(new InputFilter[]{filter});
	 fav_desert.setFilters(new InputFilter[]{filter});
	 fav_drink.setFilters(new InputFilter[]{filter});
	    	
	   	}
	    catch(Exception ex)
	    {
	    	Log.i("Bundle Error", ex.toString());
	    	
	    } 
		 
	}

	@Override
	public void onClick(View arg0) 
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
			 myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
	    	 String Contact = String.valueOf(General.CurContactNo);
			 String Sfav_cuisine = fav_cuisine.getText().toString();
			 String Sfav_restro = fav_restro.getText().toString();
			 String Sfav_chaupaty = fav_chaupaty.getText().toString();
			 String Sfast_food = fast_food.getText().toString();
			 String Sfav_desert = fav_desert.getText().toString();
			 String Sfav_drink = fav_drink.getText().toString();
			 String Staste = taste.getSelectedItem().toString();
			 
			 myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
			
			 General.QUERY = " update "+General.DATABASE_TABLE+ " set fav_cuisine = '"+Sfav_cuisine+"', fav_restro = '"+Sfav_restro+"',fav_chaupaty = '"+Sfav_chaupaty+"', fast_food = '"+Sfast_food+"', taste = '"+Staste+"', fav_desert = '"+Sfav_desert+"', fav_drink = '"+Sfav_drink+"' " +
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
