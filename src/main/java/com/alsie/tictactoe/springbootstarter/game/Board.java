package com.alsie.tictactoe.springbootstarter.game;

public class Board {
	private Square[][] board;

	public Board() {
		board = new Square[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = new Square("", Integer.toString(i)+Integer.toString(j));
			}

		}
	}

	public Square[][] getBoard() {
		return board;
	}

	public void setBoard(Square[][] board) {
		this.board = board;
	}
	
}
