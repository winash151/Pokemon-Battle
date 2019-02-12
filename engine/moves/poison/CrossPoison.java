package engine.moves.poison;

import engine.Statuses;
import engine.moves.Move;

public class CrossPoison extends PoisonMove {

	/**
	 * id 343
	 * special move
	 * base power 90
	 * base accuracy 10
	 * poisons 30 percent
	 */
	public CrossPoison() {
		super(440, Move.PHYSICAL, 70, 1.0, 20, "Cross Poison", Statuses.POISON,
				0.1);
		setCriticalHitBoost(1);
		setDescription("A slashing attack with a poisonous blade that may also poison the target. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new CrossPoison();
	}
}