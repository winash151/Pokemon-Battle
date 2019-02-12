package engine.moves.ice;

import engine.moves.Move;

public class IceShard extends IceMove {

	/**
	 * id 279
	 * physical move
	 * base power 40
	 * base accuracy of 100
	 * pp 30
	 * speed priority 1
	 */
	public IceShard() {
		super(420, Move.PHYSICAL, 40, 1.0, 30, "Ice Shard", 1);
		setDescription("The user flash freezes chunks of ice and hurls them at the target. This move always goes first.");
	}

	@Override
	public Move newInstance() {
		return new IceShard();
	}
}