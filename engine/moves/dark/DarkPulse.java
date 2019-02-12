package engine.moves.dark;

import engine.Statuses;
import engine.moves.Move;

public class DarkPulse extends DarkMove {

	/**
	 * di 22
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public DarkPulse() {
		super(399, Move.SPECIAL, 80, 1, 15, "Dark Pulse", Statuses.FLINCHED,
				0.2);
		setDescription("The user releases a horrible aura imbued with dark thoughts. This may also make the target flinch.");
		setPulse(true);
	}

	@Override
	public Move newInstance() {
		return new DarkPulse();
	}

}
