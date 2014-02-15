package net.clearwaterink.changethispart.world;

import org.lwjgl.opengl.GL11;

public class World {

	public World() {
		
	}
	
	public void Render() {
		GL11.glColor3f(0.0f, 1.0f, 0.0f);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glVertex2f(0, 0);
			GL11.glVertex2f(10, 0);
			GL11.glVertex2f(10, 10);
			GL11.glVertex2f(0, 10);
		GL11.glEnd();
	}
}
