package piecesTest;

import static org.junit.Assert.*;

import javax.print.attribute.standard.PrinterLocation;

import org.junit.Test;

import pieces.Bishop;
import pieces.Board;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class BoardTest {
	// Test CheckInterPosition(int cur_x_pos,int cur_y_pos,int target_x_pos,int target_y_pos)
	@Test
	public void DiagonalPathShouldBeClear() {
		Board testBoard = new Board();
		testBoard.board[3][4] = new Bishop(3,4, true);
		testBoard.board[3][3] = new Bishop(3,3, true);
		// bishop at (3,4) should not be able to move to (0,7) and (6,7) due to the pawn in between
		assertFalse(testBoard.CheckInterPosition(3, 4,0, 7));
		assertFalse(testBoard.CheckInterPosition(3, 4,6, 7));
		// bishop at (3,4) should be able to move to (1,2) and (5,2)
		assertTrue(testBoard.CheckInterPosition(3, 4,1, 2));
		assertTrue(testBoard.CheckInterPosition(3, 4,5, 2));
		// bishop at (3,3) should not be able to move to (0,0) and (6,0) due to the pawn in between
		assertFalse(testBoard.CheckInterPosition(3, 3,0, 0));
		assertFalse(testBoard.CheckInterPosition(3, 3,6, 0));
		// bishop at (3,3) should be able to move to (0,6) and (5,6)
		assertTrue(testBoard.CheckInterPosition(3, 3,0, 6));
		assertTrue(testBoard.CheckInterPosition(3, 3,5, 6));	
		//Path for one step move should always be clear
		assertTrue(testBoard.CheckInterPosition(3, 3,2, 2));
		assertTrue(testBoard.CheckInterPosition(3, 3,4, 2));
		assertTrue(testBoard.CheckInterPosition(3, 3,4, 4));
		assertTrue(testBoard.CheckInterPosition(3, 3,2, 4));	
	}
	@Test
	public void VerticalAndVerticalPathShouldBeClear() {
		Board testBoard = new Board();
		testBoard.board[3][4] = new Rook(3,4, true);
		testBoard.board[1][4] = new Pawn(1,4, true);
		testBoard.board[6][4] = new Pawn(6,4, true);
		//Horizontal test
		//Rook at (3,4) should not be able to move to (0,4) and (7,4) due to the pawn in between.
		assertFalse(testBoard.CheckInterPosition(3, 4,0, 4));
		assertFalse(testBoard.CheckInterPosition(3, 4,7, 4));
		//Rook at (3,4) should be able to move to (1,4) and (5,4) 
		assertTrue(testBoard.CheckInterPosition(3, 4,1, 4));
		assertTrue(testBoard.CheckInterPosition(3, 4,5, 4));
		//Vertical test
		//Rook at (3,4) should not be able to move to (3,1) and (3,7) due to the pawn in between.
		assertFalse(testBoard.CheckInterPosition(3, 4,3, 0));
		assertFalse(testBoard.CheckInterPosition(3, 4,3, 7));
		//Rook at (3,4) should be able to move to (3,2) and (3,6)
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 2));
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 6));	
		//Path for one step move should always be clear
		assertTrue(testBoard.CheckInterPosition(3, 4,2, 4));
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 5));
		assertTrue(testBoard.CheckInterPosition(3, 4,4, 4));
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 3));
	}
	@Test
	public void PathForPawnKnightKingAreAlwaysClear(){
		//Test Knight
		Board testBoard = new Board();
		testBoard.board[3][4] = new Knight(3,4, true);
		assertTrue(testBoard.CheckInterPosition(3, 4,2, 2));
		assertTrue(testBoard.CheckInterPosition(3, 4,4, 2));
		assertTrue(testBoard.CheckInterPosition(3, 4,2, 6));
		assertTrue(testBoard.CheckInterPosition(3, 4,1, 3));
		assertTrue(testBoard.CheckInterPosition(3, 4,1, 5));
		assertTrue(testBoard.CheckInterPosition(3, 4,5, 3));
		assertTrue(testBoard.CheckInterPosition(3, 4,5, 5));
		//Test Pawn
		testBoard.board[3][4] = new Pawn(3,4, true);
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 5));
		testBoard.board[3][4] = new Pawn(3,5, false);
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 3));
		//Test King
		testBoard.board[3][4] = new King(3,5, false);
		assertTrue(testBoard.CheckInterPosition(3, 4,3, 3));
		assertTrue(testBoard.CheckInterPosition(3, 4,4, 3));
		assertTrue(testBoard.CheckInterPosition(3, 4,4, 4));
		assertTrue(testBoard.CheckInterPosition(3, 4,4, 5));
		assertTrue(testBoard.CheckInterPosition(3, 4,2, 5));
		assertTrue(testBoard.CheckInterPosition(3, 4,2, 4));
		assertTrue(testBoard.CheckInterPosition(3, 4,2, 3));	
		
	}
	@Test
	public void TestNormalMoveWithCaptureQueen(){
		Board testBoard = new Board();
		testBoard.board[3][4] = new Queen(3,4, false);
		testBoard.board[2][3] = new Queen(2,3, true);
		testBoard.board[3][3] = new Queen(3,3, true);
		testBoard.board[4][3] = new Queen(4,3, true);
		testBoard.board[4][4] = new Queen(4,4, true);
		testBoard.board[4][5] = new Queen(4,5, true);
		testBoard.board[3][5] = new Queen(3,5, true);
		testBoard.board[2][5] = new Queen(2,5, true);
		testBoard.board[2][4] = new Queen(2,4, true);
		assertTrue(testBoard.Move(false,3,4,2,3));
		assertTrue(testBoard.Move(false,2,3,3,3));
		assertTrue(testBoard.Move(false,3,3,4,3));
		assertTrue(testBoard.Move(false,4,3,4,4));
		assertTrue(testBoard.Move(false,4,4,4,5));
		assertTrue(testBoard.Move(false,4,5,3,5));
		assertTrue(testBoard.Move(false,3,5,2,5));
		assertTrue(testBoard.Move(false,2,5,2,4));
		assertTrue(testBoard.board[2][4] instanceof Queen);
		assertTrue(testBoard.board[2][3]==null);
		assertTrue(testBoard.board[3][3]==null);
		assertTrue(testBoard.board[4][3]==null);
		assertTrue(testBoard.board[4][4]==null);
		assertTrue(testBoard.board[4][5]==null);
		assertTrue(testBoard.board[3][5]==null);
		assertTrue(testBoard.board[2][5]==null);
	}
	@Test
	public void TestNormalMoveWithCaptureKing(){
		Board testBoard = new Board();
		testBoard.board[3][4] = new King(3,4, false);
		testBoard.board[2][3] = new King(2,3, true);
		testBoard.board[3][3] = new King(3,3, true);
		testBoard.board[4][4] = new King(4,3, true);
		testBoard.board[4][4] = new King(4,4, true);
		testBoard.board[4][5] = new King(4,5, true);
		testBoard.board[3][5] = new King(3,5, true);
		testBoard.board[2][5] = new King(2,5, true);
		testBoard.board[2][4] = new King(2,4, true);
		assertTrue(testBoard.Move(false,3,4,2,3));
		assertTrue(testBoard.Move(false,2,3,3,3));
		assertTrue(testBoard.Move(false,3,3,4,3));
		assertTrue(testBoard.Move(false,4,3,4,4));
		assertTrue(testBoard.Move(false,4,4,4,5));
		assertTrue(testBoard.Move(false,4,5,3,5));
		assertTrue(testBoard.Move(false,3,5,2,5));
		assertTrue(testBoard.Move(false,2,5,2,4));
		assertTrue(testBoard.board[2][4] instanceof King);
		assertTrue(testBoard.board[2][3]==null);
		assertTrue(testBoard.board[3][3]==null);
		assertTrue(testBoard.board[4][3]==null);
		assertTrue(testBoard.board[4][4]==null);
		assertTrue(testBoard.board[4][5]==null);
		assertTrue(testBoard.board[3][5]==null);
		assertTrue(testBoard.board[2][5]==null);
	}
	//Test Move( boolean player,int cur_x_pos,int cur_y_pos,int target_x_pos,int target_y_pos)
	@Test
	public void TestNormalMoveWithCaptureKnight(){
		Board testBoard = new Board();
		testBoard.board[3][4] = new Knight(3,4, false);
		testBoard.board[2][2] = new Knight(2,2, true);
		testBoard.board[4][2] = new Knight(4,2, true);
		testBoard.board[4][6] = new Knight(4,6, true);
		testBoard.board[2][6] = new Knight(2,6, true);
		testBoard.board[1][3] = new Knight(1,3, true);
		testBoard.board[1][5] = new Knight(1,5, true);
		testBoard.board[5][5] = new Knight(5,5, true);
		testBoard.board[5][3] = new Knight(5,3, true);
		assertTrue(testBoard.Move(false,3,4,2,2));
		assertTrue(testBoard.Move(false,2,2,3,4));
		assertTrue(testBoard.Move(false,3,4,4,2));
		assertTrue(testBoard.Move(false,4,2,3,4));
		assertTrue(testBoard.Move(false,3,4,4,6));
		assertTrue(testBoard.Move(false,4,6,3,4));
		assertTrue(testBoard.Move(false,3,4,2,6));
		assertTrue(testBoard.Move(false,2,6,3,4));
		assertTrue(testBoard.Move(false,3,4,1,3));
		assertTrue(testBoard.Move(false,1,3,3,4));
		assertTrue(testBoard.Move(false,3,4,1,5));
		assertTrue(testBoard.Move(false,1,5,3,4));
		assertTrue(testBoard.Move(false,3,4,5,5));
		assertTrue(testBoard.Move(false,5,5,3,4));
		assertTrue(testBoard.Move(false,3,4,5,3));
		assertTrue(testBoard.board[5][3] instanceof Knight);
		assertTrue(testBoard.board[2][2]==null);
		assertTrue(testBoard.board[4][2]==null);
		assertTrue(testBoard.board[4][6]==null);
		assertTrue(testBoard.board[2][6]==null);
		assertTrue(testBoard.board[1][3]==null);
		assertTrue(testBoard.board[1][5]==null);
		assertTrue(testBoard.board[5][5]==null);
		assertTrue(testBoard.board[3][4]==null);
	}
	@Test
	public void TestNormalMoveWithCaptureBishop(){
		Board testBoard = new Board();
		testBoard.board[3][4] = new Bishop(3,4, true);
		testBoard.board[1][2] = new Bishop(1,2, false);
		testBoard.board[5][2] = new Bishop(5,2, false);
		assertTrue(testBoard.Move(true,3,4,1,2));
		assertTrue(testBoard.Move(true,1,2,3,4));
		assertTrue(testBoard.Move(true,3,4,5,2));
		assertTrue(testBoard.Move(true,5,2,3,4));
		assertTrue(testBoard.Move(true,3,4,1,6));
		assertTrue(testBoard.Move(true,1,6,3,4));
		assertTrue(testBoard.Move(true,3,4,5,6));
		assertTrue(testBoard.board[5][6] instanceof Bishop);
		assertTrue(testBoard.board[1][2]==null);
		assertTrue(testBoard.board[5][2]==null);
		assertTrue(testBoard.board[1][6]==null);
		assertTrue(testBoard.board[3][4]==null);
	}
	@Test
	public void TestNormalMoveWithCaptureRook(){
		Board testBoard = new Board();
		testBoard.board[3][4] = new Rook(3,4,true);
		testBoard.board[0][4] = new Rook(0,4, false);
		testBoard.board[7][4] = new Rook(7,4, false);
		testBoard.board[3][2] = new Rook(3,2, false);
		//should not be able to move the other player's piece
		assertFalse(testBoard.Move(false,3,4,0,4));
		assertTrue(testBoard.Move(true,3,4,0,4));
		assertTrue(testBoard.Move(true,0,4,7,4));
		assertTrue(testBoard.Move(true,7,4,3,4));
		assertTrue(testBoard.Move(true,3,4,3,2));
		assertTrue(testBoard.Move(true,3,2,3,6));
		assertTrue(testBoard.board[3][6] instanceof Rook);
		assertTrue(testBoard.board[3][4]==null);
		assertTrue(testBoard.board[0][4]==null);
		assertTrue(testBoard.board[7][4]==null);
		assertTrue(testBoard.board[3][2]==null);
	}
	@Test
	public void TestNormalMoveWithCapturePawn(){
		//Test Pawn
		Board testBoard = new Board();
		testBoard.board[3][5] = new Pawn(3,5, true);
		//black Pawn 
		assertTrue(testBoard.Move(true,3,5,2,6));
		assertTrue(testBoard.Move(true,2,6,3,7));
		assertTrue(testBoard.board[3][7] instanceof Pawn);
		assertTrue(testBoard.board[2][6]==null);
		assertTrue(testBoard.board[3][5]==null);
		// white Pawn
		testBoard.board[3][2] = new Pawn(3,2,false);
		assertTrue(testBoard.Move(false,3,2,4,1));
		assertTrue(testBoard.Move(false,4,1,3,0));
		assertTrue(testBoard.board[3][0] instanceof Pawn);
		assertTrue(testBoard.board[4][1]==null);
		assertTrue(testBoard.board[3][2]==null);
	}
	@Test
	public void PawnShouldBeAbleToMoveTwoStepInTheFirstMove(){
			Board testBoard = new Board();
			//Test white pawn
			assertTrue(testBoard.Move(true, 3, 1, 3, 3));
			assertFalse(testBoard.Move(true, 3, 3, 3, 5));
			assertTrue(testBoard.Move(true, 3, 3, 3, 4));
			//Test black pawn
			assertTrue(testBoard.Move(false, 5, 6, 5, 4));
			assertFalse(testBoard.Move(false, 5, 4, 5, 2));
			assertTrue(testBoard.Move(false, 5, 4, 5, 3));		
	}
	@Test
	public void ShouldNotMoveOutOfBound(){
		Board testBoard = new Board();
		assertFalse(testBoard.Move(false,-88,2131,324,6312));
		assertFalse(testBoard.Move(false,0,0,34,62));
		assertFalse(testBoard.Move(false,-9,82,4,2));	
	}
	
	@Test
	public void ShouldNotMoveToSpaceWithSameColorPiece(){
		Board testBoard = new Board();
		//Test Rook
		testBoard.board[3][5] = new Rook(3,5, false);
		testBoard.board[3][7] = new Rook(3,7, false);
		assertFalse(testBoard.Move(false,3,5,3,7));
		assertTrue(testBoard.board[3][5] instanceof Rook);
		assertTrue(testBoard.board[3][7] instanceof Rook);
	}
	@Test
	public void TestCheckMate(){
		// this Knight should not be bale to capture the king cuz a pawn can capture this knight
		Board testBoard = new Board();
		testBoard.board[4][5] = new Knight(4,5, true);
		testBoard.board[3][5] = new Rook(3,5, true);
		assertFalse(testBoard.CheckMate(false,4,5));
		assertTrue(testBoard.Move(true,3,5,3,6));
		//assertFalse(testBoard.CheckMate(false,3,6));
		assertTrue(testBoard.Move(true,3,6,3,3));
		assertTrue(testBoard.Move(false,3,7,3,6));
		assertTrue(testBoard.board[3][6] instanceof King);
		//king is blocked by pawns so the rook should be able to capture the king
		testBoard.board[2][5] = new Pawn(2,5, false);
		testBoard.board[4][5] = new Pawn(4,5, false);
		testBoard.board[3][7] = new Pawn(3,7, false);
		assertTrue(testBoard.board[2][5] instanceof Pawn);
		assertTrue(testBoard.board[4][5] instanceof Pawn);
		assertFalse(testBoard.Movable(false,2,5,3,4));
		assertTrue(testBoard.board[4][6] instanceof Pawn);
		assertFalse(testBoard.Movable(false, 3, 6, 4, 6));
		assertTrue(testBoard.CheckMate(false,3,3));	
		//white bishop should be able to catch the king as the black king is surrounded by black pawns and a black bishop. 
		testBoard = new Board();
		assertTrue(testBoard.board[3][7] instanceof King);
		testBoard.board[3][7] = null;
		testBoard.board[3][7] = new King(3,4,false);
		testBoard.board[3][3] = new Pawn(3,3,false);
		testBoard.board[2][3] = new Pawn(2,3,false);
		testBoard.board[2][4] = new Pawn(2,4,false);
		testBoard.board[2][5] = new Pawn(2,5,false);
		testBoard.board[3][5] = new Pawn(3,5,false);
		testBoard.board[4][5] = new Pawn(4,5,false);
		testBoard.board[4][4] = new Bishop(4,4,false);
		testBoard.board[5][2] = new Bishop(5,2,true);
		assertTrue(testBoard.CheckMate(false,5,2));		
	}
	
	
	


	
	
	
	

}
