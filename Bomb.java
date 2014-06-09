import java.util.*;

public class Bomb extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Bomb(String name){
	this.name = name;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){//sits around waiting for someone to blow up
	return -1;
    }
}
