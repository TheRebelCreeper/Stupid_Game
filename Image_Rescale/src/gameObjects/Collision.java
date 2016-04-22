package gameObjects;

import java.util.ArrayList;

public class Collision 
{
	private ArrayList<GameObject> myList;
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
					if (list.get(i).hitbox.intersects(list.get(j).hitbox))
					{
						list.get(i).moveBack();
					}
				}
			}
		}
	}
	
	public void handleCollision(GameObject obj)
	{
		for (int i = 0; i < myList.size(); i++)
		{
			if (!myList.get(i).equals(obj))
			{
				if (obj.hitbox.intersects(myList.get(i).hitbox))
				{
					obj.moveBack();
				}
			}
		}
	}
	
	public boolean checkCollision(GameObject obj)
	{
		for (int i = 0; i < myList.size(); i++)
		{
			if (!myList.get(i).equals(obj))
			{
				if (obj.hitbox.intersects(myList.get(i).hitbox))
				{
					return true;
				}
			}
		}
		return false;
	}
}
