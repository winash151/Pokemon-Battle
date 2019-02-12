package engine.moves.dragon;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Outrage extends DragonMove {

	//turn of two turn attack
	private int turn = 1;
	private int totalTurns = 2;
	
	private int minTurns = 2;
	private int maxTurns = 3;

	/**
	 * id 293
	 * physical move
	 * base power 100
	 * base accuracy 100
	 * pp 15
	 */
	public Outrage() {
		super(200, Move.PHYSICAL, 120, 1.0, 10, "Outrage");
		setDescription("The user rampages and attacks for two to three turns. It then becomes confused, however.");
	}

	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		boolean didWork;
		if (turn == 1) {
			totalTurns= (int) (user.getRandomGen().next()*minTurns) + maxTurns - minTurns + 1;
			didWork = super.use(user, target);
			if(didWork){
				turn++;
				user.setLastMove(user.getIndexOfNextMove());
			} else{
				turn=1;
				super.cleanUp(user, target);
				user.confuse();
			}
			
		} else	{//if second turn use move
			didWork = super.use(user, target);
			if(turn==totalTurns){
				turn=1;
				super.cleanUp(user, target);
				user.confuse();
			}
			else{
				if(didWork){
					turn++;
					user.setLastMove(user.getIndexOfNextMove());
				} else{
					turn=1;
					super.cleanUp(user, target);
					user.confuse();
				}
			}
		}
		
		return didWork;
	}

	public void cleanUp(InBattlePokemon user, InBattlePokemon target) {}

	
	public Move newInstance() {
		return new Outrage();
	}

}
