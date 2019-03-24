package engine.moves.steel;

import engine.InBattlePokemon;
import engine.moves.Move;

public class MeteorMash extends SteelMove {

	/**
	 * id 375
	 * physical
	 * base power 60
	 * base accuracy 100 percent
	 * pp 5
	 */
	public MeteorMash() {
		super(309, Move.PHYSICAL, 90, 0.9, 10, "Meteor Mash");
		setDescription("The target is hit with a hard punch fired like a meteor. This may also raise the user's Attack stat.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			boolean attackIncreased = user.increaseAttack(1, false, user);
			if(attackIncreased) {
				user.getDisplay().animateStatIncrease(user);
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
		return new MeteorMash();
	}
}