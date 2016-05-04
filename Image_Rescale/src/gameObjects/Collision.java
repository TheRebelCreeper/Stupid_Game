package gameObjects;

import java.util.ArrayList;

import projectiles.Projectile;

public class Collision 
{
	private static ArrayList<GameObject> myList;
	public Collision(ArrayList<GameObject> list)
	{
		myList = new ArrayList<GameObject>();
		for (GameObject n: list)
		{
			myList.add(n);
		}
	}
	
	public void handleCollision(ArrayList<GameObject> list)
	{
		for (int i = 0; i < list.size(); i++)
		{
			for (int j = 0; j < list.size(); j++)
			{
				if (i != j)
				{
					if (list.get(i).getBounds().intersects(list.get(j).getBounds()))
					{
						list.get(i).moveBack();
					}
				}
			}
		}
	}
	
	public static String handleCollision(GameObject obj)
	{
		for (int i = 0; i < myList.size(); i++)
		{
			if (!obj.equals(myList.get(i)))
			{
				if (obj.getBounds().intersects(myList.get(i).getBounds()))
				{
					obj.moveBack();
					return myList.get(i).getId();
				}
			}
		}
		return "";
	}
	
	public static String handleCollision(Projectile proj)
	{
		for (int i = 0; i < myList.size(); i++)
		{
			if (!proj.equals(myList.get(i)))
			{
				if (proj.getBounds().intersects(myList.get(i).getBounds()))
				{
					return myList.get(i).getId();
				}
			}
		}
		return "";
	}
}
