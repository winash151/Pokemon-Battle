package engine.moves.water;

import engine.moves.Move;

public class AquaTail extends WaterMove {

	/**
	 * id 315
	 * physical move
	 * base power 50
	 * base accuracy of 100
	 * pp 35
	 */
	public AquaTail() {
		super(401, Move.PHYSICAL, 90, 0.9, 10, "Aqua Tail");
		setDescription("The user attacks by swinging its tail as if it were a vicious wave in a raging storm.");
	}

	@Override
	public Move newInstance() {
		return new AquaTail();
	}

}