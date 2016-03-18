package br.com.canalbrasil2.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.canalbrasil2.builder.WebClientBuilder;
import br.com.canalbrasil2.model.Stats;
import br.com.canalbrasil2.model.member.Member;
import br.com.canalbrasil2.model.member.MemberGame;
import br.com.canalbrasil2.model.member.MemberGeneralStats;
import br.com.canalbrasil2.service.MemberService;
import br.com.canalbrasil2.utils.Constants;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

@Service
public class MemberServiceImpl extends BaseServiceImpl implements MemberService
{
	private static final int PAGE_LIMIT = 30;

	public List<Member> getRank() 
	{
		List<Member> members = new ArrayList<Member>();

		WebClient webClient = WebClientBuilder.build();
		
		try
		{
			HtmlPage page = webClient.getPage(Constants.RANK_URL);
			
			HtmlTable table = (HtmlTable) page.getElementsByTagName("table").get(2);
			
			List<HtmlTableRow> rows = table.getBodies().get(0).getRows();
			
			for(int i = 1; i < rows.size(); i++)
			{
				HtmlTableRow row = rows.get(i);
				
				int position 			= Integer.parseInt(row.getCell(0).asText());
				String name				= row.getCell(2).asText();
				int points				= Integer.parseInt(row.getCell(3).asText());
				int games				= Integer.parseInt(row.getCell(6).asText());
				int wins				= Integer.parseInt(row.getCell(7).asText());
				int looses				= Integer.parseInt(row.getCell(8).asText());
				
				int winPercentage		= getPercentageFromCell(row.getCell(9));
				
				String favoriteHero	= getImageSrcFromCell(row.getCell(10));
				
				String bestKD			= row.getCell(11).asText();
				String bestCS			= row.getCell(12).asText();
				
				Member member = new Member(name, position, points, games, wins, looses, winPercentage, favoriteHero, bestKD, bestCS);
				
				members.add(member);
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
		
		return members;
	}
	
	public Member getMember(String user, int pageNumber)
	{
		Member member = new Member(); 
		
		WebClient webClient = WebClientBuilder.build();
		
		try
		{
			HtmlPage page = webClient.getPage(Constants.MEMBER_URL + user);
			
			HtmlTable topTable 	= (HtmlTable) page.getElementsByTagName("table").get(2);
			HtmlTable botTable	= (HtmlTable) page.getElementsByTagName("table").get(3);
			
			HtmlTableRow topRow = topTable.getBodies().get(0).getRows().get(1);
			HtmlTableRow botRow = botTable.getBodies().get(0).getRows().get(1);
			
				
			Integer rank		= Integer.valueOf(	topRow.getCell(0)	.getElementsByTagName("div").get(0).asText());
			Integer points		= Integer.valueOf(	topRow.getCell(1)	.getElementsByTagName("div").get(0).asText());
			Integer lvl			= Integer.valueOf(	topRow.getCell(5)	.getElementsByTagName("div").get(0).asText());
			Date joined			= getDateFromCell(	topRow.getCell(9)	,"yyyy-MM-dd");
			Integer games		= Integer.valueOf(	botRow.getCell(0)	.getElementsByTagName("div").get(0).asText());
			Integer wins		= Integer.valueOf(	botRow.getCell(1)	.getElementsByTagName("div").get(0).asText());
			Integer looses		= Integer.valueOf(	botRow.getCell(2)	.getElementsByTagName("div").get(0).asText());
			Integer kills		= Integer.valueOf(	botRow.getCell(3)	.getElementsByTagName("div").get(0).asText());
			Integer deaths		= Integer.valueOf(	botRow.getCell(4)	.getElementsByTagName("div").get(0).asText());
			Integer assists		= Integer.valueOf(	botRow.getCell(5)	.getElementsByTagName("div").get(0).asText());
			Integer creeps		= Integer.valueOf(	botRow.getCell(6)	.getElementsByTagName("div").get(0).asText());
			Integer denies		= Integer.valueOf(	botRow.getCell(7)	.getElementsByTagName("div").get(0).asText());
			Integer neutrals	= Integer.valueOf(	botRow.getCell(8)	.getElementsByTagName("div").get(0).asText());
			Integer towers		= Integer.valueOf(	botRow.getCell(9)	.getElementsByTagName("div").get(0).asText());
//			Integer rk			= Integer.valueOf(	botRow.getCell(10)	.getElementsByTagName("div").get(0).asText());
//			Integer ck			= Integer.valueOf(	botRow.getCell(11)	.getElementsByTagName("div").get(0).asText());
				
			Stats stats = new Stats(kills, deaths, assists, creeps, denies, neutrals, towers);

			MemberGeneralStats generalStats = new MemberGeneralStats(rank, points, lvl, joined, games, wins, looses, stats);
			
			member.setGeneralStats(generalStats);
			
			List<MemberGame> memberGames = new ArrayList<MemberGame>();

			int start	= (pageNumber -1) * PAGE_LIMIT;
			int end		= start + PAGE_LIMIT;
			
			if(end > games)
				end = games;
			
			if(start > games)
			{
				member.setMemberGames(memberGames);
				webClient.close();
				return member;
			}
			
			while(start < end)
			{
				try
				{
					HtmlTable tableStats	= (HtmlTable) page.getElementsByTagName("table").get(4 + start);
					
					topRow 					= tableStats.getBodies().get(0).getRows().get(1);
					botRow					= tableStats.getBodies().get(0).getRows().get(3);
					
					int 	game			= Integer.parseInt(getStringDivFromCell(topRow.getCell(0)));
					Date 	date			= getDateFromCell(topRow.getCell(1), "yyyy-MM-dd HH:mm:ss");
					String	duration		= getStringDivFromCell(topRow.getCell(2));
					String 	hero			= getImageSrcFromCell(topRow.getCell(3));
					
					List<String> items  		= new ArrayList<String>(6);
					for(int j = 0; j < 6; j++)
					{
						items.add(getImageSrcFromCell(topRow.getCell(4+j)));
					}
					
					String team				= getStringDivFromCell(topRow.getCell(10));
					boolean winner			= getStringDivFromCell(topRow.getCell(11)).equalsIgnoreCase(team);
					
					kills					= Integer.parseInt(getStringDivFromCell(botRow.getCell(1)));
					deaths					= Integer.parseInt(getStringDivFromCell(botRow.getCell(2)));
					assists					= Integer.parseInt(getStringDivFromCell(botRow.getCell(3)));
					creeps					= Integer.parseInt(getStringDivFromCell(botRow.getCell(4)));
					denies					= Integer.parseInt(getStringDivFromCell(botRow.getCell(5)));
					neutrals				= Integer.parseInt(getStringDivFromCell(botRow.getCell(6)));
					int gold				= Integer.parseInt(getStringDivFromCell(botRow.getCell(7)));
					towers					= Integer.parseInt(getStringDivFromCell(botRow.getCell(8)));
//					rk						= Integer.parseInt(getStringDivFromCell(botRow.getCell(9)));
//					ck						= Integer.parseInt(getStringDivFromCell(botRow.getCell(10)));
										
					stats = new Stats(kills, deaths, assists, creeps, denies, neutrals, towers, gold);

					MemberGame memberGame = new MemberGame(game, date, duration, hero, items, team, winner, stats);
					
					memberGames.add(memberGame);

					start++;
				}
				catch(Exception e)
				{
					break;
				}							
			}
			
			member.setMemberGames(memberGames);
						
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			webClient.close();
		}
		
		return member;
	}
}
