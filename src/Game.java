import java.util.*;

public class Game {
    public static int id = 101;
    public int gameId;
    public Map<Integer, Integer> scores ;
    public String player1;
    public String player2;
    public String result;

    Game(Map<Integer, Integer> scores, String player1, String player2, String result){
        this.gameId = id++;
        this.player1 = player1;
        this.player2 = player2;
        this.scores = scores;
        this.result = result;
    }
}
