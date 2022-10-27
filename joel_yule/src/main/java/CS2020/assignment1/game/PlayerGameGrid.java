package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid{
    public PlayerGameGrid(int w, int h, int noOfShips){
        super(w, h, noOfShips);
    }
    public void printGrid(){
        System.out.println("Player's Grid");
        for(int i=0;i<gameGrid.length;i++){
            for(int j=0;j<gameGrid[0].length;j++){
                System.out.printf(gameGrid[i][j]);
            }
            System.out.println();
        }
    }
}