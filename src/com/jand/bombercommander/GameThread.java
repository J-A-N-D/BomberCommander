package com.jand.bombercommander;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.TextView;

public class GameThread extends Thread {
	private static final String TAG = GameThread.class.getSimpleName();
	private static enum gameState { P1_SETUP, P2_SETUP };
	gameState state;
	private boolean running;
	private SurfaceHolder surfaceHolder;
	private PlayingFieldView playingField;
	
	public GameThread( SurfaceHolder sh, PlayingFieldView pf )
	{
		super();
		surfaceHolder = sh;
		playingField = pf;
		state = gameState.P1_SETUP;
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
				canvas = this.surfaceHolder.lockCanvas();
				synchronized (surfaceHolder)
				{
					playingField.onDraw( canvas );
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
