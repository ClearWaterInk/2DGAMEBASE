package net.clearwaterink.changethispart;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Controls {
	
	private Main main;
	
	/**
	 * Creates the keyboard
	 */
	public Controls(Main main) {
		this.main = main;
    	try {
    		Keyboard.create();
    	} catch(Exception e) {
    		System.out.print(e);
    	}
	}
	
	/**
	 * Performs actions if keys are pressed
	 * 
	 * @param dt - Delta used to make movement speed constant
	 */
	public void listenForControls(int dt) {
    	float movementSpeed = 0.015f * dt;
    	
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			main.player.strafeLeft(movementSpeed);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			main.player.strafeRight(movementSpeed);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			main.player.flyUp(movementSpeed);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			main.player.flyDown(movementSpeed);
		}
		
		if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
			Display.destroy();
			System.exit(0);
		}
	}
}
