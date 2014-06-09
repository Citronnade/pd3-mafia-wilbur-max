import java.util.*;

public class Granny extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Granny(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	ArrayList<Player> victims = new ArrayList<Player>();
	for (Mark mark: marks){
	    victims.add(mark.getOrigin());
	}
	for (Player victim: victims){
	    victim.addMark(new Mark(this, "death"));
	}
	this.addMark(new Mark(this, "save"));
	return 1; //don't go to act(other);
    }

    public int act(Player other){//just waits silently for her victims
	return -1;
    }
}
