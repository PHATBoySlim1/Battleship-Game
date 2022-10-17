public class GameGrid extends AbstractGameGrid {

    private void createGrid(int width, int height, int numberOfShips) {
        String[][] gameGrid = new String[width][height];
    }

    private void initializeGrid(String[][] gameGrid) {
        for(int i=0;i<gameGrid[].length;i++){
            for(int j=0;j<gameGrid[][].length;j++){
                gameGrid[i][j] = ".";
            }
        }
    }

}