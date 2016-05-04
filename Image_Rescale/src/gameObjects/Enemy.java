package gameObjects;

import javax.swing.JOptionPane;

import projectiles.Fireball;
import projectiles.ProjectileCanShoot;
import Main.Images;
import Main.Keys;
import Main.MyImage;

@SuppressWarnings("serial")

public class Enemy extends GameObject
{
	
	private GameObject target;
	private static MyImage icon = Images.imgPyro;
	private double angle;
	
	public Enemy(int x, int y, int w, int h, int speed, String id, GameObject targ) 
	{
		super(icon, x, y, w, h, speed, id);
		target = targ;
		calcDirection();
	}

	public void move() 
	{
		setLastX(getX());
		setLastY(getY());
		movePlayer(getSpeed(), angle);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		calcDirection();
		move();
		
		projCanShoot = new ProjectileCanShoot(100, this);
		if (canShoot)
		{
			projectiles.add(new Fireball(this, target));
			canShoot = false;
			projCanShoot.execute();
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
