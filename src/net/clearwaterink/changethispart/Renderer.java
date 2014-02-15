package net.clearwaterink.changethispart;

import net.clearwaterink.changethispart.world.World;

/**
 * The class used for rendering things within the world itself
 * 
 * This class will also contain initialized classes that involve
 * the world. Entities (besides player, just call that class from main),
 * sprites, etc.
 * 
 * @author ClearWaterInk
 *
 */
public class Renderer {
	
	// Always make classes public so they can be called from other classes
	public World world;
	
	public Renderer() {
		world = new World();
	}
	
	/**
	 * Where everything in the world is actually rendered
	 * 
	 * (Use other classes for rendering things and create
	 * render methods in them, then call the render method
	 * here)
	 * 
	 * ANYTHING GUI RELATED IS NOT PUT HERE
	 */
	public void render() {
		world.Render();
	}
}
