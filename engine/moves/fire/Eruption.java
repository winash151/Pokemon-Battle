package engine.moves.fire;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Eruption extends FireMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public Eruption() {
		super(284, Move.SPECIAL, 150, 1, 5, "Eruption");
		setDescription("The user attacks opposing Pokémon with explosive fury. The lower the user's HP, the lower the move's power.");
	}
	
	public int getBasePower(InBattlePokemon user, InBattlePokemon target) {
		return 150 * user.getCurrentHP()/user.getTotalHP();
	}

	@Override
	public Move newInstance() {
		return new Eruption();
	}
}
