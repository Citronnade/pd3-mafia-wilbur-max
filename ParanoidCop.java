import java.util.ArrayList;

public class ParanoidCop extends Cop{

	public ParanoidCop(String name){
		super(name);
	}

	public int inspect(Player other){
		System.out.println (other.getName() + " is associated with the mafia.");
		return 1;
	}

}