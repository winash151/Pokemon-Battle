package engine;

import java.util.Random;

/**
 * Statically generates a random number
 * @author Ashwin
 *
 */
public class RandomGen {
	private Random ranGen;
	
	public void setSeed(int seed){
		ranGen = new Random(seed);
	}
	
	public double next(){
		return ranGen.nextDouble();
	}
}
