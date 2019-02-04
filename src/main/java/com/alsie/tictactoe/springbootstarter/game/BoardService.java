package com.alsie.tictactoe.springbootstarter.game;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BoardService {
	private static  Board board;
	private String lastPlayedPiece = "";
	public Board getBoard() {
		return board;
	}
	
	public boolean markBoard(@RequestBody Square square) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(board.getBoard()[i][j].getCoordenate().equals(square.getCoordenate()) && board.getBoard()[i][j].getPiece().equals("") && !lastPlayedPiece.equals(square.getPiece())) {
					board.getBoard()[i][j].setPiece(square.getPiece());
					lastPlayedPiece = square.getPiece();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkWinner(String symbol) {
		boolean winner = false;
		if(board.getBoard()[0][0].getPiece().equals(symbol) && board.getBoard()[0][1].getPiece().equals(symbol) && board.getBoard()[0][2].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[1][0].getPiece().equals(symbol) && board.getBoard()[1][1].getPiece().equals(symbol) && board.getBoard()[1][2].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[2][0].getPiece().equals(symbol) && board.getBoard()[2][1].getPiece().equals(symbol) && board.getBoard()[2][2].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[0][0].getPiece().equals(symbol) && board.getBoard()[1][0].getPiece().equals(symbol) && board.getBoard()[2][0].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[1][0].getPiece().equals(symbol) && board.getBoard()[1][1].getPiece().equals(symbol) && board.getBoard()[1][2].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[2][0].getPiece().equals(symbol) && board.getBoard()[2][1].getPiece().equals(symbol) && board.getBoard()[2][2].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[0][0].getPiece().equals(symbol) && board.getBoard()[1][1].getPiece().equals(symbol) && board.getBoard()[2][2].getPiece().equals(symbol)) {
			winner = true;
		}
		if(board.getBoard()[0][2].getPiece().equals(symbol) && board.getBoard()[1][1].getPiece().equals(symbol) && board.getBoard()[2][0].getPiece().equals(symbol)) {
			winner = true;
		}
		return winner;
	}

	public static Board getBoardInstance() {
		if(board==null) {
			board= new Board();
		}
		return board;
	}

	public void startBoard() {
		getBoardInstance().clearBoard();
		
	}

}
