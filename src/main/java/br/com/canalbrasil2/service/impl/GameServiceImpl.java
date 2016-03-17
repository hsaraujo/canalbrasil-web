package br.com.canalbrasil2.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.canalbrasil2.builder.WebClientBuilder;
import br.com.canalbrasil2.model.game.Game;
import br.com.canalbrasil2.service.GameService;
import br.com.canalbrasil2.utils.Constants;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class GameServiceImpl extends BaseServiceImpl implements GameService {

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

}
