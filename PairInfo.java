package class8;

import java.util.HashMap;

public class PairInfo {

	City At;
	City From;
	//City adjacentCity;
	int depTime;
	int arrTime;
	int cost;
	int totalSum;
	HashMap<City, Boolean> visited =new HashMap<City, Boolean>();
	
	//String name;
	public PairInfo(City At,City From,int depTime,int arr,int cost,int totalSum){
		this.At=At;
		this.From=From;
		this.depTime=depTime;
		this.cost=cost;
		this.arrTime=arr;
		this.totalSum=totalSum;
		
//		this.name=name;
	}
	
}
