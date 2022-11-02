package CS2020.assignment1.game; 
import java.util.Random;

public class BattleShip extends AbstractBattleShip {
    Random rand = new Random();

    public BattleShip(String n) {
        //Sets name of current object's name to value passed into constructor
        this.name = n;

        //Generates either 0 or 1 to determine the orientation
        int randomNum = rand.nextInt(2);

        //Sets the random orientation of the ship
        if(randomNum == 1){
            this.shipOrientation = "vertical";
        }
        else{
            this.shipOrientation = "horizontal";
        }
    }

    //Setters and getters
    public void setHits(int numberOfHits){
        this.hits = numberOfHits;
    }

    public void setShipCoordinates(int [][] coordinates){
        this.shipCoordinates = coordinates;
    }

    public String getName() {return this.name;}
    public int getHits() {return this.hits;}
    public String getShipOrientation(){return this.shipOrientation;}
    public int[][] getShipCoordinates(){return this.shipCoordinates;}

    //Method to check if the attack was a hit or not
    public boolean checkAttack(int row, int column){
        if(getHits() == 3){
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