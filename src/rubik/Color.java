package rubik;

public enum Color {
	/**
	 * Represents the white face of the rubiks cube
	 */
	W (Direction.FRONT_BACK, 0),
	/**
	 * Represents the blue face of the rubiks cube
	 */
	B (Direction.FRONT_BACK, 2),
	/**
	 * Represents the green face of the rubiks cube
	 */
	G (Direction.LEFT_RIGHT, 0),
	/**
	 * Represents the yellow face of the rubiks cube
	 */
	Y (Direction.LEFT_RIGHT, 2),
	/**
	 * Represents the red face of the rubiks cube
	 */
	R (Direction.TOP_BOTTOM, 0),
	/**
	 * Represents the orange face of the rubiks cube
	 */
	O (Direction.TOP_BOTTOM, 2),
	/**
	 * Represents a side that isn't shown in the rubiks cube
	 */
	N (Direction.NONE, -1);
	
	private final Direction direction; //the orientation of the cube based on 
	private final int index; //the constant layer/row/column of the color
	
	Color(Direction direction, int index) {
		this.direction = direction;
		this.index = index;
	}

	/**
	 * Gets the direction of the color 
	 * @return returns the color's direction
	 */
	public Direction getDirection() {
		return direction;
	}
	
	/**
	 * Gets the constant index of the color
	 * @return returns the color's constant layer/row/column index
	 */
	public int getIndex() {
		return index;
	}
	
	public enum Direction {
		/**
		 * The direction that represents the top/bottom faces in the rubiks cube
		 */
		TOP_BOTTOM(1, 2, 0),
		/**
		 * The direction that represents the front/back faces in the rubiks cube
		 */
		FRONT_BACK(2, 1, 0),
		/**
		 * The direction that represents the left/right faces in the rubiks cube
		 */
		LEFT_RIGHT(0, 1, 2),
		/**
		 * The direction that represents the faces that aren't shown in the rubiks cube
		 */
		NONE(-1, -1, -1);
		
		private int layer; //order of the layer index when rotating clockwise
		private int row;   //order of the row index when rotating clockwise
		private int col;   //order of the col index when rotating clockwise
		
		Direction(int layer, int row, int col) {
			this.layer = layer;
			this.row = row;
			this.col = col;
		}
		
		/**
		 * Gets the layer index of the direction
		 * @return returns the direction's layer index position in the rubiks cube
		 */
		public int getLayer() {
			return layer;
		}
		
		/**
		 * Gets the row index of the direction
		 * @return returns the direction's row index position in the rubiks cube
		 */
		public int getRow() {
			return row;
		}
		
		/**
		 * Gets the column index of the direction
		 * @return returns the direction's col index position in the rubiks cube
		 */
		public int getCol() {
			return col;
		}
	}
}
