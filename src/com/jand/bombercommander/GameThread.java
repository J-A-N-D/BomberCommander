package com.jand.bombercommander;

import com.jand.bombercommander.screens.Player1SetupActivity;
import com.jand.bombercommander.screens.Player1SetupActivity.gameState;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
	private static final String TAG = GameThread.class.getSimpleName();
	
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private PlayingFieldView playingField;
	
	public GameThread( SurfaceHolder sh, PlayingFieldView pf )
	{
		super();
		surfaceHolder = sh;
		playingField = pf;
		Player1SetupActivity.state = gameState.P1_SETUP;
	}
	
	@Override
	public void run()
	{
		Canvas canvas;
		
		Log.d(TAG, "Starting game loop");
		while (running)
		{
			canvas = null;
			
			try
			{
				switch (Player1SetupActivity.state)
				{
				case P1_SETUP:
					canvas = this.surfaceHolder.lockCanvas();
					synchronized (surfaceHolder)
					{
						playingField.onDraw( canvas );
					}
					break;
				case P2_SETUP:
					canvas = this.surfaceHolder.lockCanvas();
					synchronized (surfaceHolder)
					{
						playingField.onDraw( canvas );
					}
					break;
				default:
					break;
				}
			}
			finally
			{
				if (canvas != null)
				{
					surfaceHolder.unlockCanvasAndPost( canvas );
				}
			}
		}
	}
	
	public void setRunning( boolean status )
	{
		running = status;
	}
}
