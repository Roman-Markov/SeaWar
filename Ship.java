import java.awt.Point;
import java.util.ArrayList;
public class Ship {
	String shipClass;
	ArrayList<Point> location;
	ArrayList<Point> injuredCells;
	String state = new String("Цел");
	int length;
	
	public Ship(String s){
		shipClass = s;
		switch(s){
			case ("huge"): length = 4;
			case ("big"): length = 3;
			case ("middle"): length = 2;
			case ("little"): length = 1;
		}
	}
	public void setShipClass(String s){
		String name = new String();
		switch (name){
		case ("huge"): shipClass = s;
		break;
		case ("big"): shipClass = s;
		break;
		case ("middle"): shipClass = s;
		break;
		case ("little"): shipClass = s;
		break;
		default: System.out.println("Ошибка в названии класса корабля");	
		}
	}
	public void setLocation(ArrayList<Point> arp){
		location = arp;
	}
	public void addInjuredCell(Point p){
		injuredCells.add(p);
	}
	public void setState(String s){
		state = s;
	}
	public void setLength(int l){
		length = l;
	}
	public String getShipClass(){
		return shipClass;
	}
	public ArrayList<Point> getLocation(){
		return location;
	}
	public ArrayList<Point> getInjuredSells(){
		return injuredCells;
	}
	public String getState(){
		return state;
	}
	public int getLength(){
		return length;
	}
	public String selfCheck(Point p){
		String report = new String("Мимо");
		if(location.contains(p) && injuredCells.isEmpty()){
			state = "Повреждён";
		}
		if(location.contains(p)){
			injuredCells.add(p);
			report = "Попал";
		}
		if(location == injuredCells){
			state = "Потоплен";
			report = "Потопил";
		}
		return report;
	}


}
