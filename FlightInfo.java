package class8;

public class FlightInfo {

	String name;
	City from;
	City too;
	int depTime;
	int arrTime;
	int cost;

	public FlightInfo(City from,City too,int depTime,int arrTime,String name,int cost){
	
		this.from=from;
		this.too=too;
		this.depTime=depTime;
		this.arrTime=arrTime;
		this.name=name;
		this.cost=cost;
}
}
