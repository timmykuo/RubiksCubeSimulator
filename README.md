# RubiksCubeSimulator

# Synopsis 
This cube simulator allows you to create any sized cube, a standard sized cube, or a custom configuration of a rubiks cube.

# Code Example
```java
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
   ```
   This code block is an example of how it rotates a face of the cube.  The cube is represented through physical representations of each cube in a 3x3x3 matrix, so rotating consists of switching around the order of the cubes.
   
# Motivation
   This project was created as a homework assignment for EECS 293 at Case Western Reserve University.  The purpose of the project is to
   focus on object oriented design.  
   
# Installation
   Set up a development environment so that JAVA_HOME is equal to the path to the JDK and PATH must contain the path to the JDK. 
   Download Apache Ant, Junit, and JaCoCo and copy Junit's jars to ANT_HOME/lib and copy only the jacocoant.jar to ANT_HOME/lib.
   
   Enter the following lines into your .profile file:
   ```
   export ANT_HOME=/path/to/your/apache-ant-version/file
   export PATH=“$PATH:$ANT_HOME/bin:$JAVA_HOME/bin”
   ```
   
   That's a wrap for the environment set up.  You can now clone the repository through:
   ```
   git clone git@github.com:timmykuo/RubiksCubeSimulator.git
   ```
# API Reference
   Ant creates JavaDoc htmls for API reference.  Run the following command in your terminal:
   ```
   ant doc
   ```
   And the files will appear in a report file inside of your cloned respository.
   
# Tests
   Ant also run Junit tests for you that are in the src folder. Run the following command in your terminal when in the rubik folder: 
   ```
   ant test
   ```
   And it will report the tests that were passed/not passed inside the terminal.  
   
   
   
