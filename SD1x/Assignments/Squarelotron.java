package Assignments;

public class Squarelotron  {
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

	/* Creates a replica squarelotron */
	private Squarelotron copySquarelotron(){
		Squarelotron returnSquarelotron = new Squarelotron(this.size);
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				returnSquarelotron.squarelotron[i][j] = this.squarelotron[i][j];
			}
		}
		return returnSquarelotron;
	}
	
	/* Equals method for testing */
	public boolean equals(Object obj){
		Squarelotron s = (Squarelotron) obj;
		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				if(this.squarelotron[i][j] != s.squarelotron[i][j]){
					return false;
				}
			}
		}
		return true;
	}

	/* This method performs the Upside-Down Flip of the squarelotron, as described above, and returns the new squarelotron.
	 * The original squarelotron should not be modified. */
	public Squarelotron upsideDownFlip(int ring) {
		//check that the ring specified is not out of bounds
		int checkRings = (int) Math.ceil(size/2.0);
		if(ring <= 0 || ring > checkRings){
			return this;
		}

		//perform the upsideDownFlip
		Squarelotron returnSquarelotron = this.copySquarelotron();
		int maxDepth = (int) Math.floor(size/2.0);

		for(int i = 0; i < maxDepth; i ++){
			for(int j = 0; j < size; j ++){
				if(i == ring - 1 ){ //top
					if(j >= ring - 1 && j <= size - ring){
						returnSquarelotron.squarelotron[i][j] = this.squarelotron[size-1-i][j];
						returnSquarelotron.squarelotron[size-1-i][j] = this.squarelotron[i][j];
					}
				}
				else if(i >= ring - 1 ){ //in middle range horizontally
					if(j == ring - 1 || j == size - ring){ //in range vertically
						returnSquarelotron.squarelotron[i][j] = this.squarelotron[size-1-i][j];
						returnSquarelotron.squarelotron[size-1-i][j] = this.squarelotron[i][j];
					}
				}

			}
		}

		//return the upsideDownFlip Squarelotron
		return returnSquarelotron;
	}

	/* This method performs the Main Diagonal Flip of the squarelotron, as described above, and returns the new squarelotron.
	 * The original squarelotron should not be modified. */
	public Squarelotron mainDiagonalFlip(int ring){
		//check that the ring specified is not out of bounds
		int checkRings = (int) Math.ceil(size/2.0);
		if(ring <= 0 || ring > checkRings){
			return this;
		}

		//perform the upsideDownFlip
		Squarelotron returnSquarelotron = this.copySquarelotron();
		int maxDepth = (int) Math.floor(size/2.0);

		for(int i = 0; i < size; i ++){
			for(int j = 0; j < size; j ++){
				if(i == ring - 1 || i == size - ring){ //top&bottom
					if(j >= ring - 1 && j <= size - ring){
						returnSquarelotron.squarelotron[i][j] = this.squarelotron[j][i];
					}
				}
				else if(i >= ring - 1 && i <= size - ring){ //in middle range horizontally
					if(j == ring - 1 || j == size - ring){ //in range vertically
						returnSquarelotron.squarelotron[i][j] = this.squarelotron[j][i];
					}
				}

			}
		}

		//return the upsideDownFlip Squarelotron
		return returnSquarelotron;
	}

	/* The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
	 * Any integer, including zero and negative integers, is allowable as the argument.
	 * A value of -1 indicates a 90° counterclockwise rotation.
	 * This method modifies the internal representation of the squarelotron; it does not create a new squarelotron. */
	public void rotateRight(int numberOfTurns){
		if (numberOfTurns == 0 || numberOfTurns%4==0){
			return;
		}
		int[][] newSquarelotron = new int[size][size];
		if(numberOfTurns >= 1){
			for(int thisMany = 0; thisMany < numberOfTurns; thisMany++){
				for(int i = 0; i < size; i ++){
					for(int j = 0; j < size; j ++){
						newSquarelotron[i][j] = this.squarelotron[size - j - 1][i];
					}
				}
			}
		}
		if(numberOfTurns <= -1){
			for(int thisMany = 0; thisMany < Math.abs(numberOfTurns); thisMany++){
				for(int i = 0; i < size; i ++){
					for(int j = 0; j < size; j ++){
						newSquarelotron[i][j] = this.squarelotron[j][size - i - 1];
					}
				}
			}
		}
		this.squarelotron = newSquarelotron;
	}
}