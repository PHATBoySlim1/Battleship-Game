package CS2020.assignment1.game;

import java.util.Scanner;

public class RunGame {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = "";

        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int numberOfShips = Integer.parseInt(args[2]);
        
        GameControls game = new Game (width,height,numberOfShips);

        do{
            try{
                System.out.println("Enter coordinates (separated by comma): ");
                input = sc.nextLine();
                game.exitGame(input);
                game.playRound(input);
            }
            catch(Exception e){
                System.out.println("Incorrect input");
            }
        }
        while(game.checkVictory() != true);

        System.exit(0);

		
    }
}