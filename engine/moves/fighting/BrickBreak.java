package engine.moves.fighting;

import engine.BattleSide;
import engine.InBattlePokemon;
import engine.moves.Move;

public class BrickBreak extends FightingMove {

	/**
	 * id 69
	 * special move
	 * base power 80
	 * never misses
	 * pp 20
	 */
	public BrickBreak() {
		super(280, Move.PHYSICAL, 75, 1.0, 15, "Brick Break");
		setDescription("The user attacks with a swift chop. It can also break barriers, such as Light Screen and Reflect.");
	}
	
	public void beforeDoingDamage(InBattlePokemon user, InBattlePokemon target) {
		BattleSide targetSide = target.getBattleSide();
		if(targetSide.hasReflect()) {
			targetSide.breakReflect();
			user.getDisplay().consolePrintln(getName() + " broke through Reflect.");
		}
		
		if(targetSide.hasLightScreen()) {
			targetSide.breakLightScreen();
			user.getDisplay().consolePrintln(getName() + " broke through Light Screen.");
		}
	}

	@Override
	public Move newInstance() {
		return new BrickBreak();
	}

}
