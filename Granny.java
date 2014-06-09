import java.util.*;

public class Granny extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Granny(String name){
	this.name = name;
	priority = 1;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){//just waits silently for her victims
	return -1;
    }
}
