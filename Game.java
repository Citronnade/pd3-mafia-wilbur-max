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

    public String processMarks(){//goes through the marks of each player to see what to do with them
        String results = "";
        for (int x = 0; x < players.size(); x++){
            Player currentP = players.get(x);
            ArrayList<Mark> marks = currentP.getMarks();

            boolean dead = false, saved = false; 

            for (Mark m : marks){
                if (m.getType().equals("death")){
                    dead = true;
                } else if (m.getType().equals("save")){
                    saved = true;
                }
            }

            if (dead && (!saved)){
                players.remove(x); //he's dead, out of the game
                x--;
                results += currentP.getName() + " has died.";
            } else {
                currentP.clearMarks();//clears the arraylist of marks
            }
        }

        if (results.equals("")){
            results = "Nothing happened this night.";
        }

        return results;
    }
}
