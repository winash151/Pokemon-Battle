package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class HighJumpKick extends FightingMove {

	/**
	 * id 117
	 * physical move
	 * 120 base power
	 * 100 base accuracy
	 * pp 15
	 * inflicts burn 10% of the time
	 * blocked by protect
	 */
	public HighJumpKick() {
		super(136, Move.PHYSICAL, 130, .9, 10, "High Jump Kick");
		setRecoil(true);
		setDescription("The target is attacked with a knee kick from a jump. If it misses, the user is hurt instead.");
	}
	
	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		if(!super.use(user, target)) {
			if(user.canBattle()){
				int recoil = (int) (user.getTotalHP() / 2.0);
				if (recoil > user.getCurrentHP())
					recoil = user.getCurrentHP();
				user.deductHP(recoil);
				System.out.println(user.getName() + " took " + recoil
						+ " in recoil damage.");
				user.getDisplay().consolePrintln(user.getName() + " kept going and crashed.");
			}
		}
		
		return false;
	}
	
	public Move newInstance() {
		return new HighJumpKick();
	}
}
