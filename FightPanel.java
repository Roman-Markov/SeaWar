import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class FightPanel extends JPanel{
	public FightPanel(CellListener cl){
		super();
		this.setSize(360, 260);
		this.setLayout(null);	
		// добавляем кнопки
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				MyButton b = new MyButton();
				b.setBackground(Color.white);
				b.setLocation(i, j);
				b.addActionListener(cl);
				b.setBounds(40+j*20, 40+i*20, 20, 20);
				this.add(b);
			}
		}	
		// добавляем буквы сбоку
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "g"};
		for(int i = 0; i < 10; i++){
			JLabel lab = new JLabel(letters[i]);
			lab.setBounds(20, 40+i*20, 20, 20);
			this.add(lab);
		}		
		//добавляем цифры сверху
		String[] digits = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		for(int i = 0; i < 10; i++){
			JLabel lab = new JLabel(digits[i]);
			lab.setBounds(40+i*20, 20, 20, 20);
			this.add(lab);
		}
	}
}
