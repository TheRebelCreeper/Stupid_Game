package Main;

import javax.swing.ImageIcon;

public class Images 
{
	public static ImageIcon fireImg = new ImageIcon(GUI.class.getResource("/images/fireball.png"));
	public static MyImage imgFire = new MyImage(fireImg, 64, 64);
	
	public static ImageIcon spyImg = new ImageIcon(GUI.class.getResource("/images/Spy.png"));
	public static MyImage imgSpy = new MyImage(spyImg, 62, 158);
	
	public static ImageIcon spycrabImg = new ImageIcon(GUI.class.getResource("/images/Spycrab.png"));
	public static MyImage imgSpycrab = new MyImage(spycrabImg, 125, 158);
	
	public static ImageIcon pyroImg = new ImageIcon(GUI.class.getResource("/images/Pyro.png"));
	public static MyImage imgPyro = new MyImage(pyroImg, 75, 158);
}
