import java.util.*;
import java.io.*;

//in order to set up the game: game will give out a list of all possible roles, have driver print it out and send it back and have game add it.

public static class Game{
    PriorityQueue<Player> players;
    public static void addPlayer(Player p){
	players.add(p);
    }

    public Game(){
	players = new PriorityQueue(15, new PriorityComp());
    }

    public static void tick(){
	for (Player p: players){
	    p.act();
	}
    }
}
