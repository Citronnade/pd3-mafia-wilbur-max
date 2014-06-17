import java.util.*;

public class Mafia extends Player{ //maybe mafia as a group should get a priority as well...

    //should we use static initialization blocks for this kind of stuff?
    public Mafia(String name){
	this.name = name;
	priority = 2;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){
	if (false){
	    return -1;
	}
	/*
	else{
	    kill(other);
	    return 1;
	}
	*/
	return -1; //DISABLED.  MAFIA MANUALLY CALL KILL.
	
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
