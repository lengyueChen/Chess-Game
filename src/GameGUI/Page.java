package GameGUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * A super class built to organize the screens of the game.
 */
public abstract class Page extends JPanel{
	String title;
	public Page (String title){
		this.title = title;
	}
	@Override 
	public void paintComponent(Graphics g) {
		draw(g);
	}
	public abstract void draw(Graphics g);
}
