package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SkullBash extends NormalMove {

	//turn of two turn attack
	private int turn = 1;

	/**
	 * id 293
	 * physical move
	 * base power 130
	 * base accuracy 100
	 * pp 15
	 */
	public SkullBash() {
		super(130, Move.PHYSICAL, 130, 1.0, 15, "Skull Bash");
		setDescription("The user tucks in its head to raise its Defense in the first turn, then rams the target on the next turn.");
	}

	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		boolean didWork;
		if (turn == 1) {//if first turn
			System.out.println(user.getName() + " tucked in its head.");
			user.getDisplay().consolePrintln(user.getName() + " tucked in its head.");
			
			if(user.increaseDefense(1, false, user)){
				user.getDisplay().animateStatIncrease(user);
				while(user.getDisplay().isAnimatingStat()){
					System.out.print("");
				}
			}
			
			turn++;
			user.setLastMove(user.getIndexOfNextMove());
			didWork = true;
		} else {//if second turn use move
			didWork = super.use(user, target);
		}
		return didWork;
	}

	public void cleanUp(InBattlePokemon user, InBattlePokemon target) {
		turn = 1;
		super.cleanUp(user, target);
	}

	@Override
	public Move newInstance() {
		return new SkullBash();
	}
}
