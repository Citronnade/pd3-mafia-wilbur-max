import java.util.*;
import java.io.*;

//in order to set up the game: game will give out a list of all possible roles, have driver print it out and send it back and have game add it.

public class Game{
    private ArrayList<Player> players;
    protected static boolean mafiaWent;
    public void addPlayer(Player p){
	players.add(p);
    }

    public Game(){
	players = new ArrayList<Player>();
    }

    public Game(int numPlayers){
    players = new ArrayList<Player>();
    }

    public void tick(){
	for (Player p: players){
	    p.act();
	}
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public Player getPlayerByName(String name){
        for (int x = 0; x < players.size();x++){
            if (players.get(x).getName().equals(name)){
                return players.get(x);
            }
        }
        return null;
    }
}
