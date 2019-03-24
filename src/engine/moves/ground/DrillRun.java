package engine.moves.ground;

import engine.moves.Move;

public class DrillRun extends GroundMove {

	/**
	 * id 296
	 * physical move
	 * base power 70
	 * base accuracy 100
	 * pp 20
	 * high crit rate
	 */
	public DrillRun() {
		super(529, Move.PHYSICAL, 80, .95, 10, "Drill Run", 0, 1);
		setDescription("The user crashes into its target while rotating its body like a drill. Critical hits land more easily.");
	}

	@Override
	public Move newInstance() {
		return new DrillRun();
	}
}