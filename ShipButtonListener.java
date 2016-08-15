import java.awt.Color;
import java.awt.event.*;


public class ShipButtonListener implements ActionListener{
	ShipButton currentButton;
	
	public void actionPerformed(ActionEvent ev){
		currentButton = (ShipButton) ev.getSource();
		currentButton.setBackground(Color.gray);
	}

}
