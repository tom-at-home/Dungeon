package de.urbaniak.dungeon.character;

public class Player extends Character{

	public Player(String name) {
		super(name);
	}
	
	public void move(String direction){
		
		switch(direction){
		
			case "west":	if(this.currentSpace.getWest() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");								
								this.setCurrentSpace(this.currentSpace.getWest());
								this.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;
							
			case "north":	if(this.currentSpace.getNorth() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");
								this.setCurrentSpace(this.currentSpace.getNorth());
								this.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;
							
			case "east":	if(this.currentSpace.getEast() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");
								this.setCurrentSpace(this.currentSpace.getEast());
								this.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;
			
			case "south":	if(this.currentSpace.getSouth() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");
								this.setCurrentSpace(this.currentSpace.getSouth());
								this.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;			
							
		}
	}
	
	public void showEnvironment(){
		System.out.println("[Dungeon] Dein aktueller Ort > " + this.getCurrentSpace().getName());
	}
	
}
