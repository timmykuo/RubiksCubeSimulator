package rubik;

public class Cube {
	private final Color[] cube; //the final array of colors that represents a cube
	
	/**
	 * Constructs a cube based on the colors that are input
	 * @param c1 the first color of the cube
	 * @param c2 the second color of the cube
	 * @param c3 the third color of the cube
	 */
	public Cube(Color c1, Color c2, Color c3) {
		cube = new Color[3];
		cube[0] = c1;
		cube[1] = c2;
		cube[2] = c3;
	}
	
	/**
	 * Returns the color array of the cube
	 * @return the color array of the cube
	 */
	public Color[] getCube() {
		return cube;
	}
}
