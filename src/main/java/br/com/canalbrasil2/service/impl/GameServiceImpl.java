package br.com.canalbrasil2.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.canalbrasil2.builder.WebClientBuilder;
import br.com.canalbrasil2.model.Stats;
import br.com.canalbrasil2.model.game.Game;
import br.com.canalbrasil2.model.game.GameMember;
import br.com.canalbrasil2.service.GameService;
import br.com.canalbrasil2.utils.Constants;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class GameServiceImpl extends BaseServiceImpl implements GameService 
{

	@Override
	public List<Game> getGamesList(int pageNumber) 
	{
		List<Game> games = new ArrayList<Game>();
		
		WebClient webClient = WebClientBuilder.build();
		
		try
		{
			
			HtmlPage page = webClient.getPage(Constants.GAMES_URL + String.valueOf(pageNumber));
			
			HtmlTable table = (HtmlTable) page.getElementsByTagName("table").get(2);
			
			List<HtmlTableRow> rows = table.getBodies().get(0).getRows();
			
			for(int i = 2; i < rows.size(); i++)
			{
				HtmlTableRow row = rows.get(i);
				
				int id			= Integer.parseInt(row.getCell(0).asText());
				String name		= row.getCell(1).asText();
				String owner	= row.getCell(2).asText();
				String duration	= row.getCell(3).asText();
				String dateStr	= row.getCell(4).asText();
				
				SimpleDateFormat sdf 	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date				= sdf.parse(dateStr);
				
				Game game = new Game(id, name, owner, duration, date);
				
				games.add(game);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			webClient.close();
		}
		
		return games;
	}

	@Override
	public Game getGameById(int id) 
	{
		Game game = new Game();
		
		WebClient webClient = WebClientBuilder.build();
		
		try
		{
			
			HtmlPage page = webClient.getPage(Constants.GAMESTATS_URL + String.valueOf(id));
			
			HtmlTable table = (HtmlTable) page.getElementsByTagName("table").get(2);
			
			List<HtmlTableRow> rows = table.getBodies().get(0).getRows();
			
			List<GameMember> gameMembers = new ArrayList<GameMember>();
			
			for(int i = 5; i < rows.size() - 2; i++)
			{
				HtmlTableRow row = rows.get(i);
				
				int slot = 0;
				try
				{
					slot		= Integer.parseInt(row.getCell(1).asText());
				}
				catch(NumberFormatException nfe)
				{
					continue;
				}
				String name		= getAnchorValueCell(row.getCell(2));
				String hero		= getImageSrcFromCell(row.getCell(3));
				int heroKill	= Integer.parseInt(row.getCell(4).asText());
				int heroDeath	= Integer.parseInt(row.getCell(5).asText());
				int assistence	= Integer.parseInt(row.getCell(6).asText());
				int creepKill	= Integer.parseInt(row.getCell(7).asText());
				int creepDenny	= Integer.parseInt(row.getCell(8).asText());
				int neutral		= Integer.parseInt(row.getCell(9).asText());
				int gold		= Integer.parseInt(row.getCell(10).asText());
				int towerKill	= Integer.parseInt(row.getCell(11).asText());
//				int rk			= Integer.parseInt(row.getCell(12).asText());
//				int ck			= Integer.parseInt(row.getCell(13).asText());

				List<String> items = new ArrayList<String>(6);
				for(int j = 0; j < 6; j++)
				{
					items.add(getImageSrcFromCell(row.getCell(14+j)));
				}
				
				Stats stats = new Stats(heroKill, heroDeath, assistence, creepKill, creepDenny, neutral, towerKill, gold);
				
				GameMember gameMember = new GameMember(slot, name, hero, items, stats);
				
				gameMembers.add(gameMember);
			}
			
			// GETTING POINTS FOR SENTINEL AND SCOURGE
			
			HtmlTableRow rowPoints	= rows.get(rows.size() - 2);
			int[] points			= getSentinelAndScourgePointsFromCell(rowPoints.getCell(0));
			
			int sentinelPoints		= points[0];
			int scourgePoints		= points[1];
			
			game.setSentinelPoints(sentinelPoints);
			game.setScourgePoints(scourgePoints);
			
			
			// GETTING WINNER
			
			HtmlTableRow winnerRow	= rows.get(rows.size() -1);
			String winner 			= winnerRow.getAttribute("class");
			
			game.setWinner(winner);
			
			
			// GETTING 
			
			HtmlDivision content	= (HtmlDivision) page.getElementById("content");
			
			int divs  				= content.getElementsByTagName("div").size();

			HtmlDivision divKillers	= (HtmlDivision) content.getElementsByTagName("div").get(divs-3);
			
			String sBestKiller 		= divKillers.getElementsByTagName("span").get(0).asText();
			String sBestFarmer		= divKillers.getElementsByTagName("span").get(1).asText();
			String sBestTower		= divKillers.getElementsByTagName("span").get(2).asText();
			
			game.setBestKiller(sBestKiller);
			game.setBestFarmer(sBestFarmer);
			game.setBestTowerRaxKiller(sBestTower);
			
			game.setGameMembers(gameMembers);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			webClient.close();
		}
		
		return game;
	}
	
}
