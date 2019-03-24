package engine.moves.ice;

import engine.Statuses;
import engine.moves.Move;

public class IceBeam extends IceMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public IceBeam() {
		super(58, Move.SPECIAL, 95, 1.0, 15, "Ice Beam", Statuses.FROZEN,
				0.1);
		setDescription("The target is struck with an icy-cold beam of energy. This may also leave the target frozen.");
	}

	@Override
	public Move newInstance() {
		return new IceBeam();
	}

}
