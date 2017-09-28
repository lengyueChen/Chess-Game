package GameGUI;
import java.awt.Graphics2D;
import sun.audio.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameFrame extends JFrame implements ActionListener {
	private Game game;
	private JMenuBar menuBarb;
	public Page currentPage;
	public boolean gameFinished;
	BufferedImage background;	
	//make it static so that other class can dynamically set changes to the main frame (e.g. change cursor)
	public static GameFrame mainFrame;
	/**
	 *  Constructor for GameFrame
	 *  makes panels and start the updater.
	 */
	public GameFrame(){
		super("Plants VS Zombies");
		mainFrame = this;
		gameFinished = false;
		game = new Game();
		//set up size
		int game_width = game.gameBackground.getWidth();
		int game_height = game.gameBackground.getHeight()+50;
		setSize(game_width,game_height);
		game.setSize(game_width, game_height);
		game.setLocation(0, 0);
		//add menu
		menuBarb = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem convertMenuItem = new JMenuItem("New Game");
		JMenuItem aboutMenuItem = new JMenuItem("Undo");
		menuBarb.add(menu);
		menu.add(convertMenuItem);
		menu.add(aboutMenuItem);
		setJMenuBar(menuBarb);
		convertMenuItem.addActionListener(this);
		aboutMenuItem.addActionListener(this);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(game);
		// set current displaying page, there may be more pages in the future development
		currentPage = game;
		Updater u = new Updater();
		u.run();	
	}
	/** set the page
	 * @param pageID
	 */
	public void setPage(String pageID) {
		System.out.println("SETTING PAGE TO: " + pageID);
		// there may be more pages in the future, so I will use switch statement for them. But this time only 1 page so I am using if
		if (pageID.equals("game")) 
			setPageObject(game);
	}
	/**
	 * Do the actual set page job.
	 * @param p
	 */
	public void setPageObject(Page p) {
		currentPage = null;
		getContentPane().removeAll();
		getContentPane().add(p);
		currentPage = p;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}