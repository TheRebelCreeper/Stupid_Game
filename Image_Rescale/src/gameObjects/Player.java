package gameObjects;

import Main.Images;
import Main.Keys;
import Main.ObjectImage;

@SuppressWarnings("serial")
public class Player extends GameObject
{
	private int myFirstSpeed;
	public Player(ObjectImage icon, int x, int y, int w, int h, int speed) 
	{		
		super(icon, x, y, w, h, speed);
		myFirstSpeed = speed;
	}
	
	public void move()
	{
		if (Keys.dPressed)
		{
			setLastX(getX());
			setLocation(getX() + getSpeed(), getY());
			hitbox.setLocation(getX() + getSpeed(), getY());
		}
		if (Keys.aPressed)
		{
			setLastX(getX());
			setLocation(getX() - getSpeed(), getY());
			hitbox.setLocation(getX() - getSpeed(), getY());
		}
		if (Keys.wPressed)
		{
			setLastY(getY());
			setLocation(getX(), getY() - getSpeed());
			hitbox.setLocation(getX(), getY() - getSpeed());
		}
		if (Keys.sPressed)
		{
			setLastY(getY());
			setLocation(getX(), getY() + getSpeed());
			hitbox.setLocation(getX(), getY() + getSpeed());
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
			setIcon(img.getImage());
			setSpeed(myFirstSpeed);
			Keys.shiftReleased = false;
		}
	}

	@Override
	public void update() 
	{
		move();
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
