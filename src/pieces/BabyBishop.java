package pieces;
/**
 * BabyBishop moves like a bishop but can only move 2 steps each time.
 */
public class BabyBishop extends Piece{
	public BabyBishop(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		super(x_pos, y_pos, player);
		name = color?"Wbabybishop":"Bbabybishop";
	}
	@Override
	public boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos) {
		// TODO Auto-generated method stub
		int x_distance = Math.abs(target_x_pos-cur_x_pos);
		int y_distance = Math.abs(target_y_pos-cur_y_pos);
		if (x_distance==y_distance&&x_distance==2&y_distance==2) 
			return true;
		return false;
	}

}
