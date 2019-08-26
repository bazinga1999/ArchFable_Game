import java.util.*; 
import java.lang.*; 
import java.math.BigInteger;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*; 

import javax.swing.*;

class node{
	int number;
	Monster monster;
	node(int number){
		this.number = number;
	}
}

class user{
	private String name = "";
	Hero hero;
	public String getName(){
		return name;
	}
	public void setName(String nam){
		name = nam;
	}
	
}

abstract class Hero{
	private int HP=0;
	private int XP=0;
	private int level=0;
	private int ideal_HP=0;
	private int XP_required=0;

	public int getideal_HP(){
		return ideal_HP;
	}
	public void setideal_HP(int Health){
		this.ideal_HP = Health;
	}
	public int getXP_required(){
		return XP_required;
	}
	public void setXP_required(int XPP){
		this.XP_required = XPP;
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int lev){
		this.level = lev;
	}
	
	public int getHP(){
		return HP;
	}
	public void setHP(int Health){
		this.HP = Health;
	}
	public int getXP(){
		return XP;
	}
	public void setXP(int XPP){
		this.XP = XPP;
	}
	abstract int attack();
	abstract int defence();	
	abstract String getName();
	abstract int attack_strength();
	abstract void set_attack_strength(int x);
	abstract int defence_strength();
	abstract void set_defence_strength(int x);
}

class Warrior extends Hero{
	private final String name = "Warrior";
	public String getName(){
		return name;
	}
	
	private int attack_strength = 10;
	private int defence_strength = 3;
//	public int attack_strength(10){
//		return attack_strength;
//	}
	
	public void setattack_strength(int as){
		this.defence_strength = as;
	}
	public void setdefence_strength(int ds){
		this.defence_strength = ds;
	}
	
	int attack() {
		return attack_strength;
	}
	
	int defence() {
		return defence_strength;
	}

	@Override
	int attack_strength() {
		return attack_strength;
	}
	@Override
	void set_attack_strength(int x) {
		this.attack_strength+=x;
	}
	@Override
	int defence_strength() {
		return defence_strength;
	}
	@Override
	void set_defence_strength(int x) {
		this.defence_strength+=x;		
	}
	
}
class Healer extends Hero{
	private final String name = "Healer";
	String getName(){
		return name;
	}
	
	private int attack_strength = 4;
	private int defence_strength = 8;
	
	public void setattack_strength(int as){
		this.defence_strength = as;
	}
	public void setdefence_strength(int ds){
		this.defence_strength = ds;
	}
	
	int attack() {
		return attack_strength;
	}
	
	int defence() {
		return defence_strength;
	}

	@Override
	int attack_strength() {
		return attack_strength;
	}
	@Override
	void set_attack_strength(int x) {
		this.attack_strength+=x;
	}
	@Override
	int defence_strength() {
		return defence_strength;
	}
	@Override
	void set_defence_strength(int x) {
		this.defence_strength+=x;		
	}
}
class Thief extends Hero{
	private final String name = "Thief";
	public String getName(){
		return name;
	}
	private int attack_strength = 6;
	private int defence_strength = 4;
	public void setattack_strength(int as){
		this.defence_strength = as;
	}
	public void setdefence_strength(int ds){
		this.defence_strength = ds;
	}
	int attack() {
		return attack_strength;
	}
	int defence() {
		return defence_strength;
	}
	@Override
	int attack_strength() {
		return attack_strength;
	}
	@Override
	void set_attack_strength(int x) {
		this.attack_strength+=x;
	}
	@Override
	int defence_strength() {
		return defence_strength;
	}
	@Override
	void set_defence_strength(int x) {
		this.defence_strength+=x;		
	}
}
class Mage extends Hero{
	private final String name = "Mage";
	public String getName(){
		return name;
	}
	private int attack_strength = 5;
	private int defence_strength = 5;
	public void setattack_strength(int as){
		this.defence_strength = as;
	}
	public void setdefence_strength(int ds){
		this.defence_strength = ds;
	}
	int attack() {
		return attack_strength;
	}
	int defence() {
		return defence_strength;
	}
	@Override
	int attack_strength() {
		return attack_strength;
	}
	@Override
	void set_attack_strength(int x) {
		this.attack_strength+=x;
	}
	@Override
	int defence_strength() {
		return defence_strength;
	}
	@Override
	void set_defence_strength(int x) {
		this.defence_strength+=x;		
	}
}


class Monster{
	private int ideal_HP;
	private int HP;
	int level = 0;
	public int getideal_HP(){
		return ideal_HP;
	}
	public void setideal_HP(int Health){
		this.ideal_HP = Health;
	}
	public int getHP(){
		return HP;
	}
	public void setHP(int Health){
		HP = Health;
	}
	public int attack(){

		Random rand = new Random();
		double temp = rand.nextGaussian();
		while(true){
			if(temp>-1 && temp<1){
				break;
			}
			temp = rand.nextGaussian();
		}
		return ((int) (temp*(HP/8) + HP/8));
	}
}
class Graph 
{ 
	int V; 
	LinkedList<node> adjListArray[]; 
	@SuppressWarnings("unchecked")
	Graph(int V) 
	{ 
		this.V = V; 
		adjListArray = new LinkedList[V]; 
		for(int i = 0; i < V ; i++){ 
			adjListArray[i] = new LinkedList<node>(); 
		} 
	} 
} 

public class May2 
{ 
	static ArrayList<user> users = new ArrayList<user>();
	static Graph graph = new Graph(18); 
	static node[] nodes = new node[18];
	static int present_node = 0;
	static int previous_node = 0;
	static user player;
	static boolean initial_move = true;
	
	static void game_won(Scanner in){
		System.out.println("Congratulation you defeated the Boss LionFang and won the game");
		System.out.println("Want to restart ?");
		System.out.println("1) Yes");
		System.out.println("2) No");
		int choice = in.nextInt();
		if(choice ==1){
			main_menue(in);
		}

		
	}
	
	static void make_graph(){
		addEdge(graph, 0, 1);addEdge(graph, 0, 2);addEdge(graph, 0, 3);addEdge(graph, 0, 4);addEdge(graph, 4, 8);addEdge(graph, 1, 5);addEdge(graph, 2, 6);
		addEdge(graph, 3, 7);addEdge(graph, 7, 11);addEdge(graph, 11, 15);addEdge(graph, 15, 17);addEdge(graph, 5, 9);addEdge(graph, 9, 13);addEdge(graph, 13, 17);
		addEdge(graph, 6, 10);addEdge(graph, 10, 14);addEdge(graph, 14, 17);addEdge(graph, 8, 12);addEdge(graph, 12, 16);addEdge(graph, 16, 17);addEdge(graph, 1, 2);addEdge(graph, 2, 3);
		addEdge(graph, 3, 4);addEdge(graph, 4, 1);addEdge(graph, 5, 6);addEdge(graph, 6, 7);addEdge(graph, 7, 8);addEdge(graph, 8, 5);addEdge(graph, 9, 10);addEdge(graph, 10, 11);addEdge(graph, 11, 12);addEdge(graph, 12, 9);
		addEdge(graph, 13, 14);addEdge(graph, 14, 15);addEdge(graph, 15, 16);addEdge(graph, 16, 13);
	}
	
	static void put_monsters(){

		Random rand = new Random();
		//Random boss location chosen
		int[] boss_PL = {13,14,15,16,17};
		int boss_L =  rand.nextInt(5);
		
		for(int i = 0;i<18;i++){
			nodes[i] = new node(i);
			nodes[i].monster = new Monster();
			nodes[i].monster.level = rand.nextInt(3) + 1;
			
			if(nodes[i].monster.level == 1){
				nodes[i].monster.setHP(100);
				nodes[i].monster.setideal_HP(100);
			}
			else if(nodes[i].monster.level == 2){
				nodes[i].monster.setHP(150);nodes[i].monster.setideal_HP(150);
			}
			else if(nodes[i].monster.level == 3){
				nodes[i].monster.setHP(200);
				nodes[i].monster.setideal_HP(200);
			}
			if(i == boss_PL[boss_L]){	
				nodes[i].monster.level = 4;
				nodes[i].monster.setHP(250);
				nodes[i].monster.setideal_HP(250);				
			}
		}
	}
	
	static void main_menue(Scanner in){
    	System.out.println("Welcome to ArchLegends");
    	System.out.println("Chose your option");
    	System.out.println("1) New User");
    	System.out.println("2) Existing User");
    	System.out.println("3) Exit");
    	
    	
    	int user_input = in.nextInt();
    	if(user_input == 1){
    		new_user(in);
        	user_input = in.nextInt();
    	}
    	
    	if(user_input == 2){
    		existing_user(in);
    	}
	}
	
	static void new_user(Scanner in){
		user new_user = new user();
		System.out.println("Enter username");
		new_user.setName(in.next());
//		System.out.println(new_user.hero.getideal_HP());

		
		System.out.println("1) Warrior");
		System.out.println("2) Thief");
		System.out.println("3) Mage");
		System.out.println("4) Healer");

		
		int hero_choice = in.nextInt();
		if(hero_choice == 1){
			Hero warrior = new Warrior();
			new_user.hero = warrior;
			
		}
		else if(hero_choice == 2){
			Hero thief = new Thief();
			new_user.hero = thief;
		}
		else if(hero_choice == 3){
			Hero mage = new Mage();
			new_user.hero = mage;
		}
		else if(hero_choice == 4){
			Hero healer = new Healer();
			new_user.hero = healer;
		}
		new_user.hero.setideal_HP(100);
		new_user.hero.setHP(100);
		new_user.hero.setXP_required(20);
		new_user.hero.setLevel(1);
		users.add(new_user);

		System.out.println("User Creation done. Username : " + new_user.getName() + ". Hero type: " + new_user.hero.getName()+ ". Log in to play the game .Exiting");
    	System.out.println("Welcome to ArchLegends");
    	System.out.println("Chose your option");
    	System.out.println("1) New User");
    	System.out.println("2) Existing User");
    	System.out.println("3) Exit");
	
	}

	static void existing_user(Scanner in){
		System.out.println("Enter Username");
		String username = in.next();
		boolean found = false;
		player = new user(); 
		for(int i = 0;i<users.size();i++){
			if(users.get(i).getName().equals(username)){
				found = true;
				player = users.get(i);
			}
		}
		if(found){
			System.out.println("User found...logging in");
			System.out.println("Welcome "+ player.getName());
			System.out.println("You are at the starting location. Choose path :");
			move(in);
			
			
		}else{
			System.out.println("Username not found");
		}
	}
		
	static void move(Scanner in){
		int count=1;
		for(node pCrawl: graph.adjListArray[present_node]){ 
			if(previous_node != pCrawl.number){
				System.out.println(count + ") Go to Location "+ pCrawl.number); 
				count++;
			}
		}
		if(present_node != previous_node){
			System.out.println(count + ") Go Back");
		}
		System.out.println("Enter -1 to exit");
		int location_choice = in.nextInt();
		
		if(location_choice!=-1){
			if(location_choice != 4 && !initial_move){
				int temp = 0;
				count = 1;
				for(node pCrawl: graph.adjListArray[present_node]){ 
					if(previous_node != pCrawl.number){
						if(location_choice == count){
							temp = pCrawl.number;
						}
						count++;
					}
				}
				previous_node = present_node;
				present_node = temp;
				System.out.println("Moving to location " + present_node);
				fight(in);
			}else if(location_choice == 4 && !initial_move){
				int temp = previous_node;
				previous_node = present_node;
				present_node = temp;
				System.out.println("Moving to location " + present_node);
				fight(in);
			}else if(initial_move){
				initial_move = false;
				int temp = 0;
				count = 1;
				for(node pCrawl: graph.adjListArray[present_node]){ 
					if(previous_node != pCrawl.number){
						if(location_choice == count){
							temp = pCrawl.number;
						}
						count++;
					}
				}
				previous_node = present_node;
				present_node = temp;
				System.out.println("Moving to location " + present_node);
				fight(in);
			}
		}
		else{
        	System.out.println("Welcome to ArchLegends");
        	System.out.println("Chose your option");
        	System.out.println("1) New User");
        	System.out.println("2) Existing User");
        	System.out.println("3) Exit");
        	int user_input = in.nextInt();
        	if(user_input == 1){
        		new_user(in);
            	user_input = in.nextInt();
        	}
        	
        	if(user_input == 2){
        		existing_user(in);
        	}
        	
		}
	}
	
	static void fight(Scanner in){


		int count_SP =0;
		int moves_valid_SP=0;
		boolean SP_activity = false;
		String name = "";
		if(nodes[present_node].monster.level == 1){name +="Goblin";}
		if(nodes[present_node].monster.level == 2){name +="Zombie";}
		if(nodes[present_node].monster.level == 3){name +="Fiends";}
		if(nodes[present_node].monster.level == 4){name +="LionFang";}

		System.out.println("Fight Started. You are fighting a level " + nodes[present_node].monster.level + " " + name);
//		System.out.println(nodes[present_node].monster.level + "  "+ nodes[present_node].monster.getHP());
		System.out.println("Choose move:");
		System.out.println("1) Attack" );
		System.out.println("2) Defence");
		if(count_SP>=4){
			System.out.println("3) Special Attack");
		}
		
//		System.out.println(player.hero.getHP() );
//		System.out.println(player.hero.getHP());

		int attack_choice = in.nextInt();
		while(player.hero.getHP()>0 && nodes[present_node].monster.getHP()>0){

			int mage_SP_undo_HP = 0;
			int healer_SP_undo_HP=0;
			int thief_stolen_HP=0;
			
			if(attack_choice == 1){
				nodes[present_node].monster.setHP(nodes[present_node].monster.getHP() - player.hero.attack());
				count_SP++;
				System.out.println("You choose to attack");
				System.out.println("You attacked and inflicted " + player.hero.attack_strength() + " damage to the monster.");
				if(SP_activity){moves_valid_SP++;}
			}else if(attack_choice == 2){
				player.hero.setHP(player.hero.getHP() + player.hero.defence());
				count_SP++;
				System.out.println("You choose to defend");
				System.out.println("Monster attack reduced by "+player.hero.defence_strength() +"!");

				if(SP_activity){moves_valid_SP++;}

			}else if(attack_choice == 3){
				SP_activity = true;
				count_SP=0;
				if(player.hero.getName().equals("Warrior")){
					player.hero.set_attack_strength(player.hero.attack_strength() + 5);
					player.hero.set_defence_strength(player.hero.defence_strength() + 5);
					System.out.println("Attack and defense attributes get boosted by 5 for the next 3 moves");
				}else if(player.hero.getName().equals("Mage")){
					 mage_SP_undo_HP = (int) (nodes[present_node].monster.getHP()*(0.05));
					 nodes[present_node].monster.setHP( (int) (nodes[present_node].monster.getHP()*(0.95)));
					 System.out.println("Spell cast successful, reduced the opponent's HP by 5% for the next 3 moves");
				}else if(player.hero.getName().equals("Thief")){
					player.hero.setHP(((int) (nodes[present_node].monster.getHP()*0.3)) + player.hero.getHP());
					thief_stolen_HP = (int) (nodes[present_node].monster.getHP()*0.3);
					nodes[present_node].monster.setHP((int) (nodes[present_node].monster.getHP() - nodes[present_node].monster.getHP()*0.3) );
					System.out.println("You have stolen "+thief_stolen_HP + "HP from the opponent" );
				}else if(player.hero.getName().equals("Healer")){
					healer_SP_undo_HP = ((int) (player.hero.getHP()*0.05 + player.hero.getHP())) - player.hero.getHP();
					player.hero.setHP((int) (player.hero.getHP()*0.05 + player.hero.getHP()));
					System.out.println("HP increased by 5% for next 3 moves");
				}
			}
			
			
			//undoing the special power
			if(moves_valid_SP == 3){
				SP_activity = false;
				moves_valid_SP=0;
				
				if(player.hero.getName().equals("Warrior")){
					player.hero.set_attack_strength(player.hero.attack_strength() - 5);
					player.hero.set_defence_strength(player.hero.defence_strength() - 5);
				}else if(player.hero.getName().equals("Mage")){
					nodes[present_node].monster.setHP(nodes[present_node].monster.getHP() + mage_SP_undo_HP );
				}else if(player.hero.getName().equals("Healer")){
//					int healer_SP_undo_HP = ((int) (player.hero.getHP()*0.05 + player.hero.getHP())) - player.hero.getHP();
					player.hero.setHP(player.hero.getHP() - healer_SP_undo_HP  );
				}
			}
			
			if(SP_activity){
				System.out.println("Special move activated");
				System.out.println("Performing special attack");
			}
			if(nodes[present_node].monster.getHP()<0){nodes[present_node].monster.setHP(0);}
			if(player.hero.getHP()<0){player.hero.setHP(0);}

			System.out.println("Your HP : "+ player.hero.getHP() +"/"+player.hero.getideal_HP() + "   Monster's HP : " + nodes[present_node].monster.getHP()+"/"+nodes[present_node].monster.getideal_HP() );
			int monster_attack_strength = nodes[present_node].monster.attack();
			if(nodes[present_node].monster.getHP()>0){
				System.out.println("Monster attack!");
				System.out.println("Monster has attactd you an inflicted " + monster_attack_strength + " damage to you");
				if(nodes[present_node].monster.level == 4){
					Random rand = new Random();
					if(rand.nextInt(10) == 1){
						System.out.println("LionFang used his special attack and reduced your health by half");
						player.hero.setHP(player.hero.getHP()/2);
					}
				}
				player.hero.setHP(player.hero.getHP() - monster_attack_strength);			
				System.out.println("Your HP : "+ player.hero.getHP() +"/"+player.hero.getideal_HP() + "   Monster's HP : " + nodes[present_node].monster.getHP()+"/"+nodes[present_node].monster.getideal_HP() );
			}
			
			
			if(nodes[present_node].monster.getHP() == 0){
				if(nodes[present_node].monster.level !=4){
					System.out.println("Monster Killed!");
					int XP_awarded = nodes[present_node].monster.level*20;
					System.out.println(XP_awarded + " XP awarded");
					player.hero.setXP(player.hero.getXP() + XP_awarded);
					if(player.hero.getXP() >=player.hero.getXP_required()){
						player.hero.setLevel(player.hero.getLevel()+1);
						System.out.println("Level Up : level-" + player.hero.getLevel());
						player.hero.setideal_HP(player.hero.getideal_HP()+50);
						player.hero.set_attack_strength(1);
						player.hero.set_defence_strength(1);
						
					
					}
					nodes[present_node].monster.setHP(nodes[present_node].monster.getideal_HP());
					player.hero.setHP(player.hero.getideal_HP());
					System.out.println("Fight won, please proceed to the next location");
					move(in);
				}else{
					game_won(in);
				}
			}else if(player.hero.getHP() <= 0){
				System.out.println("Player has died please restart");
				System.out.println();
				main_menue(in);
			}

			
			
			
			
			
			if(player.hero.getHP()>0 && nodes[present_node].monster.getHP()>0){
				System.out.println("Choose move:");
				System.out.println("1) Attack" );
				System.out.println("2) Defence");
				if(count_SP>=4){
					System.out.println("3) Special Attack");
				}
				attack_choice = in.nextInt();
			}
		}
		
	}
	 
	static void addEdge(Graph graph, int src, int dest) { 

		graph.adjListArray[src].add(nodes[dest]); 
		graph.adjListArray[dest].add(nodes[src]); 
	} 
	 

	static void printGraph(Graph graph) {	 
		for(int v = 0; v < graph.V; v++) { 
			System.out.println("Adjacency list of vertex "+ v); 
			System.out.print("head"); 
			for(node pCrawl: graph.adjListArray[v]){ 
				System.out.print(" -> "+pCrawl.number + "( Monster : " +pCrawl.monster.level + " "+pCrawl.monster.getideal_HP() +" "+pCrawl.monster.getHP() + " )"); 
			} 
			System.out.println("\n"); 
		} 
	} 
		
		
    public static void main (String[] args) 
    { 		
		Scanner in = new Scanner(System.in);		
		
		//putting monsters
		put_monsters();
				
    	//Graph
		make_graph();

		//Game begins
		main_menue(in);
    } 
} 