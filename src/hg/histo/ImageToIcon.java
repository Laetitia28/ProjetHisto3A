package hg.histo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ImageToIcon {

	public static ImageIcon scale(String source, int width, int height) {

		
		ImageIcon icon = new ImageIcon(source);
		Image imag = icon.getImage();
		BufferedImage bi = new BufferedImage(imag.getWidth(null), imag.getHeight(null), BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.createGraphics();
		g.drawImage(imag, 0, 0, width, height, null);
		ImageIcon newIcon = new ImageIcon(bi);
		return newIcon;
	}
}
