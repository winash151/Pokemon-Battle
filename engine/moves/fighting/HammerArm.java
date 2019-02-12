package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class HammerArm extends FightingMove {

	/**
	 * id 397
	 * physical
	 * base power 100
	 * base accuracy 75 percent
	 * pp 15
	 */
	public HammerArm() {
		super(359, Move.PHYSICAL, 100, .9, 10, "Hammer Arm");
		setPunch(true);
		setDescription("The user swings and hits with its strong and heavy fist. It lowers the user’s Speed, however.");
	}
	
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
		if(user.decreaseSpeed(1, false, user)){
			user.getDisplay().animateStatDecrease(user);
			while(user.getDisplay().isAnimatingStat()){
				System.out.print("");
			}
			
		}
	}

	@Override
	public Move newInstance() {
		return new HammerArm();
	}

}
