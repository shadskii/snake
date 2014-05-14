import java.awt.*;

public class Head extends Segment{
	//variables
	private int deltX;
	private int deltY;
	public static final Color color = Color.BLUE;
	
	/** constructor for Head*/
	public Head(int xPos, int yPos, String direction){
		super(Head.color,xPos,yPos);
		if(direction.equals("up")){
			deltX = 0;
			deltY = 1;
		}
		else if(direction.equals("down")){
			deltX = 0;
			deltY = -1;
		}
		else if(direction.equals("left")){
			deltX = -1;
			deltY = 0;
		}
		else if(direction.equals("right")){
			deltX = 1;
			deltY = 0;
		}
		else{
			deltX = 0;
			deltY = 0;
		}
	}
	
	/** a get method for deltX*/
	public int getDeltX(){
		return deltX;
	}
	/** a get method for deltY*/
	public int getDeltY(){
		return deltY;
	}
	
	/** a set method for direction*/
	public void setDir(String direction){
		if(direction.equals("up")){
			deltX = 0;
			deltY = 1;
		}
		else if(direction.equals("down")){
			deltX = 0;
			deltY = -1;
		}
		else if(direction.equals("left")){
			deltX = -1;
			deltY = 0;
		}
		else if(direction.equals("right")){
			deltX = 1;
			deltY = 0;
		}
		else{
			deltX = 0;
			deltY = 0;
		}
	}
}
