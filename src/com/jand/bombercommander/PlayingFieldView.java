package com.jand.bombercommander;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlayingFieldView extends SurfaceView implements SurfaceHolder.Callback {
	private static final String TAG = PlayingFieldView.class.getSimpleName();
	private GameThread thread;
	private GameObject AAGun;
	
	public PlayingFieldView(Context context) {
		super(context);
		
		getHolder().addCallback( this );
		
		AAGun = new GameObject( BitmapFactory.decodeResource(getResources(), R.drawable.bc_aa), 50, 50 );
		
		thread = new GameThread( getHolder(), this );
		setFocusable( true );
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.setRunning( true );
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		
		Log.d( TAG, "Surface is being destroyed" );
		while (retry)
		{
			try
			{
				thread.join();
				retry = false;
			}
			catch (InterruptedException e)
			{
				Log.d( VIEW_LOG_TAG, e.getMessage() );
			}
		}
		Log.d(TAG, "Thread was shut down cleanly");
	}
	
	@Override
	public boolean onTouchEvent( MotionEvent event )
	{
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			AAGun.handleActionDown( (int)event.getX(), (int)event.getY() );
		
			if (event.getY() > getHeight() - 100 )
			{
				thread.setRunning(false);
				((Activity)getContext()).finish();
			}
			else
				Log.d(VIEW_LOG_TAG, "Coords: x = " + event.getX() + ", y = " + event.getY() );
		}
			
		if (event.getAction() == MotionEvent.ACTION_MOVE)
		{
			if (AAGun.getIsTouched())
			{
				AAGun.setX( (int)event.getX() );
				AAGun.setY( (int)event.getY() );
			}
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			if (AAGun.getIsTouched()) AAGun.setIsTouched( false );
		}
		
		return true;
	}
	
	@Override
	public void onDraw( Canvas c )
	{
		c.drawColor( Color.GRAY );
		AAGun.draw( c );
	}
}
