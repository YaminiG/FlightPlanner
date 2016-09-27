package class8;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
//
//import javax.print.attribute.standard.Fidelity;

public class PlaneGraph {

	ArrayList<City>city;

	public PlaneGraph(){
		city=new ArrayList<City>();
	}


	public void print() {
		for (City v: city) {
			v.print();
		}
	}

	

	public boolean isEmpty() {
		if (numOfCity() == 0)
			return true;
		return false;
	}

	public int numOfCity() {
		return city.size();
	}

	public City getCity(String  C){
		for(City c:city){
			if(c.getFromCity().equals(C)){
				return c;
			}
		}
		return null;
	}

	public void addCity(String C){
		if(getCity(C)!=null){
			return ;
		}
		City c=new City(C);
		city.add(c);
		System.out.println(c.name);
	}

	public void addFlightInfo(String from,String to,int depTime,int arrTime,String name,int cost){

		//System.out.println(from+"  "+to+ " " +depTime+"  "+arrTime+" " +name+" "+cost);
		addCity(from);
		addCity(to);

		City From=getCity(from);
		City To=getCity(to);

		FlightInfo FI=new FlightInfo(From, To, depTime, arrTime, name, cost);
		From.addFlightInfo(FI);

	}

	public int minimumFair(String From, String To,int tripStart, int tripEnd) throws Exception {
		System.out.println(From+"  "+To+ " " +tripStart+"  "+tripEnd+" " );
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		City c1 = getCity(From);
		City c2 = getCity(To);
		//String name =name;
		if (c1 == null || c2 == null){
			int output=-1;
			return output;
		}

		QueueUsingLL<PairInfo> pendingCity = new QueueUsingLL<>();
		PairInfo PI=new PairInfo(c1,c1,tripStart-30,tripStart-30,0,0 );
		pendingCity.enqueue(PI);

		int Costsum=0;

		HashMap<City, Boolean> visited = new HashMap<>();
		//City previous=c1;
		int totalSum=0;
		int mark=0;
		while (!pendingCity.isEmpty()) {
			PairInfo front = pendingCity.dequeue();
			tripStart=front.arrTime;
			City front1=front.At;
			Costsum=front.totalSum+front.cost;
			
			ArrayList<FlightInfo> adjacent = front1.getConnectedCityAfterTimeT(tripStart+30 );

			//visited.put(front.At, true);

			int temp=0;
			

			if(adjacent!=null){
				for (FlightInfo c: adjacent){

					int arrTime=c.arrTime;
					//System.out.println(arrTime+"loop"+c.too.name+" "+c.cost);
					if(c.too.name.equals(To)&&arrTime<=tripEnd){
						
						pq.insert((Costsum+c.cost), 1);
						
						temp=1;
						mark=1;
					}

				}
				if(temp==0){
					for (FlightInfo c: adjacent){
						if(!visited.containsKey(c)){
							if(c.arrTime<=tripEnd){
								totalSum=Costsum;
								City C=c.too;
								City FRO=c.from;
								//System.out.println(c.from.name+" "+c.too.name+" "+c.depTime+" "+c.arrTime+" "+c.cost);
								PairInfo PII=new PairInfo(C,FRO, c.depTime,c.arrTime,c.cost,totalSum);
								PII.visited.put(FRO, true);
								pendingCity.enqueue(PII);
								//Costsum=Costsum-front.cost;

							}
						}
					}
				}
			}
		
		}
		if(mark==0){
			pq.insert(-1, 1);
		}
		int output=pq.getMin().priority ;

		return output;
	}

}


//	
//	public Comparison findingAllPossiblePathSum(City From, int tripStart,City To,int tripEnd,int totalSum,ArrayList<Integer>totalCostInEachPath,HashMap<City, Boolean> visited,Comparison comparison){
//
//
//		City front = From;
//		ArrayList<City>ConnectedCity=new ArrayList(front.getConnectedCityAfterTimeT(tripStart));
//
//		
//		//doubt in visited
//		visited.put(front, true);
//		System.out.println(From.name);
//
//
//		for(City C:ConnectedCity){
//			System.out.println("yes");
//			System.out.println(C.name);
//			comparison=findingAllPossiblePathSum(C, 30, To,tripEnd,totalSum,totalCostInEachPath,visited,comparison);
//			
//			
////			if(C.name.equals(To.name)){
////				System.out.println("yes3");
////				int arrTime=front.arrivalTimeAt(C);
////				if(arrTime>tripEnd){
////					System.out.println("timeout1");
////					comparison.first=20000;
////					if(comparison.second>comparison.first){
////						int temp=comparison.first;
////						comparison.first=comparison.second;
////						comparison.second=temp;
////					}
////					System.out.println(comparison.first+"  "+comparison.second+" else1");
////					return comparison;
////				}
////				System.out.println("total sum "+totalSum);
////				
////				comparison.first=totalSum;
////				if(comparison.second>comparison.first){
////					int temp=comparison.first;
////					comparison.first=comparison.second;
////					comparison.second=temp;
////				}
////				System.out.println(comparison.first+"  "+comparison.second+" else12");
////				return comparison;
//////				totalCostInEachPath.add(totalSum);
//////				return totalCostInEachPath;
////			}else{
////				{
////					System.out.println("yes1");
////					
////					if (!visited.containsKey(C)) {
////						
////						System.out.println("yes2");
////						
////						totalSum+=front.getCost(C);
////						int arrTime=front.arrivalTimeAt(C);
////						System.out.println("arrtime"+arrTime);
////						
////						if(arrTime+30>tripEnd){
////							System.out.println("timeout2");
////							comparison.first=10000;
////							if(comparison.second>comparison.first){
////								int temp=comparison.first;
////								comparison.first=comparison.second;
////								comparison.second=temp;
////							}
////							System.out.println(comparison.first+"  "+comparison.second+" if");
////							return comparison;
////						}
////						System.out.println("timeoutnil");
////						comparison=findingAllPossiblePathSum(C, arrTime+30, To,tripEnd,totalSum,totalCostInEachPath,visited,comparison);
////					}
////				}
////			}
//		}
//		System.out.println("yes4");
//		comparison.first=9999;
//		if(comparison.second>comparison.first){
//			int temp=comparison.first;
//			comparison.first=comparison.second;
//			comparison.second=temp;
//		}
//		System.out.println(comparison.first+"  "+comparison.second+" end");
//		
//		return comparison;
//	}

//	public int minimumFair(String from,String to,int tripStart,int tripEnd){
//		HashMap<City, Boolean> visited = new HashMap<>();
//		City From=getCity(from);
//		City To=new City(to);
//		ArrayList<Integer>totalCostInEachPath=null;
//		int totalSum=0;
//		Comparison comparison=null;
//		comparison=findingAllPossiblePathSum(From, tripStart, To,tripEnd,totalSum,totalCostInEachPath,visited,comparison);
//
//		return comparison.second;
//
//	}


//			ArrayList<FlightInfo> adjacentCheck = front.From.getConnectedCityAfterTimeT(0);
//			for(FlightInfo check:adjacentCheck){
//				int mark=0;
//				int amount=0;
//				if(check.too==FROM){
//					amount=check.cost;
//					mark=1;
//				}
//				if(check.too==front.At){
//					mark=2;
//				}
//				if(mark==2){
//					Costsum=Costsum- amount ;
//					visited.remove(FROM);
//				}
//			}

//public void printAdjacent(String C){
//		City c=new City(C);
//		c.print();
//	}



