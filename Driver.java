import java.util.*;

public class Driver{
    PriorityQueue<Player> players;
    public void addPlayer(Player p){
	players.add(p);
    }

    public static void main(String args[]){
	players = new PriorityQueue(15, new PriorityComp());
    }
}
