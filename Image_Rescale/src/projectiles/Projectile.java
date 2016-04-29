package projectiles;

import gameObjects.GameObject;

import java.awt.Graphics;

import javax.swing.JLabel;

import Main.GUI;
import Main.Images;
import Main.MyImage;

public abstract class Projectile extends JLabel
{
	private ProjectileExpire expire;
	private GameObject src;
	private MyImage img;
	
	public Projectile(GameObject source, int lifeTime, MyImage img)
	{
		expire = new ProjectileExpire(lifeTime);
		expire.execute();
		src = source;
		setBounds(source.getX(), source.getY(), img.getImgW(), img.getImgH());
		setIcon(img.getImage());
		GUI.frame.getContentPane().add(this);
		
	}
	
	public abstract void update();
	
	public abstract void move();
	
	public void delete()
	{
		GUI.frame.getContentPane().remove(this);
	}
	
	public boolean isExpired()
	{
		if (expire.isDone())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
