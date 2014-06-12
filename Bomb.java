import java.util.*;

public class Bomb extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Bomb(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
	priority = 0;
    }

    public int act(){
	System.out.println(marks);
	for (Mark mark: marks){
	    if (mark.getType() == "death"){
		System.out.println("blowing up " + mark.getOrigin());
		act(mark.getOrigin());
		return -1;
	    }
	}
	return -1;
    }

    public int act(Player other){//sits around waiting for someone to blow up
	System.out.println("blowing up");
	other.addMark(new Mark(this, "death"));
	return 1;
    }
}
