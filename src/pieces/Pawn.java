package pieces;

public class Pawn extends Piece {
	boolean firstMove;
	public Pawn(int x_pos,int y_pos,boolean player) {
		// TODO Auto-generated constructor stub
		super(x_pos, y_pos, player);
		firstMove = true;
		name = color?"Wpawn":"Bpawn";
		image_white = "data/sprites/Wpawn.png";
		image_black = "data/sprites/Bpawn.png";
	}
	@Override
	public boolean CheckMovingRules(Board testBoard,int target_x_pos, int target_y_pos) {
		// TODO Auto-generated method stub
		Piece target_piece =testBoard.board[target_x_pos][target_y_pos];
		//pawn can only move forward
		if (color == true&&target_x_pos==cur_x_pos&&target_y_pos-cur_y_pos==1){
			return true;
		}
		// Pawn can move two steps at the first move 
		if(color == true&&target_x_pos==cur_x_pos&&target_y_pos-cur_y_pos==2&&firstMove){	
			return true;
		}
		if(color == false&&target_x_pos==cur_x_pos&&target_y_pos-cur_y_pos==-2&&firstMove){	
			return true;
		}
		if (color == false&&target_x_pos==cur_x_pos&&target_y_pos-cur_y_pos==-1){
			return true;
		}
		//pawn captures other pieces
		if( target_piece!=null&&target_piece.color!=color){
			//white pawn can only go down
			if(color == true&&target_y_pos-cur_y_pos==1&&Math.abs(target_x_pos-cur_x_pos)==1){	
				return true;
			}	
			//black pawn can only go up
			if(color == false&&target_y_pos-cur_y_pos==-1&&Math.abs(target_x_pos-cur_x_pos)==1){
				return true;
			}			
		}
		return false;
	}
}
