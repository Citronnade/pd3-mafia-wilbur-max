import java.util.*;

public class Drunk extends Player{ 

    //should we use static initialization blocks for this kind of stuff?
    public Drunk(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){
	//not sure how to implement this
	return -1;
    }

}
