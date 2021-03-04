package tictactoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import tictactoe.dto.*;

@Controller
public class MainController {

    @Autowired
    private GameHandler gameHandler;


    @MessageMapping("/game/search")
    @SendTo("/topic/game/search")
    public void handleSearchGame(SearchGameRequest searchGameRequest) {
        gameHandler.searchGame(searchGameRequest.getPlayerId());
    }

    @MessageMapping("/game/{gameId}/click")
    @SendTo("/topic/game/{gameId}/click")
    public NewGameResponse handleClick(@DestinationVariable String gameId, Click click) {
        Game game = gameHandler.findGame(gameId);

        game.click(click.x, click.y, click.playerId);

        NewGameResponse newGameResponse = new NewGameResponse();
        newGameResponse.setGame(game);

        return newGameResponse;
    }
}
