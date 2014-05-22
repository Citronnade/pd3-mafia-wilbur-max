import java.util.*;

public class PriorityComp implements Comparator<Player>{
    public int compare(Player o1, Player o2){
	if (o1.getPriority() > o2.getPriority()){
	    return 1;
	}
	else if (o1.getPriority() == o2.getPriority()){
	    return 0;
	}
	else{
	    return -1;
	}
    }

}
