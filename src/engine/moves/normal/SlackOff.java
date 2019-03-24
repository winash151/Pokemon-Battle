package engine.moves.normal;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SlackOff extends NormalMove {

	/**
	 * id 282
	 * status move
	 * pp 10
	 */
	public SlackOff() {
		super(303, Move.STATUS, 10, "Slack Off");
		setNeedsTarget(false);
		setDescription("The user slacks off, restoring its own HP by up to half of its max HP.");
	}

	/**
	 * can always hit
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	/**
	 * heal back hp
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {

		System.out.println(user.getCurrentHP() + "recover");
		if(user.getCurrentHP()==user.getTotalHP()){
			user.getDisplay().consolePrintln(user.getName() + "'s HP is already full.");
		}
		else{
			System.out.println("clear so half back");
			user.increaseHP(user.getTotalHP() / 2);
			user.getDisplay().consolePrintln(user.getName() + " regained health.");
		}
		System.out.println(user.getName() + "'s current health is "
				+ user.getCurrentHP() + "/" + user.getTotalHP() + ".");
	}

	@Override
	public Move newInstance() {
		return new SlackOff();
	}

}