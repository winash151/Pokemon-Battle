package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class CloseCombat extends FightingMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public CloseCombat() {
		super(370, Move.PHYSICAL, 120, 1, 5, "Close Combat");
		setDescription("Inflicts damage on the target. But it also reduces the user's Defense and Special Defense by 1 level.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		boolean decreaseDefense = user.decreaseDefense(1, false, user);
		boolean spDecreaseDefense = user.decreaseSpDefense(1, false, user);
		
		if(decreaseDefense || spDecreaseDefense){
			user.getDisplay().animateStatDecrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
	}

	@Override
	public Move newInstance() {
		return new CloseCombat();
	}

}
