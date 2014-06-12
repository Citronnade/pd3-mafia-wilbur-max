import java.util.*;

public class Hooker extends Mafia{ 

    //should we use static initialization blocks for this kind of stuff?
    public Hooker(String name){
	super(name);
	priority = 5;
    actionText = "Please choose someone to block: ";
    }

    public int act(){
	return 0;
    }

    public int act(Player other){
	if (isBlocked()){
	    return -1;
	}
	block(other);
	return -1;
    }
    public int block(Player other){
	other.addMark(new Mark(this, "block"));
	return 1;
    }


}
