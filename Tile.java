import java.awt.*;
import java.awt.geom.*;
public class Tile {
//variables
	private final int size = 10;
	private Color color;
	private Rectangle2D.Double rect;
	private int i =0;
	private int j =0;
	
	/** a constructor for tile*/
	public Tile(Color color, int xPos, int yPos){
		this.rect = new Rectangle2D.Double(xPos, yPos,size,size);
		this.color = color;
	}
	
	/** a get method for size*/
	public int getSize(){
		return size;
	}
	/** a get method for color*/
	public Color getColor(){
		return color;
	}
	/** a get method for xPos*/
	public int getXPos(){
		return (int)rect.getX();
	}
	/** a get method for yPos*/
	public int getYPos(){
		return (int)rect.getY();
	}
	/** a get method for rectangle*/
	public Rectangle2D.Double getRect(){
		return rect;
	}
	/** a get method for i*/
	public int getI(){
		return i;
	}
	/** a get method for j*/
	public int getJ(){
		return j;
	}
	
	/** a set method for i */
	public void setI(int i){
		this.i = i;
	}
	/** a set method for i */
	public void setJ(int j){
		this.j = j;
	}
	/** set method for color*/
	public void setColor(Color color){
		this.color = color;
	}
	/** sets the tile at position (x,y)*/
	public void setPos(int xPos, int yPos){
		rect.setRect(xPos, yPos, size, size);
	}
}