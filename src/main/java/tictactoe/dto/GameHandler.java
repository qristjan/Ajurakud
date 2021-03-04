package tictactoe.dto;

import io.micrometer.core.instrument.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Scope("singleton")
public class GameHandler {
    private Dictionary<String, Game> games;
    private Queue<String> waitingPlayersQueue;

    @Autowired
    private SimpMessagingTemplate template;

    public GameHandler() {
        this.games = new Hashtable<>();
        this.waitingPlayersQueue = new LinkedList<>();
    }

    private Game startNewGame() {
        String id = UUID.randomUUID().toString();
        Game game = new Game();
        game.setId(id);
        this.games.put(id, game);
        return game;
    }

    public void searchGame(String playerId) {
        if (waitingPlayersQueue.peek() != null) {
            String firstPlayer = waitingPlayersQueue.remove();
            String secondPlayer = playerId;

            Game game = this.startNewGame();
            game.addPlayer(firstPlayer, "X");
            game.addPlayer(secondPlayer, "Y");

            NewGameResponse newGameResponse = new NewGameResponse();
            newGameResponse.setGame(game);

            this.template.convertAndSend("/topic/user/" + firstPlayer + "/game/start", game);
            this.template.convertAndSend("/topic/user/" + secondPlayer + "/game/start", game);

        } else {
            waitingPlayersQueue.add(playerId);
        }
    }

    public Game findGame(String id) {
        return games.get(id);
    }
}
