package projectiles;

import javax.swing.JOptionPane;

import Main.Images;
import Main.Keys;
import Main.MyImage;
import gameObjects.Collision;
import gameObjects.GameObject;

public class Fireball extends Projectile{

	private static final int lifeTime = 700;
	private static final MyImage img = Images.imgFire;
	
	
	public Fireball(GameObject source, GameObject targ) 
	{
		super(source, lifeTime, img, 4);
		target = targ;
		calcDirection();
	}
	
	public void update()
	{
		move();
		if (Collision.handleCollision(this).equals("Player"))
		{
			delete();
			Keys.isAlive = false;
		}
	}
	
	public void move()
	{
		moveProjectile(getSpeed(), angle);
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
