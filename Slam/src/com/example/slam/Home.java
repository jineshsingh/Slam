package com.example.slam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;

public class Home extends Activity 
{

	float x1,x2;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setTheme(R.style.DefaultTheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		getWindow().setBackgroundDrawableResource(R.drawable.front);
		
        
        
		
	}
	  public boolean onTouchEvent(MotionEvent touchevent) 
      {
                   switch (touchevent.getAction())
                   {
                          // when user first touches the screen we get x and y coordinate
                           case MotionEvent.ACTION_DOWN: 
                           {
                               x1 = touchevent.getX();
                               
                               break;
                          }
                           case MotionEvent.ACTION_UP: 
                           {
                               x2 = touchevent.getX();
                               
                               
                           
                           
                               // if right to left sweep event on screen
                               if (x1 > x2)
                               {
                                  Intent i1 = new Intent(getBaseContext(),Instruction_Activity.class);
                                  startActivity(i1);
                               }
                              
                              break;
                           }
                   }
                           return false;
                   
      }
	  
	  public void onBackPressed()
	    {
		   moveTaskToBack(true);
		}
	    

}
