import java.awt.event.*;
import java.awt.*;

public class CellListener implements ActionListener {
	public void actionPerformed(ActionEvent ev){
		MyButton b = (MyButton) ev.getSource();
		if(b.getState() == 0){
			b.setBackground(Color.RED);
			b.setState(1);
		} else {
			b.setBackground(Color.white);
			b.setState(0);
		}
	}

}
