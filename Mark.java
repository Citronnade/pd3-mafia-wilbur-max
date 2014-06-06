public class Mark{
    private Player origin;
    private String type;

    public Mark(String type){
        this.type = type;
    }

    public Mark(Player origin, String type){
	this.origin = origin;
	this.type = type;
    }

    public Player getOrigin(){
	return origin;
    }

    public String getType(){
	return type;
    }
}
