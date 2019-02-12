package engine.moves.normal;

import engine.moves.Move;

public class Tackle extends NormalMove {

	/**
	 * id 315
	 * physical move
	 * base power 50
	 * base accuracy of 100
	 * pp 35
	 */
	public Tackle() {
		super(33, Move.PHYSICAL, 50, 1.0, 35, "Tackle");
		setDescription("A physical attack in which the user charges and slams into the target with its whole body.");
	}

	@Override
	public Move newInstance() {
		return new Tackle();
	}

}