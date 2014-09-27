package com.example.slam;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;

import android.view.MotionEvent;
import android.widget.TextView;

public class Instruction_Activity extends Activity
{

	TextView book = null, slam = null, ins_1 = null, ins_2 = null, swipe = null;
	float x1, x2;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		setTheme(R.style.DefaultTheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instruction);
		
		ins_1 = (TextView) findViewById(R.id.ins_1);
		ins_2 = (TextView) findViewById(R.id.ins_2);
		book = (TextView) findViewById(R.id.book);
		slam = (TextView) findViewById(R.id.slam);
		swipe = (TextView) findViewById(R.id.swipe);
				
		 Typeface ins = Typeface.createFromAsset(getAssets(), "font4.TTF");
	        ins_1.setTypeface(ins);
	        ins_2.setTypeface(ins);
	    
	     Typeface swiped = Typeface.createFromAsset(getAssets(), "vintage.ttf");
	        swipe.setTypeface(swiped);
	        
	        Typeface attribute = Typeface.createFromAsset(getAssets(), "angel.otf");
	        
	        slam.setTypeface(attribute);
	        book.setTypeface(attribute);
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
	                                    Intent i1 = new Intent(getBaseContext(),ThemesAct.class);
	                                    startActivity(i1);
	                                 }
	                                
	                                break;
	                             }
	                     }
	                             return false;
	                     
	        }
	}
	
