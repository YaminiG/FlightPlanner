package class8;

import java.util.ArrayList;
import java.util.Hashtable;

public class City {

	String name;
	ArrayList<FlightInfo>connectedNext;

	public City(String name){
		this.name=name;
		connectedNext=new ArrayList<FlightInfo>();
	}


	public String getFromCity() {
		return name;
	}

	public int numberOfFlight(){
		return connectedNext.size();
	}


	public void addFlightInfo(FlightInfo FI){
		connectedNext.add(FI);
//		for(FlightInfo Fi:connectedNext){
//			//System.out.println(Fi.too.name);
//		}
		
	}

	public ArrayList<FlightInfo> getConnectedCityAfterTimeT(int T){
		ArrayList<FlightInfo>adjacent=new ArrayList<FlightInfo>();
		if(connectedNext==null){
			return null;
		}else{
		for(FlightInfo FI:connectedNext){
			if(FI.depTime>=T){
				//System.out.println(FI.too.name);
				FlightInfo PI=new FlightInfo(FI.from,FI.too,FI.depTime,FI.arrTime,FI.name,FI.cost);
			//	System.out.println(FI.from.name+" "+FI.too.name+" "+FI.depTime+" "+FI.arrTime+" "+FI.cost+"nilesh");
				adjacent.add(PI);
			}
		}
		return adjacent;
		}
	}

	public int DepTime(City To){
		for(FlightInfo c:connectedNext){
			if(c.too==(To)){
				return c.depTime;
			}
		}
		return -1 ;
	}
	
	//    public int arrivalTimeAt(City C,int depTime){
	//    	int time=0;
	//    	for(FlightInfo FI:connectedNext){
	//    		if(FI.depTime==depTime&&FI.to==C){
	//    			time= FI.arrTime;
	//    		}
	//    	}
	//		return time;
	//    	
	//    }

	//assumption one flight run from A to B in a day
	public int arrivalTimeAt(City C){
		int time=0;
		for(FlightInfo FI:connectedNext){
			if(FI.too==C){
				time= FI.arrTime;
			}
		}
		return time;

	}


	public int getCost(City to){
		int cost=0;
		for(FlightInfo FI:connectedNext){
			if(FI.too==to){
				cost= FI.cost;
			}
		}
		return cost;
	}

	public void print() {
		
		
		// TODO Auto-generated method stub
		for(FlightInfo fi:connectedNext){
			System.out.println(fi.from.name+" "+fi.too.name+" "+fi.depTime+" "+fi.arrTime+" "+fi.name+" "+fi.cost+"yes");
		}
	}


	//	public ArrayList<City>getConnectedCity(){
	//
	//		for(FlightInfo FI:connectedNext){
	//			Hashtable<City, int>visited
	//		}
	//	}


	//	public String getDepTime(City ){
	//
	//	}

}
