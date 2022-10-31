package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid{
    public PlayerGameGrid(int w, int h, int noOfShips){
        //References GameGrid constructor with values passed in order to create a new Player game grid
        super(w, h, noOfShips);
    }
    
    public void printGrid(){
        //Prints every value in player's game grid
        System.out.println("Player's Grid\n");
        for(int i=0;i<gameGrid.length;i++){
            for(int j=0;j<gameGrid[0].length;j++){
                System.out.print(gameGrid[i][j]);
            }
            System.out.println();
        }
    }
}