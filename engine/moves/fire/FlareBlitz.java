package engine.moves.fire;

import engine.InBattlePokemon;
import engine.Statuses;
import engine.moves.Move;

public class FlareBlitz extends FireMove {

	/**
	 * id 117
	 * physical move
	 * 120 base power
	 * 100 base accuracy
	 * pp 15
	 * inflicts burn 10% of the time
	 * blocked by protect
	 */
	public FlareBlitz() {
		super(394, Move.PHYSICAL, 120, 1.0, 15, "Flare Blitz", Statuses.BURN,
				0.1);
		setRecoil(true);
		setDescription("The user cloaks itself in fire and charges the target. This also damages the user quite a lot. This may leave the target with a burn.");
	}

	/**
	 * takes a third recoil damage
	 */
	public int recoilDamage(InBattlePokemon user, int damageDone) {
		int recoil = (int) (damageDone / 3.0);
		if (recoil > user.getCurrentHP())
			recoil = user.getCurrentHP();
		user.deductHP(recoil);
		System.out.println(user.getName() + " took " + recoil
				+ " in recoil damage.");
		user.getDisplay().consolePrintln(user.getName() + " sustained recoil damage.");
		return recoil;
	}

	@Override
	public Move newInstance() {
		return new FlareBlitz();
	}
}
