import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class ButtonPanelListener implements ActionListener {
	private int stateOn;
	private int chosenShip;
	private ShipButton currentShipButton;
	private Fleet ownFleet;
	ArrayList<ShipButton> listenButtons;
	
	public ButtonPanelListener(Fleet f){
		ownFleet = f;
		currentShipButton = new ShipButton();
		listenButtons = null;
	}

	public void actionPerformed(ActionEvent ev){
		
		if( ev.getSource().getClass() == currentShipButton.getClass()){
			System.out.println(ev.getSource().getClass().getName());
			JButton b = (JButton) ev.getSource();
			b.setBackground(Color.blue);
			//String str = currentShipButton.getShipName();
		} else {
			System.out.println(ev.getSource().getClass().getName());
			JButton b = (JButton) ev.getSource();
			if(b.getText() == "deploy"){
				stateOn = 1;
				deployFleet(ownFleet, listenButtons);
			}
			if(b.getText() == "stop"){
				stateOn = 0;
				stopDeployFleet(ownFleet, listenButtons);
			}
		}
	}
	
	private void deployFleet(Fleet f, ArrayList<ShipButton> arButton){
		for(ShipButton b: arButton){
			b.setBackground(Color.green);
			b.setEnabled(true);
		}
	}
	
	private void stopDeployFleet(Fleet f, ArrayList<ShipButton> arButton){
		for(ShipButton b: arButton){
			b.setBackground(Color.gray);
			b.setEnabled(false);
		}
	}
	public void setArrayButton(ArrayList<ShipButton> arsb){
		listenButtons = arsb;
	}
	public int getState(){
		return stateOn;
	}
	public int getChosenShip(){
		return chosenShip;
	}

}
