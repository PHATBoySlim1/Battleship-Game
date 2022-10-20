package CS2020.assignment1.game; 
import java.util.Random;

public class BattleShip extends AbstractBattleShip {
    Random rand = new Random();

    public BattleShip(String n) {
        name = n;

        int randomNum = rand.nextInt(2);

        //Sets the random orientation of the ship
        if(randomNum == 1){
            shipOrientation = "vertical";
        }
        else{
            shipOrientation = "horizontal";
        }
    }

    public void setHits(int numberOfHits){
        hits = numberOfHits;
    }

    public void setShipCoordinates(int [][] coordinates){
        shipCoordinates = coordinates;
    }

    public String getName() {return name;}
    public int getHits() {return hits;}
    public String getShipOrientation(){return shipOrientation;}
    public int[][] getShipCoordinates(){return shipCoordinates;}

    public boolean checkAttack(int row, int column){
        if(hits == 3){
            return false;
        }
        else {
            //Loops for number of available hits left on ship
            for(int i=0;i<(3-hits);i++){
                //Checks the passed coordinates against the ships coordinates
                if(shipCoordinates[i][0] == row && shipCoordinates[i][1] == column){
                    setHits(hits+1);
                    return true;
                }
            }
        }
        return false;
    }
}