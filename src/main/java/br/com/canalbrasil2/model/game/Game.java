package br.com.canalbrasil2.model.game;

import java.util.Date;

public class Game 
{
	private int id;
	private String name;
	private String owner;
	private String duration;
	private Date date;
	
	public Game(int id, String name, String owner, String duration, Date date)
	{
		this.id			= id;
		this.name		= name;
		this.owner		= owner;
		this.duration	= duration;
		this.date		= date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
}
