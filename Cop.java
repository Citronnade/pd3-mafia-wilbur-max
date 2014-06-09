import java.util.*;

public class Cop extends Player {
    
    public Cop (String name) {
	this.name = name;
	priority = 2;
	marks = new ArrayList <Mark> ();
	actionText = "Please choose someone to inspect: ";
    }
    
    public int act() { //not implemented.
	return 0;
    }
    
    public int act(Player other){
    	
	if (false) {
	    return 0;
	}
	else {
	    inspect(other);
	    return 1;
	}
    }
    
    
    public int inspect (Player other) {
	if (other instanceof Mafia){
	    System.out.println (other.getName() + " is associated with the mafia.");
	    return 1;
	}
	else 
	    System.out.println (other.getName() + " is innocent.");
	return 0;
	//if player is guilty, return guilty else return innocent
    }

}
