package de.urbaniak.dungeon.app;

import java.util.Scanner;

import de.urbaniak.dungeon.character.Player;
import de.urbaniak.dungeon.space.Space;

public class App {
	
	private Player player;
	private Space s_0_0;
	private Space s_0_1;
	private Space s_1_0;
	private Space s_1_1;
	private Space s_1_2;
	private Space s_2_0;
	private Space s_2_1;

	public static void main(String[] args) {

		App world = new App();
		world.build();		
		world.createPlayer();
		world.play();
		world.sayGoodbye();

	}
	
	public void build(){
		
		s_0_0 = new Space("Dungeons entrance");
		s_0_1 = new Space("Bloody cave");
		s_1_0 = new Space("Biomechanical laboratory");
		s_1_1 = new Space("Stalagmite corridor");
		s_1_2 = new Space("Old library");
		s_2_0 = new Space("Cooling chamber");
		s_2_1 = new Space("Brood chamber");
		
		s_0_0.setSideSpace("east", s_0_1);
		s_0_1.setSideSpace("west", s_0_0);
		s_0_1.setSideSpace("south", s_1_1);
		s_1_0.setSideSpace("east", s_1_1);
		s_1_0.setSideSpace("south", s_2_0);
		s_1_1.setSideSpace("west", s_1_0);
		s_1_1.setSideSpace("north", s_0_1);
		s_1_1.setSideSpace("east", s_1_2);
		s_1_1.setSideSpace("south", s_2_1);
		s_1_2.setSideSpace("west", s_1_1);
		s_2_0.setSideSpace("north", s_1_0);
		s_2_0.setSideSpace("east", s_2_1);
		s_2_1.setSideSpace("north", s_1_1);
		s_2_1.setSideSpace("west", s_2_0);
		
	}
	
	public void createPlayer(){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("[Dungeon] Bitte geben Sie einen Spielernamen ein > ");
		String playerName = scanner.nextLine();
		player = new Player(playerName);
		player.setCurrentSpace(s_0_0);
		
		System.out.println("Willkommen im Dungeon " + player.getName());
		System.out.println("[Spielzuege] w => nach Norden gehen");
		System.out.println("[Spielzuege] d => nach Osten gehen");
		System.out.println("[Spielzuege] s => nach Sueden gehen");
		System.out.println("[Spielzuege] a => nach Westen gehen");
		System.out.println("[Spielzuege] y => Gegenstand aufsammeln");
		System.out.println("[Spielzuege] x => Gegenstand fallenlassen");
		System.out.println("[Spielzuege] c => Inventar anzeigen");
		System.out.println("[Spielzuege] q => Dungeon verlassen");
		player.getCurrentSpace().showEnvironment();
	}

	public void play(){

		Scanner scanner = new Scanner(System.in);

		while(true){

			System.out.println("[Dungeon] Was moechtest Du tun " + player.getName() + "?");
			String decision = scanner.next();

			switch(decision){

				case "w":	player.move("north");
							break;

				case "d":	player.move("east");
							break;

				case "s":	player.move("south");
							break;

				case "a":	player.move("west");
							break;

				case "y":	player.pickItem();
							player.getCurrentSpace().showEnvironment();
							break;

				case "x":	player.dropItem();
							player.getCurrentSpace().showEnvironment();
							break;

				case "c":	player.showInventory();
							break;

				case "q":	return;

				default:
					System.out.println("[Dungeon] Ungueltige Wahl");
			}

		}

	}

	public void sayGoodbye(){
		System.out.println("Du verlaesst nun Dungeon. Wir sehen uns wieder...");
	}
	
}
