package pieces;

public class Rook extends Piece{
	public Rook(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		super(x_pos, y_pos, player);
		name = color?"Wrook":"Brook";
		image_white = "data/sprites/Wrook.png";
		image_black = "data/sprites/Brook.png";
	}
	@Override
	public boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos) {
		// TODO Auto-generated method stub
		if(target_x_pos==cur_x_pos||target_y_pos==cur_y_pos)
			return true;
		return false;
	}
}
