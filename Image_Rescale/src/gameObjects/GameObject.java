package gameObjects;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JLabel;

import Main.MyImage;
import projectiles.Projectile;
import projectiles.ProjectileCanShoot;


@SuppressWarnings("serial")
public abstract class GameObject extends JLabel
{
	private int mySpeed;
	private int lastX, lastY;
	private String id;
	public ArrayList<Projectile> projectiles;
	private ArrayList<Integer> indexes;
	public MyImage img;
	public boolean canShoot = true;
	protected ProjectileCanShoot projCanShoot;
	
	GameObject(MyImage icon, int x, int y, int w, int h, int speed, String id)
	{
		projectiles = new ArrayList<Projectile>();
		img = icon;
		setIcon(img.getImage());
		setBounds(x, y, w, h);
		lastX = x; 
		lastY = y;
		mySpeed = speed;
		this.id = id;
	}
	
	GameObject(int x, int y, int w, int h, int speed, String id)
	{
		setIcon(null);
		setBounds(x, y, w, h);
		lastX = x; 
		lastY = y;
		mySpeed = speed;
		this.id = id;
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
	}
	
	public void movePlayer(int speed, double angle)
	{
		int speedX = (int)(Math.abs(speed) * Math.cos(angle));
		int speedY = (int)(Math.abs(speed) * Math.sin(angle));
		setLocation((getX() + speedX), getY() + speedY);
	}
	
	public void movePlayer(int speedX, int speedY, int i)
	{
		setLocation((getX() + speedX), getY() + speedY);
	}
	
	protected String getId()
	{
		return id;
	}
	
	protected void updateProjectiles()
	{
		indexes = new ArrayList<Integer>();
		
		for (Projectile n: projectiles)
		{
			n.update();
		}
		
		for (int i = 0; i < projectiles.size(); i++)
		{
			if (projectiles.get(i).isExpired())
			{
				indexes.add(i);
			}
		}
		
		for (Integer n: indexes)
		{
			projectiles.get(n.intValue()).delete();
			projectiles.remove(n.intValue());
		}
	}
	
}
