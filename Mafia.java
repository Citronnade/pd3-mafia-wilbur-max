import java.util.*;

public class Mafia extends Player{ //maybe mafia as a group should get a priority as well...

    //should we use static initialization blocks for this kind of stuff?
    public Mafia(String name){
	this.name = name;
	priority = 1;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){
	if (false){
	    return 0;
	}
	else{
	    kill(other);
	    return 1;
	}
	
    }

    public int kill(Player other){ //this can return some interesting information
	other.addMark(new Mark(this, "death"));
	return 1;
    }
}
