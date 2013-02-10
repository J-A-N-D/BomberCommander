package com.jand.bombercommander;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class GameObject {
	
	private Bitmap bitmap;
	private int posX, posY;
	private int width, height;
	private boolean isTouched;
	private boolean is_player_one;
	private int field_position;
	private int lane;
	GameObjectType type;
	
	public enum GameObjectType {
		ANTIAIR, FIGHTER, BOMBER
	}
	
	public GameObject(Bitmap graphics, int x, int y) {
		this.bitmap = graphics;
		posX = x;
		posY = y;
		isTouched = false;
		this.is_player_one = true;
		this.field_position = 0;
		this.type = GameObjectType.ANTIAIR;
		lane = -1;
	}
	
	public GameObject(GameObjectType start_type, boolean start_is_player_one, int start_field_position) {
		this.type = start_type;
		this.is_player_one = start_is_player_one;
		this.field_position = start_field_position;
		lane = -1;
	}
	
	public Bitmap getBitmap()
	{
		return bitmap;
	}
	
	public void setBitmap( Bitmap bitmap )
	{
		this.bitmap = bitmap;
	}
	
	public int getX()
	{
		return posX;
	}
	
	public void setX( int x )
	{
		posX = x;
	}
	/**
	 * returns the lane that this object has been placed in
	 * returns -1 if the lane has not been set
	 */
	public int getLane()
	{
		return lane;
	}
	/**
	 * sets the lane of the object
	 * @return
	 */
	public void setLane(int lane){
		this.lane = lane;
	}
	public int getY()
	{
		return posY;
	}
	
	public void setY( int y )
	{
		posY = y;
	}
	
	public boolean getIsTouched()
	{
		return isTouched;
	}
	
	public void setIsTouched( boolean touched )
	{
		isTouched = touched;
	}
	
	public boolean getIsPlayerOne() {
		return is_player_one;
	}
	
	public int getFieldPosition() {
		return field_position;
	}
	
	public GameObjectType getType() {
		return type;
	}
	
	
	public void setIsPlayerOne(boolean is_player_one) {
		this.is_player_one = is_player_one;
	}
	
	public void setFieldPosition(int new_field_position) {
		this.field_position = new_field_position;
	}
	
	public void setType(GameObjectType new_type) {
		this.type = new_type;
	}
	
	/**
	 * returns true if the object is being touched
	 * @param eventX
	 * @param eventY
	 * @return
	 */
	public boolean handleActionDown( int eventX, int eventY )
	{
		if (eventX >= (posX - bitmap.getWidth()) && (eventX <= (posX + bitmap.getWidth())))
		{
			if (eventY >= (posY - bitmap.getHeight()) && (eventY <= (posY + bitmap.getHeight())))
				setIsTouched( true );
			else
				setIsTouched( false );
		}
		else
			setIsTouched( false );
		return isTouched;
	}
	
	public void draw( Canvas c )
	{
		c.drawBitmap( bitmap, posX, posY, null );
	}
	
}