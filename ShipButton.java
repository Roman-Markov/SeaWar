import javax.swing.*;

public class ShipButton extends JButton {
	private String shipName;
	public ShipButton(String s){
		super();
		shipName = s;
	}
	public ShipButton(){
		super();
		shipName = new String();
	}
	public void setShipName(String s){
		shipName = s;
	}
	public String getShipName(){
		return shipName;
	}
}
