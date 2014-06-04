import java.util.*;

public class Doctor extends Player{
    public Doctor(String name){
	super();
	this.name = name;
	priority = 2;
	marks = new ArrayList<Mark>();
    }

    public int act(){
	Player other;
	other = chooseTarget();
	if (false){
	    return 0;
	}
	else{
	    save(other);
	    return 0;
	}
	///NEED A SAVE ROUTINE

    }

    public int save(Player other){
	other.addMark(new Mark(this	, "save"));
	return 1;
    }
}
