/* MainScreenActivity.java
 * Initial start screen of game.
 */

package com.jand.bombercommander.screens;

import com.jand.bombercommander.R;
import com.jand.bombercommander.R.layout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.app.Activity;
import android.content.Intent;

public class Setup1Activity extends Activity implements OnCheckedChangeListener {
	private static final String TAG = Setup1Activity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setup1);
		
		Button startButton = (Button)findViewById(R.id.btnStart);
		
		RadioGroup radioaa = (RadioGroup)findViewById(R.id.radio_group_aa);
		RadioGroup radiofighter = (RadioGroup)findViewById(R.id.radio_group_fighter);
		RadioGroup radiobomber = (RadioGroup)findViewById(R.id.radio_group_bomber);
		
		radioaa.setOnCheckedChangeListener(this);
		
		startButton.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent startGame = new Intent( Setup1Activity.this, Setup2Activity.class );
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

	@Override
	public void onCheckedChanged(RadioGroup radiogroup, int checkedId) {
		String numeral = null;
        switch (checkedId) {

		
	}
	}
}
