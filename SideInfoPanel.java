import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class SideInfoPanel extends JPanel {
	private ArrayList<ShipButton> arrayButton;
	Fleet ownFleet;
	public SideInfoPanel(ButtonPanelListener bpl){
		super();
		arrayButton = new ArrayList<ShipButton>();
		this.setSize(120, 240);
		this.setLayout(null);
		this.setBackground(Color.white);
		ShipButton huge = new ShipButton("huge");
		ShipButton big1 = new ShipButton("big1");
		ShipButton big2 = new ShipButton("big2");
		
		ShipButton middle1 = new ShipButton("middle1");
		ShipButton middle2 = new ShipButton("middle2");
		ShipButton middle3 = new ShipButton("middle3");
		
		ShipButton little1 = new ShipButton("little1");
		ShipButton little2 = new ShipButton("little2");
		ShipButton little3 = new ShipButton("little3");
		ShipButton little4 = new ShipButton("little4");
		
		huge.setBounds(5, 5, 20, 80);
		big1.setBounds(5, 95, 20, 60);
		big2.setBounds(35, 95, 20, 60);
		
		middle1.setBounds(5, 165, 20, 40);
		middle2.setBounds(35, 165, 20, 40);
		middle3.setBounds(65, 165, 20, 40);
		
		little1.setBounds(5, 215, 20, 20);
		little2.setBounds(35, 215, 20, 20);
		little3.setBounds(65, 215, 20, 20);
		little4.setBounds(95, 215, 20, 20);
		
		arrayButton.add(huge);
		arrayButton.add(big1);
		arrayButton.add(big2);
		
		arrayButton.add(middle1);
		arrayButton.add(middle2);
		arrayButton.add(middle3);
		
		arrayButton.add(little1);
		arrayButton.add(little2);
		arrayButton.add(little3);
		arrayButton.add(little4);
		
		for(ShipButton b: arrayButton){
			b.setBackground(Color.gray);
			b.setEnabled(false);
			this.add(b);
			b.addActionListener(bpl);
		}	
	}
    public ArrayList<ShipButton> getArrayButton(){
    	return arrayButton;
    }
}
