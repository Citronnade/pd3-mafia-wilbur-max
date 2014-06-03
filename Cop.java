import java.util.*;

public class Cop extends Player {
    
    public Cop (String name) {
	this.name = name;
	//not sure what else to put here
	marks = new ArrayList <Mark> ();
    }
    
    public int act() {
	Player other;
	other = chooseTarget();
	if (false) {
	    return 0;
	}
	else {
	    inspect(other);
	    return 0;
	}
    }
    
    public int inspect (Player other) {
    	return 0;
	//if player is guilty, return guilty else return innocent
    }

}
