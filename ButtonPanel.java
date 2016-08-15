import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;

public class ButtonPanel extends JPanel{
	private JButton leftButton;
	private JButton rightButton;
	
	public ButtonPanel(ButtonPanelListener bpl){
		super();
		this.setSize(360, 80);
		leftButton = new JButton("deploy");
		rightButton = new JButton("stop");
		this.add(leftButton);
		this.add(rightButton);
		
		leftButton.addActionListener(bpl);
		rightButton.addActionListener(bpl);
	}

}
