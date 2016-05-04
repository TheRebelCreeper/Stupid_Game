package Main;

import javax.swing.JOptionPane;

public class Driver {
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		boolean playAgain = true;
		while (playAgain)
		{
			GUI gui = new GUI();
			Object[] options = {"Yes", "No"};
			int choice = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			if (choice != 0)
			{
				playAgain = false;
			}
		}
	}
}
