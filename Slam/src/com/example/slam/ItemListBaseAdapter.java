package com.example.slam;



import java.util.ArrayList;




import android.content.Context;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemListBaseAdapter extends BaseAdapter 
{
	private static ArrayList<ItemDetails> itemDetailsrrayList;
	private Integer[] img=
		{
			R.drawable.modernth,
			R.drawable.abstract2th,
			R.drawable.cornth,
			R.drawable.featherth,
			R.drawable.friendsforever,
			R.drawable.freshsky,
			R.drawable.greenbubbles,
			R.drawable.handsth,
			R.drawable.moonth,
			R.drawable.puredewdrop,
			R.drawable.pinktreesth,
			R.drawable.sharpenyourmind,
			R.drawable.sunflowerth,
			R.drawable.shoreinthecity,					
			R.drawable.roadth,
			R.drawable.yellowflowersth,
			R.drawable.yellowth,
			R.drawable.you72,
			R.drawable.food72,
			R.drawable.me,
			R.drawable.media72,
			R.drawable.other,
			R.drawable.sports72
		};
	private LayoutInflater l_In;
	
	public ItemListBaseAdapter(Context c,ArrayList<ItemDetails>result)
	{
		itemDetailsrrayList = result;
		l_In = LayoutInflater.from(c);
	}

	@Override
	public int getCount() 
	{
		// TODO Auto-generated method stub
		return itemDetailsrrayList.size();
		
	}

	@Override
	public Object getItem(int arg0) 
	{
		// TODO Auto-generated method stub
		return itemDetailsrrayList.get(arg0);
	
	}

	@Override
	public long getItemId(int arg0) 
	{
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) 
	{
		ViewHolder holder;
		if (arg1 == null) 
		{
			arg1 = l_In.inflate(R.layout.activity_itembaseadapter, null);
			holder = new ViewHolder();
			holder.txt_itemName = (TextView) arg1.findViewById(R.id.tv_slam_base);
			holder.itemImage = (ImageView) arg1.findViewById(R.id.imageView1);

			arg1.setTag(holder);
		} 
		else 
		{
			holder = (ViewHolder) arg1.getTag();
		}
		
		holder.txt_itemName.setText(itemDetailsrrayList.get(arg0).getName());
	
		holder.itemImage.setImageResource(img[itemDetailsrrayList.get(arg0).getImageNumber() - 1]);


		return arg1;
	}

	static class ViewHolder 
	{
		TextView txt_itemName;
		ImageView itemImage;
	}

	}

	


