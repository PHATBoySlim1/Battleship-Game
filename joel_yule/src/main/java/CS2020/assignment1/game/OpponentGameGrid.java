package CS2020.assignment1.game;

public class OpponentGameGrid extends GameGrid {
    public OpponentGameGrid(int w, int h, int noOfShips){
        //References GameGrid constructor with values passed in order to create a new Opponent game grid
        super(w, h, noOfShips);
    }
    
    public void printGrid(){
        System.out.println("Opponents's Grid\n");
        //Loops for the width of the game grid
        for(int i=0;i<gameGrid.length;i++){
            //Loops for the height of the game grid
            for(int j=0;j<gameGrid[0].length;j++){
                //Checks if the current game grid coordinates hold a ship value and if it does prints a dot instead to hide it
                if(gameGrid[i][j] == "*"){
                    System.out.print(".");
                }
                //Else just prints the current value in the game grid
                else{System.out.print(gameGrid[i][j]);}
            }
            System.out.println();
        }
    }
}