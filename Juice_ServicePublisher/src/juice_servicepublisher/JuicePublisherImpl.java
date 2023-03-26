package juice_servicepublisher;

import java.util.HashMap;
import java.util.Scanner;

import com.Strings;


public class JuicePublisherImpl implements juicePublisher {

	@Override
	public Juice menu() {
		Strings STRING = new Strings();
		String another= "N";
		String buyOrNO;
		
		HashMap<Integer, Integer> itemList = new HashMap<Integer, Integer>();
		
		itemList.put(1,0);
		itemList.put(2,0);
		itemList.put(3,0);
		itemList.put(4,0);
		itemList.put(5,0);
		itemList.put(6,0);
		
		double amount = 0;
		double total = 0.0;
		int count = 1;
		int type;
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(STRING.BANNER);
		System.out.println();
		System.out.println(STRING.JUICE_MENU);
		
		do {
			do {
				System.out.print(STRING.SELECT_JUICE);
				type = sc.nextInt();
				amount = calculations.typeselect(type);
			}while(amount == 0);
			
			System.out.print(STRING.NO_OF_ITEMS);
			count = sc.nextInt();
			
			itemList.put(type,count);
			
			total += calculations.getTotal(count,amount);
			System.out.println();
			System.out.println("Total : "+total);
			
			System.out.println(STRING.ANOTHER);
			another = sc.next().toString();
			
		}while(!another.equalsIgnoreCase("N"));
		
		System.out.println(STRING.BUY_RESPONSE);
		buyOrNO = sc.next().toString();
		
		System.out.println("Your Total Amount is : "+total);
		
//		for(int i=0;i<=5;i++) {
//			
//		}
//		sc.close();
		Juice juice = new Juice(buyOrNO, itemList);
		return juice;
	}
	

}
