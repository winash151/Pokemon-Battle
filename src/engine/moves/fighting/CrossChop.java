package engine.moves.fighting;

import engine.moves.Move;

public class CrossChop extends FightingMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public CrossChop() {
		super(238, Move.PHYSICAL, 100, .8, 5, "Cross Chop", 0, 1);
		setDescription("The user delivers a double chop with its forearms crossed. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new CrossChop();
	}
}
