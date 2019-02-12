package engine.moves.flying;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class SkyAttack extends FlyingMove {
	
	//the turn of the two turn attack
	private int turn = 1;

	/**
	 * id 141
	 * physical move
	 * base power 140
	 * base accuracy 90
	 * 5 pp
	 * flinches 30 percent
	 * high crit rate
	 */
	public SkyAttack() {
		super(143, Move.PHYSICAL, 140, .9, 5, "Sky Attack", Statuses.FLINCHED, 0.3, 0, 1);
		setDescription("A second-turn attack move where critical hits land more easily. This may also make the target flinch.");
	}
	
	/**
	 * different use
	 */
	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		boolean didWork = false;
		if (turn == 1) {//if first turn
			// set up for second turn but do nothing
			System.out.println(user.getName() + " became cloaked in a harsh light.");
			user.getDisplay().consolePrintln(user.getName() + " became cloaked in a harsh light.");
			turn++;
			user.setLastMove(user.getIndexOfNextMove());
			didWork = true;
		} else if (turn == 2) {//if its the second we do the move
			didWork = super.use(user, target);
		}
		return didWork;
	}

	public void cleanUp(InBattlePokemon user, InBattlePokemon target) {
		turn = 1;//reset the turn count
		super.cleanUp(user, target);//then clean up like usual
	}

	@Override
	public Move newInstance() {
		return new SkyAttack();
	}
}
