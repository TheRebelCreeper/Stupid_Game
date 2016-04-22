package Main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ObjectImage 
{
	private ImageIcon img;
	private int imgW;
	private int imgH;
	
	ObjectImage(ImageIcon icon, int w, int h)
	{
		setImgW(w);
		setImgH(h);
		img = resize(icon, w, h);
	}
	
	public ImageIcon getImage()
	{
		return img;
	}
	
	public ImageIcon resize(ImageIcon img, int w, int h)
	{
		return new ImageIcon(img.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
	}

	public int getImgH() {
		return imgH;
	}

	public void setImgH(int h) 
	{
		imgH = h;
	}

	public int getImgW() 
	{
		return imgW;
	}

	public void setImgW(int w) 
	{
		imgW = w;
	}
	
	
}
