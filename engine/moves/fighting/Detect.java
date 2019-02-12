package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;
import engine.moves.normal.Protect;

public class Detect extends FightingMove {

	/**
	 * id is 76
	 * is a status move
	 * starting accuracy is 100 percent
	 * pp is 10
	 * is not blocked by protect
	 * priority of 4
	 * 
	 */
	public Detect() {
		super(197, Move.STATUS, 1.0, 10, "Detect", 4);
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("Enables the user to evade all attacks. Its chance of failing rises if it is used in succession.");
	}
	
	//this move does not factor in stat changes or the target's evasion
	private double likelinessToProtect = 1.0;
	
	public boolean willStatusWork(InBattlePokemon user, InBattlePokemon target) {
		if (user.hasLastMove() && (user.getLastMove().equals(this)
				|| user.getLastMove().equals(new Protect()))
				) {
			//if one was used before cut the likeliness in half
			likelinessToProtect/=2;
		} else {
			//otherwise bring it back to 1.0
			likelinessToProtect = 1.0;
		}
		
		return user.getRandomGen().next()<likelinessToProtect;
	}
	
	//the status is setting up protect
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		user.getDisplay().consolePrintln(user.getName() + " detected the enemy.");
		user.setUpProtect();
	}

	@Override
	public Move newInstance() {
		return new Detect();
	}
}
