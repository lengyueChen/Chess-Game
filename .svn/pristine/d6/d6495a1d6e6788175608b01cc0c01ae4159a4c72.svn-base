package pieces;
import pieces.Cell;

public class Board {
	public Piece[][] board;
	/**
	 * Constructor to set up board with all pieces in positions for game.
	 */
	public Board() {
		// TODO Auto-generated constructor stub
		board = new Piece[8][8];
		InitializePieces(true);
		InitializePieces(false);
		for (int i = 0;i<8;i++){
			board[i][1] = new Pawn(i,1,true);
			board[i][6] = new Pawn(i, 6, false);
		}
	}
	/** helper function for the board constructor
	 * Initialize all pieces except pawns
	 * 
	 * @param player
	 */
	private void InitializePieces(boolean player){
		int row;
		row = player?0:7;
		board[0][row] = new Rook(0,row,player);
		board[1][row] = new Knight(1,row,player);
		board[2][row] = new Bishop(2,row,player);
		board[3][row] = new King(3,row,player);
		board[4][row] = new Queen(4,row,player);
		board[5][row] = new Bishop(5,row,player);
		board[6][row] = new Knight(6,row,player);
		board[7][row] = new Rook(7,row,player);
	}
	/**
	 * Move function for all pieces
	 * 
	 * @param player: the player who is moving pieces.(true for white, false for black)
	 * @param cur_x_pos
	 * @param cur_y_pos
	 * @param target_x_pos
	 * @param target_y_pos
	 * @return true for a successful move, false otherwise
	 */
	public boolean Move( boolean player,int cur_x_pos,int cur_y_pos,int target_x_pos,int target_y_pos){
		if (Movable(player,cur_x_pos, cur_y_pos, target_x_pos, target_y_pos)){
			Piece cur_piece = board[cur_x_pos][cur_y_pos];
			cur_piece.cur_x_pos = target_x_pos;
			cur_piece.cur_y_pos = target_y_pos;
			board[target_x_pos][target_y_pos] = cur_piece;
			board[cur_x_pos][cur_y_pos] = null;
			return true;
		}
		return false;
	}
	/**
	 * Check if a move is legal thorouly
	 *  
	 * @param player: the player who is moving pieces.(true for white, false for black)
	 * @param cur_x_pos
	 * @param cur_y_pos
	 * @param target_x_pos
	 * @param target_y_pos
	 * @return
	 */
	public boolean Movable(boolean player,int cur_x_pos,int cur_y_pos,int target_x_pos,int target_y_pos){	
		//1. Check if out of bounds
		if (cur_x_pos<0||cur_x_pos>7||cur_y_pos<0||cur_y_pos>7||target_x_pos<0||target_x_pos>7||target_y_pos<0||target_y_pos>7){	
			return false;
		}
		Piece cur_piece = board[cur_x_pos][cur_y_pos];
		Piece target_piece = board[target_x_pos][target_y_pos];
		
		/*
		 * 2. Check if the cur piece is null
		 * 3. Check if you are moving the other player's piece
		 * 4. Check if the target position stands a piece with same color
		 * 5. check against the moving rule of this piece
		 * 6. check the moving path is clear
		 */
		if (cur_piece == null||cur_piece.color!=player||target_piece!=null&&target_piece.color == cur_piece.color
				||!cur_piece.CheckMovingRules(this,target_x_pos, target_y_pos)||!CheckInterPosition(cur_x_pos, cur_y_pos, target_x_pos, target_y_pos)){
			return false;
		}
		if (cur_piece instanceof Pawn)
			((Pawn) cur_piece).firstMove = false;
		return true;
	}
	/**
	 *  Check if the path is clear before moving a piece. i.e. make sure no other pieces block its way
	 * @param cur_x_pos
	 * @param cur_y_pos
	 * @param target_x_pos
	 * @param target_y_pos
	 * @return
	 */
	public boolean CheckInterPosition(int cur_x_pos,int cur_y_pos,int target_x_pos,int target_y_pos){
		//do not need to check if current piece is a knight, king or pawn after its first move
		Piece cur_piece = board[cur_x_pos][cur_y_pos];
		if (cur_piece instanceof King||(cur_piece instanceof Pawn&&!((Pawn) cur_piece).firstMove)||cur_piece instanceof Knight)
			return true;
		//get all inter positions and check if any pieces stands on the way.
		Cell[] interpositions = GetInterPosition(cur_x_pos, cur_y_pos, target_x_pos, target_y_pos);
		if(interpositions==null){
			return true;
		}
		for (int i = 0;i<8;i++){
			if(interpositions[i]!=null){
				if(board[interpositions[i].x_pos][interpositions[i].y_pos]!=null){
					return false;
				}
			}
		}
		return true;
	}
	/**
	 *  Get the inter positions between current position and target position.
	 * @param cur_x_pos
	 * @param cur_y_pos
	 * @param target_x_pos
	 * @param target_y_pos
	 * @return
	 */
	public Cell[] GetInterPosition(int cur_x_pos,int cur_y_pos,int target_x_pos,int target_y_pos){
		if((Math.abs(cur_x_pos-target_x_pos)<=1)&&(Math.abs(cur_y_pos-target_y_pos)<=1))
			return null;
		Cell[] interPositions = new Cell[8];
		//Get vertical inter positions
		if(cur_x_pos==target_x_pos){
			int distance = Math.abs(target_y_pos - cur_y_pos);
			if (target_y_pos > cur_y_pos){
				for (int i = 1;i<distance;i++){
					interPositions[i-1] = new Cell(cur_x_pos,cur_y_pos+i);
				}
				return interPositions;
			}
			else
			{
				for (int i = 1;i<distance;i++){
					interPositions[i-1] = new Cell(cur_x_pos,cur_y_pos-i);			
				}
				return interPositions;
			}
		}
		//Get horizontal inter positions
		else if(cur_y_pos==target_y_pos)
		{
			int distance = Math.abs(target_x_pos - cur_x_pos);
			if (target_x_pos < cur_x_pos){
				for (int i = 1;i<distance;i++){
					interPositions[i-1] = new Cell(cur_x_pos-i,cur_y_pos);
				}
				return interPositions;
			}
			else
			{
				for (int i = 1;i<distance;i++){
					interPositions[i-1] = new Cell(cur_x_pos+i,cur_y_pos);
				}
				return interPositions;
			}
				
		}
		//Get diagonal inter positions
		else {
			int distance = Math.abs(target_x_pos - cur_x_pos);
			if(target_x_pos>cur_x_pos&&target_y_pos>cur_y_pos)
				{
					for (int i = 1;i<distance;i++){
						interPositions[i-1] = new Cell(cur_x_pos+i,cur_y_pos+i);
					}
					return interPositions;
				}
				else if(target_x_pos>cur_x_pos&&target_y_pos<cur_y_pos){
					for (int i = 1;i<distance;i++){
						interPositions[i-1] = new Cell(cur_x_pos+i,cur_y_pos-i);
					}
					return interPositions;					
				}
				else if(target_x_pos<cur_x_pos&&target_y_pos>cur_y_pos){
					for (int i = 1;i<distance;i++){
						interPositions[i-1] = new Cell(cur_x_pos-i,cur_y_pos+i);
					}
					return interPositions;
				}
				else
				{
					for (int i = 1;i<distance;i++){
						interPositions[i-1] = new Cell(cur_x_pos-i,cur_y_pos-i);			
					}
					return interPositions;
				}
			}
	}
	/**
	 * To determine if the player's king is checked
	 * @param player : the player whose king is checked
	 * @param threatening_piece_x
	 * @param threatening_piece_y
	 * @return
	 */
	public boolean CheckMate(boolean player,int threatening_piece_x,int threatening_piece_y){
		// Check out of bounds
		if(threatening_piece_x<0||threatening_piece_x>7||threatening_piece_y<0||threatening_piece_y>7){
			return false;
		}
		// Check if there actually is a threatening_piece.
		if (board[threatening_piece_x][threatening_piece_y]==null){
			return false;
		}
		// Find the king
		int king_x_pos = 0, king_y_pos = 0;
		for (int i = 0;i<8;i++){
			for(int j = 0;j<8;j++){
				if( board[i][j] instanceof King&&board[i][j].color==player){
					king_x_pos = i;
					king_y_pos = j;
					break;
				} 
			}
		}
		Piece threatening_piece = board[threatening_piece_x][threatening_piece_y];
		//1. Try to kill the threatening pieces
		for (int i = 0;i<8;i++){
			for (int j = 0;j<8;j++){
				if (Movable(player, i, j, threatening_piece_x, threatening_piece_y)){
					return false;
				}
			}
		}
		//2. Try to block the threatening piece
		if(!(threatening_piece instanceof Knight)){
			Cell[] interPositions = GetInterPosition(king_x_pos, king_y_pos, threatening_piece_x, threatening_piece_y);
			if (interPositions!=null){
				for(int i =0;i<8;i++){
					if (interPositions[i]!=null){
						for (int j = 0;j<8;j++){
							for (int k = 0;k<8;k++){ 
								// Can the player who is checked move a non-king piece to any cell in interPosition?
								if (Movable(player, j, k, interPositions[i].x_pos, interPositions[i].y_pos)&&!(board[j][k] instanceof King)){
									System.out.println("inter position "+interPositions[i].x_pos+" "+interPositions[i].y_pos);
									System.out.println(j+" "+k);
									return false;
								}
							}
						}
					}
				}
			}
		}
		//3. Try to Let the king run
		return (KingDangerous(player,king_x_pos,king_y_pos,king_x_pos+1,king_y_pos)&&KingDangerous(player,king_x_pos,king_y_pos,king_x_pos,king_y_pos+1)&&KingDangerous(player,king_x_pos,king_y_pos,king_x_pos+1,king_y_pos+1)
				&&KingDangerous(player,king_x_pos,king_y_pos,king_x_pos-1,king_y_pos)&&KingDangerous(player,king_x_pos,king_y_pos,king_x_pos,king_y_pos-1)&&KingDangerous(player,king_x_pos,king_y_pos,king_x_pos-1,king_y_pos-1)&&
				KingDangerous(player,king_x_pos,king_y_pos,king_x_pos+1,king_y_pos-1)&&KingDangerous(player,king_x_pos,king_y_pos,king_x_pos-1,king_y_pos+1));			
	}
	
	/**
	 * To determin if king is dangerous (can be captured) in a certain positions
	 * @param player
	 * @param king_x_pos
	 * @param king_y_pos
	 * @param potential_safe_x_pos
	 * @param potential_safe_y_pos
	 * @return
	 */
	public boolean KingDangerous(boolean player,int king_x_pos,int king_y_pos,int potential_safe_x_pos,int potential_safe_y_pos){
		//1. check out of bound
		if (king_x_pos<0||king_x_pos>7||king_y_pos<0||king_y_pos>7)
			return true;
		// King can not move to this position because it was occupied.
		if (!Movable(player,king_x_pos,king_y_pos,potential_safe_x_pos,potential_safe_y_pos))
			return true;
		// Can any of the other player's piece move to this positions? i.e. capture the king
		for (int i = 0;i<8;i++){
			for (int j = 0;j<8;j++){ 
				if(Movable(!player, i, j, potential_safe_x_pos, potential_safe_y_pos)){
					return true;
				}
			}
		}
		return false;
	}
}
