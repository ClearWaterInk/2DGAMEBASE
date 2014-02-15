package net.clearwaterink.changethispart;

/**
 * Custom Vector2f class
 * 
 * @author brandon
 *
 */
public class Vector2f {
	public float x = 0.0f, y = 0.0f;
	
	public Vector2f() {}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}
