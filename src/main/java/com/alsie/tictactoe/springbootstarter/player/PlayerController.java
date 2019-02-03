package com.alsie.tictactoe.springbootstarter.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(method=RequestMethod.POST, value="/players")
	public ResponseEntity<Object> addPlayer(@RequestBody Player player) {
		playerService.addPlayer(player);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/players")
	public List<Player> getPlayers() {
		return playerService.getPlayers();
	}
}
