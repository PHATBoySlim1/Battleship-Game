import java.util.Random;

public class BattleShip extends AbstractBattleShip {
    Random rand = new Random();

    public BattleShip(String name) {
        this.name = name;

        int randomNum = rand.nextInt(2);

        //Sets the random orientation of the ship
        if(randomNum == 1){
            this.shipOrientation = "vertical";
        }
        else{
            this.shipOrientation = "horizontal";
        }
    }

    private void setHits(int numberOfHits){
        this.numberOfHits = numberOfHits;
    }

    private void setShipCoordinates(int [][] coordinates){
        this.shipCoordinates = coordinates
    }

    private String getName() {return name;}
    private int getHits() {return hits;}
    private String getShipOrientation(){return shipOrientation;}
    private int getShipCoordinates(){return shipCoordinates;}

    private boolean checkAttack(int row, int column){
        if(this.numberOfHits == 3){
            return false;
        }
        else if(this.numberOfHits < 3){
            //Loops for number of available hits left on ship
            for(int i=0;i<=this.numberOfHits;i++){
                //If row passed into the method is equal to any of the row coordinates of the ship
                if(row == this.shipCoordinates[i]){
                    //Loops for number of available hits left on ship
                    for(int j=0;j<=this.numberOfHits;j++){
                        //If column passed into the method is equal to any of the column coordinates of the ship
                        if(column == this.shipCoordinates[i][j]){
                            return true;
                        }
                    }
                }
                else{
                    return false;
                }
            }
        }
    }


}