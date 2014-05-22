import java.*;

public abstract class Player{
    public abstract int act(); //returns 1 if successful, 0 if otherwise
    private int priority; //sort based on this
    public int getPriority(){
	return priority;
    }
}
