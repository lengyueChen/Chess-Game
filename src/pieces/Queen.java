package pieces;

public class Queen extends Piece{
	public Queen(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		super(x_pos, y_pos, player);
		name = color?"Wqueen":"Bqueen";
		image_white = "data/sprites/Wqueen.png";
		image_black = "data/sprites/Bqueen.png";
	}
	@Override
	public boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos) {
		// TODO Auto-generated method stub
		int x_distance = Math.abs(target_x_pos-cur_x_pos);
		int y_distance = Math.abs(target_y_pos-cur_y_pos);
		
		if (x_distance==y_distance) 
			return true;
		
		if(target_x_pos==cur_x_pos||target_y_pos==cur_y_pos)
			return true;
		return false;
	}
}
