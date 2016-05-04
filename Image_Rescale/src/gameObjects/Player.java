package gameObjects;

import Main.Images;
import Main.Keys;
import Main.MyImage;
import projectiles.Fireball;
import projectiles.ProjectileCanShoot;

@SuppressWarnings("serial")
public class Player extends GameObject
{
	private int myFirstSpeed;
	private static MyImage icon = Images.imgSpy;
	
	public Player(int x, int y, int w, int h, int speed, String id) 
	{		
		super(icon, x, y, w, h, speed, id);
		myFirstSpeed = speed;
	}
	
	public void move()
	{
		setLastX(getX());
		setLastY(getY());
		if (Keys.dPressed && Keys.wPressed)
		{
			movePlayer(getSpeed(), 7 * Math.PI / 4.0);
		}
		else if(Keys.dPressed && Keys.sPressed)
		{
			movePlayer(getSpeed(), Math.PI / 4.0);
		}
		else if (Keys.aPressed && Keys.wPressed)
		{
			movePlayer(getSpeed(), 5 * Math.PI / 4.0);
		}
		else if(Keys.aPressed && Keys.sPressed)
		{
			movePlayer(getSpeed(), 3 * Math.PI / 4.0);
		}
		else if (Keys.dPressed)
		{
			movePlayer(getSpeed(), 0);
		}
		else if (Keys.aPressed)
		{
			movePlayer(getSpeed(), Math.PI);
		}
		else if (Keys.wPressed)
		{
			movePlayer(getSpeed(), 3 * Math.PI / 2.0);
		}
		else if (Keys.sPressed)
		{
			movePlayer(getSpeed(), Math.PI / 2.0);
		}
		
		if (Keys.shiftPressed)
		{
			setBounds(getX(), getY(), 125, 158);
			setIcon(Images.imgSpycrab.getImage());
			setSpeed(2);
		}
		if (Keys.shiftReleased)
		{
			setBounds(getX(), getY(), 62, 158);
			setIcon(icon.getImage());
			setSpeed(myFirstSpeed);
			Keys.shiftReleased = false;
		}
	}

	@Override
	public void update() 
	{	
		move();
		Collision.handleCollision(this);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
