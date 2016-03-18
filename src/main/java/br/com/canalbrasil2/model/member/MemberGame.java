package br.com.canalbrasil2.model.member;

import java.util.Date;
import java.util.List;

import br.com.canalbrasil2.model.Stats;

public class MemberGame {
	
	private int game;
	private Date date;
	private String duration;
	private String hero;
	private List<String> items;
	private String team;
	private boolean winner;
	private Stats stats; 
	
	public MemberGame(int game, Date date, String duration, String hero, List<String> items, String team, boolean winner,
						Integer	kills, Integer deaths, Integer assists, Integer creepKills, Integer creepDennies, Integer neutrals,
						Integer gold, Integer towers)
	{
		this.game			= game;
		this.date			= date;
		this.duration		= duration;
		this.hero			= hero;
		this.items			= items;
		this.team			= team;
		this.winner			= winner;
		
		this.stats = new Stats(kills, deaths, assists, creepKills, creepDennies, neutrals, gold, towers);
	}
	
	public MemberGame(int game, Date date, String duration, String hero, List<String> items, String team, boolean winner, Stats stats)
	{
		this.game			= game;
		this.date			= date;
		this.duration		= duration;
		this.hero			= hero;
		this.items			= items;
		this.team			= team;
		this.winner			= winner;
		this.stats 			= stats;
	}		
	
	public MemberGame(){
		
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public boolean getWinner() {
		return winner;
	}

	public void setWinner(boolean winner) {
		this.winner = winner;
	}

	public Stats getStats() {
		return stats;
	}
	
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
}
