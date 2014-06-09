import java.util.*;

public class Druck extends Player{ //maybe mafia as a group should get a priority as well...

    //should we use static initialization blocks for this kind of stuff?
    public Drunk(String name){
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
