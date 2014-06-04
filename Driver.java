import java.util.*;

public class Driver{
    
    public static Game game;
    
    public static void startUp(){//initial things to do before the game starts
    	System.out.print("Welcome to Mafia! How many players?");
    	Scanner s = new Scanner(System.in);
    	//Should add a try/catch block
    	int numPlayers = Integer.parseInt(s.next());
    	
    	game = new Game();
    	int i = 0;
    	while (i < numPlayers){
    		addPlayer();
    		i++;
    	}
    }

    public static void addPlayer(){//temporary thing for testing purposes
    	String[] types = {"Villager","Mafia","Cop","Doctor"};

    	Scanner s = new Scanner(System.in);
    	System.out.println("What kind of player would you like to be? ");
    	for (String str : types){
    		System.out.print(str + " " 
    			//+ "[" + str.substring(0,1) + "]"
    			 + " ");
    	}
	System.out.println();
    	String in = s.next();
    	System.out.print("What is your name? ");
    	String name = s.next();
    	Player temp = null;

    	
    	if (in.equals("Villager")){
    		temp = new Villager(name);
    	} else if (in.equals("Mafia")){
    		temp = new Mafia(name);
    	} else if (in.equals("Cop")){
    		temp = new Cop(name);
    	} else if (in.equals("Doctor")){
    		temp = new Doctor(name);
    	} else {
    		temp = new Villager(name);//temporary final assignment
    	}//there's gotta be a better way to do this

    	game.addPlayer(temp);
    }

    public static void loopThroughPlayers(){//prints everyone out
        String playersstr = "";
        for (int x = 0; x < game.getPlayers().size();x++){
            playersstr += game.getPlayers().get(x).getName() + " ";//for the puroose of printing everybody out
        }
        playersstr = playersstr.substring(0,playersstr.length()-1);//just to remove the last space
        System.out.println(playersstr);
    }


    public static void main(String args[]){ //perhaps can set up with args[] instead...
	startUp();
	while (1 == 1){ //loop
	    game.tick();
        loopThroughPlayers();
	}
    }
}
