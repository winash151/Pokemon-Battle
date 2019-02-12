package engine.moves.steel;

import engine.moves.Move;

public class BulletPunch extends SteelMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public BulletPunch() {
		super(418, Move.PHYSICAL, 40, 1.0, 30, "Bullet Punch", 1);
		setDescription("The user strikes the target with tough punches as fast as bullets. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new BulletPunch();
	}
}
