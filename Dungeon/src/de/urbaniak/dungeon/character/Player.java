package de.urbaniak.dungeon.character;

import de.urbaniak.dungeon.items.Food;
import de.urbaniak.dungeon.items.Item;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Character{

	private ArrayList<Item> inventory = new ArrayList<>();

	public Player(String name) {
		super(name);
	}
	
	public void move(String direction){
		
		switch(direction){
		
			case "west":	if(this.currentSpace.getWest() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");								
								this.setCurrentSpace(this.currentSpace.getWest());
								this.currentSpace.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;
							
			case "north":	if(this.currentSpace.getNorth() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");
								this.setCurrentSpace(this.currentSpace.getNorth());
								this.currentSpace.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;
							
			case "east":	if(this.currentSpace.getEast() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");
								this.setCurrentSpace(this.currentSpace.getEast());
								this.currentSpace.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;
			
			case "south":	if(this.currentSpace.getSouth() != null){
								System.out.println("[Dungeon] Du hast nun " + this.currentSpace.getName() + " verlassen.");
								this.setCurrentSpace(this.currentSpace.getSouth());
								this.currentSpace.showEnvironment();
							}
							else{
								System.out.println("[Dungeon] Dieser Weg ist versperrt.");
							}
							break;			
							
		}
	}

	public void addItem(Item item){
		this.inventory.add(item);
	}

	public void removeItem(Item item){
		this.inventory.remove(item);
	}

	public void pickItem(){
		if(this.getCurrentSpace().getItems().size() == 0){
			System.out.println("[Dungeon] Hier gibt es nichts zu holen.");
		}
		else{
			if(this.getCurrentSpace().getItems().size() == 1) {
				System.out.println("[Dungeon] " + this.getCurrentSpace().getItems().get(0).getName() + " aufgenommen.");
				this.addItem(this.getCurrentSpace().getItems().get(0));
				this.getCurrentSpace().removeItem(this.getCurrentSpace().getItems().get(0));
			}
			else{
				Scanner scanner = new Scanner(System.in);
				System.out.println("[Dungeon] Welchen Gegenstand moechtest Du aufnehmen? > ");

				for (int i = 0; i < this.getCurrentSpace().getItems().size(); i++){

					System.out.println(i+1 + " - " + this.getCurrentSpace().getItems().get(i).getName());

				}

				while(true) {
					try {
						int selectedItem = scanner.nextInt();

						if (selectedItem >= 1 && selectedItem <= this.getCurrentSpace().getItems().size()) {
							System.out.println("[Dungeon] " + this.getCurrentSpace().getItems().get(selectedItem -1).getName() + " aufgenommen.");
							this.addItem(this.getCurrentSpace().getItems().get(selectedItem -1));
							this.getCurrentSpace().removeItem(this.getCurrentSpace().getItems().get(selectedItem -1));
							//scanner.close();
							break;
						} else {
							System.out.println("[Entscheidung] Ungueltige Eingabe");
						}
					} catch (java.util.InputMismatchException exception) {
						System.out.println("[Entscheidung] Bitte eine Zahl eingeben");
						scanner.next();
					}
				}

			}
		}


	}

	public void dropItem(){
		if(this.inventory.size() == 0){
			System.out.println("[Dungeon] Dein Rucksack ist leer.");
		}
		else{
			if(this.inventory.size() == 1) {
				System.out.println("[Dungeon] " + this.inventory.get(0).getName() + " abgelegt.");
				this.getCurrentSpace().addItem(this.inventory.get(0));
				this.inventory.remove(this.inventory.get(0));
			}
			else{
				Scanner scanner = new Scanner(System.in);
				System.out.println("[Dungeon] Welchen Gegenstand moechtest Du ablegen? > ");

				for (int i = 0; i < this.inventory.size(); i++){

					System.out.println(i+1 + " - " + this.inventory.get(i).getName());

				}

				while(true) {
					try {
						int itemToDrop = scanner.nextInt();

						if (itemToDrop >= 1 && itemToDrop <= this.inventory.size()) {
							System.out.println("[Dungeon] " + this.inventory.get(itemToDrop -1).getName() + " abgelegt.");
							this.getCurrentSpace().addItem(this.inventory.get(itemToDrop -1));
							this.inventory.remove(this.inventory.get(itemToDrop -1));
							break;
						} else {
							System.out.println("[Entscheidung] Ungueltige Eingabe");
						}
					} catch (java.util.InputMismatchException exception) {
						System.out.println("[Entscheidung] Bitte eine Zahl eingeben");
						scanner.next();
					}
				}
			}
		}

	}

	/*public void eatItem(){
		if(this.inventory.size() == 0){
			System.out.println("[Dungeon] Dein Rucksack ist leer.");
		}
		else{
			if(this.inventory.size() == 1) {
				System.out.println("[Dungeon] " + this.inventory.get(0).getName() + " abgelegt.");
				this.getCurrentSpace().addItem(this.inventory.get(0));
				this.inventory.remove(this.inventory.get(0));
			}
			else{
				Scanner scanner = new Scanner(System.in);
				System.out.println("[Dungeon] Welchen Gegenstand moechtest Du ablegen? > ");

				for (int i = 0; i < this.inventory.size(); i++){

					System.out.println(i+1 + " - " + this.inventory.get(i).getName());

				}

				while(true) {
					try {
						int itemToDrop = scanner.nextInt();

						if (itemToDrop >= 1 && itemToDrop <= this.inventory.size()) {
							System.out.println("[Dungeon] " + this.inventory.get(itemToDrop -1).getName() + " abgelegt.");
							this.getCurrentSpace().addItem(this.inventory.get(itemToDrop -1));
							this.inventory.remove(this.inventory.get(itemToDrop -1));
							break;
						} else {
							System.out.println("[Entscheidung] Ungueltige Eingabe");
						}
					} catch (java.util.InputMismatchException exception) {
						System.out.println("[Entscheidung] Bitte eine Zahl eingeben");
						scanner.next();
					}
				}
			}
		}

	}*/

	public void showInventory(){
		if(this.inventory.size() == 0){
			System.out.println("[Dungeon] Du hast keine Gegenstaende in deinem Rucksack");
		}
		else{
			System.out.println("[Dungeon] In deinem Rucksack gibt es: ");
			for (Item item : this.inventory) {
				String itemDesc = item.getName();
				if(item instanceof Food){
					itemDesc += " (" + ((Food) item).getHp() + ")";
				}
				System.out.println(itemDesc);
			}
		}
	}

}
