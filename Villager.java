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

    public int act(Player other){ //idk i guess villagers sometimes go play poker with each other at night but this isn't it
	return -1;
    }

}
