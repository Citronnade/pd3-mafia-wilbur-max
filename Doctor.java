import java.util.*;

public class Doctor extends Player{
    public Doctor(String name){
	super();
	this.name = name;
	priority = 3;
	marks = new ArrayList<Mark>();
	actionText = "Please choose someone to save: ";
    }

    public int act(){
	return 0;
    }

    public int act(Player other){
	for(Mark mark: marks){
	    if (mark.getType() == "block"){
		return -1;
	    }
	}
	save(other);
	return 1;
	
    }

    public int save(Player other){
	other.addMark(new Mark(this, "save"));
	return 1;
    }
}
