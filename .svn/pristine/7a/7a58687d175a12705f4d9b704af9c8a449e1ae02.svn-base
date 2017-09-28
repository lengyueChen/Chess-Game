package pieces;
/**
 * Special knight is moving 1 step longer in horizontal or vertical direction than normal knight.
 */
public class SpecialKnight extends Piece {
	public SpecialKnight(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		super(x_pos, y_pos, player);
		name = color?"Wspecialknight":"Bspecialknight";
	}
	@Override
	public boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos) {
		// TODO Auto-generated method stub
		return  ((target_x_pos-cur_x_pos==1)&&(target_y_pos-cur_y_pos==3))||((target_x_pos-cur_x_pos==3)&&(target_y_pos-cur_y_pos==1))||
				((target_x_pos-cur_x_pos==3)&&(target_y_pos-cur_y_pos==-1))||((target_x_pos-cur_x_pos==1)&&(target_y_pos-cur_y_pos==-3))||
				((target_x_pos-cur_x_pos==-1)&&(target_y_pos-cur_y_pos==3))||((target_x_pos-cur_x_pos==-1)&&(target_y_pos-cur_y_pos==-3))||
				((target_x_pos-cur_x_pos==-3)&&(target_y_pos-cur_y_pos==1))||((target_x_pos-cur_x_pos==-3)&&(target_y_pos-cur_y_pos==-1));
	}

}
