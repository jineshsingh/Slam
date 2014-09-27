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

public class OtherActivity extends Activity implements OnClickListener 
{
	EditText fav_book = null, fav_auth = null,  fav_desti = null, fav_island = null, fav_male = null, fav_female = null;
	
	Button update = null;
    
    SQLiteDatabase myDatabase = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		try
	   	{
	    	setTheme(General.CurTheme);
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.activity_other);
		
	    	fav_book = (EditText) findViewById(R.id.fav_book);
	    	fav_auth = (EditText) findViewById(R.id.fav_auth);
	    	
	    	fav_island = (EditText) findViewById(R.id.fav_island);
	    	fav_desti = (EditText) findViewById(R.id.fav_desti);
	    	fav_male = (EditText) findViewById(R.id.fav_male);
	    	fav_female = (EditText) findViewById(R.id.fav_female);
	    	
		    
		 
		 
	    	update = (Button) findViewById(R.id.updateother);
		
	    	update.setOnClickListener(this);
	    	
	    	
	    	Typeface attribute = Typeface.createFromAsset(getAssets(), "editfont.ttf");
	    	fav_book.setTypeface(attribute);
	    	fav_auth.setTypeface(attribute);
	    	fav_island.setTypeface(attribute);
	    	fav_desti.setTypeface(attribute);
	    	fav_male.setTypeface(attribute);
	    	fav_female.setTypeface(attribute);
	    	
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
	 
	 fav_book.setFilters(new InputFilter[]{filter});
	 fav_auth.setFilters(new InputFilter[]{filter});
	 fav_island.setFilters(new InputFilter[]{filter});
	 fav_desti.setFilters(new InputFilter[]{filter});
	 fav_male.setFilters(new InputFilter[]{filter});
	 fav_female.setFilters(new InputFilter[]{filter});
	 }
	 
	catch(Exception ex)
	{
	   	Log.i("Bundle Error", ex.toString());
	    	
    }
}

	@Override
	public void onClick(View v)
	{
		
			updateDb();
			Intent i1 = new Intent(this, SelectAct.class);
			startActivity(i1);
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
				 String Sfav_book = fav_book.getText().toString();
				 String Sfav_auth = fav_auth.getText().toString();
				 String Sfav_desti = fav_desti.getText().toString();
				 String Sfav_island = fav_island.getText().toString();
				 String Sfav_male = fav_male.getText().toString();
				 String Sfav_female = fav_female.getText().toString();
				 
				 
				
				 myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
				 
				 General.QUERY = " update "+General.DATABASE_TABLE+ " set fav_book = '"+Sfav_book+"', fav_auth = '"+Sfav_auth+"',fav_desti = '"+Sfav_desti+"', fav_island = '"+Sfav_island+"',  fav_male = '"+Sfav_male+"', fav_female = '"+Sfav_female+"'"+
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
