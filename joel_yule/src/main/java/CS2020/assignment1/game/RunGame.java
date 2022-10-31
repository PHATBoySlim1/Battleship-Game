package CS2020.assignment1.game;

import java.util.Scanner;

public class RunGame {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String input = "";

        //Converts command line inputs into int in order to create game object
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        int numberOfShips = Integer.parseInt(args[2]);
        
        GameControls game = new Game (width,height,numberOfShips);

        //Try and catch to test if the coordinates entered are valid inside a do while loop to run the game until 'exit' is entered
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
        //Exits game if victory has been achieved
        while(game.checkVictory() != true);

        System.exit(0);

		
    }
}