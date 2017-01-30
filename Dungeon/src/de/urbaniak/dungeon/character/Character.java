package de.urbaniak.dungeon.character;
import de.urbaniak.dungeon.space.Space;

public class Character {

	protected Space currentSpace;
	protected String name;
	
	public Character(String name) {
		//super();
		this.name = name;
	}

	public Space getCurrentSpace() {
		return this.currentSpace;
	}
	
	public void setCurrentSpace(Space currentSpace) {
		this.currentSpace = currentSpace;
	}
	
	public String getName() {
		return name;
	}
	
}
