package gameObjects;
import java.awt.Rectangle;

import javax.swing.JLabel;

import Main.ObjectImage;


@SuppressWarnings("serial")
public abstract class GameObject extends JLabel
{
	private int mySpeed;
	private int lastX, lastY;
	public Rectangle hitbox;
	public ObjectImage img;
	public boolean isColliding = false;
	
	GameObject(ObjectImage icon, int x, int y, int w, int h, int speed)
	{
		img = icon;
		setIcon(img.getImage());
		setBounds(x, y, w, h);
		lastX = x; 
		lastY = y;
		hitbox = new Rectangle(x, y, w, h);
		mySpeed = speed;
	}
	
	GameObject(int x, int y, int w, int h, int speed)
	{
		setIcon(null);
		setBounds(x, y, w, h);
		lastX = x; 
		lastY = y;
		hitbox = new Rectangle(x, y, w, h);
		mySpeed = speed;
	}
	
	public abstract void update();
	
	public abstract void draw();
	
	public int getSpeed()
	{
		return mySpeed;
	}
	
	public void setSpeed(int s)
	{
		mySpeed = s;
	}
	
	public void setLastX(int x)
	{
		lastX = x;
	}
	
	public void setLastY(int y)
	{
		lastY = y;
	}
	
	public void moveBack()
	{
		setLocation(lastX, lastY);
		hitbox.setLocation(lastX, lastY);
	}
}
