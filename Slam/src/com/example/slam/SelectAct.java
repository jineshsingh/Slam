package com.example.slam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;

import android.view.animation.AnimationUtils;

import android.widget.Button;
import android.widget.Toast;



public class SelectAct extends Activity implements OnClickListener
{
	Button create = null, edit = null, view =null , exit = null;
    Animation bounceAnim, slideUp;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
        setTheme(General.CurTheme);
        try
        {
        super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_select);

		create = (Button) findViewById(R.id.buttonth);
		edit = (Button) findViewById(R.id.btn_edit);
		view = (Button) findViewById(R.id.view_button);
		create.setBackgroundResource(R.drawable.hello);
		edit.setBackgroundResource(R.drawable.hello1);
		view.setBackgroundResource(R.drawable.hello2);
		exit = (Button) findViewById(R.id.exit_button);
            
		create.setOnClickListener(this);
		edit.setOnClickListener(this);
		view.setOnClickListener(this);
		exit.setOnClickListener(this);
		
		bounceAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce); 
		slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
		
		
		create.startAnimation(bounceAnim);
		edit.startAnimation(bounceAnim);
		view.startAnimation(bounceAnim);
		
		
        }
        catch(Exception ex)
        {
            Log.i("Select Error", ex.toString());
        }
	}
	
	
	@Override
	public void onClick(View arg0) 
	{
        try
        {
        	switch(arg0.getId())
        	{
        	case R.id.buttonth:
        		edit.startAnimation(slideUp);
        		view.startAnimation(slideUp);
        		Intent i1 = new Intent(this, CreateAct.class);
          		startActivity(i1);
        		break;
        	case R.id.btn_edit:
        		create.startAnimation(slideUp);
        		view.startAnimation(slideUp);
        		
        		General.flag = false;
        		Intent i2 = new Intent(this, ContactList.class);
        		
        		startActivity(i2);
        		break;
        	case R.id.view_button:
        		edit.startAnimation(slideUp);
        		create.startAnimation(slideUp);
        		General.flag = true;
        		Intent i3 = new Intent(this, ContactList.class);
        		startActivity(i3);
        		break;
        	case R.id.exit_button:
        		moveTaskToBack(true);
        		break;
        		
        		
        	}
        }
        catch(Exception ex)
        {
            Log.i("Select2 error", ex.toString());
        }
	}
	public void onBackPressed()
    {
	    startActivity(new Intent(this, ThemesAct.class));
	}
    
}
