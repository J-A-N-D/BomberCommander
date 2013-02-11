/* MainScreenActivity.java
 * Initial start screen of game.
 */

package com.jand.bombercommander.screens;

import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;
import com.jand.bombercommander.screens.Player1SetupActivity.ExitDialogFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;

public class MainScreenActivity extends Activity {
	private static final String TAG = MainScreenActivity.class.getSimpleName();
	
	////////////////////
	/*private boolean loaded = false;
	private SoundPool soundPool;
	private int soundID;*/
	//////////////
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//Some sample code found on http://www.fampennings.nl/maarten/android/07sound/index.htm and from http://www.vogella.com/articles/AndroidMedia/article.html
		/*
		soundPool = new SoundPool( 10, AudioManager.STREAM_MUSIC, 0 );
		soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
		      @Override
		      public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
		    	  loaded = true;
		      }
		});
		
		Context context = getBaseContext();
		soundID = soundPool.load( context, R.raw.five_armies, 1 );
		*/
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
	
	/////////////////////////////////////////////
	/*@Override
	protected void onStart()
	{
		super.onStart();
		Context context = getBaseContext();
		AudioManager audioManager = (AudioManager)context.getSystemService( Context.AUDIO_SERVICE );
		float actualVolume = (float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
		float maxVolume = (float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		float streamVolume = actualVolume / maxVolume;
	    
	    // Is the sound loaded already?
	    if (loaded) {
	    	soundPool.play(soundID, streamVolume, streamVolume, 1, 0, 1f);
	    	Log.e("Test", "Played sound");
	    }
	}*/
	/////////////////////////////////////////////////
	
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
	
	@Override
	public void onBackPressed() {
		ExitDialogFragment dialog = new ExitDialogFragment();
		dialog.show(getFragmentManager(), "loggingOut");
	}
	
	public class ExitDialogFragment extends DialogFragment {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			// Use the Builder class for convenient dialog construction
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setMessage("Are you sure you want to exit?")
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									finish();
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// Do nothing...
								}
							});
			// Create the AlertDialog object and return it
			return builder.create();
		}
	}
}
