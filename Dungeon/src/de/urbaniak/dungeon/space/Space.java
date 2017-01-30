package de.urbaniak.dungeon.space;
import java.util.ArrayList;

import de.urbaniak.dungeon.items.Item;

public class Space {

	private Space west;
	private Space north;
	private Space east;
	private Space south;
	
	private String name;
	
    private ArrayList<Item> items = new ArrayList<>();

	public Space(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Space getWest(){
		return this.west;
	}
	
	public Space getNorth(){
		return this.north;
	}
	
	public Space getEast(){
		return this.east;
	}
	
	public Space getSouth(){
		return this.south;
	}	
	
	public void setSideSpace(String orientation, Space space){
		
		switch(orientation){
		
			case "west":	this.west = space;
							break;
			case "north":	this.north = space;
							break;
			case "east":	this.east = space;
							break;
			case "south":	this.south = space;
							break;		
		
		}
		
	}
	
	public Space getSideSpace(String orientation){
		
		Space space = null;
		
		switch(orientation){
		
			case "west":	space = this.west;
							break;
			case "north":	space = this.north;
							break;
			case "east":	space = this.east;
							break;
			case "south":	space = this.south;
							break;
		
		}
		
		return space;
		
	}	
	
    public void addItem(Item item){
    	this.items.add(item);
    }
    
    public void removeItem(Item item) {
    	this.items.remove(item);		
	}
	
}
