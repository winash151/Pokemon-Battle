package engine.moves.water;

import engine.Statuses;
import engine.moves.Move;

public class Waterfall extends WaterMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public Waterfall() {
		super(127, Move.PHYSICAL, 80, 1, 15, "Waterfall", Statuses.FLINCHED,
				0.2);
		setDescription("The user charges at the target and may make it flinch. This can also be used to climb a waterfall.");
	}

	@Override
	public Move newInstance() {
		return new Waterfall();
	}
}