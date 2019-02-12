package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class BellyDrum extends NormalMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public BellyDrum() {
		super(187, Move.STATUS, 10, "Belly Drum");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user maximizes its Attack stat in exchange for HP equal to half its max HP.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		
		
		int halfHP = user.getTotalHP()/2;
		
		if(user.getCurrentHP()<=halfHP || user.getAttackStage()==6) {
			user.getDisplay().consolePrintln("But it failed.");
		} else {
			user.deductHP(halfHP);
			user.setAttackStage(6);
			user.getDisplay().animateStatIncrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
		}
		
	}

	@Override
	public Move newInstance() {
		return new BellyDrum();
	}

}
