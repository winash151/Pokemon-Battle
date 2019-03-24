package engine.moves.flying;

import engine.Statuses;
import engine.moves.Move;

public class Bounce extends FlyingMove {

	/**
	 * id 130
	 * special move
	 * 85 base power
	 * accuracy 85
	 * paralysis 30 percent
	 */
	public Bounce() {
		super(340, Move.PHYSICAL, 85, .85, 15, "Bounce", Statuses.PARALYSIS,
				0.3);
		setDescription("The user bounces up high, then drops on the target on the second turn. This may also leave the target with paralysis.");
	}

	@Override
	public Move newInstance() {
		return new Bounce();
	}

}
