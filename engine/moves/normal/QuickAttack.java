package engine.moves.normal;

import engine.moves.Move;

public class QuickAttack extends NormalMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public QuickAttack() {
		super(98, Move.PHYSICAL, 40, 1.0, 30, "Quick Attack", 1);
		setDescription("The user lunges at the target at a speed that makes it almost invisible. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new QuickAttack();
	}
}
