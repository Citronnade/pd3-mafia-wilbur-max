import java.util.*;

public class Godfather extends Mafia{

    //should we use static initialization blocks for this kind of stuff?
    public Godfather(String name){
		super(name);
		marks = new ArrayList<Mark>();
		priority = 6; //higher than hooker; will visit; this should be higher than any mafia role
    }

    public int act(){
		return 0;
    }

    public int act(Player other){/*
		if (false){
	    	return 0;
		}
		else{
	    	kill(other);
	    	return 1;
		}
				 */
	return 0;
    }

    public int kill(Player other){ //this can return some interesting information
	for (Mark mark: marks){
	    if (mark.getType() == "block"){
		return -1; //mafia are weird since they have meetings.  But this'll work.
	    }
	}
	other.addMark(new Mark(this, "death"));
	return 1;
    }

}
