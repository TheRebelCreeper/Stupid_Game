package projectiles;

import javax.swing.SwingWorker;

public class ProjectileExpire extends SwingWorker<Object, Object>
{
	int duration;
	public ProjectileExpire(int duration)
	{
		this.duration = duration;
	}
	
	@Override
	protected Object doInBackground() throws Exception 
	{
		for (int i = 1; i <= duration; i++)
		{
			Thread.sleep(1);
		}
		return null;
	}

}
