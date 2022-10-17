import java.util.Random;

public class GameGrid extends AbstractGameGrid {

    public GameGrid(int width, int height, int numberOfShips) {
        int gridWidth = width;
        int gridHeight = height;
        int noOfShips = numberOfShips;
    }

    private void initializeGrid() {
        String[][] gameGrid = new String[gridWidth][gridHeight];
        for(int i=0;i<gameGrid[].length;i++){
            for(int j=0;j<gameGrid[][].length;j++){
                gameGrid[i][j] = ".";
            }
        }
    }

    private void generateShips(int numberOfShips) {
        AbstractBattleShip[] ships = new AbstractBattleShip[numberOfShips];

        for(int i=0;i<numberOfShips;i++){
            ships[i] = ("Ship "+i);
        }
    }

    private void placeShip() {
        for(int i=0;i<numberOfShips;i++) {
            int randomX = rand.nextInt(width);
            int randomY = rand.nextInt(height);

            if(this.shipOrientation == "horizontal"){
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
            else if(this.shipOrientation == "vertical"){
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