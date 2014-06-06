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



    public static void loopThroughPlayers(){
	String playersstr = ""; //contains all playernames
	ArrayList<Player> players = game.getPlayers(); //assuming this is sorted
	for (Player currentP: players){
	    playersstr += currentP.getName();
	}
	playersstr = playersstr.substring(0,playersstr.length()-1);//just to remove the last space
	System.out.println(playersstr);
    }

    public static void queryPlayers(String allPlayers){
	Scanners = new Scanner(System.in);
        System.out.println();
        System.out.println("Mafia, please wake up.");
        System.out.println("Mafia, choose someone to kill tonight");
        System.out.println(allPlayers);
        
	ArrayList<Player> players = game.getPlayers();
	
	Mafia mafiaVisitor;

	for (Player currentP: players){
	    System.out.println(currentP.getName() + ", please wake up.");
	    if (currentP instanceof Mafia && !mafiaWent){
		game.mafiaWent = true; //THIS MUST BE RESET EVERY TICK!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		mafiaVisitor = currentP;
	    }

	    while(player.act() != -1){
		player.act(); //re-run this until act says we can go on...may need other int return values.
		//then player.act(Other) until that returns success.
	    }
	    while (!(playerExists(in, players))){
		System.out.println("Please choose someone in the game.");
		in = s.next();
	    }
	    
	    
	}
	if (mafiaWent){
	    System.out.println("Mafia, choose someone to kill.  " + currentP.getName() + " will visit.")
		while (!(playerExists(in, players))){
		    System.out.println("Please choose someone in the game.");
		    in = s.next();
		}
	
	    for (Player target: players){    //find the target.  we can quickselect
		if (target.getName().equals(in)){
		    currentP.act(target); //basically puts kill mark on target.
		}
	    }
	}
	
    }

    public static void queryPlayers(String allPlayers,
                                    ArrayList<Player> players,
                                    ArrayList<Player> mafia,
                                    ArrayList<Player> cops,
                                    ArrayList<Player> doctors){//asks everyone to do stuff, night thing
        //THERE MUST BE A BETTER WAY TO DO THIS
        Scanner s = new Scanner(System.in);
        //Mafia
        System.out.println();
        System.out.println("Mafia, please wake up.");
        System.out.println("Mafia, choose someone to kill tonight");
        System.out.println(allPlayers);
        
        String in = "";

        while (!(playerExists(in, players))){
            System.out.println("Please choose someone in the game.");
            in = s.next();
        }
        for (int x = 0; x < players.size();x++){   
            if (players.get(x).getName().equals(in)){
                players.get(x).addMark(new Mark("mafiadeath"));
            }
        }
        System.out.println("Mafia, please go to sleep.");

        in = "";
        //Cops
        System.out.println();
        System.out.println("Cops, please wake up.");
        System.out.println("Cops, choose someone to inspect");
        System.out.println(allPlayers);

        while (!(playerExists(in, players))){
            System.out.println("Please choose someone in the game.");
            in = s.next();
        }
        

        System.out.println("Cops, please go to sleep.");

        in = "";
        //Doctors
        System.out.println();
        System.out.println("Doctors, please wake up.");
        System.out.println("Doctors, choose someone to save tonight");
        System.out.println(allPlayers);

        while (!(playerExists(in, players))){
            System.out.println("Please choose someone in the game.");
            in = s.next();
        }
        System.out.println("Doctors, please go to sleep.");

    }

    public static boolean playerExists(String name, ArrayList<Player> players){
        for (int x = 0; x <players.size();x++){
            if (players.get(x).getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){ //perhaps can set up with args[] instead...
	int night = 1;

    startUp();
	while (1 == 1){ //loop
	    game.tick();
        System.out.println();
        System.out.println("Night " + night
            + "\nEverybody go to sleep!");
        night++;
        loopThroughPlayers();
        System.out.println();
        System.out.println("Everybody wake up!");
	}
    }
}
