package br.com.canalbrasil2.model;

public class Stats {

	private Integer kills;
	private Integer deaths;
	private Integer assists;
	private Integer creepKills;
	private Integer creepsDennies;
	private Integer neutrals;
	private Integer gold;
	private Integer towers;
	
	public Stats(){
		
	}
	
	public Stats(Integer kills, Integer deaths, Integer assists, Integer creepKills, Integer creepDennies, Integer neutrals, Integer towers)
	{
		this.kills			= kills;
		this.deaths			= deaths;
		this.assists		= assists;
		this.creepKills		= creepKills;
		this.creepsDennies	= creepDennies;
		this.neutrals		= neutrals;
	}
	
	public Stats(Integer kills, Integer deaths, Integer assists, Integer creepKills, Integer creepDennies, Integer neutrals, Integer towers, Integer gold)
	{
		this(kills, deaths, assists, creepKills, creepDennies, neutrals, towers);
		
		this.gold	= gold;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public Integer getCreepKills() {
		return creepKills;
	}

	public void setCreepKills(Integer creepKills) {
		this.creepKills = creepKills;
	}

	public Integer getCreepsDennies() {
		return creepsDennies;
	}

	public void setCreepsDennies(Integer creepsDennies) {
		this.creepsDennies = creepsDennies;
	}

	public Integer getNeutrals() {
		return neutrals;
	}

	public void setNeutrals(Integer neutrals) {
		this.neutrals = neutrals;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public Integer getTowers() {
		return towers;
	}

	public void setTowers(Integer towers) {
		this.towers = towers;
	}

	
}
