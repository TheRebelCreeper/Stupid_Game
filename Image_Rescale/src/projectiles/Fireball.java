package projectiles;

import Main.Images;
import Main.MyImage;
import gameObjects.GameObject;

public class Fireball extends Projectile{

	private static final int lifeTime = 3000;
	private static final MyImage img = Images.imgFire;
	
	public Fireball(GameObject source) 
	{
		super(source, lifeTime, img);
	}
	
	public void update()
	{
		move();
	}
	
	public void move()
	{
		setLocation(getX() + 10, getY());
	}

}
