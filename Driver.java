import java.util.*;

public class Driver{
    
    public static Game game;
    
    public static void startUp(){//initial things to do before the game starts
    	System.out.print("Welcome to Mafia! How many players? ");
    	Scanner s = new Scanner(System.in);
        
        String in = "";
        int numPlayers = 0;
        while (numPlayers <= 0){
            in = s.next();
            try {
               numPlayers = Integer.parseInt(in);
               if (numPlayers <= 0){
                    System.out.print("Please input a positive integer: ");
               }
            } catch (NumberFormatException E){
                System.out.print("Please input an integer: ");
            }
        }
    	
    	System.out.println();
    	game = new Game();
    	int i = 0;
    	while (i < numPlayers){
            System.out.println("Player " + (i + 1));
    		addPlayer();
    		i++;
            System.out.println();
    	}
    }

    public static void startUpRoleChooser(){
        System.out.print("Welcome to Mafia! How many players? ");
        Scanner s = new Scanner(System.in);
        
        String in = "";
        int numPlayers = 0;
        while (numPlayers <= 0){
            in = s.next();
            try {
               numPlayers = Integer.parseInt(in);
               if (numPlayers <= 0){
                    System.out.print("Please input a positive integer: ");
               }
            } catch (NumberFormatException E){
                System.out.print("Please input an integer: ");
            }
        }
        
        System.out.println();

        game = new Game();
        
        int numRolesRemaining = numPlayers;//number of roles left to assign
        String[] roles = {"mafia","godfathers","cops","doctors","bombs","drunks","vigilantes","grannies","fools","hookers","cerealkillers","villager"};
        int[] numOfEachRole = new int[roles.length];//array for the number of people with that role 
        while (numRolesRemaining > 0){
            int i = 0;
            if (i == roles.length-1){//in case gone through all the roles and still have extras 
                numOfEachRole[i] = numRolesRemaining;
                numRolesRemaining = 0;
            } else {
                System.out.print("How many " + roles[i] + "? ");

                int temp = -1;
                while (temp < 0 || temp > numRolesRemaining){
                    in = s.next();
                    try {
                        temp = Integer.parseInt(in);
                        if (temp < 0){
                            System.out.print("Please input a nonnegative integer: ");
                        }
                    } catch (NumberFormatException E){
                        System.out.print("Please input an integer: ");
                    }
                }
                numOfEachRole[i] = temp;
            }
            i++;
        }

        String[] names = new String[numPlayers];
        int i = 0;
        while (i < names.length){
            System.out.println("Player " + (i+1));
            System.out.print("What is your name? ");
            String name = s.next();
            while (!(validateName(name))){
                System.out.print("That name has already been chosen. Please choose another name: ");
                name = s.next();
            }
        }


        /*
        for (int i = 0; i < numOfEachRole.length; i++ ){
            addPlayer(numOfEachRole[i],roles[i]);
        }
        */

    }

    public static void addPlayer(){//temporary thing for testing purposes
    	String[] types = {"villager","mafia","godfather","cop","doctor","bomb","drunk","vigilante","granny","fool","hooker","cerealkiller"};

    	Scanner s = new Scanner(System.in);
    	System.out.println("What kind of player would you like to be? ");
    	for (String str : types){
    		System.out.print(str + " " 
    			//+ "[" + str.substring(0,1) + "]"
    			 + " ");
    	}
    	System.out.println();
    	String in = s.next();
        in = in.toLowerCase();
    	System.out.print("What is your name? ");
    	String name = s.next();
        while (!(validateName(name))){
            System.out.print("That name has already been chosen. Please choose another name: ");
            name = s.next();
        }

    	Player temp = null;


    	if (in.equals("villager") || in.equals("v")){
    		temp = new Villager(name);
    	} 
	   else if (in.equals("mafia") || in.equals("m")){
    		temp = new Mafia(name);
    	} 
        else if (in.equals("godfather")) {
            temp = new Godfather(name);
        }
	   else if (in.equals("cop") || in.equals("c")){
            double rand = Math.random();
            if (rand < 0.25){
                temp = new Cop(name);
            } 
            else if (rand < 0.5){
                temp = new NaiveCop(name);
            } 
            else if (rand < 0.75){
                temp = new ParanoidCop(name);
            } 
            else {
                temp = new InsaneCop(name);
            }
    	} 
	else if (in.equals("doctor") || in.equals("d")){
	    temp = new Doctor(name);
    	} 
	else if (in.equals("bomb")) {
	    temp = new Bomb (name);
	} else if (in.equals("drunk")){
        temp = new Drunk(name);
    }
	else if (in.equals("vigilante")) {
	    temp = new Vigilante (name);
	}
	else if (in.equals("granny")) {
	    temp = new Granny (name);
	}
	else if (in.equals("fool")) {
	    temp = new Fool (name);
	}
	else if (in.equals("hooker")) {
	    temp = new Hooker (name);
	}
	else if (in.equals("cerealkiller")) {
	    temp = new CerealKiller (name);
	}
	else {
    		temp = new Villager(name);
    	}
	//temporary final assignment
	//there's gotta be a better way to do this

    	game.addPlayer(temp);
    }

    public static boolean validateName(String name){//to make sure nobody has the same name
        for (Player p : game.getPlayers()){
            if (name.equals(p.getName())){//muy mal
                return false;
            }
        }
        return true;
    }

    public static void loopThroughPlayers(){
	String playersstr = ""; //contains all playernames
	ArrayList<Player> players = game.getPlayers(); //assuming this is sorted
	for (Player currentP: players){
	    playersstr += currentP.getName() + " ";
	}
	playersstr = playersstr.substring(0,playersstr.length()-1);//just to remove the last space
	System.out.println(playersstr);
    }

    public static void queryPlayers(String allPlayers){
	Scanner s = new Scanner(System.in);
    System.out.println();

	String in = "";
        
	ArrayList<Player> players = game.getPlayers();
	Collections.sort(players,new PriorityComp());

	Mafia mafiaVisitor = new Mafia("I'm going to be gone soon");

	for (Player currentP: players){

	    if(currentP.act() != -1){//if != -1, then that person didn't complete a night action yet
		  
          if(currentP.priority <= 1 && !game.mafiaWent){ //this checks if we skipped past where the mafia should go, even if there are no vanilla mafia
              if (currentP instanceof Mafia){
                 game.mafiaWent = true; //must be reset every tick
                  mafiaVisitor = (Mafia) currentP;
              }
              if (game.mafiaWent){
                  System.out.println("Mafia, choose someone to kill.  " + mafiaVisitor.getName() + " will visit.");

                  in = s.next();

                  while (!(playerExists(in, players))){
                     System.out.println("Please choose someone in the game.");
                     in = s.next();
                  }

                 for (Player target: players){    //find the target.  we can quickselect
                       if (target.getName().equals(in)){
                         mafiaVisitor.act(target); //basically puts kill mark on target.
                       }
                 }
            }
        } else if (currentP instanceof Mafia){//skips the remaining mafia

        } else {
        System.out.println(currentP.getName() + 
				   "(" + currentP.getClass().getName() + ")"
				   + ", please wake up.");
		System.out.print(currentP.getActionText());
            
		in = s.next();
          
		while (!(playerExists(in, players))){
		    System.out.println("Please choose someone in the game.");
		    in = s.next();
		}
		
		currentP.act(game.getPlayerByName(in));
		System.out.println(currentP.getName() + ", please go to sleep.");
		System.out.println();
		
		}
		}
	    
	    in = "";
	}
    //mafia night action
    game.mafiaWent = false;
	
    }

    public static void dayTime(){//daytime phase
        Scanner s = new Scanner(System.in);

        System.out.println("It's daytime! Discuss who you wanna lynch, if anyone.");
        System.out.print("Do you want to lynch someone? (Y/N) ");

        String in = s.next();
        in = in.toLowerCase();
        while (!(in.equals("y") || in.equals("n")
            || in.equals("no") || in.equals("yes"))){
            System.out.print("Please input Y/N/Yes/No: ");
            in = s.next();
        }

        if (in.equals("no") || in.equals("n")){
            return;
        } else { //yes
            System.out.print("Who do you wanna lynch? ");
            printAll();
            in = s.next();
            while (!(playerExists(in,game.getPlayers()))){
                System.out.print("Please choose someone in the game: ");
                in = s.next();
            }
            game.removePlayer(in);
        }

    }

    public static void printAll(){// test function
        for (Player p : game.getPlayers()){
            System.out.println(p);
        }
    }
    

    public static boolean playerExists(String name, ArrayList<Player> players){
        for (int x = 0; x <players.size();x++){
            if (players.get(x).getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    //----------------------------------------

    //----------------------------------------
    
    public static void main(String args[]){ //perhaps can set up with args[] instead...
	int night = 1;

	startUp();
	while (game.checkWinConditions() == 0){ //loop
	    //game.tick();
	    System.out.println();
	    System.out.println("Night " + night
			       + "\nEverybody go to sleep!");
	  
	    night++;
	    loopThroughPlayers();
	    queryPlayers("");
	    System.out.println();
	    System.out.println("Everybody wake up!");

        System.out.println();
        printAll();//test
        System.out.println();

        System.out.println(game.processMarks());

        System.out.println();
        printAll();//test
        System.out.println();

        if (game.checkWinConditions() != 0){
            break;
        }
        dayTime();

	}
    }
    
    //testing
    /*
    public static void main(String[] args) {
        startUpRoleChooser();
    }
    */
}
 

//UNUSED CODE
/*
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
    */
