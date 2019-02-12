package engine.moves.electric;

import engine.Abilities;
import engine.InBattlePokemon;
import engine.Status;
import engine.Types;
import engine.moves.Move;

public abstract class ElectricMove extends Move {

	public ElectricMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		super(idNum, Types.ELECTRIC, kind, basePower, accuracy, totalPP, name,
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
	public ElectricMove(int idNum, String kind, double accuracy, int totalPP,
			String name, Status status, double statusProbability) {
		super(idNum, Types.ELECTRIC, kind, accuracy, totalPP, name, status,
				statusProbability);
	}
	
	public ElectricMove(int idNum, String kind, double accuracy, int totalPP,
			String name) {
		super(idNum, Types.ELECTRIC, kind, 0, accuracy, totalPP, name, null, 0, 0);
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
	public ElectricMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority) {
		super(idNum, Types.ELECTRIC, kind, basePower, accuracy, totalPP, name,
				speedPriority);
		// TODO Auto-generated constructor stub
	}

	public ElectricMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, int speedPriority, int criticalHitBoost) {
		super(idNum, Types.ELECTRIC, kind, basePower, accuracy, totalPP, name,
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
	public ElectricMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name, Status status, double statusProbability,
			int speedPriority) {
		super(idNum, Types.ELECTRIC, kind, basePower, accuracy, totalPP, name,
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
	public ElectricMove(int idNum, String kind, int basePower, double accuracy,
			int totalPP, String name) {
		super(idNum, Types.ELECTRIC, kind, basePower, accuracy, totalPP, name);
		// TODO Auto-generated constructor stub
	}

	public ElectricMove(int idNum, String kind, int totalPP, String name) {
		super(idNum, Types.ELECTRIC, kind, 0, 1.0, totalPP, name, null, 0, 0);
	}
	
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if(getType().equals(Types.ELECTRIC) && target.getAbility().equals(Abilities.LIGHTNING_ROD)){
			return true;
		}
		
		return super.willHit(user, target);
	}
	
	public boolean canHitIfWillHit(InBattlePokemon user, InBattlePokemon target) {
		if(target.getAbility().equals(Abilities.LIGHTNING_ROD)){
			if(target.increaseSpAttack(1, false, target)){
				target.getDisplay().animateAbility(target);
				target.getDisplay().animateStatIncrease(target);
			}
			else {
				target.getDisplay().animateAbility(target);
			}
			return false;
		} else if(target.getAbility().equals(Abilities.VOLT_ABSORB)){
			target.getDisplay().animateAbility(target);
			target.increaseHP(target.getTotalHP()/4);
			return false;
		} else if(target.getAbility().equals(Abilities.MOTOR_DRIVE)){
			if(target.increaseSpeed(1, false, target)){
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
