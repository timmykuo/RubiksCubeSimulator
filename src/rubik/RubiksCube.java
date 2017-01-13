package rubik;

import rubik.Color.Direction;

public class RubiksCube {

	private final int size; //the size of the cube
	private Cube[][][] rubiksCube; //the 3x3x3 array of cubes that represents the rubiks cube
	
	/**
	 * Creates a rubiks cube with a default size of 3
	 */
	public RubiksCube() {
		size = 3;	//size of a standard RubiksCube
		rubiksCube = new Cube[size][size][size];
	
		Color layerColor;
		Color rowColor;
		Color colColor;
		
		//constructs the 3x3x3 array of the cube
		for(int layer = 0; layer < size; layer++) {
			layerColor = setLayerColor(layer, size);
			for(int row = 0; row < size; row++) {
				rowColor = setRowColor(row, size);
				for(int col = 0; col < size; col++) {
					colColor = setColColor(col, size);
					rubiksCube[layer][row][col] = new Cube(layerColor, rowColor, colColor);
				} //for -- constructs the columns of the rubiks cube
			} //for -- constructs the rows of the rubiks cube
		} //for -- constructs the layers of the rubiks cube
	}
	
	private Color setLayerColor(int layer, int size) {
		if(layer == 0) {
			return Color.W;
		}
		else if(layer != size-1) {
			return Color.N;
		}
		else {
			return Color.B;
		}
	}
	
	private Color setRowColor(int row, int size) {
		if(row == 0) {
			return Color.R;
		}
		else if(row != size-1) {
			return Color.N;
		}
		else {
			return Color.O;
		}
	}
	
	private Color setColColor(int col, int size) {
		if(col == 0) {
			return Color.G;
		}
		else if(col != size-1) {
			return Color.N;
		}
		else {
			return Color.Y;
		}
	}
	
	/**
	 * Constructs a rubiks cube with the 3x3x3 cube array  
	 * @param rubiksCube the desired 3x3x3 array for the rubiks cube
	*/
	public RubiksCube(Cube[][][] rubiksCube) {
		size = rubiksCube.length;	//size of the input rubiksCube
		this.rubiksCube = rubiksCube;
	}
	
	/**
	 * Constructs a rubiks cube based on the size specified in the input
	 * @param size the desired size of the rubiks cube 
	 */
	public RubiksCube(int size) {
		this.size = size;
		
		rubiksCube = new Cube[size][size][size];
		
		Color layerColor;
		Color rowColor;
		Color colColor;
		
		for(int i = 0; i < size; i++) {
			layerColor = setLayerColor(i, size);
			for(int j = 0; j < size; j++) {
				rowColor = setRowColor(j, size);
				for(int k = 0; k < size; k++) {
					colColor = setColColor(k, size);
					rubiksCube[i][j][k] = new Cube(layerColor, rowColor, colColor);
				}
			}
		}
	} 
	
	/**
	 * Get the current configuration of the cube
	 * @return returns the config in a form of a 3x3x3 array of cubes
	 */
	public Cube[][][] getCurrentConfig() {
		return rubiksCube;
	}
	
	/**
	 * Prints the rubiks cube so that it is organized by an extra line for each layer
	 */
	public void displayCube() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					Cube cube = rubiksCube[i][j][k];
					System.out.print(cube.getCube()[0]);
					System.out.print(cube.getCube()[1]);
					System.out.print(cube.getCube()[2]);
					if (k != size-1) {
						System.out.print(" ");
					} 
				} //for - print each cube in the column
				System.out.print("\n");
			} //for - each row
			System.out.print("\n");
		} //for - each layer
	}
	
	/**
	 * Rotates the face in a clockwise or counterclockwise direction
	 * @param color the face that is to be rotated
	 * @param clockwise the direction to rotate
	 */
	public void rotate(Color color, boolean clockwise) {
		//rotate the cube clockwise
		if(clockwise) {
			rotate(color);
		}
		//rotate the cube counter-clockwise
		else {
			for(int i = 0; i < size; i++) {
				rotate(color);
			}
		}
	}

	private void rotate(Color color) { 
		//rotate the color's face in a clockwise direction
		for(int j = 0; j < size/2; j++) {
			for(int k = j; k < size-j-1; k++) {
				//store top cube in temp
				Cube temp = getCube(color.getDirection(), k, j, color.getIndex());
				
				//rotate from right to top
				setCube(color.getDirection(), 
						getCube(color.getDirection(), j, size-k-1, color.getIndex()), 
						k, j, color.getIndex());
			
				//rotate from bottom to right
				setCube(color.getDirection(), 
						getCube(color.getDirection(), size-k-1, size-j-1, color.getIndex()), 
						j, size-k-1, color.getIndex());
			
				//rotate from left to bottom
				setCube(color.getDirection(), 
						getCube(color.getDirection(), size-j-1, k, color.getIndex()), 
						size-k-1, size-j-1, color.getIndex());
			
				//store temp in left 
				setCube(color.getDirection(), 
						temp, 
						size-j-1, k, color.getIndex());
			}
		}
	}
	
	private void setCube(Direction direction, Cube cube, int... indices) {
		//order the indices correctly by the direction's order
		int layer = indices[direction.getLayer()];
		int row = indices[direction.getRow()];
		int col = indices[direction.getCol()];
		
		rubiksCube[layer][row][col] = cube;
	}

	private Cube getCube(Direction direction, int... indices) {
		//order the indices correctly by the direction's order
		int layer = indices[direction.getLayer()];
		int row = indices[direction.getRow()];
		int col = indices[direction.getCol()];
		
		return rubiksCube[layer][row][col];
	}
	
	private Cube[][][] getCube() {
		return this.rubiksCube;
	}
	
	public class TestHook {
		public Color setLayerColor(int i) {
			return RubiksCube.this.setLayerColor(i, size);
		}
		public Color setRowColor(int i) {
			return RubiksCube.this.setRowColor(i, size);
		}
		public Color setColColor(int i) {
			return RubiksCube.this.setColColor(i, size);
		}
		public Cube[][][] getCube() {
			return RubiksCube.this.getCube();
		}
		public void rotate(Color color) {
			RubiksCube.this.rotate(color);
		}
	}
}
	
	
