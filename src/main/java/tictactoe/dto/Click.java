package tictactoe.dto;

public class Click {
    public int x;
    public int y;
    public String playerId;

    public Click(int x, int y, String playerId) {
        this.x = x;
        this.y = y;
        this.playerId = playerId;
    }
}
