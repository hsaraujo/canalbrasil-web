package br.com.canalbrasil2.model.banlist;

import java.util.Date;

public class Banlist 
{
	private String name;
	private String reason;
	private String info;
	private Integer remain;
	private Date date;
	
	
	public Banlist(){
		
	}
	
	public Banlist(String name, String reason, String info, Integer remain, Date date)
	{
		this.name	= name;
		this.reason	= reason;
		this.info	= info;
		this.remain	= remain;
		this.date	= date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getRemain() {
		return remain;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
