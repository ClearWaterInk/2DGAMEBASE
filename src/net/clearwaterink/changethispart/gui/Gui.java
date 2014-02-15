package net.clearwaterink.changethispart.gui;

import static org.lwjgl.opengl.GL11.*;

/**
 * Class that will be used to draw all GUI related items
 * 
 * E.G. Menus, text, chat, etc.
 * 
 * @author ClearWaterInk
 *
 */
public class Gui {
	
	public HUD hud;
	
	public Gui() {
		hud = new HUD(this);
	}
	
	/**
	 * Draws everything GUI related
	 * 
	 * (Do not actually draw anything here. Create other classes
	 * and put a draw method in the class then call that classes'
	 * draw method here.)
	 */
	public void draw() {
		glLoadIdentity();
		hud.draw();
	}
	
	/**
	 * Draws a quadrilateral on screen
	 * 
	 * @param startX
	 * @param startY
	 * @param endX
	 * @param endY
	 */
	public void drawQuad(float startX, float startY, float endX, float endY, int hexColor) {
		// Convert hex color codes into OpenGL's four float color format
		float a = (float)(hexColor >> 24 & 255) / 255.0F;
        float r = (float)(hexColor >> 16 & 255) / 255.0F;
        float g = (float)(hexColor >> 8 & 255) / 255.0F;
        float b = (float)(hexColor & 255) / 255.0F;

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glBegin(GL_QUADS);
			glColor4f(r, g, b, a);
			glVertex2f(startX, endY);
			glVertex2f(endX,   endY);
			glVertex2f(endX,   startY);
			glVertex2f(startX, startY);
		glEnd();
		glDisable(GL_BLEND);
	}
}
