import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer{
	Point currentShipPosition; //Current position of the ship
	Point currentPirateShipLocation, secondCurrentPirateShipLocation; //Current position of the pirate ship
    OceanMap oceanMap;
    int[][] myGrid;

    
	public PirateShip(OceanMap oceanMap) {
		this.oceanMap = oceanMap;
	    this.currentPirateShipLocation = oceanMap.getPirateShipLocation();
	    this.secondCurrentPirateShipLocation = oceanMap.getSecondPirateShipLocation();
	    this.myGrid = oceanMap.getMap();
	}
	
	public Point getPirateShipLocation() {
		return this.currentPirateShipLocation;
	}
	
	public Point getSecondPirateShipLocation() {
		return this.secondCurrentPirateShipLocation;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Ship){
			this.currentShipPosition = ((Ship)o).getShipLocation();
			movePirateShip();
		  }
		
	}
	
	public void movePirateShip(){  
		int CCShipx = this.currentShipPosition.x;
		int CCShipy = this.currentShipPosition.y;
		int PShipx = this.currentPirateShipLocation.x; 
		int Pshipy = this.currentPirateShipLocation.y;
		
		if (PShipx <9 && (PShipx - CCShipx < 0)) {
			if(this.myGrid[(PShipx) + 1][Pshipy] != 1) {
				this.currentPirateShipLocation.x=this.currentPirateShipLocation.x+1;
				this.secondCurrentPirateShipLocation.x=this.secondCurrentPirateShipLocation.x+1;
			}
		}
		else if(PShipx>0 && (PShipx - CCShipx > 0)){
			if(this.myGrid[(PShipx) - 1][Pshipy] != 1){
				this.currentPirateShipLocation.x=this.currentPirateShipLocation.x-1;
				this.secondCurrentPirateShipLocation.x=this.secondCurrentPirateShipLocation.x-1;
			}
		 }
		 
		if (Pshipy<9 && (Pshipy - CCShipy < 0)) {
			if(this.myGrid[PShipx][Pshipy+1] != 1){
				this.currentPirateShipLocation.y=this.currentPirateShipLocation.y+1;
				this.secondCurrentPirateShipLocation.y=this.secondCurrentPirateShipLocation.y+1;
			}
		 }
		 else if(Pshipy>0 && (Pshipy - CCShipy > 0)){
			 if(this.myGrid[PShipx][Pshipy-1] != 1) {
				 this.currentPirateShipLocation.y=this.currentPirateShipLocation.y-1;
				 this.secondCurrentPirateShipLocation.y=this.secondCurrentPirateShipLocation.y-1;
			 }
		 }	
	}
}
