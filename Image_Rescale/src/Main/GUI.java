package Main;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gameObjects.Collision;
import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.Player;
import gameObjects.Wall;


public class GUI {

	public static JFrame frame;
	public Player player;
	public Enemy other;
	public Wall wall1, wall2, wall3, wall4;
	private ArrayList<GameObject> gameObjects;
	@SuppressWarnings("unused")
	private Collision collisionHandler;
	private double timeAlive;
	@SuppressWarnings("unused")
	private boolean playAgain = true;

	/**
	 * Create the application.
	 */
	public GUI() 
	{
		resetKeys();
		gameObjects = new ArrayList<GameObject>();
		initialize();
		frame.addKeyListener(new KeyboardListener());
		collisionHandler = new Collision(gameObjects);	
		while(Keys.isAlive)
		{
			update();
			render();
			try 
			{
				Thread.sleep(1000/Keys.tickRate); 
				timeAlive += (1.0 / Keys.tickRate);
			} 
			catch (InterruptedException e) 
			{
				
			}
		}
		new String();
		String strTimeAlive = String.format("%.2f", timeAlive);
		JOptionPane.showMessageDialog(null, "Game Over.\nYou lived for " + strTimeAlive + " seconds", "", JOptionPane.DEFAULT_OPTION);
		frame.dispose();
	}

	private void update()
	{
		for (GameObject n: gameObjects)
		{
			n.update();
		}
		//collisionHandler.handleCollision(gameObjects);
	}
	
	private void render()
	{
		@SuppressWarnings("static-access")
		String strTimeAlive = new String().format("%.2f", timeAlive);
		frame.setTitle(strTimeAlive);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		player = new Player(10, 250, 62, 158, 10, "Player");
		gameObjects.add(player);
		
		other = new Enemy(1000, 250, 75, 145, 6, "Enemy", player, false);
		gameObjects.add(other);
		
		wall1 = new Wall(0, 0, 1264, 5, 0);
		wall1.setBounds(0, 0, 1264, 5);
		gameObjects.add(wall1);
		wall2 = new Wall(0, 0, 5, 682, 0);
		wall2.setBounds(0, 0, 5, 682);
		gameObjects.add(wall2);
		wall3 = new Wall(0, 677, 1264, 5, 0);
		wall3.setBounds(0, 677, 1264, 5);
		gameObjects.add(wall3);
		wall4 = new Wall(1260, 0, 5, 682, 0);
		wall4.setBounds(1260, 0, 5, 682);
		gameObjects.add(wall4);
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(other);
		frame.getContentPane().add(player);
		frame.getContentPane().add(wall1);
		frame.getContentPane().add(wall2);
		frame.getContentPane().add(wall3);
		frame.getContentPane().add(wall4);
		frame.setVisible(true);
	}
	
	private void resetKeys()
	{
		Keys.rightPressed = false;
		Keys.leftPressed = false;
		Keys.upPressed = false;
		Keys.downPressed = false;
		Keys.shiftPressed = false;
		Keys.shiftReleased = false;
		Keys.spacePressed = false;
		
		Keys.wPressed = false;
		Keys.aPressed = false;
		Keys.sPressed = false;
		Keys.dPressed = false;
		Keys.isAlive = true;
	}
}
