import java.util.*;

public abstract class Player{
    //wait can I make a constructor to be copied or no
    public abstract int act(); //returns 1 if successful, 0 if otherwise
    protected int priority; //sort based on this
    protected String name;
    protected ArrayList<Mark> marks; //marks will be in order of priority because they're placed in order of priority

    public int getPriority(){
	return priority;
    }

    public String getName(){
	return name;
    }

    public void addMark(Mark m){
	marks.add(m);
    }
}
