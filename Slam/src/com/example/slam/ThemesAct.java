package com.example.slam;


import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class ThemesAct extends Activity implements OnItemClickListener
{
	TextView select = null;
	
    ListView lv;

    @Override
	protected void onCreate(Bundle savedInstanceState) 
	{
        try
        {
            setTheme(R.style.DefaultTheme);
		    super.onCreate(savedInstanceState);
		
		    setContentView(R.layout.activity_themes);
		    
		    ArrayList<ItemDetails> image_detail = Getsearchresult();
       
		    lv = (ListView) findViewById(R.id.listView);
		    select = (TextView)findViewById(R.id.SelectTheme);
		    Typeface myTypeface = Typeface.createFromAsset(getAssets(), "vintage.ttf");
		    select.setTypeface(myTypeface);
		     
           
            
            
		    lv.setAdapter(new ItemListBaseAdapter(this, image_detail));
            lv.setOnItemClickListener(this);
         }
        catch(Exception ex)
        {
            Log.i("Themes Error", ex.toString());


        }
    }
    private ArrayList<ItemDetails> Getsearchresult()
    {
    	
		ArrayList<ItemDetails> result = new ArrayList<ItemDetails>();
		ItemDetails itemDetail = new ItemDetails();
		itemDetail.setName("Modern Abstract");
		itemDetail.setImageNumber(1);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Abstract Blue");
		itemDetail.setImageNumber(2);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Corn");
		itemDetail.setImageNumber(3);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Feather");
		itemDetail.setImageNumber(4);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Friends Forever");
		itemDetail.setImageNumber(5);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Fresh Sky");
		itemDetail.setImageNumber(6);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Green Bubbles");
		itemDetail.setImageNumber(7);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Hand Shake");
		itemDetail.setImageNumber(8);
		result.add(itemDetail);
		
		itemDetail = new ItemDetails();
		itemDetail.setName("Moon Blue");
		itemDetail.setImageNumber(9);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Pure Dew Drops");
		itemDetail.setImageNumber(10);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Pink Beauty");
		itemDetail.setImageNumber(11);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Sharpen Your Mind");
		itemDetail.setImageNumber(12);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Sunflower");
		itemDetail.setImageNumber(13);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("\"Shore\" In The City");
		itemDetail.setImageNumber(14);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Road To Heaven");
		itemDetail.setImageNumber(15);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Yellow Flowers");
		itemDetail.setImageNumber(16);
		result.add(itemDetail);
		
		itemDetail=new ItemDetails();
		itemDetail.setName("Yellow Rays");
		itemDetail.setImageNumber(17);
		result.add(itemDetail);
		return result;
    
		
	}
	@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {

        try
        {
        		Object o = lv.getItemAtPosition(i);
        		ItemDetails obj_itemDetails = (ItemDetails)o;
               if(obj_itemDetails.getName().equals("Green Bubbles"))
                {

                    General.CurTheme = R.style.GreenTheme;
                    
                    Intent i1 = new Intent(this, SelectAct.class);
                    startActivity(i1);
                }
                else if(obj_itemDetails.getName().equals("Friends Forever"))
                {

                    General.CurTheme = R.style.BlueTheme;
                    Intent i1 = new Intent(this, SelectAct.class);
                    startActivity(i1);
                }
                else if(obj_itemDetails.getName().equals("Yellow Rays"))
                {
                    General.CurTheme = R.style.YelloTheme;
                    Intent i1 = new Intent(this, SelectAct.class);
                    startActivity(i1);
                }
                    else if(obj_itemDetails.getName().equals("Feather"))
                {
                    General.CurTheme = R.style.FeatherTheme;
                    Intent i1 = new Intent(this, SelectAct.class);
                    startActivity(i1);
                }
                    
                    else if(obj_itemDetails.getName().equals("Abstract Blue"))
                    {
                    	
                        General.CurTheme = R.style.Abstract1Theme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Modern Abstract"))
                    {
                        General.CurTheme = R.style.Abstract2Theme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("\"Shore\" In The City"))
                    {
                        General.CurTheme = R.style.Nature1Theme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Fresh Sky"))
                    {
                        General.CurTheme = R.style.NatureTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Hand Shake"))
                    {
                        General.CurTheme = R.style.HandTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    
                    else if(obj_itemDetails.getName().equals("Pure Dew Drops"))
                    {
                        General.CurTheme = R.style.DropTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                   
                    else if(obj_itemDetails.getName().equals("Sunflower"))
                    {
                        General.CurTheme = R.style.YelloFlowerTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Yellow Flowers"))
                    {
                        General.CurTheme = R.style.FLowersTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Moon Blue"))
                    {
                        General.CurTheme = R.style.MoonTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Road To Heaven"))
                    {
                        General.CurTheme = R.style.RoadTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Corn"))
                    {
                        General.CurTheme = R.style.CornTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Pink Beauty"))
                    {
                        General.CurTheme = R.style.PinkTreesTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
                    else if(obj_itemDetails.getName().equals("Sharpen Your Mind"))
                    {
                        General.CurTheme = R.style.AlmondTheme;
                        Intent i1 = new Intent(this, SelectAct.class);
                        startActivity(i1);
                    }
        }
       
        catch (Exception ex)
        {
            Log.i("THEMES ERROR", ex.toString());
        }
    }
	public void onBackPressed()
    {
	    startActivity(new Intent(this, Home.class));
	}
    
}

