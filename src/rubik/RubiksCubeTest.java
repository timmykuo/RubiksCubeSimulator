package rubik;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RubiksCubeTest {

	private RubiksCube rubiksCube;
	private RubiksCube rubiks4x4Cube;
	private RubiksCube.TestHook test;
	private boolean clockwise = true;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private String string = "WRG WRN WRY" + "\n" +
							"WNG WNN WNY" + "\n" +
							"WOG WON WOY" + "\n" + 
							"\n" +
							"NRG NRN NRY" + "\n" +
							"NNG NNN NNY" + "\n" +
							"NOG NON NOY" + "\n" +
							"\n" +
							"BRG BRN BRY" + "\n" +
							"BNG BNN BNY" + "\n" +
							"BOG BON BOY" + "\n" +
							"\n";
	
	private String string4x4 = "WRG WRN WRN WRY" + "\n" +
							 "WNG WNN WNN WNY" + "\n" +
							 "WNG WNN WNN WNY" + "\n" +
							 "WOG WON WON WOY" + "\n" + 
							 "\n" +
							 "NRG NRN NRN NRY" + "\n" +
							 "NNG NNN NNN NNY" + "\n" +
							 "NNG NNN NNN NNY" + "\n" +
							 "NOG NON NON NOY" + "\n" +
							 "\n" +
							 "NRG NRN NRN NRY" + "\n" +
							 "NNG NNN NNN NNY" + "\n" +
							 "NNG NNN NNN NNY" + "\n" +
							 "NOG NON NON NOY" + "\n" +
							 "\n" +
							 "BRG BRN BRN BRY" + "\n" +
							 "BNG BNN BNN BNY" + "\n" +
							 "BNG BNN BNN BNY" + "\n" +
							 "BOG BON BON BOY" + "\n" +
							 "\n";
	
	@Before
	public void initalize() {
		rubiksCube = new RubiksCube();
		rubiks4x4Cube = new RubiksCube(4);
		test = rubiksCube.new TestHook();
		System.setOut(new PrintStream(outContent));
	}
	
    @After
    public void tearDown() throws Exception {
        rubiksCube = null;
        System.setOut(new PrintStream(outContent));
    }
    
    @Test
    public void testSetLayerColor1stTrue() {
    	assertEquals(Color.W, test.setLayerColor(0));
    }
    
    @Test
    public void testSetLayerColor2ndTrue() {
    	assertEquals(Color.N, test.setLayerColor(1));
    }
    
    @Test
    public void testSetLayerColorElse() {
    	assertEquals(Color.B, test.setLayerColor(2));
    }
    
    @Test
    public void testSetRowColor1stTrue() {
    	assertEquals(Color.R, test.setRowColor(0));
    }
    
    @Test
    public void testSetRowColor2ndTrue() {
    	assertEquals(Color.N, test.setRowColor(1));
    }
    
    @Test
    public void testSetRowColorElse() {
    	assertEquals(Color.O, test.setRowColor(2));
    }
    
    @Test
    public void testSetColColor1stTrue() {
    	assertEquals(Color.G, test.setColColor(0));
    }
    
    @Test
    public void testSetColColor2ndTrue() {
    	assertEquals(Color.N, test.setColColor(1));
    }
    
    @Test
    public void testSetColColorElse() {
    	assertEquals(Color.Y, test.setColColor(2));
    }

	@Test
	public void testDisplayStandardCube() {
		rubiksCube.displayCube();
		assertEquals(string, outContent.toString());
	}
	
	@Test
	public void testDisplay4x4Cube() {
		rubiks4x4Cube.displayCube();
		assertEquals(string4x4, outContent.toString());
	}
	
	@Test
	public void testRotate1stCase() {
		Cube[][][] tester = rubiksCube.getCurrentConfig();
		//case for when direction is topbottom
		rubiksCube.rotate(Color.W, clockwise);
		rubiksCube.rotate(Color.W, !clockwise);
		assertArrayEquals(tester, rubiksCube.getCurrentConfig());
	}
	
	@Test
	public void testRotate2ndCase() {
		Cube[][][] tester = rubiksCube.getCurrentConfig();
		//case for when direction is leftright
		rubiksCube.rotate(Color.G, clockwise);
		rubiksCube.rotate(Color.G, !clockwise);
		assertArrayEquals(tester, rubiksCube.getCurrentConfig());
	}
	
	@Test
	public void testRotate3rdCase() {
		Cube[][][] tester = rubiksCube.getCurrentConfig();
		//case for when direction is frontback
		rubiksCube.rotate(Color.O, clockwise);
		rubiksCube.rotate(Color.O, !clockwise);
		assertArrayEquals(tester, rubiksCube.getCurrentConfig());
	}
	
	@Test
	public void testRotateFrontBackClockwise() {
		String rotated = "WOG WNG WRG" + "\n" +
						"WON WNN WRN" + "\n" +
						"WOY WNY WRY" + "\n" +
						"\n" +
						"NRG NRN NRY" + "\n" +
						"NNG NNN NNY" + "\n" +
						"NOG NON NOY" + "\n" +
						"\n" +
						"BRG BRN BRY" + "\n" +
						"BNG BNN BNY" + "\n" +
						"BOG BON BOY" + "\n" +
						"\n";
		
		test.rotate(Color.W);
		rubiksCube.displayCube();
		assertEquals(rotated,  outContent.toString());
	}
	
	@Test
	public void testRotateTopBottomClockwise() {
		String rotated = "BRG NRG WRG" + "\n" + 
						 "WNG WNN WNY" + "\n" +
				   		 "WOG WON WOY" + "\n" + 
						 "\n" +
						 "BRN NRN WRN" + "\n" +
						 "NNG NNN NNY" + "\n" +
						 "NOG NON NOY" + "\n" +
						 "\n" +
						 "BRY NRY WRY" + "\n" +
						 "BNG BNN BNY" + "\n" +
						 "BOG BON BOY" + "\n" +
						 "\n";
		test.rotate(Color.R);
		rubiksCube.displayCube();
		assertEquals(rotated,  outContent.toString());
	}
	
	@Test
	public void testRotateLeftRightClockwise() {
		String rotated = "WRG WRN WOY" + "\n" +
						 "WNG WNN NOY" + "\n" +
						 "WOG WON BOY" + "\n" + 
						 "\n" +
						 "NRG NRN WNY" + "\n" +
						 "NNG NNN NNY" + "\n" +
						 "NOG NON BNY" + "\n" +
						 "\n" +
						 "BRG BRN WRY" + "\n" +
						 "BNG BNN NRY" + "\n" +
						 "BOG BON BRY" + "\n" +
						 "\n";
		test.rotate(Color.Y);
		rubiksCube.displayCube();
		assertEquals(rotated,  outContent.toString());
	}
	
	@Test
	public void testStressCase() {
		Cube[][][] comparer = rubiksCube.getCurrentConfig();
		for(int i = 0; i < 1000000; i+=1) {
			rubiksCube.rotate(Color.W, clockwise);
		}
		for(int i = 0; i < 1000000; i+=1) {
			rubiksCube.rotate(Color.B, !clockwise);
		}
		for(int i = 0; i < 1000000; i+=1) {
			rubiksCube.rotate(Color.G, clockwise);
		}
		for(int i = 0; i < 1000000; i+=1) {
			rubiksCube.rotate(Color.Y, !clockwise);
		}
		for(int i = 0; i < 1000000; i+=1) {
			rubiksCube.rotate(Color.O, clockwise);
		}
		for(int i = 0; i < 1000000; i+=1) {
			rubiksCube.rotate(Color.R, !clockwise);
		}
		
		assertArrayEquals(comparer, test.getCube());
	}

}
