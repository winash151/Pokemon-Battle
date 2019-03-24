package engine.moves.normal;

import engine.moves.Move;

public class Slash extends NormalMove {

	/**
	 * id 296
	 * physical move
	 * base power 70
	 * base accuracy 100
	 * pp 20
	 * high crit rate
	 */
	public Slash() {
		super(163, Move.PHYSICAL, 70, 1.0, 20, "Slash", 0, 1);
		setDescription("The target is attacked with a slash of claws or blades. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new Slash();
	}
}