package CS2020.assignment1.game;
import java.util.Random;

public class GameGrid extends AbstractGameGrid {
    Random rand = new Random();
    
    public GameGrid(int w, int h, int noOfShips) {
        int width = w;
        int height = h;
        int numberOfShips = noOfShips;
        gameGrid = new String[width][height];
        initializeGrid();
        generateShips(numberOfShips);
    }

    public void initializeGrid() {
        for(int i=0;i<gameGrid.length;i++){
            for(int j=0;j<gameGrid[i].length;j++){
                gameGrid[i][j] = ".";
            }
        }
    }
    
    public void generateShips(int numberOfShips) {
        ships = new AbstractBattleShip[numberOfShips];
        for(int i=0;i<ships.length;i++) {
            ships[i] = new BattleShip("Ship "+(i+1));
            placeShip(ships[i]);
        }
    }

    public void placeShip(AbstractBattleShip ship) {
        int randomX = rand.nextInt(gameGrid.length);
        int randomY = rand.nextInt(gameGrid[0].length);
        int[][] shipCoords = new int[3][2];

        if(ship.shipOrientation == "horizontal"){
            for(int i=0;i<3;i++){
                if((randomX-2) < 0){
                    gameGrid[randomX+i][randomY] = "*";
                    shipCoords[i][0] = (randomX+i);
                    shipCoords[i][1] = randomY;
                }
                else if(randomX+2 > gameGrid.length){
                    gameGrid[randomX-i][randomY] = "*";
                    shipCoords[i][0] = (randomX-i);
                    shipCoords[i][1] = randomY;
                }
                else{
                    gameGrid[randomX-i][randomY] = "*";
                    shipCoords[i][0] = (randomX-i);
                    shipCoords[i][1] = randomY;
                }
                ship.setShipCoordinates(shipCoords);
            }
        }
        else if(ship.shipOrientation == "vertical"){
            for(int i=0;i<3;i++){
                if((randomY-2) < 0){
                    gameGrid[randomX][randomY+i] = "*";
                    shipCoords[i][0] = randomX;
                    shipCoords[i][1] = (randomY+i);
                }
                else if(randomY+2 > gameGrid[0].length){
                    gameGrid[randomX][randomY-i] = "*";
                    shipCoords[i][0] = randomX;
                    shipCoords[i][1] = (randomY-i);
                }
                else{
                    gameGrid[randomX][randomY-i] = "*";
                    shipCoords[i][0] = randomX;
                    shipCoords[i][1] = (randomY-i);
                }
                ship.setShipCoordinates(shipCoords);
            }
        }
    }
}