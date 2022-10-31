package CS2020.assignment1.game;
import java.util.Random;

public class Game implements GameControls{
    Random rand = new Random();
    //Create player and opponent game grid variables
    PlayerGameGrid pGameGrid;
    OpponentGameGrid oGameGrid;

    public Game(int w, int h, int noOfShips){
        //Update player and opponent game grid variables with filled grids generated from the parameters passed
        this.pGameGrid = new PlayerGameGrid(w,h,noOfShips);
        this.oGameGrid = new OpponentGameGrid(w,h,noOfShips);
    }

    public void playRound(String input){
        
        //Splits the string coordinates input into 2 separate int values for coordinates 
        String[] splitInput = input.split(",",0);
        int x = Integer.parseInt(splitInput[0]);
        int y = Integer.parseInt(splitInput[1]);
        
        System.out.println("Player is attacking!");
        hitOrMiss(oGameGrid,x,y);
        oGameGrid.printGrid();
        
        int opponentX = rand.nextInt(pGameGrid.gameGrid.length);
        int opponentY = rand.nextInt(pGameGrid.gameGrid[0].length);
        
        System.out.println("Opponent is attacking!");
        hitOrMiss(pGameGrid,opponentX,opponentY);
        pGameGrid.printGrid();
    }

    //Method to check whether the coordinates passed are a hit or miss
    public void hitOrMiss(AbstractGameGrid currentGameGrid,int x,int y){
        //Loops for the number of ships on the current game grid being checked
        for(int i=0;i<currentGameGrid.ships.length;i++){
            //Loops for the length of each ship
            for(int j=0;j<3;j++){
                //Checks if the current ships coordinates match the input coordinates
                if(currentGameGrid.ships[i].shipCoordinates[j][0] == x && currentGameGrid.ships[i].shipCoordinates[j][1] == y){
                    System.out.println("HIT "+currentGameGrid.ships[i].name+"!!!");
                    //Increments value of hits by 1
                    currentGameGrid.ships[i].hits++;
                    //Updates game grid to display where the hit was
                    currentGameGrid.gameGrid[x][y] = "X";
                    return;
                }
            }
        }
        System.out.println("MISS!!!");
        //Updates game grid to display where the miss was
        currentGameGrid.gameGrid[x][y] = "%";
    }

    public boolean checkVictory(){
        //Variable to check if all ships have been destroyed
        int shipsDestroyed = 0;
        //Loop for number of ships
        for(int i=0;i<pGameGrid.ships.length;i++){
            //If number of hits on the current ship equals 3 increase the number of ships destroyed by 1
            if(pGameGrid.ships[i].hits == 3){
                shipsDestroyed++;
                //If the number of ships destroyed equals the number of ships
                if(shipsDestroyed == pGameGrid.ships.length){
                    //Lose scenario
                    System.out.println("You have lost!");
                    return false;
                }
            }
            //If number of hits on the current ship equals 3 increase the number of ships destroyed by 1
            else if(oGameGrid.ships[i].hits == 3){
                shipsDestroyed++;
                //If the number of ships destroyed equals the number of ships
                if(shipsDestroyed == oGameGrid.ships.length){
                    //Win scenario
                    System.out.println("You have won!");
                    return true;
                }
            }
        }
        return false;
    }

    //Exit method
    public void exitGame(String input){
        if(input == "exit"){
            System.out.println("Exiting game - thank you for playing!");
            System.exit(0);
        }
    }
    
    public AbstractGameGrid getPlayersGrid(){
        return pGameGrid;
    }

    public AbstractGameGrid getOpponentsGrid(){
        return oGameGrid;
    }
}