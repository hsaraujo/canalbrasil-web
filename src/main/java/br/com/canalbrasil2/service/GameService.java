package br.com.canalbrasil2.service;

import java.util.List;

import br.com.canalbrasil2.model.game.Game;

public interface GameService 
{
	List<Game> getGamesList(int pageNumber);
}
