package gameObjects;

import Main.Images;
import Main.Keys;
import Main.MyImage;
import projectiles.Fireball;
import projectiles.ProjectileCanShoot;

@SuppressWarnings("serial")

public class Enemy extends GameObject
{
	
	private GameObject target;
	private static MyImage icon = Images.imgPyro;
	private double angle;
	private boolean hardMode;
	
	public Enemy(int x, int y, int w, int h, int speed, String id, GameObject targ, boolean hard) 
	{
		super(icon, x, y, w, h, speed, id);
		target = targ;
		calcDirection();
		hardMode = hard;
	}

	public void move() 
	{
		setLastX(getX());
		setLastY(getY());
		if (hardMode)
		{
			if (target.getX() > getX())
			{
				movePlayer(getSpeed(), 0, 0);
			}
			else if(target.getX() < getX())
			{
				movePlayer(-getSpeed(), 0, 0);
			}
			
			if (target.getY() > getY())
			{
				movePlayer(0, getSpeed(), 0);
			}
			else if(target.getY() < getY() && getY() > 10)
			{
				movePlayer(0, -getSpeed(), 0);
			}
		}
		else
			movePlayer(getSpeed(), angle);
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		calcDirection();
		move();
		
		projCanShoot = new ProjectileCanShoot(200, this);
		if (canShoot)
		{
			projectiles.add(new Fireball(this, target));
			canShoot = false;
			projCanShoot.start();
		}
		
		if (Collision.handleCollision(this).equals("Player"))
		{
			Keys.isAlive = false;
		}			
		
		updateProjectiles();	
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	private void calcDirection()
	{
		double m = Math.abs(Math.sqrt(Math.pow(target.getX() - getX(), 2) + Math.pow(target.getY() - getY(), 2)));
		angle = Math.acos((target.getX() - getX()) / m);
		if (target.getY() < getY())
		{
			angle = -angle;
		}		
	}
}
