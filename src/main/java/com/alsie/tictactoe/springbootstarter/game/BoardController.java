package com.alsie.tictactoe.springbootstarter.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alsie.tictactoe.springbootstarter.player.PlayerService;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(method=RequestMethod.GET, value="/board")
	public Board getBoard() {
		return boardService.getBoard();
	}
	

	@RequestMapping(method=RequestMethod.PUT, value="/board")
	public 	ResponseEntity<Object> markBoard(@RequestBody Square square) {
		if(!boardService.markBoard(square)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		};
		if(boardService.checkWinner(square.getPiece())){
			String playerWinner = playerService.getPlayers().stream().filter(t -> t.getPlayerGamePiece().getSymbol().equals(square.getPiece())).findFirst().get().getPlayerName(); 
			return ResponseEntity.ok().body(playerWinner+" has won!");
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/board")
	public ResponseEntity<Object> startBoard() {
		if(playerService.getPlayers().size()<2) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		boardService.startBoard();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
