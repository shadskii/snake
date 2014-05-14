import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.*;
import java.util.ArrayList;

public class SnakeGame extends Applet implements Runnable{ //, KeyListener{

	//total segments including head
	private int segments = 3;

	//the main thread becomes the game loop
	Thread gameloop;

	//use this as a double buffer
	BufferedImage backbuffer;

	//the main drawing object for the back buffer
	Graphics2D g2d;

	//toggle for drawing bounding boxes
	boolean showBounds = false;

	//create the identity transform (0,0)
	AffineTransform identity = new AffineTransform();

	//create a game 
	GameBoard board = new GameBoard();

	//ArrayList to store snake segments
	private ArrayList<Segment> snake = new ArrayList<Segment>();

	/** applet init event */
	public void init(){
		backbuffer = new BufferedImage(480, 480, BufferedImage.TYPE_INT_RGB);
		g2d = backbuffer.createGraphics();

		//create the snake body
		snake.add(new Head(0,0,"right"));
		for(int i =1;i<segments;i++){
			snake.add(new Segment(0,0,snake.get(i-1)));
		}
		//adds snake to board
		for(int i=0;i<segments;i++){
			board.addTile((board.getnumRow()/2) - i, board.getnumRow()/2, snake.get(i));
		}
		//add apple to board
		board.addApple();
		//start the user input listener
		//addKeyListener(this);
	}

	/** applet update event */
	public void update(Graphics g) {
		//start off transforms at identity
		g2d.setTransform(identity);

		//erase the background
		//g2d.setPaint(Color.BLACK);
		//g2d.fillRect(0, 0, getSize().width, getSize().height);

		//information
		g2d.setColor(Color.WHITE);
		g2d.drawString("Score:" + segments, 5, 15);

		drawBoard();
		paint(g);
	}

	/** draws the gameboard*/
	public void drawBoard(){
		g2d.setColor(Color.WHITE);
		g2d.drawString("Score:" + segments, 25, 150);
		
		for(int i=0;i<board.getnumRow();i++){
			for(int j=0;j<board.getnumRow();j++){
				g2d.setTransform(identity);
				//g2d.translate(board.getTile(i, j).getXPos(),board.getTile(i, j).getYPos());
				g2d.setColor(board.getTile(i, j).getColor());
				g2d.fill(board.getTile(i, j).getRect());
			}
		}
	}

	/** paint */
	public void paint(Graphics g){
		g.drawImage(backbuffer, 0, 0, this);
	}

	/** thread start */
	public void start(){
		//create the gameloop thread for real-time updates
		gameloop = new Thread(this);
		gameloop.start();
	}

	/** thread run */
	public void run(){
		//acquire the current thread
		Thread t = Thread.currentThread();
		//keep going as long as the thread is alive
		while (t == gameloop) {

			try {
				//update the game loop
				gameUpdate();

				//target framerate is 50 fps
				Thread.sleep(20);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}

	/** thread stop */
	public void stop(){
		//kill the gameloop thread
		gameloop = null;
	}

	/** updates the game */
	public void gameUpdate(){
		//updateSnake();
		//checkCollision();
	}

	/** updates and moves the snake*/
	public void updateSnake(){
		Tile temp;
		if(((Head)snake.get(0)).getDeltX() !=0){ 
			temp = board.getTile((snake.get(0).getI() + ((Head)snake.get(0)).getDeltX()), snake.get(0).getJ());
			board.swapTiles(snake.get(segments-1), temp);
		}
		else{
			temp = board.getTile(snake.get(0).getI(),(snake.get(0).getJ() + ((Head)snake.get(0)).getDeltY()));
			board.swapTiles(snake.get(segments-1), temp);
		}
		
		board.swapTiles(snake.get(segments-1), snake.get(0));
		Segment swap = snake.get(1);
		snake.set(1,snake.get(segments-1));
		snake.set(segments-1, swap);
	}
}
