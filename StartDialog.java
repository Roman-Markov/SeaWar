import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartDialog extends JDialog
{
	JTextField nameArea;
	String gamerName;
	
	public StartDialog(JFrame owner, String name)
	{
		super(owner, "Registration", true);
		add(new JLabel("<html><center><h3>Your name, admiral</h3></center></html>"),
				BorderLayout.NORTH);

		nameArea =  new JTextField(20);
		// При активизации кнопки ОК диалоговое окно закрывается.

		OkListener ol = new OkListener(owner, this);
		JButton ok = new JButton("ok");
		ok.addActionListener(ol);

		// Кнопка ОК помещается в нижнюю часть окна.

		JPanel panel = new JPanel();
		panel.add(ok);
		add(nameArea, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		setSize(260, 160);
	}
	class OkListener implements ActionListener{
		JFrame frame;
		JDialog dialog;
		
		public OkListener(JFrame f, JDialog d){
			frame = f;
			dialog = d;
		}
		public void actionPerformed(ActionEvent event) {
			gamerName = nameArea.getText();
			dialog.setVisible(false);
		}
	}
}

