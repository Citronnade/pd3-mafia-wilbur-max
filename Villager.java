import java.util.ArrayList;

public class Villager extends Player{//default villager that doesn't do anything but vote

	public Villager(String name){
		this.name = name;
		priority = 0;
		marks = new ArrayList<Mark>();
	}

	public int act(){
		return 1;
	}

}