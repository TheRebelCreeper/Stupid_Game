package projectiles;

import gameObjects.GameObject;

public class ProjectileCanShoot extends Thread
{
	private int delay;
	private GameObject parent;
	
	public ProjectileCanShoot(int delay, GameObject parent)
	{
		this.delay = delay;
		this.parent = parent;
	}
	
	@Override
	public void run()
	{
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parent.canShoot = true;
	}

}
