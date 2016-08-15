import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton{
	private Point location;
	private int state;
	
	public MyButton(){
		super();
		location = new Point();
		state = 0;
	}
	
	public Point getLocation(){
		return location;
	} 
	public void setLocation(int row, int column){
		location.setLocation(row, column);
	}
	
	public int getState(){
		return state;
	}
	public void setState(int s){
		state = s;
	}
}
