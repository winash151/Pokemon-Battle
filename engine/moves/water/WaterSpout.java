package engine.moves.water;

import engine.InBattlePokemon;
import engine.moves.Move;

public class WaterSpout extends WaterMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public WaterSpout() {
		super(323, Move.SPECIAL, 150, 1, 5, "Water Spout");
		setDescription("The user spouts water to damage opposing Pokémon. The lower the user's HP, the lower the move's power.");
	}
	
	public int getBasePower(InBattlePokemon user, InBattlePokemon target) {
		return 150 * user.getCurrentHP()/user.getTotalHP();
	}

	@Override
	public Move newInstance() {
		return new WaterSpout();
	}
}
