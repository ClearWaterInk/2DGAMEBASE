package net.clearwaterink.changethispart;

import java.awt.image.BufferedImage;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Tools {
	/**
	 * Turns an image within the RES folder into a texture
	 * 
	 * @param path
	 * @return
	 */
	public static int loadTexture(String path) {
		int tex = 0;

		BufferedImage img = null;

		try {
			img = ImageIO.read(Main.class.getResourceAsStream(path));
		} catch (Exception e) {
			System.out.print(e.toString());
			return 0;
		}

		int[] pix = img.getRGB(0, 0, img.getWidth(), img.getHeight(), null, 0, img.getWidth());
		ByteBuffer bb = BufferUtils.createByteBuffer((img.getWidth() * img.getHeight()) * 4);

		for (int i = 0; i < pix.length; i++) {
			byte alpha = (byte) ((pix[i] >> 24) & 0xFF);
			byte red = (byte) ((pix[i] >> 16) & 0xFF);
			byte green = (byte) ((pix[i] >> 8) & 0xFF);
			byte blue = (byte) ((pix[i]) & 0xFF);

			bb.put(red);
			bb.put(green);
			bb.put(blue);
			bb.put(alpha);
		}

		bb.flip();

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, tex);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, img.getWidth(), img.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, bb);

		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);

		return tex;
	}
}
