import java.util.*;

public class Fool extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Fool(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){//sorta like the bomb, just waits for someone to kill them
	return -1;
    }

}
