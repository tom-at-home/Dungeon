package de.urbaniak.dungeon.space;
import java.util.ArrayList;

import de.urbaniak.dungeon.items.*;

public class Space {

	private Space west;
	private Space north;
	private Space east;
	private Space south;
	
	private String name;
	
    private ArrayList<Item> items = new ArrayList<>();

    private final int MAX_ITEMS_PER_SPACE = 3;

	public Space(String name) {
		this.name = name;
		this.addRandomItems();
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

	public ArrayList<Item> getItems() {
		return items;
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

	public void showEnvironment(){
		System.out.println("[Dungeon] Dein aktueller Ort > " + this.getName());

		String gatesMessage = "Du kannst nach ";

		ArrayList<String> gates = new ArrayList<>();

		if(this.getNorth() != null){
			gates.add("N");
		}
		if(this.getEast() != null){
			gates.add("E");
		}
		if(this.getSouth() != null){
			gates.add("S");
		}
		if(this.getWest() != null){
			gates.add("W");
		}

		for (int i = 0; i < gates.size(); i++){
			gatesMessage += gates.get(i);
			if (i < (gates.size()-1))
				gatesMessage += ", ";
		}

		gatesMessage += " laufen";

		System.out.println("[Dungeon] " + gatesMessage);

		if(this.items.size() > 0){
			System.out.println("In diesem Raum gibt es: ");
			for (Item item : this.items) {
				System.out.println(item.getName());
			}
		}
		else
			System.out.println("In diesem Raum gibt es keine Gegenstaende");


	}

	private void addRandomItems(){

		for (int i = 0; i < this.MAX_ITEMS_PER_SPACE; i++){
			int r = (int)(Math.random() * 18) + 1;
			switch (r){

				case 1:	this.addItem(new Food("Apfel", 8));
						break;
				case 2:	this.addItem(new Tool("Fackel"));
						break;
				case 3:	this.addItem(new Tool("Spitzer Stein"));
						break;
				case 4:	this.addItem(new Food("Birne", 10));
						break;
				case 5:	this.addItem(new Food("Fisch", 15));
						break;
				case 6:	this.addItem(new Tool("Ring"));
						break;
				case 7:	this.addItem(new Tool("Runder Stein"));
					break;
				default:
						break;

			}
		}

	}
	
    public void addItem(Item item){
    	this.items.add(item);
    }
    
    public void removeItem(Item item) {
    	this.items.remove(item);	
	}
	
}
