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

    public static void loopThroughPlayers(){//prints everyone out and calls queryplayers
        String playersstr = "";//contains all playernames
        ArrayList<Player> players = game.getPlayers();

        ArrayList<Player> mafia = new ArrayList<Player>();//to be sent to queryplayers
        ArrayList<Player> cops = new ArrayList<Player>();
        ArrayList<Player> doctors = new ArrayList<Player>();
        for (int x = 0; x < players.size();x++){
            Player currentP = players.get(x);
            playersstr += currentP.getName() + " ";//for the puroose of printing everybody out
            if (currentP instanceof Mafia){
                mafia.add(currentP);
            } else if (currentP instanceof Cop){
                cops.add(currentP);
            } else if (currentP instanceof Doctor){
                doctors.add(currentP);
            } else {}
        }

        playersstr = playersstr.substring(0,playersstr.length()-1);//just to remove the last space
        System.out.println(playersstr);
        queryPlayers(playersstr,players,mafia,cops,doctors);

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
