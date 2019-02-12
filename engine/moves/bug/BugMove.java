package engine.moves.bug;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class BugMove extends Move {

	public BugMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.BUG, kind, basePower, accuracy, totalPP, name,
				status, statusProbability);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 */
	public BugMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.BUG, kind, accuracy, totalPP, name, status,
				statusProbability);
		// TODO Auto-generated constructor stub
	}
	
	public BugMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.BUG, kind, 0, accuracy, totalPP, name, null, 0, 0);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param speedPriority
	 */
	public BugMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.BUG, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		// TODO Auto-generated constructor stub
	}

	public BugMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.BUG, kind, basePower, accuracy, totalPP, name,
				speedPriority, criticalHitBoost);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 * @param speedPriority
	 */
	public BugMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.BUG, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public BugMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.BUG, kind, basePower, accuracy, totalPP, name);
		// TODO Auto-generated constructor stub
	}

	public BugMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.BUG, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}
	
	public int calculateDamage(InBattlePokemon user, InBattlePokemon target) {
		int damage = super.calculateDamage(user, target);
		
		if(user.getAbility().equals(Abilities.SWARM)){
			double hpPercent = 1.0*user.getCurrentHP()/user.getTotalHP();
			if(hpPercent<=1.0/3){
				damage = damage*3/2;
			}
		}
		
		return damage;
	}
}
