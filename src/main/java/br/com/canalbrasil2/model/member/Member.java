package br.com.canalbrasil2.model.member;

import java.util.List;

public class Member 
{
	private String name;
	private int position;
	private int points;
	private int games;
	private int wins;
	private int looses;
	private int winPercentage;
	private String favoriteHero;
	private String bestKD;
	private String bestCS;
	private MemberGeneralStats generalStats;
	private List<MemberGame> memberGame;
	
	public Member(){
		
	}
	
	public Member(String name, int position, int points, int games, int wins, int looses, int winPercentage, String favoriteHero, String bestKD, String bestCS)
	{
		this.name			= name;
		this.position		= position;
		this.points			= points;
		this.games			= games;
		this.wins			= wins;
		this.looses			= looses;
		this.winPercentage	= winPercentage;
		this.favoriteHero	= favoriteHero;
		this.bestKD			= bestKD;
		this.bestCS			= bestCS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
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

	public int getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(int winPercentage) {
		this.winPercentage = winPercentage;
	}

	public String getFavoriteHero() {
		return favoriteHero;
	}

	public void setFavoriteHero(String favoriteHero) {
		this.favoriteHero = favoriteHero;
	}

	public String getBestKD() {
		return bestKD;
	}

	public void setBestKD(String bestKD) {
		this.bestKD = bestKD;
	}

	public String getBestCS() {
		return bestCS;
	}

	public void setBestCS(String bestCS) {
		this.bestCS = bestCS;
	}
	
	public MemberGeneralStats getGeneralStats() {
		return generalStats;
	}
	
	public void setGeneralStats(MemberGeneralStats generalStats) {
		this.generalStats = generalStats;
	}
	
	public List<MemberGame> getMemberGames() {
		return memberGame;
	}
	
	public void setMemberGames(List<MemberGame> memberGame) {
		this.memberGame = memberGame;
	}
}
