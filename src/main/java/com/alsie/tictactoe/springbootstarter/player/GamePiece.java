package com.alsie.tictactoe.springbootstarter.player;

public class GamePiece {
	private String symbol;
	
	public GamePiece() {}
	public GamePiece(String symbol) {
		super();
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
}
