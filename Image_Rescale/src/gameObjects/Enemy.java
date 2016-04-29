package gameObjects;

import javax.swing.JOptionPane;

import Main.Images;
import Main.MyImage;

@SuppressWarnings("serial")

public class Enemy extends GameObject
{
	
	private GameObject target;
	private static MyImage icon = Images.imgPyro;
	
	public Enemy(int x, int y, int w, int h, int speed, String id, GameObject targ) 
	{
		super(icon, x, y, w, h, speed, id);
		target = targ;
	}

	public void move() 
	{
		setLastX(getX());
		setLastY(getY());
		
		if (getX() < target.getX())
		{
			movePlayer(getSpeed(), 0);
		}
		else
		{
			movePlayer(-getSpeed(), 0);
		}
		
		if (getY() < target.getY())
		{
			movePlayer(0, -getSpeed());
		}
		else
		{
			movePlayer(0, getSpeed());
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		move();
		if (Collision.handleCollision(this).equals("Player"))
		{
			JOptionPane.showMessageDialog(null, "Game Over", "", JOptionPane.DEFAULT_OPTION);
			System.exit(1);
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
}
