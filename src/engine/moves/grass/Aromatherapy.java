package engine.moves.grass;

import engine.InBattlePokemon;
import engine.Trainer;
import engine.moves.Move;

public class Aromatherapy extends GrassMove {

	/**
	 * id 350
	 * status move
	 * pp 30
	 */
	public Aromatherapy() {
		super(312, Move.STATUS, 5, "Aromatherapy");
		setNeedsTarget(false);
		setDescription("The user releases a soothing scent that heals all status conditions affecting the user's party.");
	}

	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		Trainer trainer = user.getBattleSide().getTrainer();
		InBattlePokemon[] party = trainer.getTeam();
		
		boolean didWork = false;
		
		for(InBattlePokemon pk: party) {
			if(pk.hasMajorStatusAilment()) {
				pk.healMajorStatusAilment();
				didWork = true;
			}
		}
		
		if(didWork) {
			user.getDisplay().consolePrintln(user.getName() + " and its team was cured of status problems.");
		} else {
			user.getDisplay().consolePrintln("But it failed.");
		}
	}

	@Override
	public Move newInstance() {
		return new Aromatherapy();
	}

}
