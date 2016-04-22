package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener
{
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT)
		{
			Keys.rightPressed = true;
		}
		else if (key == KeyEvent.VK_LEFT)
		{
			Keys.leftPressed = true;
		}
		else if (key == KeyEvent.VK_UP)
		{
			Keys.upPressed = true;
		}
		else if (key == KeyEvent.VK_DOWN)
		{
			Keys.downPressed = true;
		}
		else if (key == KeyEvent.VK_D)
		{
			Keys.dPressed = true;
		}
		else if (key == KeyEvent.VK_A)
		{
			Keys.aPressed = true;
		}
		else if (key == KeyEvent.VK_W)
		{
			Keys.wPressed = true;
		}
		else if (key == KeyEvent.VK_S)
		{
			Keys.sPressed = true;
		}
		
		
		if (e.isShiftDown())
		{
			Keys.shiftPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT)
		{
			Keys.rightPressed = false;
		}
		else if (key == KeyEvent.VK_LEFT)
		{
			Keys.leftPressed = false;
		}
		else if (key == KeyEvent.VK_UP)
		{
			Keys.upPressed = false;
		}
		else if (key == KeyEvent.VK_DOWN)
		{
			Keys.downPressed = false;
		}
		else if (key == KeyEvent.VK_D)
		{
			Keys.dPressed = false;
		}
		else if (key == KeyEvent.VK_A)
		{
			Keys.aPressed = false;
		}
		else if (key == KeyEvent.VK_W)
		{
			Keys.wPressed = false;
		}
		else if (key == KeyEvent.VK_S)
		{
			Keys.sPressed = false;
		}
		
		if (!e.isShiftDown())
		{
			Keys.shiftPressed = false;
			Keys.shiftReleased = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
	}
}
