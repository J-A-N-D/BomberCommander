package com.jand.bombercommander;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlayingFieldView extends SurfaceView implements SurfaceHolder.Callback {
	private static final String TAG = PlayingFieldView.class.getSimpleName();
	private GameThread thread;
	
	private ArrayList<GameObject> gameObjects;
	
	public PlayingFieldView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		
		if( !isInEditMode() )
		{
			this.setZOrderOnTop( true );
			getHolder().setFormat( PixelFormat.TRANSPARENT );
		}
		
		getHolder().addCallback( this );
		
		// Game object tests
		gameObjects = new ArrayList<GameObject>();
		gameObjects.add( new GameObject(BitmapFactory.decodeResource(getResources(), R.drawable.bc_aa), 50, 640) );
		gameObjects.add( new GameObject(BitmapFactory.decodeResource(getResources(), R.drawable.bc_bomber), 200, 640) );
		gameObjects.add( new GameObject(BitmapFactory.decodeResource(getResources(), R.drawable.bc_fighter), 350, 640) );
		gameObjects.add( new GameObject(BitmapFactory.decodeResource(getResources(), R.drawable.bc_explosion), 500, 640) );
		
		thread = new GameThread( getHolder(), this );
		setFocusable( true );
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Matrix reverse = new Matrix();
		reverse.postRotate(180);
		
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
			for (GameObject obj : gameObjects)
			{
				obj.handleActionDown( (int)event.getX(), (int)event.getY() );
			}
			
		
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
			for (GameObject obj : gameObjects)
			{
				if (obj.getIsTouched())
				{
					obj.setX( (int)event.getX() - obj.getBitmap().getWidth() / 2 );
					obj.setY( (int)event.getY() - obj.getBitmap().getHeight() / 2 );
				}
			}
		}
		
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			for (GameObject obj : gameObjects)
			{
				if (obj.getIsTouched()) obj.setIsTouched( false );
				
				if ( obj.getY() < 100)
				{
					if (obj.getX() > 144 * 4)
					{
						obj.setX(144 * 4);
						
					}
					else if (obj.getX() > 144 * 3)
					{
						obj.setX(144*3);
						obj.setY(0);
					}
					else if (obj.getX() > 144 * 2)
					{
						obj.setX(144 * 2);
						obj.setY(0);
					}
					else if (obj.getX() > 144)
					{
						obj.setX(144);
						obj.setY(0);
					}
					else
					{
						obj.setX(0);
						obj.setY(0);
					}
				}
			}
		}
		
		return true;
	}
	
	@Override
	public void onDraw( Canvas c )
	{
		if( !isInEditMode() )
		{
			c.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
		
			for (GameObject obj : gameObjects)
			{
				obj.draw( c );	
			}
		}
	}
}
