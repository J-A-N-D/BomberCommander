package com.jand.bombercommander.screens;

import com.jand.bombercommander.PlayingFieldView;
import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;
import com.jand.bombercommander.R.menu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class PlayingFieldActivity extends Activity {
	private static final String TAG = PlayingFieldActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView( new PlayingFieldView(this) );
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
