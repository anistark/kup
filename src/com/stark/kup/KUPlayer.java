package com.stark.kup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KUPlayer extends Activity {
	Button btnplay, btnpause, btnstop;
	MediaPlayer mMediaPlayer;
	TextView tvdur;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnplay= (Button)findViewById(R.id.btnplay);
        btnpause= (Button)findViewById(R.id.btnpause);
        btnstop= (Button)findViewById(R.id.btnstop);
        tvdur= (TextView)findViewById(R.id.tvdur);
        
        mMediaPlayer= MediaPlayer.create(this, R.raw.a);
        
        btnplay.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Starting to Play", Toast.LENGTH_SHORT).show();
				mMediaPlayer.start();
				tvdur.setText("Song Now Playing");
			}
        	
        });
        
        btnpause.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Pausing", Toast.LENGTH_SHORT).show();
				mMediaPlayer.pause();
			}
        	
        });
        
        btnstop.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Stopping", Toast.LENGTH_SHORT).show();
				mMediaPlayer.stop();
			}
        	
        });
    }
    
    /* Initiating Menu XML file (playermenu.xml) */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.playermenu, menu);
        return true;
    }
    
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        
        switch (item.getItemId())
        {
        /*case R.id.menu_bookmark:
        	// Single menu item is selected do something
        	// Ex: launching new activity/screen or show alert message
            Toast.makeText(this, "Bookmark is Selected", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.menu_save:
        	Toast.makeText(this, "Save is Selected", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.menu_search:
        	Toast.makeText(this, "Search is Selected", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.menu_share:
        	Toast.makeText(this, "Share is Selected", Toast.LENGTH_SHORT).show();
            return true;
        case R.id.menu_delete:
        	Toast.makeText(this, "Delete is Selected", Toast.LENGTH_SHORT).show();
            return true;*/
        case R.id.menu_credit:
        	//Toast.makeText(this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
        	AlertDialog.Builder alertcredit = new AlertDialog.Builder(this);
        	alertcredit.setTitle("App Credit");
        	alertcredit.setMessage("Kumar Anirudha");
        	alertcredit.setCancelable(false);
        	alertcredit.setNeutralButton("OK", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
              }
            });
        	alertcredit.create().show();
        	return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    
}