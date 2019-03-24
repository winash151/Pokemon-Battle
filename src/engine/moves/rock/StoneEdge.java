package engine.moves.rock;

import engine.moves.Move;

public class StoneEdge extends RockMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public StoneEdge() {
		super(444, Move.PHYSICAL, 100, .8, 5, "Stone Edge", 0, 1);
		setDescription("The user stabs the target with sharpened stones from below. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new StoneEdge();
	}
}
