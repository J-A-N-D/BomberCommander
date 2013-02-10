package com.jand.bombercommander;

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
