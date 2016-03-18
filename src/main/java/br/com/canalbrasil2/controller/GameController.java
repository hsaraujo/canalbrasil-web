package br.com.canalbrasil2.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.canalbrasil2.model.game.Game;
import br.com.canalbrasil2.service.GameService;

@RestController
@RequestMapping("/api/game")
public class GameController 
{
	@Autowired
	private GameService gameService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public List<Game> getGames(@RequestParam(value="page") Integer page)
	{	
		if(page == null || page < 1)
			page = 1;
		
		return gameService.getGamesList(page);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public Game getGame(@PathVariable(value="id") Integer id)
	{	
		return gameService.getGameById(id);
	}
}
