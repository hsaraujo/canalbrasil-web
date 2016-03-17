package br.com.canalbrasil2.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gargoylesoftware.htmlunit.html.HtmlTableCell;

public class BaseServiceImpl 
{
	protected String getImageSrcFromCell(HtmlTableCell cell)
	{
		return cell.getElementsByTagName("img").get(0).getAttribute("src");
	}
	
	protected int getPercentageFromCell(HtmlTableCell cell)
	{
		String cellStr = cell.asText();
		return Integer.parseInt(cellStr.substring(0, cellStr.length()-1));
	}
	
	protected String getStringDivFromCell(HtmlTableCell cell)
	{
		return cell.getElementsByTagName("div").get(0).asText();
	}
	
	
	protected String getAnchorValueCell(HtmlTableCell cell)
	{
		return cell.getElementsByTagName("a").get(0).asText();
	}
	
	protected int[] getSentinelAndScourgePointsFromCell(HtmlTableCell cell)
	{
		// References for Substring
		String sentinel 	= "Sentinel";
//		String scourge		= "Scourge";
//		String points		= "points";
		
		String pointsStr	= cell.asText();
		
		int sentinelPoint	= Integer.parseInt(pointsStr.substring(sentinel.length() + 1, pointsStr.indexOf(',')));
		int scourgePoint 	= sentinelPoint * (-1);
//		int scourgePoint	= Integer.parseInt(pointsStr.substring(pointsStr.indexOf(scourge) + scourge.length() + 1, pointsStr.indexOf(points) - 1));
		
		
		return new int[] { sentinelPoint, scourgePoint };
	}
	
	protected Date getDateFromCell(HtmlTableCell cell, String pattern)
	{
		String dateStr = cell.getElementsByTagName("div").get(0).asText();
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		try
		{
			return sdf.parse(dateStr);
		}
		catch(ParseException pe)
		{
			return null;
		}
		
	}
}
