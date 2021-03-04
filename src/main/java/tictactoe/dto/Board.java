package tictactoe.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    ArrayList<ArrayList<String>> state;

    public Board() {
        this.state = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                 row.add("");
            }
            this.state.add(row);
        }
    }

    public String get(Integer x, Integer y) {
        return this.state.get(y).get(x);
    }

    public void set(Integer x, Integer y, String player) {
        this.state.get(y).set(x, player);
    }

    public ArrayList<ArrayList<String>> getState() {
        return state;
    }

    public String getWinner() {
        // Integer count = 0;

        // for (int y = 0; y < state.size(); y++) {
        //     ArrayList<String> row = state.get(y);
        //     for (int x = 0; x < row.size(); x++) {
        //         String value = row.get(x);
        //         if ()
        //     }
        // }

        return null;
    }
}
