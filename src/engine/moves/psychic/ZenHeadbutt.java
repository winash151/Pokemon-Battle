package engine.moves.psychic;

import engine.Statuses;
import engine.moves.Move;

public class ZenHeadbutt extends PsychicMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public ZenHeadbutt() {
		super(428, Move.PHYSICAL, 80, 0.9, 15, "Zen Headbutt", Statuses.FLINCHED,
				0.2);
		setDescription("The user focuses its willpower to its head and attacks the target. This may also make the target flinch.");
	}

	@Override
	public Move newInstance() {
		return new ZenHeadbutt();
	}
}