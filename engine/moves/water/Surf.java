package engine.moves.water;

import engine.moves.Move;

public class Surf extends WaterMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public Surf() {
		super(57, Move.SPECIAL, 90, 1.0, 15, "Surf");
		setDescription("The user attacks everything around it by swamping its surroundings with a giant wave. This can also be used for crossing water.");
	}

	@Override
	public Move newInstance() {
		return new Surf();
	}
}
