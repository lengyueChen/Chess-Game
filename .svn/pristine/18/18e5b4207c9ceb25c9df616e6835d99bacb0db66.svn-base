package pieces;

public class Knight extends Piece{
	public Knight(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		super(x_pos, y_pos, player);
		name = color?"Wknight":"Bknight";
		image_white = "data/sprites/WKnight.png";
		image_black = "data/sprites/BKnight.png";
	}
	@Override
	public boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos) {
		// TODO Auto-generated method stub
		return  ((target_x_pos-cur_x_pos==1)&&(target_y_pos-cur_y_pos==2))||((target_x_pos-cur_x_pos==2)&&(target_y_pos-cur_y_pos==1))||
				((target_x_pos-cur_x_pos==2)&&(target_y_pos-cur_y_pos==-1))||((target_x_pos-cur_x_pos==1)&&(target_y_pos-cur_y_pos==-2))||
				((target_x_pos-cur_x_pos==-1)&&(target_y_pos-cur_y_pos==2))||((target_x_pos-cur_x_pos==-1)&&(target_y_pos-cur_y_pos==-2))||
				((target_x_pos-cur_x_pos==-2)&&(target_y_pos-cur_y_pos==1))||((target_x_pos-cur_x_pos==-2)&&(target_y_pos-cur_y_pos==-1));
	}
}
