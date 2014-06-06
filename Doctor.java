import java.util.*;

public class Doctor extends Player{
    public Doctor(String name){
	super();
	this.name = name;
	priority = 2;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	return -1;
    }

    public int act(Player other){
	if (false){
	    return 0;
	}
	else{
	    save(other);
	    return 1;
	}
    }

    public int save(Player other){
	other.addMark(new Mark(this, "save"));
	return 1;
    }
}
