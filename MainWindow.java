import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow {
	JFrame mainFrame;
	FightPanel enemyPanel;
	FightPanel ownPanel;
	Fleet ownFleet;
	Fleet enemyFleet;
	ButtonPanelListener deployer1;
	ButtonPanelListener deployer2;
	
	public void go(){
		mainFrame = new JFrame();
		ownFleet = new Fleet();
		enemyFleet = new Fleet();
		CellListener cl = new CellListener();
		enemyPanel = new FightPanel(cl);
		ownPanel = new FightPanel(cl);
		
		deployer1 = new ButtonPanelListener(ownFleet);
		deployer2 = new ButtonPanelListener(enemyFleet);

		mainFrame.setSize(600, 800);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("SeaWar");
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		mainFrame.getContentPane().add(BorderLayout.CENTER, centerPanel);
		
		ownFleet = new Fleet();
		ButtonPanel buttonPanel = new ButtonPanel(deployer1);
		buttonPanel.setSize(360, 80);
		
		SideInfoPanel sidePanel = new SideInfoPanel(deployer1);
		sidePanel.setBounds(250, 20, 120, 240);
		ownPanel.add(sidePanel);
		deployer1.setArrayButton(sidePanel.getArrayButton());

		centerPanel.add(enemyPanel);
		centerPanel.add(ownPanel);
		mainFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
	}

}
