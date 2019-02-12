package engine;


/**
 * Each pokemon has its own ability
 * @author Ashwin
 *
 */
public class Ability {

	//Each ability has an id number for the equals method
	private int idNum;
	//Each ability has a name
	private String name;

	/**
	 * @param idNum
	 * @param name
	 */
	public Ability(int idNum, String name) {
		this.idNum = idNum;
		this.name = name;
		Abilities.add(this);
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The equals method compares the id numbers
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Ability))
			return false;
		Ability objType = (Ability) obj;

		if (objType.getIdNum() != idNum)
			return false;

		return true;
	}

}
