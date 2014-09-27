package com.example.slam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class ContactList extends Activity 
{
	
	EditText search_text = null;
	String _click;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		try
		{
			setTheme(General.CurTheme);
			super.onCreate(savedInstanceState);
			setContentView( new DemoView(this).createView(this) );
		}
		catch(Exception ex)
		{
			Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show();
		}
	}
	@Override
	public void onBackPressed()
    {
	    startActivity(new Intent(this, SelectAct.class));
	}
	
}

class DemoView extends View
{
	SQLiteDatabase myDatabase = null;
	Context context1 = null;
	ListView lv = null;
	public DemoView(Context context) 
	{
		super(context);
		this.context1 = context;
	}
	
	public View createView(Context context)
	{
		LinearLayout ll = new LinearLayout(context);
		
		ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		
		lv = new ListView(context);
		
		try
		{
			myDatabase = context.openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
            Toast.makeText(context, "Entries Loaded", Toast.LENGTH_LONG).show();
            General.QUERY = "Select * from  "+General.DATABASE_TABLE+" order by name;";
            Cursor rs = myDatabase.rawQuery(General.QUERY, null);
            String list[] = new String[rs.getCount() ];
            int i = 0;
            
            	rs.moveToFirst();
            	while(!rs.isAfterLast())
            	{
            		list[i] = rs.getString(0);
            		i++;
            		rs.moveToNext();
            		
            	}
            
            
            ArrayAdapter<String> ap = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, list);
            lv.setAdapter(ap);
            lv.setOnItemClickListener(new OnItemClickListener() 
            {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
				{
					try
					{
						
							String text_name = lv.getItemAtPosition(arg2).toString();
							
							Intent i1 ;
							if(General.flag == true)
							{
								i1 = new Intent(getContext(), ViewActivityYou.class);
							
								i1.putExtra("getname", text_name);
											
								getContext().startActivity(i1);
							}
							else
							{
								i1 = new Intent(getContext(), EditYou.class);
								
								i1.putExtra("getname", text_name);
								
								getContext().startActivity(i1);
							}
					}
					catch(Exception ex)
					{
						Log.i("ContactList Error", ex.toString());
					}
				}
            	
			});
		}
		catch(Exception ex)
		{
			Toast.makeText(context, "- -No Entries - -", Toast.LENGTH_LONG).show();
		}
		ll.addView(lv);
		return ll;
	}
}
