package net.clearwaterink.changethispart;

import static org.lwjgl.opengl.GL11.glLoadIdentity;
import net.clearwaterink.changethispart.entities.Player;
import net.clearwaterink.changethispart.gui.Gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class Main {
	
	// Make other classes public so you can pass Main to another class
	// and access all initialized classes used for the game
	public Controls controls;
	public Gui gui;
	public Player player;
	public Renderer renderer;
	
	private int width = 640, height = 480;
	// Variables used for getting the FPS
	private long fps = 0, lastFPS = 0, lastFrame = 0;
	// Holds the current FPS
	private String strFPS = "";
	
	/**
	 * Initializes variables and starts the game loop
	 */
	public Main() {
		gui = new Gui();
		player = new Player(0, 0);
		start();
	}
	
	/**
	 * Game loop and initialization of the game
	 */
	private void start() {
		try {
            Display.setDisplayMode(new DisplayMode(width, height));
            Display.setResizable(true);
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

		// Never pass another class any class but this one(Main).
		controls = new Controls(this);
		renderer = new Renderer();
		
		initGL();
		
		while (!Display.isCloseRequested()) {
			// Listens for the display to be resized
			if(Display.wasResized()){width=Display.getWidth();height=Display.getHeight();onResize();}
			listenForKeyPresses();
			
			// OpenGL stuff here
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			// Always render terrain before the GUI
			// Else transparent/opaque GUI images won't be transparent/opaque
			renderer.render();

			gui.draw();
			
    		glLoadIdentity();
    		// This class controls the map movement, also should be used for
    		// everything related to the Player (besides GUI)
			player.lookThrough();
			
			Display.update();
			updateFPS();
		}
		Display.destroy();
		System.exit(0);
	}
	
	/**
	 * Initialize the OpenGL environment
	 */
	private void initGL() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, height, 0, -1, 10);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	/**
	 * Fix the things within the window if the display is resized
	 */
	private void onResize() {
		GL11.glViewport(0, 0, width, height);
	}
	
	/**
	 * Listens for a key being pressed on each frame
	 */
	private void listenForKeyPresses() {
		controls.listenForControls(getDelta());
	}
	
	/**
	 * When the JAR is executed start the Main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {new Main();}
	
	/* FPS STUFF */
	
	private long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	/**
	 * This is used for keeping update speed constant regardless
	 * of FPS
	 * 
	 * @return
	 */
	private int getDelta() {
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		return delta;
	}
	
	/**
	 * Gets the FPS
	 */
	private void updateFPS() {
		if (getTime() - lastFPS > 1000) {
			strFPS = fps + " ";
			fps = 0;
			lastFPS += 1000;
		}
		fps++;
	}
	
	/**
	 * Returns the most recent FPS
	 * 
	 * @return
	 */
	public String getFPS() {
		return strFPS;
	}
}
