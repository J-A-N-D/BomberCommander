package com.jand.bombercommander.screens;

import com.jand.bombercommander.GameThread;
import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class Player1SetupActivity extends Activity {
	
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

}
