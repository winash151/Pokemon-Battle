package engine.moves.normal;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class FakeOut extends NormalMove {

	/**
	 * di 129
	 * special mvoe
	 * base power 75
	 * bace accuracy 95
	 * pp 15
	 * flinches 30 percent
	 */
	public FakeOut() {
		super(252, Move.PHYSICAL, 40, 1, 10, "Fake Out", Statuses.FLINCHED,
				1);
		setSpeedPriority(3);
		setDescription("An attack that hits first and makes the target flinch. It only works the first turn the user is in battle.");
	}
	
	public boolean canHit(InBattlePokemon user, InBattlePokemon target) {
		if(user.getTurnsInBattle()==1) {
			return super.canHit(user, target);
		}
		
		user.getDisplay().consolePrintln("But it failed...");
		return false;
	}

	@Override
	public Move newInstance() {
		return new FakeOut();
	}
}
