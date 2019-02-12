package engine.moves.rock;

import engine.InBattlePokemon;
import engine.moves.Move;

public class HeadSmash extends RockMove {

	/**
	 * id 117
	 * physical move
	 * 120 base power
	 * 100 base accuracy
	 * pp 15
	 * inflicts burn 10% of the time
	 * blocked by protect
	 */
	public HeadSmash() {
		super(457, Move.PHYSICAL, 150, 0.8, 5, "Head Smash");
		setRecoil(true);
		setDescription("The user attacks the target with a hazardous, full-power headbutt. This also damages the user terribly.");
	}

	/**
	 * takes a third recoil damage
	 */
	public int recoilDamage(InBattlePokemon user, int damageDone) {
		int recoil = (int) (damageDone / 2.0);
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
		return new HeadSmash();
	}
}
