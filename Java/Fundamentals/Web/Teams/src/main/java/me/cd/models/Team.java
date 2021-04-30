package me.cd.models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Team implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Player> players;
	private int id;
	static int instanceCounter = 0;
	
	public Team() {

	}
	
	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<Player>();
		instanceCounter++;
		this.id = instanceCounter;
	}

	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public void addPlayer(String firstName, String lastName, int age) {
		Player newPlayer = new Player(firstName, lastName, age);
		this.players.add(newPlayer);
	}
}
