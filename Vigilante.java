import java.util.*;

public class Vigilante extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Vigilante(String name){
	this.name = name;
	priority = 1;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return 0;
    }

    public int act(Player other){
	if (isBlocked()){
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
