import java.util.*;
import java.io.*;

//in order to set up the game: game will give out a list of all possible roles, have driver print it out and send it back and have game add it.

public class Game{
    private ArrayList<Player> players;
    private String[] deathMessages;
    protected static boolean mafiaWent;

    public void addPlayer(Player p){
	players.add(p);
    
    }


    public Game(){
	players = new ArrayList<Player>();
    try {
        File f = new File("organizing/deathstories.txt");

        Scanner s = new Scanner(f);
        int numLines = Integer.parseInt(s.nextLine());
        deathMessages = new String[numLines];

        int i = 0;
        while (s.hasNextLine()){
            deathMessages[i] = s.nextLine();
            i++;
        }
    } catch (FileNotFoundException E){
        System.out.println("The file of deathmessages has not been found. ");
    }
    
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

    public void removePlayer(String name){
        for (int x = 0; x < players.size();x++){
            if (players.get(x).getName().equals(name)){
                players.remove(x);
                return;
            }
        }
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
                int randInArray = (int)(Math.random() * deathMessages.length);
                String deathMessage = deathMessages[randInArray];
                deathMessage.replaceAll("<VICTIM>",currentP.getName());

                Player temp = players.get((int)(Math.random() * players.size()));
                deathMessage.replaceAll("<PASSERBY>",temp.getName());

            } else {
                currentP.clearMarks();//clears the arraylist of marks
            }
        }

        if (results.equals("")){
            results = "Nothing happened this night.";
        }

        return results;
    }

    public int checkWinConditions(){//checks to see if anyone won 0 -> nobody 1 -> town 2 -> mafia 3 -> fool 4 -> serial killer
        int index = 0;
        boolean noMafia = true, noTown = true, serialAlive = false;
        while (index < players.size()){
            Player p = players.get(index);
            if (p instanceof Mafia || p instanceof Hooker){
                noMafia = false;
            } else if (p instanceof Villager ||
                       p instanceof Cop ||// p instanceof NaiveCop || p instanceof ParanoidCop || p instanceof InsaneCop ||
                       p instanceof Doctor ||
                       p instanceof Drunk ||
                       p instanceof Vigilante ||
                       p instanceof Granny ||
                       p instanceof Bomb){
                noTown = false;
            }
	    if (p instanceof SerialKiller){
		serialAlive = true;
	    }
            index++;
        }
	if (serialAlive && players.size() == 1){
	    System.out.println("Serial has prevailed!");
	    return 4;
	}
        if (noMafia){
            System.out.println("The town has ousted the mafia!");
            return 1;          
        } else if (noTown && !serialAlive){
            System.out.println("The mafia has killed all the townspeople!");
            return 2;
        }

        return 0;
    }

}
