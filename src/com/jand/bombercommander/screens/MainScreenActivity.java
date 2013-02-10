/* MainScreenActivity.java
 * Initial start screen of game.
 */

package com.jand.bombercommander.screens;

import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MainScreenActivity extends Activity {
	private static final String TAG = MainScreenActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//Some sample code found on http://www.fampennings.nl/maarten/android/07sound/index.htm
		
		SoundPool soundPool = new SoundPool( 30, AudioManager.STREAM_MUSIC, 0 );
		Context context = getBaseContext();
		AudioManager audioManager = (AudioManager)context.getSystemService( Context.AUDIO_SERVICE );
		float streamVolume = audioManager.getStreamVolume( AudioManager.STREAM_MUSIC );
		int soundID = soundPool.load( context, R.raw.five_armies ,1 );
		soundPool.play(soundID, streamVolume, streamVolume, 1, -1, 1.0f);
		
		//**********************************************
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		
		Button startButton = (Button)findViewById(R.id.btnStart);
		
		startButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent startGame = new Intent( MainScreenActivity.this, Player1SetupActivity.class );
				startActivity( startGame );
			}
		});
	}
	
	@Override
	protected void onDestroy()
	{
		Log.d( TAG, "Destroying MainScreenActivity..." );
		super.onDestroy();
	}
	
	@Override
	protected void onStop()
	{
		Log.d( TAG, "Stopping MainScreenActivity..." );
		super.onStop();
	}
	
}
