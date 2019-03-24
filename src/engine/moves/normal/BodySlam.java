package engine.moves.normal;

import engine.Statuses;
import engine.moves.Move;

public class BodySlam extends NormalMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public BodySlam() {
		super(34, Move.PHYSICAL, 85, 1.0, 15, "Body Slam", Statuses.PARALYSIS,
				0.3);
		setDescription("The user drops onto the target with its full body weight. This may also leave the target with paralysis.");
	}

	@Override
	public Move newInstance() {
		return new BodySlam();
	}
}
