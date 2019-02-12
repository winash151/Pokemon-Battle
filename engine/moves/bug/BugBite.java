package engine.moves.bug;

import engine.moves.Move;

public class BugBite extends BugMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public BugBite() {
		super(450, Move.PHYSICAL, 60, 1, 20, "Bug Bite");
		setDescription("The user bites the target. If the target is holding a Berry, the user eats it and gains its effect.");
		setBite(true);
	}

	@Override
	public Move newInstance() {
		return new BugBite();
	}
}