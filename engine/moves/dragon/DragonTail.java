package engine.moves.dragon;

import engine.moves.Move;

public class DragonTail extends DragonMove {

	/**
	 * id 243
	 * physical move
	 * base power 80
	 * base accuracy of 100
	 * pp 5
	 * speed priority 1
	 */
	public DragonTail() {
		super(525, Move.PHYSICAL, 60, .9, 10, "Dragon Tail", -6);
		setDescription("The target is knocked away, and a different Pokémon is dragged out. In the wild, this ends a battle against a single Pokémon.");
	}

	@Override
	public Move newInstance() {
		return new DragonTail();
	}

}
