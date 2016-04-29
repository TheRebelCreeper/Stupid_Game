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
			movePlayer(getSpeed(), getSpeed());
		}
		else if(Keys.dPressed && Keys.sPressed)
		{
			movePlayer(getSpeed(), -getSpeed());
		}
		else if (Keys.aPressed && Keys.wPressed)
		{
			movePlayer(-getSpeed(), getSpeed());
		}
		else if(Keys.aPressed && Keys.sPressed)
		{
			movePlayer(-getSpeed(), -getSpeed());
		}
		else if (Keys.dPressed)
		{
			movePlayer(getSpeed(), 0);
		}
		else if (Keys.aPressed)
		{
			movePlayer(-getSpeed(), 0);
		}
		else if (Keys.wPressed)
		{
			movePlayer(0, getSpeed());
		}
		else if (Keys.sPressed)
		{
			movePlayer(0, -getSpeed());
		}
		
		if (Keys.shiftPressed)
		{
			setBounds(getX(), getY(), 125, 158);
			setIcon(Images.imgSpycrab.getImage());
			setSpeed(1);
		}
		if (Keys.shiftReleased)
		{
			setBounds(getX(), getY(), 62, 158);
			setIcon(icon.getImage());
			setSpeed(myFirstSpeed);
			Keys.shiftReleased = false;
		}
		
		if (Keys.spacePressed)
		{
			projCanShoot = new ProjectileCanShoot(500, this);
			if (canShoot)
			{
				projectiles.add(new Fireball(this));
				canShoot = false;
				projCanShoot.execute();
			}
		}
	}

	@Override
	public void update() 
	{
		updateProjectiles();		
		move();
		Collision.handleCollision(this);
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
