package Main;

import javax.swing.ImageIcon;

public class Images 
{
	public static ImageIcon spyImg = new ImageIcon(GUI.class.getResource("/images/Spy.png"));
	public static ObjectImage imgSpy = new ObjectImage(spyImg, 62, 158);
	
	public static ImageIcon spycrabImg = new ImageIcon(GUI.class.getResource("/images/Spycrab.png"));
	public static ObjectImage imgSpycrab = new ObjectImage(spycrabImg, 125, 158);
	
	public static ImageIcon pyroImg = new ImageIcon(GUI.class.getResource("/images/Pyro.png"));
	public static ObjectImage imgPyro = new ObjectImage(pyroImg, 75, 158);
}
