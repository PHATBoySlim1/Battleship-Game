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
        int totalHits = 0;
        
        System.out.println("Player is attacking!");
        if(oGameGrid.gameGrid[y][x] != "X" && oGameGrid.gameGrid[y][x] != "%"){
            for(int i=0;i<oGameGrid.ships.length;i++){
                if(oGameGrid.ships[i].checkAttack(x,y) == true){
                    totalHits++;
                    System.out.println("HIT "+oGameGrid.ships[i].name+"!!!");
                }
            }
            if(totalHits > 0){
                oGameGrid.gameGrid[y][x] = "X";
            }
            else{
                System.out.println("MISS!!!");
                oGameGrid.gameGrid[y][x] = "%";
            }
        }
        else{
            System.out.println("This position has previously been attacked!");
        }
        
        oGameGrid.printGrid();
        
        int opponentX = rand.nextInt(pGameGrid.gameGrid[0].length);
        int opponentY = rand.nextInt(pGameGrid.gameGrid.length);
        totalHits = 0;
        
        System.out.println("Opponent is attacking!");
        if(pGameGrid.gameGrid[opponentY][opponentX] != "X" && pGameGrid.gameGrid[opponentY][opponentX] != "%"){
            for(int j=0;j<pGameGrid.ships.length;j++){
                if(pGameGrid.ships[j].checkAttack(opponentX,opponentY) == true){
                    totalHits++;
                    System.out.println("HIT "+pGameGrid.ships[j].name+"!!!");
                }
            }
            if(totalHits > 0){
                pGameGrid.gameGrid[opponentY][opponentX] = "X";
            }
            else{
                System.out.println("MISS!!!");
                pGameGrid.gameGrid[opponentY][opponentX] = "%";
            }
        }
        pGameGrid.printGrid();
    }

    public boolean checkVictory(){
        //Variable to check if all ships have been destroyed
        int pShipsDestroyed = 0;
        int oShipsDestroyed = 0;
        //Loop for number of ships
        for(int i=0;i<pGameGrid.ships.length;i++){
            //If number of hits on the current ship equals 3 increase the number of ships destroyed by 1
            if(pGameGrid.ships[i].getHits() == 3){
                pShipsDestroyed++;
                //If the number of ships destroyed equals the number of ships
                if(pShipsDestroyed == pGameGrid.ships.length){
                    //Lose scenario
                    System.out.println("You have lost!");
                    return true;
                }
            }
            //If number of hits on the current ship equals 3 increase the number of ships destroyed by 1
            else if(oGameGrid.ships[i].getHits() == 3){
                oShipsDestroyed++;
                //If the number of ships destroyed equals the number of ships
                if(oShipsDestroyed == oGameGrid.ships.length){
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
        if(input.equals("exit")){
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