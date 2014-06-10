import java.util.*;

public class Drunk extends Player{ 

    //should we use static initialization blocks for this kind of stuff?
    public Drunk(String name){
	this.name = name;
	priority = 4; //higher than hooker
	marks = new ArrayList<Mark>();
    actionText = "Please choose someone to role block: ";
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
