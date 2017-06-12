package Assignments;

public class Squarelotron {
	int [][] squarelotron;
	int size;

	/* Maximum size 8x8 */
	public Squarelotron(int n){
		this.size = n;
		this.squarelotron = new int[size][size];
		int curValue = 1;
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				squarelotron[i][j] = curValue++;
			}
		}
	}
	
	/* This method performs the Upside-Down Flip of the squarelotron, as described above, and returns the new squarelotron.
	 * The original squarelotron should not be modified. */
	public Squarelotron upsideDownFlip(int ring){
		// TODO
	}
	
	/* This method performs the Main Diagonal Flip of the squarelotron, as described above, and returns the new squarelotron.
	 * The original squarelotron should not be modified. */
	public Squarelotron mainDiagonalFlip(int ring){
		// TODO
	}
	
	/* The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
	 * Any integer, including zero and negative integers, is allowable as the argument.
	 * A value of -1 indicates a 90° counterclockwise rotation.
	 * This method modifies the internal representation of the squarelotron; it does not create a new squarelotron. */
	public void rotateRight(int numberOfTurns){
		// TODO
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
