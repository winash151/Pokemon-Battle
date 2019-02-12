package engine.moves.flying;

import engine.Statuses;
import engine.moves.Move;

public class AirSlash extends FlyingMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public AirSlash() {
		super(403, Move.SPECIAL, 75, .95, 15, "Air Slash", Statuses.FLINCHED,
				0.3);
		setDescription("The user attacks with a blade of air that slices even the sky. This may also make the target flinch.");
	}

	@Override
	public Move newInstance() {
		return new AirSlash();
	}
}