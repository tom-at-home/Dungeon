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

	}
	
	public void build(){
		
		s_0_0 = new Space("Dungeon entrance");
		s_0_1 = new Space("Cave");
		s_1_0 = new Space("Labor");
		s_1_1 = new Space("Stalagmite corridor");
		s_1_2 = new Space("Library");
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
		
		//System.out.println(s_1_1.getSideSpace("south").getName());
		
	}
	
	public void createPlayer(){
		
		//Scanner scanner = new Scanner(System.in);		
		
		//System.out.println("[Dungeon] Bitte geben Sie einen Spielernamen ein > ");
		
		//String playerName = scanner.next();
			
		String playerName = "Master";
		
		player = new Player(playerName);
		
		player.setCurrentSpace(s_0_0);


		player.move("east");
		player.move("east");
		player.move("south");

		
		
		//System.out.println("Willkommen in Dungeon " + player.getName());
		//System.out.println("[Dungeon] Dein aktueller Ort > " + player.getCurrentSpace().getName());
	}
	
}
