import java.util.ArrayList;

public class InsaneCop extends Cop{

	public InsaneCop(String name){
		super(name);
	}

	public int inspect(Player other){
		if (!(other instanceof Mafia)){
	    //System.out.println ("mafia");
	    return 1;
	}
	else 
	   // System.out.println ("innocent");
	return 0;
	//if player is guilty, return guilty else return innocent
	}

}