package pieces;

public abstract class Piece {
	public int cur_x_pos, cur_y_pos;
	public boolean color;
	public String name;
	public String image_white;
	public String image_black;
	/**
	 * @param x_pos
	 * @param y_pos
	 * @player true for white and false for black
	 */
	public Piece(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		cur_x_pos = x_pos;
		cur_y_pos = y_pos;
		color = player;
	}
	/**
	 * Test if a move is legal only against the moving rules of the piece.
	 * @param testBoard
	 * @param target_x_pos
	 * @param target_y_pos
	 * @return
	 */
	public abstract boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos);
	
}
