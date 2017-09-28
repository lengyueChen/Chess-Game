package GameGUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import GameGUI.Game;
import GameGUI.GameFrame;

public class MouseOverArea implements MouseListener, MouseMotionListener  {
	BufferedImage image;
	int x_position, y_position, button_width,button_height;
	public boolean mouseOver = false;
	String ID;
	/**
	 * Constructor
	 * @param ID
	 * @param fileAddress
	 * @param x_pos
	 * @param y_pos
	 */
	public MouseOverArea(String ID, String fileAddress, int x_pos, int y_pos) {
		image = ImageCoverter(fileAddress, 0, 0);
		this.ID = ID;
		x_position = x_pos;
		y_position = y_pos;
		button_width = 60;
		button_height = 60;
	}
	public void draw(Graphics g) {
			g.drawImage(image, x_position, y_position, null);
	}
	@Override	
	public void mouseMoved(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	
	/**
	 * Reads in an image and convert it to BufferedImage
	 * @param fileName
	 * @param width
	 * @param height
	 * @return
	 */
	public static BufferedImage ImageCoverter(String fileName, int width, int height) {
		try {
			BufferedImage picture = ImageIO.read(new File(fileName));
			//if no need to transform the image
			if (width == 0 || height == 0)
				return picture;
			//need to scale the image
			BufferedImage bdest = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D d = bdest.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance((double) width / picture.getWidth(), (double) height/ picture.getHeight());
			d.drawRenderedImage(picture, at);
			return bdest;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
