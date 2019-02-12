package engine.moves.water;

import engine.InBattlePokemon;
import engine.moves.Move;

public class RazorShell extends WaterMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public RazorShell() {
		super(534, Move.PHYSICAL, 75, 0.95, 10, "Razor Shell");
		setDescription("The user cuts its target with sharp shells. This may also lower the target's Defense stat.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseDefense(1, false, user)){
				user.getDisplay().animateStatDecrease(target);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
		}
	}

	/**
	 * Uses randomness to determine whether a status effect will occur
	 * 30 percent of the time
	 * @return
	 */
	public boolean willSideStatusOccur(InBattlePokemon user, InBattlePokemon target) {
		if (user.getRandomGen().next() < 0.50)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new RazorShell();
	}

}
