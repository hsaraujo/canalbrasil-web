package br.com.canalbrasil2.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.canalbrasil2.model.banlist.Banlist;
import br.com.canalbrasil2.service.BanlistService;

@RestController
@RequestMapping("/api/banlist")
public class BanlistController 
{
	@Autowired
	private BanlistService banlistService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Banlist> getBanlist()
	{	
		return banlistService.getBanlist(); 		
	}
}
