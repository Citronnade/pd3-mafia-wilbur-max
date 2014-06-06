import java.util.ArrayList;

public class NaiveCop extends Cop{

	public NaiveCop(String name){
		super(name);
	}

	public int inspect(Player other){
		//System.out.println("innocent");
		return 0;
	}

}