package net.clearwaterink.changethispart.gui;

/**
 * In-game HUD, this is an example fix this.
 * 
 * @author ClearWaterInk
 *
 */
public class HUD {
	
	public Gui gui;
	
	public HUD(Gui gui) {
		this.gui = gui;
	}
	
	public void draw() {
		gui.drawQuad(10.0f, 10.0f, 60.0f, 60.0f, 0x55ffffFF);
	}
}
