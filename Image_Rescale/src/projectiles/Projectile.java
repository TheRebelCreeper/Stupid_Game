package projectiles;

import javax.swing.JLabel;

import Main.GUI;
import Main.MyImage;
import gameObjects.GameObject;

@SuppressWarnings("serial")
public abstract class Projectile extends JLabel
{
    private ProjectileExpire expire;
    private GameObject src;
    private MyImage img;
    protected int speed;
    protected double angle;
    protected GameObject target;

    public Projectile(GameObject source, int lifeTime, MyImage img, int speed)
    {
        expire = new ProjectileExpire(lifeTime);
        expire.start();
        src = source;
        setBounds(source.getX(), source.getY(), img.getImgW(), img.getImgH());
        setIcon(img.getImage());
        GUI.frame.getContentPane().add(this);
        this.speed = speed;
    }

    public abstract void update();

    public abstract void move();

    public void delete()
    {
        GUI.frame.getContentPane().remove(this);
    }

    public boolean isExpired()
    {
        if (!expire.isAlive())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    protected void moveProjectile(int speed, double angle)
    {
        int speedX = (int) (Math.abs(speed) * Math.cos(angle));
        int speedY = (int) (Math.abs(speed) * Math.sin(angle));
        setLocation(getX() + speedX, getY() + speedY);
    }

    protected int getSpeed()
    {
        return speed;
    }
}
