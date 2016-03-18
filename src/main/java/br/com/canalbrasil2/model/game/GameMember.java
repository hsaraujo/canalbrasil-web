package br.com.canalbrasil2.model.game;

import java.util.List;

import br.com.canalbrasil2.model.Stats;

public class GameMember 
{
	private Integer slot;
	private String name;
	private String hero;
	private List<String> items;
	private Stats stats;
	
	public GameMember(){
		
	}
	
	public GameMember(Integer slot, String name, String hero, List<String> items, Stats stats)
	{
		this.slot	= slot;
		this.name	= name;
		this.hero	= hero;
		this.items	= items;
		this.stats	= stats;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
