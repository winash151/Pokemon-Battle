package engine.moves.psychic;
import engine.InBattlePokemon;
import engine.moves.Move;

public class LightScreen extends PsychicMove {

	/**
	 * id 360
	 * status
	 * pp 30
	 * 
	 */
	public LightScreen() {
		super(113, Move.STATUS, 30, "Light Screen");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("A wondrous wall of light is put up to reduce damage from special attacks for five turns.");
	}

	//sets up a light screen
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		user.setUpLightScreen();
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new LightScreen();
	}
}
