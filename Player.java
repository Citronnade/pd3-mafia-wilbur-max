import java.*;

public abstract class Player{
    public abstract int act(); //returns 1 if successful, 0 if otherwise
    private int priority; //sort based on this
    private ArrayList<Mark> marks; //marks will be in order of priority because they're placed in order of priority

    public int getPriority(){
	return priority;
    }
}
