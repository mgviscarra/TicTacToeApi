package com.alsie.tictactoe.springbootstarter.game;

public class Square {
	private String piece;
	private String coordenate;
	public Square() {}
	public Square(String piece, String coordenate) {
		super();
		this.piece = piece;
		this.coordenate = coordenate;
	}
	public String getPiece() {
		return piece;
	}
	public void setPiece(String piece) {
		this.piece = piece;
	}
	public String getCoordenate() {
		return coordenate;
	}
	public void setCoordenate(String coordenate) {
		this.coordenate = coordenate;
	}

}
