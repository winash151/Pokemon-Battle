package engine.moves.grass;

import engine.moves.Move;

public class LeafBlade extends GrassMove {

	/**
	 * id 296
	 * physical move
	 * base power 70
	 * base accuracy 100
	 * pp 20
	 * high crit rate
	 */
	public LeafBlade() {
		super(348, Move.PHYSICAL, 90, 1.0, 15, "Leaf Blade", 0, 1);
		setDescription("The user handles a sharp leaf like a sword and attacks by cutting its target. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new LeafBlade();
	}
}