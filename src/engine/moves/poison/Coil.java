package engine.moves.poison;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Coil extends PoisonMove {

	/**
	 * bulk up has an id of 71
	 * it is a status move
	 * the pp is 20
	 */
	public Coil() {
		super(489, Move.STATUS, 20, "Coil");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user coils up and concentrates. This raises its Attack and Defense stats as well as its accuracy.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		System.out.println(user.getName() + " became more bulky.");
		user.getDisplay().consolePrintln(user.getName() + " became more bulky.");
		boolean attackIncreased = user.increaseAttack(1, true, user);
		boolean defenseIncreased = user.increaseDefense(1, true, user);
		boolean accuracyIncreased = user.increaseAccuracy(1, true, user);
		
		if(attackIncreased || defenseIncreased || accuracyIncreased){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}
	
	@Override
	public Move newInstance() {
		return new Coil();
	}
}