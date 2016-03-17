package br.com.canalbrasil2.model.member;

import java.util.Date;

import br.com.canalbrasil2.model.Stats;

public class MemberGeneralStats 
{
	private Integer rank;
	private Integer points;
	private Integer lvl;
	private Date joined;
	private Integer games;
	private Integer wins;
	private Integer looses;
	private Stats stats;
	
	public MemberGeneralStats(){
		
	}
	
	public MemberGeneralStats(Integer rank, Integer points, Integer lvl, Date joined, Integer games, Integer wins, Integer looses, Stats stats)
	{
		this.rank	= rank;
		this.points	= points;
		this.lvl	= lvl;
		this.joined	= joined;
		this.games	= games;
		this.wins	= wins;
		this.looses	= looses;
		this.stats	= stats;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public Date getJoined() {
		return joined;
	}

	public void setJoined(Date joined) {
		this.joined = joined;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLooses() {
		return looses;
	}

	public void setLooses(int looses) {
		this.looses = looses;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
