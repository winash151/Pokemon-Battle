package engine.moves.ghost;

import engine.InBattlePokemon;
import engine.moves.Move;

public class ShadowBall extends GhostMove {

	/**
	 * id 21
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public ShadowBall() {
		super(247, Move.SPECIAL, 80, 1.0, 15, "Shadow Ball");
		setDescription("The user hurls a shadowy blob at the target. This may also lower the target's Sp. Def stat.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			if(target.decreaseSpDefense(1, false, user)){
				user.getDisplay().animateStatDecrease(user);
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
		if (user.getRandomGen().next() < 0.20)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new ShadowBall();
	}

}
