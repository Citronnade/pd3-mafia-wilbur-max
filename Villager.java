import java.util.ArrayList;

public class Villager extends Player{

	public Villager(){
		priority = 0;
		marks = new ArrayList<Mark>();
	}

	public int act(){
		return 1;
	}

}