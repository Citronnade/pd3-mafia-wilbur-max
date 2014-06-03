import java.util.ArrayList;

public class Doctor extends Player {
    
    public Doctor (String name) {
	this.name = name;
	priority = 2;
	marks = new ArrayList <Mark>();
    }
    
    public int act() {
		Player other;
		other = chooseTarget();
		if (false) {
	   	 return 0;
		}
		else {
	    	save(other);
	    	return 0;
		}
    }

    public Player chooseTarget() {
		return null;
    }
    
    public int save (Player other) {
    	return 0;
	//player cannot be killed this night
    }

}
