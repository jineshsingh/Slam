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


public class SportActivity extends Activity implements OnClickListener
{
	EditText fav_outd = null, fav_ind = null, fav_team = null, fav_spm = null, achieve = null;
	
	Button update = null;
    
    SQLiteDatabase myDatabase = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		try
		{
			setTheme(General.CurTheme);
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.activity_sport);
		
	    	fav_outd = (EditText) findViewById(R.id.fav_outd);
	    	fav_ind = (EditText) findViewById(R.id.fav_ind);
	    	fav_spm = (EditText) findViewById(R.id.fav_spm);
	    	fav_team = (EditText) findViewById(R.id.fav_team);
	    	achieve = (EditText) findViewById(R.id.achieve);
	    	
	    	update = (Button) findViewById(R.id.updatesports);
		
	    	update.setOnClickListener(this);
	    	
	    	Typeface attribute = Typeface.createFromAsset(getAssets(), "editfont.ttf");
	    	fav_outd.setTypeface(attribute);
	    	fav_team.setTypeface(attribute);
	    	fav_ind.setTypeface(attribute);
	    	fav_spm.setTypeface(attribute);
	    	achieve.setTypeface(attribute);
	    	
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
	 
	 fav_outd.setFilters(new InputFilter[]{filter});
	 fav_ind.setFilters(new InputFilter[]{filter});
	 fav_spm.setFilters(new InputFilter[]{filter});
	 fav_team.setFilters(new InputFilter[]{filter});
	 achieve.setFilters(new InputFilter[]{filter});   	
			
	}
	catch(Exception ex)
	{
        Log.i("Sport Error", ex.toString());
    }
	}

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
	    	 String Contact = String.valueOf(General.CurContactNo);
			 String Sfav_ind = fav_ind.getText().toString();
			 String Sfav_outd = fav_outd.getText().toString();
			 String Sfav_team = fav_team.getText().toString();
			 
			 String Sfav_spm = fav_spm.getText().toString();
			 String Sachieve = achieve.getText().toString();
			
			 myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
			 
			 General.QUERY = " update "+General.DATABASE_TABLE+ " set  fav_outd = '"+Sfav_outd+"', fav_team = '"+Sfav_team+"', fav_ind = '"+Sfav_ind+"', fav_spm = '"+Sfav_spm+"', achieve = '"+Sachieve+"' " +
			 				"where contact = '"+Contact+"' "  ;
			
			 
			 myDatabase.execSQL(General.QUERY);
			 Toast.makeText(getApplicationContext(), " Data Inserted", Toast.LENGTH_LONG).show();
			
		}
		catch(Exception ex)
		{
		    Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
			
		}
	}




}
