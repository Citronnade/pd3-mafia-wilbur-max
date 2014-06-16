import java.util.*;

/*
  So this is kind of a hash...but exploiting the fact that collisions will occur and are easily handled with a linkedlist.
 */
public class CardHash{ //wtf
    private ArrayList<LinkedList> values;
    private ArrayList<Player> players; //do we need this?
    
    public CardHash(ArrayList<Player> players){
	values = new ArrayList(13);
	for (int i = 0; i< 13; i++){
	    values.add(new LinkedList());
	}

	this.players = players;
	init();
    }

    public void init(){ //stuff into linkedlist buckets.  if out o froom go backwards.
	int normalizer = players.get(0).priority; //take each player's priority, multiply by 7, divide by this.  Should this be a double?
	int current = 0;
	for (Player player: players){ //sorted in priority order
	    System.out.println(values.size());
	    System.out.println(players.size());
	    System.out.println("normalizer:" + normalizer);
	    int pri = (int)(((double) player.priority * 7) / (double) normalizer + 5); //start at 6--> A;
	    System.out.println("pri:" + pri);
	    if (values.get(pri).size() < 4){
		values.get(pri).add(player);
	    }
	    else{
			while (values.get(current).size() >= 4){
		    	current ++;
			}/*
		if (values.get(current).size() != 0){
		    System.out.println("something went wrong; too much overlap?");
		    return;
		}
		*/
		values.get(current).add(player);
	    }
	}
    }
    
    public String toString(){
	String[] cards = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	String[] suits = {"spades","hearts","clubs","diamonds"};
	String part = "";
	for (int i = 0; i < values.size(); i++){
	    LinkedList<Player> bucket = values.get(i);
	    if (bucket.size() > 0){
		int s = 0;
		for (Player player: bucket){
		    part += player.name + ", " + player.getClass() + ": " + cards[i] + " of ";
		    part += suits[s] + "\n";
		    s++;
		}
	    }
	}
	return part;
    }
    
}
