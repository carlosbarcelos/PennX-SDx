package Assignments;

import java.util.Scanner;

public class WhackAMole {
	int score;
	int molesLeft;
	int attemptsLeft;
	char[][] moleGrid;
	
	public WhackAMole(int numAttempts, int gridDimension){
		this.attemptsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
		for(int i = 0; i < gridDimension; i++){
			for(int j = 0; j < gridDimension; j++){
				moleGrid[i][j] = '*';
			}
		}
	}
	
	/* Given a location, place a mole at that location. */
	public boolean place(int x, int y){
		if(x > 0 && x < moleGrid.length){
			if(y > 0 && y < moleGrid.length){
				if(this.moleGrid[x][y] == '*'){
					this.moleGrid[x][y] = 'M';
					this.molesLeft++;
					return true;
				}
				return false;
			}
		}
		return false; //out of bounds
	}
	
	/* Given a location, take a whack at that location. */
	public void whack(int x, int y){
		if(this.moleGrid[x][y] == 'M'){
			this.moleGrid[x][y] = 'W';
			this.molesLeft--;
			this.score++;
			System.out.println("Whack!");	
			System.out.println("Moles left: " + this.molesLeft);	
		}
		this.attemptsLeft--;
	}
	
	/* Print the grid without showing where the moles are. */
	public void printGridToUser(){
		int size = this.moleGrid.length;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(moleGrid[i][j] == 'W'){
					System.out.print(moleGrid[i][j]);	
				} else{
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}
	
	/* Print the grid completely. */
	public void printGrid(){
		int size = this.moleGrid.length;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(moleGrid[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args){
		//create the game
		int gridSize = 10;
		WhackAMole game = new WhackAMole(50, gridSize);
		boolean wasPlaced;
		int rand1, rand2;
		for(int i = 0; i < 10; i++){
			wasPlaced = false;
			while(!wasPlaced){
				rand1 = (int )(Math.random() * gridSize + 1);
				rand2 = (int )(Math.random() * gridSize + 1);
				wasPlaced = game.place(rand1, rand2);
			}
		}
		
		//play the game
		Scanner scanner = new Scanner(System.in);
		int userX;
		int userY;
		System.out.println("Welcome to WhackAMole!");
		System.out.println("You have " + game.attemptsLeft + " to whack " + game.molesLeft + " moles.");

		while(true){
			game.printGridToUser();

			System.out.println("Please input an x coordinate: ");
			userX = scanner.nextInt();
			System.out.println("Please input an y coordinate: ");
			userY = scanner.nextInt();
			if(userX == -1 && userY == -1){ //check exit condition
				System.out.println("You have decided to give up.");
				break;
			}
			
			game.whack(userX, userY);
			
			if(game.molesLeft == 0){ //check win condition
				System.out.println("Congratulations! You have won the game.");
				break;
			}
			if(game.attemptsLeft == 0){ //check lose condition
				System.out.println("Aw man! You have lost the game.");
				break;
			}
		}
		System.out.println("Game Over.");
		game.printGrid();
		scanner.close();
	}
}
