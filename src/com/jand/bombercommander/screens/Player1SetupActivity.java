package com.jand.bombercommander.screens;

import com.jand.bombercommander.GameThread;
import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;

public class Player1SetupActivity extends Activity {
	
	public static GameThread thread;
	public static enum gameState { P1_SETUP, P2_SETUP };
	public static gameState state;
	TextView playerText;
	Button actionButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player1_setup);
		
		playerText = (TextView)findViewById(R.id.textP1Setup);
		actionButton = (Button)findViewById(R.id.btnNextPlayer);
		
			actionButton.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				state = gameState.P2_SETUP;
				playerText.setText( "Player 2 Setup" );
				actionButton.setText( "Prepare for Battle" );
			}
		});
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
			builder.setMessage("Do you want to return to the main menu?")
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									thread.setRunning(false);
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
