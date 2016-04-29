package projectiles;

import javax.swing.SwingWorker;

import gameObjects.GameObject;

public class ProjectileCanShoot extends SwingWorker<Object, Object>
{
	private int delay;
	private GameObject target;
	
	public ProjectileCanShoot(int delay, GameObject target)
	{
		this.delay = delay;
		this.target = target;
	}
	
	@Override
	protected Object doInBackground() throws Exception 
	{
		Thread.sleep(delay);
		target.canShoot = true;
		return null;
	}

}
