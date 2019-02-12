package engine.moves.bug;

import engine.Statuses;
import engine.moves.Move;

public class SignalBeam extends BugMove {

	/**
	 * id 419
	 * special move
	 * base powre 60
	 * base acccuracy 100
	 * pp 20
	 * confuses target 20 percent
	 */
	public SignalBeam() {
		super(324, Move.SPECIAL, 75, 1.0, 15, "Signal Beam", Statuses.CONFUSED,
				0.1);
		setDescription("The user attacks with a sinister beam of light. This may also confuse the target.");
	}

	@Override
	public Move newInstance() {
		return new SignalBeam();
	}
}
