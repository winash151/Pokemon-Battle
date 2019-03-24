package engine.moves.ice;

import engine.Statuses;
import engine.moves.Move;

public class IcicleCrash extends IceMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public IcicleCrash() {
		super(556, Move.PHYSICAL, 85, .9, 10, "Icicle Crash", Statuses.FLINCHED,
				0.3);
		setDescription("The user attacks by harshly dropping large icicles onto the target. This may also make the target flinch.");
	}

	@Override
	public Move newInstance() {
		return new IcicleCrash();
	}
}