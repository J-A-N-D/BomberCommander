package com.jand.bombercommander.screens;

import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;

public class Player1SetupActivity extends Activity {
	
	TextView playerText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player1_setup);
		
		playerText = (TextView)findViewById(R.id.textP1Setup);
		playerText.setText( "Player 2!" );
	}

}
