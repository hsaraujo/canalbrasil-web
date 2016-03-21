package br.com.canalbrasil2.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.canalbrasil2.builder.WebClientBuilder;
import br.com.canalbrasil2.model.banlist.Banlist;
import br.com.canalbrasil2.service.BanlistService;
import br.com.canalbrasil2.utils.Constants;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class BanlistServiceImpl extends BaseServiceImpl implements BanlistService
{

	@Override
	public List<Banlist> getBanlist() 
	{
		List<Banlist> banlist = new ArrayList<Banlist>();
		
		WebClient webClient = WebClientBuilder.build();
		
		try
		{
			HtmlPage page = webClient.getPage(Constants.BANLIST_URL);
			
			HtmlTable table = (HtmlTable) page.getElementsByTagName("table").get(2);
			
			List<HtmlTableRow> rows = table.getBodies().get(0).getRows();
			
			for(int i = 1; i < rows.size(); i++)
			{
				HtmlTableRow row = rows.get(i);
				
				String name		= row.getCell(0).asText();
				String reason	= row.getCell(3).asText();
				String info		= row.getCell(4).asText();
				Integer remain	= Integer.valueOf(row.getCell(5).asText());
				String dateStr	= row.getCell(7).asText();
				
				Date date = null;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try
				{
					date = sdf.parse(dateStr);
				}
				catch(ParseException e)
				{
					e.printStackTrace();
				}
				
				Banlist ban = new Banlist(name, reason, info, remain, date);
				
				banlist.add(ban);
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
		
		return banlist;
	}

}
