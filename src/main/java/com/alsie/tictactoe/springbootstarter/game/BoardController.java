package com.alsie.tictactoe.springbootstarter.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(method=RequestMethod.GET, value="/board")
	public Board getBoard() {
		return boardService.getBoard();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/board")
	public 	ResponseEntity<Object> markBoard(@RequestBody Square square) {
		if(!boardService.markBoard(square)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		};
		if(boardService.checkWinner(square.getPiece())){
			return new ResponseEntity<>(HttpStatus.CHECKPOINT);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
