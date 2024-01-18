import java.util.Map;

public class Controller {
    public boolean enterScore(int boxNumber, boolean player, Map<Integer, Integer> score){
        View view = new View();
        if(score.get(boxNumber) == null){
            score.put(boxNumber, player == true? 1: 0);
            view.printGrid(score);
            return true;
        }
        return false;
    }

    public boolean checkWin(Map<Integer, Integer> score){
        for(int i=1; i<9; i++){
            switch (i){
                case 1:{
                    if(score.get(1)!=null && score.get(1) == score.get(2) && score.get(1) == score.get(3)) {
                        return true;
                    }
                }
                break;
                case 2:{
                    if(score.get(4)!=null && score.get(4) == score.get(5) && score.get(4) == score.get(6)) {
                        return true;
                    }
                }
                break;
                case 3:{
                    if(score.get(7)!=null && score.get(7) == score.get(8) && score.get(7) == score.get(9)) {
                        return true;
                    }
                }
                break;
                case 4:{
                    if(score.get(1)!=null && score.get(1) == score.get(4) && score.get(1) == score.get(7)) {
                        return true;
                    }
                }
                break;
                case 5:{
                    if(score.get(2)!=null && score.get(2) == score.get(5) && score.get(2) == score.get(8)) {
                        return true;
                    }
                }
                break;
                case 6:{
                    if(score.get(3)!=null && score.get(3) == score.get(6) && score.get(3) == score.get(9)) {
                        return true;
                    }
                }
                break;
                case 7:{
                    if(score.get(1)!=null && score.get(1) == score.get(5) && score.get(1) == score.get(9)) {
                        return true;
                    }
                }
                break;
                case 8:{
                    if(score.get(3)!=null && score.get(3) == score.get(5) && score.get(3) == score.get(7)) {
                        return true;
                    }
                }
                break;
            }
        }
        return false ;
    }
}
