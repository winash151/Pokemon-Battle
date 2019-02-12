package engine.moves.electric;

import engine.InBattlePokemon;
import engine.moves.Move;

public class ThunderWave extends ElectricMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public ThunderWave() {
		super(86, Move.STATUS, 1, 20, "Thunder Wave");
		setDescription("The user launches a weak jolt of electricity that paralyzes the target.");
	}

	/**
	 * badly poisons target
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(!target.paralyze(user)){
			user.getDisplay().consolePrintln("But it failed.");
		}
	}
	

	@Override
	public Move newInstance() {
		return new ThunderWave();
	}

}
