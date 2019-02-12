package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;
import engine.moves.fighting.Detect;

public class Protect extends NormalMove {

	/**
	 * id 277 status move pp 10 priority of 4
	 */
	public Protect() {
		super(182, Move.STATUS, 1.0, 10, "Protect", 4);
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("Enables the user to evade all attacks. Its chance of failing rises if it is used in succession.");
	}

	// this move does not factor in stat changes or the target's evasion
	private double likelinessToProtect = 1.0;

	/**
	 * likeliness is cut in half each consecutive use if not consecutive
	 * likeliness is back to 100 percent
	 */
	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		boolean didWork = false;
		user.getDisplay().consolePrintln(user.getName() + " used " + getName() + "!");
		//this and protect are the two moves
		if (user.hasLastMove() && (user.getLastMove().equals(this)
				|| user.getLastMove().equals(new Detect()))
				) {
			//if one was used before cut the likeliness in half
			likelinessToProtect/=2;
		} else {
			//otherwise bring it back to 1.0
			likelinessToProtect = 1.0;
		}
		
		if(user.getRandomGen().next()<likelinessToProtect){
			System.out.println(user.getName() + " protected itself.");
			user.getDisplay().consolePrintln(user.getName() + " protected itself.");
			user.setUpProtect();
			didWork = true;
		}else{
			user.getDisplay().consolePrintln("But it failed");
		}
		cleanUp(user, target);
		return didWork;
	}
	
	//the status is setting up protect
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		System.out.println(user.getName() + " protected itself");
		user.setUpProtect();
	}

	@Override
	public Move newInstance() {
		return new Protect();
	}
}
