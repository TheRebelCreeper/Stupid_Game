package gameObjects;

import Main.Keys;
import Main.ObjectImage;

@SuppressWarnings("serial")
public class Enemy extends GameObject
{

	public Enemy(ObjectImage icon, int x, int y, int w, int h, int speed) 
	{
		super(icon, x, y, w, h, speed);
	}

	public void move() 
	{
		if (Keys.rightPressed)
		{
			setLastX(getX());
			setLocation(getX() + getSpeed(), getY());
			hitbox.setLocation(getX() + getSpeed(), getY());
		}
		if (Keys.leftPressed)
		{
			setLastX(getX());
			setLocation(getX() - getSpeed(), getY());
			hitbox.setLocation(getX() - getSpeed(), getY());
		}
		if (Keys.upPressed)
		{
			setLastY(getY());
			setLocation(getX(), getY() - getSpeed());
			hitbox.setLocation(getX(), getY() - getSpeed());
		}
		if (Keys.downPressed)
		{
			setLastY(getY());
			setLocation(getX(), getY() + getSpeed());
			hitbox.setLocation(getX(), getY() + getSpeed());
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
