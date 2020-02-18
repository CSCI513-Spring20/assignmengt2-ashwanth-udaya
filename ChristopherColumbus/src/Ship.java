import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Ship extends Observable{
	List<Observer> observers = new LinkedList<Observer>();
	Point currentShipLocation;
    OceanMap oceanMap;
    int[][] myGrid;
    public void registerObserver(Observer o) {
		observers.add(o);
		
	}

	public void removeObserver(Observer o) {
		if(observers.contains(o))
			observers.remove(o);
		
	}

	public void notifyObservers() {
		for (Observer pirateShipObserver: observers)
			pirateShipObserver.update(this, pirateShipObserver);
		
	}
	public Ship(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.currentShipLocation = oceanMap.getShipLocation();
	    this.myGrid = oceanMap.getMap();
	}
	
	public Point getShipLocation() {
		return this.currentShipLocation;
	}
	
	public void goEast() {
		if (this.currentShipLocation.x<9) {
			if(this.myGrid[(this.currentShipLocation.x) + 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x=this.currentShipLocation.x+1;
				notifyObservers();
			}
		}
	}

	public void goWest() {
		if(this.currentShipLocation.x >0){
			if(this.myGrid[(this.currentShipLocation.x) - 1][this.currentShipLocation.y] != 1){
				this.currentShipLocation.x = this.currentShipLocation.x-1;
				notifyObservers();
			}
		}   
	}

	public void goNorth() {
		if(this.currentShipLocation.y>0){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y-1] != 1){
				this.currentShipLocation.y = this.currentShipLocation.y-1;
				notifyObservers();
			}
		}    
	}

	public void goSouth() {
		if(this.currentShipLocation.y<9){
			if(this.myGrid[this.currentShipLocation.x][this.currentShipLocation.y+1] != 1){
				this.currentShipLocation.y=this.currentShipLocation.y+1;
				notifyObservers();
			}
		} 
	}

	
}