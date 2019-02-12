package engine.moves.poison;

import engine.Statuses;
import engine.moves.Move;

public class PoisonJab extends PoisonMove {

	/**
	 * id 343
	 * special move
	 * base power 90
	 * base accuracy 10
	 * poisons 30 percent
	 */
	public PoisonJab() {
		super(398, Move.PHYSICAL, 80, 1.0, 20, "Poison Jab", Statuses.POISON,
				0.3);
		setDescription("The target is stabbed with a tentacle or arm steeped in poison. This may also poison the target.");
	}

	@Override
	public Move newInstance() {
		return new PoisonJab();
	}
}