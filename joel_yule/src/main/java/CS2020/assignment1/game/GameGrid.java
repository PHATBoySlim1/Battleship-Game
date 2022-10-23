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
        int randomX = rand.nextInt(width);
        int randomY = rand.nextInt(height);
        String shipOrientation = ship.getShipOrientation();

        if(shipOrientation == "horizontal"){
            if((randomX-2) < 0){
                for(int i=0;i<3;i++){
                    gameGrid[randomX+i][randomY] = "*";
                }
                ship.setShipCoordinates(new int [][]{new int[]{randomX,randomY},new int[]{randomX+1,randomY},new int[]{randomX+2,randomY}});
            }
            else if((randomX+2) > width){
                for(int i=0;i<3;i++){
                    gameGrid[randomX-i][randomY] = "*";
                }
                ship.setShipCoordinates(new int[][]{new int[]{randomX,randomY},new int[]{randomX-1,randomY},new int []{randomX-2,randomY}});
            }
        }
        else if(shipOrientation == "vertical"){
            if((randomY-2) < 0){
                for(int i=0;i<3;i++){
                    gameGrid[randomX][randomY-i] = "*";
                }
                ship.setShipCoordinates(new int[][]{new int[]{randomX,randomY},new int[]{randomX,randomY+1},new int []{randomX,randomY+2}});
            }
            else if((randomY+2) > height){
                for(int i=0;i<3;i++){
                    gameGrid[randomX][randomY+i] = "*";
                }
                ship.setShipCoordinates(new int[][]{new int[]{randomX,randomY},new int[]{randomX,randomY-1},new int []{randomX,randomY-2}});
            }
        }
    }
}