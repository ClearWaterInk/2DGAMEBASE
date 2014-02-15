package net.clearwaterink.changethispart.entities;

import static org.lwjgl.opengl.GL11.*;

import net.clearwaterink.changethispart.Vector2f;

public class Player {
	private Vector2f position;
	
	public Player(float x, float y){
		position = new Vector2f(x, y);
	}
    
    public void strafeLeft(float distance){
    	position.x += distance;
    }

    public void strafeRight(float distance){
    	position.x -= distance;
    }
    
    public void flyUp(float distance){
    	position.y += distance;
    }
    
    public void flyDown(float distance){
    	position.y -= distance;
    }
    
	public void lookThrough(){
		glTranslatef(position.x, position.y, 0);
	}
	
	public void setPos(int x, int y){
		position.x = x;
		position.y = y;
	}
	
	public Vector2f getPosition() {
		return position;
	}
}