package com.example.slam;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MeActivity extends Activity implements OnClickListener
{
	EditText call_me = null, my_strength = null, my_weakness = null, words = null, change = null;
	
	Button record = null, play = null, stopRecord = null, stopPlay = null, update = null;
	
	SQLiteDatabase myDatabase = null;
	String OUT_FILE;
	private MediaPlayer mediaPlayer;
	private MediaRecorder recorder;
	String Contact = String.valueOf(General.CurContactNo), audioPath;
	
    
    public void onCreate(Bundle savedInstanceState)
    {
    	try
	   	{
    		    		
	    	setTheme(General.CurTheme);
	    	super.onCreate(savedInstanceState);
	    	setContentView(R.layout.activity_me);
		
	    	call_me = (EditText) findViewById(R.id.call_me);
	    	my_strength = (EditText) findViewById(R.id.my_strength);
	    	my_weakness = (EditText) findViewById(R.id.my_weakness);
	    	words = (EditText) findViewById(R.id.words);
	    	change = (EditText) findViewById(R.id.change);
	    	
		 
	    	update = (Button) findViewById(R.id.updateme);
	    	record = (Button) findViewById(R.id.record);
	    	stopRecord = (Button) findViewById(R.id.stopRecording);
	    	play = (Button) findViewById(R.id.play);
	    	stopPlay = (Button)findViewById(R.id.stopPlaying);
	    	
	    	update.setOnClickListener(this);
	    	record.setOnClickListener(this);
	    	stopRecord.setOnClickListener(this);
	    	stopPlay.setOnClickListener(this);
	    	play.setOnClickListener(this);
	    	
	    	
	    	
	    	Typeface attribute = Typeface.createFromAsset(getAssets(), "editfont.ttf");
	    	call_me.setTypeface(attribute);
	    	my_strength.setTypeface(attribute);
	    	my_weakness.setTypeface(attribute);
	    	words.setTypeface(attribute);
	    	change.setTypeface(attribute);
	    	
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
	 
	 call_me.setFilters(new InputFilter[]{filter});
	 my_strength.setFilters(new InputFilter[]{filter});
	 my_weakness.setFilters(new InputFilter[]{filter});
	 words.setFilters(new InputFilter[]{filter});
	 change.setFilters(new InputFilter[]{filter});
	 }
	    catch(Exception ex)
	    {
	    	Log.i("MeAct Error", ex.toString());
	    	
	    }
    	
		
	}

    private void beginRecording() throws Exception 
	{
    	play.setClickable(false);
    	stopPlay.setClickable(false);
    	update.setClickable(false);
		killMediaRecorder();
		String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/slambook");
        String fname = General.name+".3GPP";
		File file = new File (myDir, fname);
         if (file.exists ()) 
        	 file.delete (); 
         try 
         {
                FileOutputStream out = new FileOutputStream(file);
                
         
                audioPath = file.getPath();
                OUT_FILE = audioPath;
                out.flush();
                out.close();

         } 
         catch (Exception e) 
         {
                Log.i("File Creation", e.toString());
         }
         
         
		recorder = new MediaRecorder();
		
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		
		recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
		
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		
		recorder.setOutputFile(audioPath);
		recorder.prepare();
		recorder.start();
		Toast.makeText(this, "Recording Started", Toast.LENGTH_LONG).show();
	}
	
	private void stopRecording() throws Exception 
	{	play.setClickable(true);
		update.setClickable(true);
		if (recorder != null) 
		{
			recorder.stop();
			Toast.makeText(this, "Recording Stopped", Toast.LENGTH_LONG).show();
			
		}
		else
		{
			Toast.makeText(this, "Start Record then Stop", Toast.LENGTH_LONG).show();
		}
		
	}
	
	private void killMediaRecorder() 
	{
		if (recorder != null) 
		{
			recorder.release();
		}
	}
	
	private void killMediaPlayer() 
	{
		if(mediaPlayer != null) 
		{
			try 
			{
				mediaPlayer.release();
			} 
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private void playRecording() throws Exception 
	{
		
		stopPlay.setClickable(true);
		stopRecord.setClickable(false);
		update.setClickable(false);
		record.setClickable(false);
		killMediaPlayer();
		mediaPlayer = new MediaPlayer();
		mediaPlayer.setDataSource(audioPath);
		mediaPlayer.prepare();
		mediaPlayer.start();
		Toast.makeText(this, "Recording Playing", Toast.LENGTH_LONG).show();
		record.setClickable(false);
	}
	
	private void stopPlayingRecording() throws Exception 
	{
		record.setClickable(true);
		update.setClickable(true);
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
			mediaPlayer.release();
			Toast.makeText(this, "Recording Play Stopped", Toast.LENGTH_LONG).show();
		}
		else
		{
			Toast.makeText(this, "Play first then stop", Toast.LENGTH_LONG).show();
		}
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		killMediaRecorder();
		killMediaPlayer();
	}

	@Override
	public void onClick(View v) 
	{
		switch(v.getId())
		{
		case R.id.record:
						try 
						{
							
							beginRecording();
						} 
						catch (Exception e) 
						{
							Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
						}
						break;
		case R.id.stopRecording:
						try 
						{	
							stopRecording();
						} 
						catch (Exception e) 
						{
							Toast.makeText(this, "ERROR", Toast.LENGTH_LONG).show();
						}
						break;
		case R.id.play:
						try 
						{
							playRecording();
						} 
						catch(Exception e) 
						{
							Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
						}
						break;
		case R.id.stopPlaying:
						try 
						{
							stopPlayingRecording();
						} 
						catch(Exception e) 
						{
							Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
						}
						break;
		case R.id.updateme:
			
				updateDb();
					
		}
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
		    	
				 String Scall_me = call_me.getText().toString();
				 String Smy_strength = my_strength.getText().toString();
				 String Smy_weakness = my_weakness.getText().toString();
				 String Swords = words.getText().toString();
				 String Schange = change.getText().toString();
				 
				 myDatabase = openOrCreateDatabase(General.DATABASE_NAME, Context.MODE_PRIVATE, null);
				 
				 General.QUERY = " update "+General.DATABASE_TABLE+ " set call_me = '"+Scall_me+"', my_strength = '"+Smy_strength+"', my_weakness = '"+Smy_weakness+"', words = '"+Swords+"',  change = '"+Schange+"', record_uri = '"+OUT_FILE+"' "+
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