package engine.moves.psychic;

import engine.InBattlePokemon;
import engine.moves.Move;

public class CalmMind extends PsychicMove {

	/**
	 * bulk up has an id of 353
	 * it is a status move
	 * the pp is 20
	 */
	public CalmMind() {
		super(347, Move.STATUS, 20, "Calm Mind");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user quietly focuses its mind and calms its spirit to raise its Sp. Atk and Sp. Def stats.");
	}

	/**
	 * increases attack and defense by one stage
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		System.out.println(user.getName() + " became more calmed down.");
		user.getDisplay().consolePrintln(user.getName() + " calmed its mind.");
		boolean increaseSpAttack = user.increaseSpAttack(1, true, user);
		boolean increaseSpDefense = user.increaseSpDefense(1, true, user);
		if(increaseSpAttack || increaseSpDefense){
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}

	/**
	 * This move can't miss
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new CalmMind();
	}
}
