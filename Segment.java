import java.awt.*;
public class Segment extends Tile {
	//variables
	private Segment next = null;
	private Segment previous = null;
	public static final Color color = Color.CYAN;

	/** a constructor for segment*/
	public Segment(int xPos, int yPos, Segment next){
		super(Segment.color,xPos,yPos);
		this.next = next;
	}
	/** a constructor for segment that includes color*/
	public Segment(Color color, int xPos, int yPos){
		super(color, xPos,yPos);
	}
	public Segment(int xPos, int yPos){
		super(Segment.color,xPos,yPos);
	}

	/** adds a new segment*/
	public void addSegment(int size, Color color){
		Segment current = this.previous;
		while(current != null){
			current = current.previous;
		}
		current = new Segment(this.getXPos(),this.getYPos(),current.next); /////////////fix dis
	}	
}
