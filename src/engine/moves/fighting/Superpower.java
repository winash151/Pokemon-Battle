package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Superpower extends FightingMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public Superpower() {
		super(276, Move.PHYSICAL, 120, 1, 5, "Superpower");
		setDescription("The user attacks the target with great power. However, this also lowers the user's Attack and Defense stats.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		boolean decreaseAttack = user.decreaseAttack(1, false, user);
		boolean decreaseDefense = user.decreaseDefense(1, false, user);
		
		if(decreaseAttack || decreaseDefense){
			user.getDisplay().animateStatDecrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
	}

	@Override
	public Move newInstance() {
		return new Superpower();
	}

}
