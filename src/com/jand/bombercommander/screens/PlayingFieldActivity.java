package com.jand.bombercommander.screens;

import com.jand.bombercommander.PlayingFieldView;
import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;
import com.jand.bombercommander.R.menu;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PlayingFieldActivity extends Activity {
	private static final String TAG = PlayingFieldActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/*
		FrameLayout gameFrame = new FrameLayout( this );
		LinearLayout gameBackgrounds = new LinearLayout( this );
		ImageView topGrid = new ImageView( this );
		ImageView battleBackground = new ImageView( this );
		ImageView bottomGrid = new ImageView( this );
		SurfaceView playingField = new PlayingFieldView(this);
		
		topGrid.setImageResource( R.drawable.grid );
		battleBackground.setImageResource( R.drawable.background_battle );
		bottomGrid.setImageResource( R.drawable.grid );
		
		gameBackgrounds.addView( topGrid );
		gameBackgrounds.addView( battleBackground );
		gameBackgrounds.addView( bottomGrid );
		
		//gameFrame.addView( playingField );
		gameFrame.addView( (ImageView)findViewById(R.id.gridTop) );
		gameFrame.addView( (ImageView)findViewById(R.id.backgroundBattle) );
		gameFrame.addView( (ImageView)findViewById(R.id.gridBottom) );
		*/
		
		setContentView(R.layout.activity_playing_field);
		Log.d( TAG, "View added." );
	}

	@Override
	protected void onDestroy()
	{
		Log.d( TAG, "Destroying PlayingFieldActivity..." );
		super.onDestroy();
	}
	
	@Override
	protected void onStop()
	{
		Log.d( TAG, "Stopping PlayingFieldActivity..." );
		super.onStop();
	}
}
