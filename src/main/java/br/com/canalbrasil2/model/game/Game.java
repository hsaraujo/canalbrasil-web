package br.com.canalbrasil2.model.game;

import java.util.Date;
import java.util.List;

public class Game 
{
	private Integer id;
	private String name;
	private String owner;
	private String duration;
	private Date date;
	
	private List<GameMember> gameMembers;
	
	private Integer sentinelPoints;
	private Integer scourgePoints;
	private String 	winner;
	private String	bestKiller;
	private String	bestFarmer;
	private String	bestTowerRaxKiller;
	
	public Game(){
		
	}
	
	public Game(int id, String name, String owner, String duration, Date date)
	{
		this.id			= id;
		this.name		= name;
		this.owner		= owner;
		this.duration	= duration;
		this.date		= date;
	}
	
	public Game(List<GameMember> gameMembers, Integer sentinelPoints, Integer scourgePoints, String winner, String bestKiller, String bestFarmer, String bestTowerRaxKiller)
	{
		this.gameMembers		= gameMembers;
		this.sentinelPoints		= sentinelPoints;
		this.scourgePoints		= scourgePoints;
		this.winner				= winner;
		this.bestKiller			= bestKiller;
		this.bestFarmer			= bestFarmer;
		this.bestTowerRaxKiller	= bestTowerRaxKiller;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<GameMember> getGameMembers() {
		return gameMembers;
	}

	public void setGameMembers(List<GameMember> gameMembers) {
		this.gameMembers = gameMembers;
	}

	public Integer getSentinelPoints() {
		return sentinelPoints;
	}

	public void setSentinelPoints(Integer sentinelPoints) {
		this.sentinelPoints = sentinelPoints;
	}

	public Integer getScourgePoints() {
		return scourgePoints;
	}

	public void setScourgePoints(Integer scourgePoints) {
		this.scourgePoints = scourgePoints;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getBestKiller() {
		return bestKiller;
	}

	public void setBestKiller(String bestKiller) {
		this.bestKiller = bestKiller;
	}

	public String getBestFarmer() {
		return bestFarmer;
	}

	public void setBestFarmer(String bestFarmer) {
		this.bestFarmer = bestFarmer;
	}

	public String getBestTowerRaxKiller() {
		return bestTowerRaxKiller;
	}

	public void setBestTowerRaxKiller(String bestTowerRaxKiller) {
		this.bestTowerRaxKiller = bestTowerRaxKiller;
	}
	
}
