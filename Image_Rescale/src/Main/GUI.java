package Main;
import java.util.ArrayList;

import javax.swing.JFrame;

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
		//collisionHandler.handleCollision(gameObjects);
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
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		player = new Player(10, 10, 62, 158, 5, "Player");
		gameObjects.add(player);
		
		other = new Enemy(300, 23, 75, 145, 1, "Enemy", player);
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
}
