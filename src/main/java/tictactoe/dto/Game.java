package tictactoe.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

@JsonComponent
public class Game {
    private String id;
    private Integer currentPlayerIndex;
    final private Board board;
    final private Dictionary<String, String> players;
    final private List<String> playingOrder;

    @Autowired
    private SimpMessagingTemplate template;

    public Game() {
        this.currentPlayerIndex = 0;
        this.board = new Board();
        this.players = new Hashtable<>();
        this.playingOrder = new ArrayList<>();
    }

    public Integer getCurrentPlayerIndex() {
        return currentPlayerIndex;
    }

    public String getCurrentPlayer() {
        return playingOrder.get(currentPlayerIndex);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addPlayer(String playerId, String symbol) {
       this.players.put(playerId, symbol);
       this.playingOrder.add(playerId);
    }

    public void removePlayer(String playerId) {
        this.players.remove(playerId);
        this.playingOrder.remove(playerId);
    }

    public Dictionary<String, String> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public void nextPlayer() {
        currentPlayerIndex += 1;

        if (currentPlayerIndex >= playingOrder.size()) {
            currentPlayerIndex = 0;
        }
    }

    public void click(Integer x, Integer y, String playerId) {
        if (playerId != null && playerId.equals(this.getCurrentPlayer())) {
            this.board.set(x, y, this.getCurrentPlayer());
            this.nextPlayer();

            String winner = this.board.getWinner();
            if (winner != null) {
                this.template.convertAndSend("/topic/game/" + getId() + "/game/winner", winner);
            }
        }
    }
}
