package CS2020.assignment1.game;
import java.util.Random;

public class Game implements GameControls{
    Random rand = new Random();
    PlayerGameGrid pGameGrid;
    OpponentGameGrid oGameGrid;

    public Game(int w, int h, int noOfShips){
        this.pGameGrid = new PlayerGameGrid(w,h,noOfShips);
        this.oGameGrid = new OpponentGameGrid(w,h,noOfShips);
    }

    public void playRound(String input){

        String[] splitInput = input.split(",",0);
        int x = Integer.parseInt(splitInput[0]);
        int y = Integer.parseInt(splitInput[1]);
        
        for(int i=0;i<oGameGrid.ships.length;i++){
            for(int j=0;j<3;j++){
                if(x == oGameGrid.ships[i].shipCoordinates[j][0] && y == oGameGrid.ships[i].shipCoordinates[j][1]){
                    System.out.println("HIT "+oGameGrid.ships[i].name+"!!!");
                    oGameGrid.ships[i].hits =+ 1;
                    oGameGrid.gameGrid[x][y] = "X";
                }
                else{
                    System.out.println("MISS!!!");
                    oGameGrid.gameGrid[x][y] = "%";
                }
            }
        }
        
        int opponentX = rand.nextInt(pGameGrid.gameGrid.length);
        int opponentY = rand.nextInt(pGameGrid.gameGrid[0].length);
        
        for(int a=0;a<pGameGrid.ships.length;a++){
            for(int b=0;b<3;b++){
                if(opponentX == pGameGrid.ships[a].shipCoordinates[b][0] && opponentY == pGameGrid.ships[a].shipCoordinates[b][1]){
                    System.out.println("HIT "+pGameGrid.ships[a].name+"!!!");
                    pGameGrid.ships[a].hits =+ 1;
                    pGameGrid.gameGrid[opponentX][opponentY] = "X";
                }
                else{
                    System.out.println("MISS!!!");
                    pGameGrid.gameGrid[opponentX][opponentY] = "%";
                }
            }
        }
    }

    public boolean checkVictory(){
        int shipsDestroyed = 0;
        for(int i=0;i<pGameGrid.ships.length;i++){
            if(pGameGrid.ships[i].hits == 3){
                shipsDestroyed++;
                if(shipsDestroyed == pGameGrid.ships.length){
                    System.out.println("You have lost!");
                    return false;
                }
            }
            else if(oGameGrid.ships[i].hits == 3){
                shipsDestroyed++;
                if(shipsDestroyed == oGameGrid.ships.length){
                    System.out.println("You have won!");
                    return true;
                }
            }
        }
        return false;
    }

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