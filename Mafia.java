import java.util.*;

public class Mafia extends Player{

    //should we use static initialization blocks for this kind of stuff?
    public Mafia(String name){
	this.name = name;
	priority = 1;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	Player other;
	other = chooseTarget();
	if (false){
	    return 0;
	}
	else{
	    kill(other);
	}
	
    }


    public Player chooseTarget(){
	//ask player to do stuff here
	return this; //obviously not finished yet
    }

    public int kill(Player other){ //this can return some interesting information
	other.addMark(new Mark(this, "death"));
	return 1;
    }
}
