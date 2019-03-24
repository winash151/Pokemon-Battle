package engine.moves.steel;

import engine.Statuses;
import engine.moves.Move;

public class IronHead extends SteelMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public IronHead() {
		super(442, Move.PHYSICAL, 80, 1, 15, "Iron Head", Statuses.FLINCHED,
				0.3);
		setDescription("The user slams the target with its steel-hard head. This may also make the target flinch.");
	}

	@Override
	public Move newInstance() {
		return new IronHead();
	}
}
