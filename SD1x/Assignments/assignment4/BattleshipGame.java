package Assignments.assignment4;

import java.util.Scanner;

public class BattleshipGame {


	public static void main(String[] args) {
		/* Set-up the game */
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();

		//repeat until the game is over
		Scanner scanner = new Scanner(System.in);
		String inputBuffer;
		while(true){
			while(!ocean.isGameOver()){
				/* Accept user input */
				System.out.println("Inputs Shots:");
				System.out.println("  Format is: x1, y1; x2, y2; x3, y3; x4, y4; x5, y5");
				inputBuffer = scanner.nextLine();

				/* Parse and compute the user input*/
				String[] moves = inputBuffer.split(";");
				String[] positions;
				for(int i = 0; i < moves.length; i++){
					positions = moves[i].split(",");
					ocean.shootAt(Integer.parseInt(positions[0]), Integer.parseInt(positions[1]));
				}

				/* Display result */
				ocean.print();
			}

			/* Print final score and asks user to play again */
			System.out.println("Play again? (yes/no)");
			inputBuffer = scanner.nextLine();
			if(inputBuffer.equals("yes")){
				continue;
			} else {
				scanner.close();
				break;
			}
		}
	}

}
