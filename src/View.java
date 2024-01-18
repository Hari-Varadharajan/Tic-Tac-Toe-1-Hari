import java.util.Map;

public class View {
    View(){}
    public void printGrid(Map<Integer, Integer> scores){
        int tiles = 1;
        for(int i=0; i<3; i++){
            System.out.println(" ___  ___  ___");
            for(int j=0; j<3 ;j++){
                String a = scores.get(tiles) == null? " ": scores.get(tiles)+"";
                if(!(a.equals(" ")))
                    a = (a.equals("1"))? "X": "O";
                System.out.print("| "+a+" |");
                tiles++;
            }
            System.out.println();
        }
        System.out.println(" ___  ___  ___");
    }
}
