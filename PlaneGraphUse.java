package class8;

public class PlaneGraphUse {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		PlaneGraph pg=new PlaneGraph();
		
		pg.addFlightInfo("1" , "2" , 200 ,400 ,"AI1204" ,10000);
		pg.addFlightInfo("2",  "5" , 500, 600, "AI5647", 3000);
		pg.addFlightInfo("1","3",  0 ,100,"AI6784", 3000);
		pg.addFlightInfo("3", "4",  300 ,500 ,"AI8756", 2000);
		pg.addFlightInfo("4","5",  600, 800 ,"AI6488", 3000);
		pg.addFlightInfo("3",  "2", 200, 300 ,"AI9848", 5000);
		pg.addFlightInfo("3",  "5",  200 ,700, "AI1214", 7000);
		pg.addFlightInfo("6",  "7",  0, 300,"AI1204", 3000);
		pg.addFlightInfo("7", "9",  400, 500,"AI5647", 3000);
		pg.addFlightInfo("6",  "13", 100, 200, "AI6784", 1000);
		pg.addFlightInfo("13" ,"9",  300, 400,"AI8756", 8000);
		pg.addFlightInfo("6",  "8",  0 ,200, "AI6488", 1000);
		pg.addFlightInfo("8", "9", 300, 700, "AI9848", 1000);
		pg.addFlightInfo("9",  "10", 800, 1100,"AI1204", 3000);
		pg.addFlightInfo("10", "12", 1200, 1300 ,"AI5647", 3000);
		pg.addFlightInfo("9",  "14", 900, 1000, "AI6784", 1000);
		pg.addFlightInfo("14", "12", 1100 ,200,"AI8756 ",8000);
		pg.addFlightInfo("9",  "11", 800, 1000, "AI6488", 1000);
		pg.addFlightInfo("11", "12", 1100, 1500, "AI9848", 1000);
		pg.addFlightInfo("1",  "6", 100 ,200,"AI9645", 1000);
		pg.addFlightInfo("6", "5",  215, 330, "AI7865", 1000);
		pg.addFlightInfo("4",  "15", 0, 330, "AI8836", 3000);
		pg.addFlightInfo("3",  "15", 30, 700, "AI8736", 3000);
		pg.addFlightInfo("7",  "15", 20, 400,"AI8036", 3000);
		pg.addFlightInfo("9",  "15", 45, 330, "AI8136", 3000);
		
		
		
		pg.print();
		System.out.println("go");
		//pg.printAdjacent("1");
		int min=0;
		 min=pg.minimumFair( "1",  "5",  200, 600);
		System.out.println(min);
		
		 min=pg.minimumFair( "1",  "5",  0, 600);
		System.out.println(min);
		
		 min=pg.minimumFair( "1",  "5",  0, 700);
		System.out.println(min);
		
		 min=pg.minimumFair( "1",  "5",  0, 800);
		System.out.println(min);
		
		 min=pg.minimumFair( "1",  "5",  0, 400);
		System.out.println(min);
		
		 min=pg.minimumFair( "6",  "1",  0, 1500);
			System.out.println(min);
			
			 min=pg.minimumFair( "6",  "9", 0, 400);
				System.out.println(min);
				
				min=pg.minimumFair( "9",  "12", 800, 1400);
				System.out.println(min);
				
				min=pg.minimumFair( "6", "12", 0, 1200);
				System.out.println(min);
				
				min=pg.minimumFair("6", "12", 0, 1300);
				System.out.println(min);
	}

}
//13000
//11000
//10000
//8000
//-1
//-1
//9000
//6000
//11000
//8000


//1  5  0200 0600
//1  5  0000 0600
//1  5  0000 0700
//1  5  0000 0800
//1  5  0000 0400
//6  1  0000 1500
//6  9  0000 0400
//9  12 0800 1400
//6  12 0000 1200
//6  12 0000 1300
//
//
//1  2  0200 0400 AI1204 10000
//2  5  0500 0600 AI5647 3000
//1  3  0000 0100 AI6784 3000
//3  4  0300 0500 AI8756 2000
//4  5  0600 0800 AI6488 3000
//3  2  0200 0300 AI9848 5000
//3  5  0200 0700 AI1214 7000
//6  7  0000 0300 AI1204 3000
//7  9  0400 0500 AI5647 3000
//6  13 0100 0200 AI6784 1000
//13 9  0300 0400 AI8756 8000
//6  8  0000 0200 AI6488 1000
//8  9  0300 0700 AI9848 1000
//9  10 0800 1100 AI1204 3000
//10 12 1200 1300 AI5647 3000
//9  14 0900 1000 AI6784 1000
//14 12 1100 1200 AI8756 8000
//9  11 0800 1000 AI6488 1000
//11 12 1100 1500 AI9848 1000
//1  6  0100 0200 AI9645 1000
//6  5  0215 0330 AI7865 1000
//4  15 0000 0330 AI8836 3000
//3  15 0030 0700 AI8736 3000
//7  15 20 0400 AI8036 3000
//9  15 0045 0330 AI8136 3000