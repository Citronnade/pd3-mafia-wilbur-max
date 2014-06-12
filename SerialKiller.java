import java.util.*;

public class SerialKiller extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public SerialKiller(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
	actionText = "Please choose someone to kill: ";
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
