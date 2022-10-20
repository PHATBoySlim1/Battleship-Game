package CS2020.assignment1.game;
import java.util.Random;

public class GameGrid extends AbstractGameGrid {
    Random rand = new Random();
    int width;
    int height;
    int numberOfShips;
    
    public GameGrid(int gridWidth, int gridHeight, int noOfShips) {
        width = gridWidth;
        height = gridHeight;
        numberOfShips = noOfShips;
        gameGrid = new String[width][height];
        initializeGrid();
    }

    public void initializeGrid() {
        for(int i=0;i<gameGrid.length;i++){
            for(int j=0;j<gameGrid[i].length;j++){
                gameGrid[i][j] = ".";
            }
        }
    }

    public void generateShips(int numberOfShips) {
        BattleShip[] ships = new BattleShip[numberOfShips];
        for(int i=0;i<numberOfShips;i++){
            ships[i] = new BattleShip("Ship "+i);
        }
    }

    public void placeShip(AbstractBattleShip ship) {
        for(int i=0;i<numberOfShips;i++) {
            int randomX = rand.nextInt(width);
            int randomY = rand.nextInt(height);

            if(ships[i].getShipOrientation() == "horizontal"){
                if(randomX-2 < 0){
                    gameGrid[randomX][randomY] = "*";
                    gameGrid[randomX+1][randomY] = "*";
                    gameGrid[randomX+2][randomY] = "*";
                }
                else if(randomX+2>width){
                    gameGrid[randomX][randomY] = "*";
                    gameGrid[randomX-1][randomY] = "*";
                    gameGrid[randomX-2][randomY] = "*";
                }
            }
            else if(ships[i].getShipOrientation() == "vertical"){
                if(randomY-2 < 0){
                    gameGrid[randomX][randomY] = "*";
                    gameGrid[randomX][randomY+1] = "*";
                    gameGrid[randomX][randomY+2] = "*";
                }
                else if(randomY+2 > height){
                    gameGrid[randomX][randomY] = "*";
                    gameGrid[randomX][randomY-1] = "*";
                    gameGrid[randomX][randomY-2] = "*";
                }
            }
        }
    }
}