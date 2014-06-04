import java.util.*;
import java.io.*;

//in order to set up the game: game will give out a list of all possible roles, have driver print it out and send it back and have game add it.

public class Game{
    private PriorityQueue<Player> players;
    public void addPlayer(Player p){
	players.add(p);
    }

    public Game(){
	players = new PriorityQueue(15, new PriorityComp());
    }

    public Game(int numPlayers){
    players = new PriorityQueue(numPlayers,new PriorityComp());
    }

    public  void tick(){
	for (Player p: players){
	    p.act();
	}
    }

    public PriorityQueue<Player> getPlayers(){
        return players;
    }

    public void setPlayers(PriorityQueue<Player> players){
        this.players = players;
    }
}
