import java.util.ArrayList;

public class NaiveCop extends Cop{

	public NaiveCop(String name){
		super(name);
	}

	public int inspect(Player other){
	    other.addMark(new Mark(this, "inspect"));
		System.out.println (other.getName() + " is innocent.");
		return 0;
	}

}
