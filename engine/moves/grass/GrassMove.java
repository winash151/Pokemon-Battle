package engine.moves.grass;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class GrassMove extends Move {

	public GrassMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.GRASS, kind, basePower, accuracy, totalPP, name,
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
	public GrassMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.GRASS, kind, accuracy, totalPP, name, status,
				statusProbability);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public GrassMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.GRASS, kind, accuracy, totalPP, name);
		//
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
	public GrassMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.GRASS, kind, basePower, accuracy, totalPP, name,
				speedPriority);
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
	public GrassMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.GRASS, kind, basePower, accuracy, totalPP, name,
				status, statusProbability, speedPriority);
	}

	public GrassMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.GRASS, kind, basePower, accuracy, totalPP, name,
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
	 */
	public GrassMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.GRASS, kind, basePower, accuracy, totalPP, name);
	}

	/**
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param totalPP
	 * @param name
	 */
	public GrassMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.GRASS, kind, totalPP, name);
	}
	
	public int calculateDamage(InBattlePokemon user, InBattlePokemon target) {
		int damage = super.calculateDamage(user, target);
		
		if(user.getAbility().equals(Abilities.OVERGROW)){
			double hpPercent = 1.0*user.getCurrentHP()/user.getTotalHP();
			if(hpPercent<=1.0/3){
				damage = damage*3/2;
			}
		}
		
		return damage;
	}
	
	public boolean canHitIfWillHit(InBattlePokemon user, InBattlePokemon target) {
		if(target.getAbility().equals(Abilities.SAP_SIPPER)){
			if(target.increaseAttack(1, false, target)){
				target.getDisplay().animateAbility(target);
				target.getDisplay().animateStatIncrease(target);
			}
			else {
				target.getDisplay().animateAbility(target);
			}
			return false;
		}
		
		return super.canHitIfWillHit(user, target);
	}
}
