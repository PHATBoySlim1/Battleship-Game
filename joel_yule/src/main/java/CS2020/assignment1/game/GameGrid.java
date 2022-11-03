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

    //Method to fill in the game grid with .
    public void initializeGrid() {
        for(int i=0;i<gameGrid.length;i++){
            for(int j=0;j<gameGrid[i].length;j++){
                gameGrid[i][j] = ".";
            }
        }
    }

    //Method to generate the number of ship objects required
    public void generateShips(int numberOfShips) {
        ships = new AbstractBattleShip[numberOfShips];
        for(int i=0;i<ships.length;i++) {
            ships[i] = new BattleShip("Ship "+(i+1));
            //Passes current ship object into placeShips method to place it on the grid
            placeShip(ships[i]);
        }
    }

    //Method to randomly place the ships across the game grid ensuring that the ship orientation is kept correctly
    public void placeShip(AbstractBattleShip ship) {
        //Generates a random x coordinate
        int randomX = rand.nextInt(gameGrid.length);
        //Generates a random y coordinate
        int randomY = rand.nextInt(gameGrid[0].length);
        //Create shipCoords 2D array to be passed into the setShipCoordinates method
        int[][] shipCoords = new int[3][2];

        //Places ship horizontally
        if(ship.shipOrientation == "horizontal"){
            for(int i=0;i<3;i++){
                //Checks if the coordinates are on the edge of the grid and if so, places it in the opposite direction of the edge
                if((randomX-2) < 0){
                    gameGrid[randomY][randomX+i] = "*";
                    shipCoords[i][1] = (randomX+i);
                    shipCoords[i][0] = randomY;
                }
                else if(randomX+2 > gameGrid[0].length){
                    gameGrid[randomY][randomX-i] = "*";
                    shipCoords[i][1] = (randomX-i);
                    shipCoords[i][0] = randomY;
                }
                else{
                    gameGrid[randomY][randomX-i] = "*";
                    shipCoords[i][1] = (randomX-i);
                    shipCoords[i][0] = randomY;
                }
                //Sets the coordinates of the current ship
                ship.setShipCoordinates(shipCoords);
            }
        }
        //Places ship vertically
        else if(ship.shipOrientation == "vertical"){
            for(int i=0;i<3;i++){
                //Checks if the coordinates are on the edge of the grid and if so, places it in the opposite direction of the edge
                if((randomY-2) < 0){
                    gameGrid[randomY+i][randomX] = "*";
                    shipCoords[i][1] = randomX;
                    shipCoords[i][0] = (randomY+i);
                }
                else if(randomY+2 > gameGrid.length){
                    gameGrid[randomY-i][randomX] = "*";
                    shipCoords[i][1] = randomX;
                    shipCoords[i][0] = (randomY-i);
                }
                else{
                    gameGrid[randomY-i][randomX] = "*";
                    shipCoords[i][1] = randomX;
                    shipCoords[i][0] = (randomY-i);
                }
                //Sets the coordinates of the current ship
                ship.setShipCoordinates(shipCoords);
            }
        }
    }
}