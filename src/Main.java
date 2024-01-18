import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Enter your choise : ");
            System.out.println("1. Start a new Game");
            System.out.println("2. Previous games");
            System.out.println("3. Quit game");
            int option = sc.nextInt();
            switch (option){
                case 1:{
                    Controller controller = new Controller();
                    View view = new View();
                    Model model = new Model();
                    model.score.clear();
                    System.out.println("Enter player 1 name :");
                    String player1 = sc.next();
                    System.out.println("Enter player 2 name :");
                    String player2 = sc.next();
                    view.printGrid(model.score);
                    int turnNumber = 0;
                    boolean gameOver = false;
                    boolean isPlayer1Turn = true;
                    String result = "";
                    while(turnNumber < 9){
                        if(isPlayer1Turn){
                            System.out.println(player1+" do enter the grid number to tick X");
                            int boxNumber = sc.nextInt();
                            if(!(boxNumber>0 && boxNumber<10)){
                                System.out.println("Enter a valid grid number ");
                                continue;
                            }
                            boolean entered = controller.enterScore(boxNumber, isPlayer1Turn, model.score);
                            if(entered){
                                turnNumber++;
                                isPlayer1Turn = false;
                                gameOver = controller.checkWin(model.score);
                                if(gameOver){
                                    result = player1+" won the game";
                                    System.out.println(result);
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid grid");
                            }
                        }
                        else {
                            System.out.println(player2+" do enter the grid number to tick O");
                            int boxNumber = sc.nextInt();
                            if(!(boxNumber>0 && boxNumber<10)){
                                System.out.println("Enter a valid grid number ");
                                continue;
                            }
                            boolean entered = controller.enterScore(boxNumber, isPlayer1Turn, model.score);
                            if(entered){
                                turnNumber++;
                                isPlayer1Turn = true;
                                gameOver = controller.checkWin(model.score);
                                if(gameOver){
                                    result = player2+" won the game";
                                    System.out.println(result);
                                    break;
                                }
                            }
                            else {
                                System.out.println("Invalid grid");
                            }
                        }
                    }
                    if(!gameOver){
                        result = "The match is draw";
                        System.out.println(result);
                    }
                    Game game = new Game(model.score,player1+" chose X",player2+" chose O",result);
                    model.gameLog.put(game.gameId, game);
                }
                break;
                case 2:{
                    System.out.println("Game History");
                    Model model = new Model();
                    View view = new View();
                    for(Map.Entry<Integer, Game> ent : model.gameLog.entrySet()){
                        System.out.println("**********************************************************");
                        System.out.println(ent.getValue().gameId);
                        System.out.println(ent.getValue().player1);
                        System.out.println(ent.getValue().player2);
                        view.printGrid(ent.getValue().scores);
                        System.out.println(ent.getValue().result);
                        System.out.println("**********************************************************");
                    }
                }
                break;
                case 3:{
                    loop = false;
                }
                break;
                default:{
                    System.out.println("Invalid Option");
                }
            }
        }
    }
}