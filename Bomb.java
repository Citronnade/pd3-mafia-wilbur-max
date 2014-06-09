import java.util.*;

public class Bomb extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Bomb(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	for (Mark mark: marks){
	    if (mark.getType() = "death"){
		act(mark.getOrigin());
		return 1;
	    }
	}
	return -1;
    }

    public int act(Player other){//sits around waiting for someone to blow up
	other.addMark(new Mark(this, "death"));
	return 1;
    }
}
