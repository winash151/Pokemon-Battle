package engine.moves.water;

import engine.Statuses;
import engine.moves.Move;

public class WaterPulse extends WaterMove {

	/**
	 * id 419
	 * special move
	 * base powre 60
	 * base acccuracy 100
	 * pp 20
	 * confuses target 20 percent
	 */
	public WaterPulse() {
		super(352, Move.SPECIAL, 60, 1.0, 20, "Water Pulse", Statuses.CONFUSED,
				0.2);
		setDescription("The user attacks the target with a pulsing blast of water. This may also confuse the target.");
		setPulse(true);
	}

	@Override
	public Move newInstance() {
		return new WaterPulse();
	}
}
