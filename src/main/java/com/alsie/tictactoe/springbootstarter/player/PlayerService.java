package com.alsie.tictactoe.springbootstarter.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {
private List<Player> players = new ArrayList<>();
	
	public void addPlayer(Player player) {
		players.add(player);
	}

	public List<Player> getPlayers() {
		return players;
	}

}
