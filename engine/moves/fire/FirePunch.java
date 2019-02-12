package engine.moves.fire;

import engine.Statuses;
import engine.moves.Move;

public class FirePunch extends FireMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public FirePunch() {
		super(7, Move.PHYSICAL, 75, 1, 15, "Fire Punch", Statuses.BURN,
				0.1);
		setDescription("The target is punched with a fiery fist. This may also leave the target with a burn.");
	}

	@Override
	public Move newInstance() {
		return new FirePunch();
	}
}
