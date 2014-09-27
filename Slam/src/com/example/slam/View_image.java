package com.example.slam;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

public class View_image extends Activity
{
	ImageView image_view = null;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		setTheme(General.CurTheme);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_image);
		image_view = (ImageView) findViewById(R.id.imageView02);
		String image_uri = getIntent().getExtras().getString("uri");
		image_view.setImageURI(Uri.fromFile(new File(image_uri)));
		
	}


}
