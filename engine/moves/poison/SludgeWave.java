package engine.moves.poison;

import engine.Statuses;
import engine.moves.Move;

public class SludgeWave extends PoisonMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public SludgeWave() {
		super(482, Move.SPECIAL, 95, 1.0, 10, "Sludge Wave", Statuses.POISON,
				0.1);
		setDescription("The user strikes everything around it by swamping the area with a giant sludge wave. This may also poison those hit.");
	}

	@Override
	public Move newInstance() {
		return new SludgeWave();
	}

}
