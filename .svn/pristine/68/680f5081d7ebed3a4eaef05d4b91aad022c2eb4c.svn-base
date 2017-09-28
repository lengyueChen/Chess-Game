package GameGUI;
import javax.swing.JPanel;

import GameGUI.GameFrame;

/**
 * This class is make for the sole purpose of updating pages in the game.
 */
public class Updater extends Thread {
	/**
	 * automatically update the pages in game.
	 */
	public void run() {
		while (!GameFrame.mainFrame.gameFinished) {
			if (GameFrame.mainFrame.currentPage != null){
				GameFrame.mainFrame.currentPage.repaint();
				GameFrame.mainFrame.setVisible(true);}
		}
	}
}
