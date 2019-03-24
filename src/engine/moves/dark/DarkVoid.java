package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class DarkVoid extends DarkMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public DarkVoid() {
		super(464, Move.STATUS, 0.8, 5, "Dark Void");
		setDescription("Opposing Pokémon are dragged into a world of total darkness that makes them sleep.");
	}

	/**
	 * badly poisons target
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(!target.putToSleep()){
			user.getDisplay().consolePrintln("But it failed.");
		}
	}

	@Override
	public Move newInstance() {
		return new DarkVoid();
	}

}
