package projectiles;

public class ProjectileExpire extends Thread
{
    int duration;

    public ProjectileExpire(int duration)
    {
        this.duration = duration;
    }

    public void run()
    {
        for (int i = 1; i <= duration; i++)
        {
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
