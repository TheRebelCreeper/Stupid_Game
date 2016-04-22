package Main;
import gameObjects.Collision;
import gameObjects.Enemy;
import gameObjects.GameObject;
import gameObjects.Player;
import gameObjects.Wall;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;


public class GUI {

	private JFrame frame;
	public Player player;
	public Enemy other;
	public Wall wall1, wall2, wall3, wall4;
	private ArrayList<GameObject> gameObjects;
	private Collision collisionHandler;

	/**
	 * Create the application.
	 */
	public GUI() 
	{
		gameObjects = new ArrayList<GameObject>();
		initialize();
		frame.addKeyListener(new KeyboardListener());
		collisionHandler = new Collision(gameObjects);
		
		while(true)
		{
			update();
			render();
			try {Thread.sleep(8);} 
			catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	private void update()
	{
		for (GameObject n: gameObjects)
		{
			n.update();
		}
		collisionHandler.handleCollision(gameObjects);
	}
	
	private void render()
	{
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		player = new Player(Images.imgSpy, 10, 10, 62, 158, 3);
		gameObjects.add(player);
		
		other = new Enemy(Images.imgPyro, 100, 10, 75, 158, 3);
		gameObjects.add(other);
		
		wall1 = new Wall(0, 0, 790, 5, 0);
		wall1.setBackground(Color.BLACK);
		wall1.setOpaque(true);
		gameObjects.add(wall1);
		wall2 = new Wall(0, 0, 5, 560, 0);
		wall2.setOpaque(true);
		wall2.setBackground(Color.BLACK);
		gameObjects.add(wall2);
		wall3 = new Wall(0, 558, 790, 5, 0);
		wall3.setOpaque(true);
		wall3.setBackground(Color.BLACK);
		gameObjects.add(wall3);
		wall4 = new Wall(780, 0, 5, 560, 0);
		wall4.setBackground(Color.BLACK);
		wall4.setOpaque(true);
		gameObjects.add(wall4);
		
		
		frame.getContentPane().add(other);
		frame.getContentPane().add(player);
		frame.getContentPane().add(wall1);
		frame.getContentPane().add(wall2);
		frame.getContentPane().add(wall3);
		frame.getContentPane().add(wall4);
		frame.setVisible(true);
	}
}
