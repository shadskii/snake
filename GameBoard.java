import java.awt.*;
import java.util.Random;
public class GameBoard {
//variables
	private int numRow = 25;
	private Tile[][] gameBoard;
	public static final Color color = Color.BLACK;
	
	/** populates a gameBoard with black tiles*/
	public GameBoard(){
		gameBoard = new Tile[numRow][numRow];
		int x = 0;
		int y = 0;
		for(int i=0;i<numRow;i++){
			y += 10;
			for(int j=0;j<gameBoard[i].length;j++){
				x += 10;
				gameBoard[i][j] = new Tile(GameBoard.color,x,y);
			}
		}
	}
	
	/** get method for tile at (i,j)*/
	public Tile getTile(int i, int j){
		return gameBoard[i][j];
	}
	/** get method for size of board*/
	public int getnumRow(){
		return numRow;
	}
	
	/** set method for tile at (i,j)*/
	public void addTile(int i, int j, Tile tile){
		Tile temp = getTile(i,j);
		tile.setPos(temp.getXPos(),temp.getYPos());
		gameBoard[i][j] = tile;
		tile.setI(i);
		tile.setJ(j);
	}
	
	/** adds apple to gameboard*/
	public void addApple(){
		Random rand = new Random();
		int i = 0;
		int j = 0;
		do{
			i = rand.nextInt(numRow);
			j = rand.nextInt(numRow);
		} while(getTile(i,j) instanceof Segment);
		addTile(i,j,new Apple(getTile(i,j).getXPos(),getTile(i,j).getYPos()));
	}
	
	/** swaps two tiles */
	public void swapTiles(Tile a, Tile b){
		//swaps positions
		a.setPos(b.getXPos(), b.getYPos());
		b.setPos(a.getXPos(), a.getYPos());
		
		Tile temp = a;
		gameBoard[a.getI()][a.getJ()] = b;
		gameBoard[b.getI()][b.getJ()] = temp;
		
	}
	 
}
