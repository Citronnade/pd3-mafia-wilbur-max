import java.util.ArrayList;

public class ParanoidCop extends Cop{

	public ParanoidCop(String name){
		super(name);
	}

	public int inspect(Player other){
	    other.addMark(new Mark(this, "inspect"));
		System.out.println (other.getName() + " is associated with the mafia.");
		return 1;
	}

}
