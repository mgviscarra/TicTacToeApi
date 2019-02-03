package com.alsie.tictactoe.springbootstarter.player;

public class Player {
	private String playerName;
	private GamePiece playerGamePiece;
	public Player() {}
	public Player(String playerName, GamePiece playerGamePiece) {
		super();
		this.playerName = playerName;
		this.playerGamePiece = playerGamePiece;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public GamePiece getPlayerGamePiece() {
		return playerGamePiece;
	}
	public void setPlayerGamePiece(GamePiece playerGamePiece) {
		this.playerGamePiece = playerGamePiece;
	}
	
}
