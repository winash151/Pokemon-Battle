package engine.moves.rock;

import engine.InBattlePokemon;
import engine.moves.Move;

public class AncientPower extends RockMove {

	/**
	 * id 375
	 * physical
	 * base power 60
	 * base accuracy 100 percent
	 * pp 5
	 */
	public AncientPower() {
		super(246, Move.SPECIAL, 60, 1.0, 5, "Ancient Power");
		setDescription("The user attacks with a prehistoric power. It may also raise all the user's stats at once.");
	}

	/**
	 * side status decreases targets defense
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (willSideStatusOccur(user, target)) {
			boolean attackIncreased = user.increaseAttack(1, false, user);
			boolean defenseIncreased = user.increaseDefense(1, false, user);
			boolean spAttackIncreased = user.increaseSpAttack(1, false, user);
			boolean spDefenseIncreased = user.increaseSpDefense(1, false, user);
			boolean speedIncreased = user.increaseSpeed(1, false, user);
			if(attackIncreased || defenseIncreased || spAttackIncreased || spDefenseIncreased || speedIncreased){
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
		if (user.getRandomGen().next() < 0.10)
			return true;
		return false;
	}

	@Override
	public Move newInstance() {
		return new AncientPower();
	}
}