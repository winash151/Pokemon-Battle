package engine.moves.ice;

import engine.Statuses;
import engine.moves.Move;

public class IcePunch extends IceMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public IcePunch() {
		super(8, Move.PHYSICAL, 75, 1.0, 15, "Ice Punch", Statuses.FROZEN,
				0.1);
		setDescription("The target is punched with an icy fist. This may also leave the target frozen.");
	}

	@Override
	public Move newInstance() {
		return new IcePunch();
	}

}
