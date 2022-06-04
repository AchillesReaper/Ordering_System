package orderingSystem;
import java.util.Scanner;

public class Customer {

	
	
	public static void main(String[] args) {
		boolean nod_test = false;	
		String orderType;
		String newOrder;
		String customerType;
		
		while (!nod_test) {
		String[] iniOrder = setOrderType();
		orderType = iniOrder[0];
		System.out.println("\nThe order is "+ orderType.toUpperCase()+"\n");
		if (orderType.equals("order_void")) {
			nod_test = false;			
		}else {
			nod_test = true;
		}
		
		newOrder = "nod001"; //order number is ready for the collection of transactions (the new order)
		
			if (nod_test) {			
				System.out.println("Select your food? Y/N");
				Scanner ptOrder =new Scanner(System.in);
				String PtoOrder = ptOrder.next();				
				
				if (PtoOrder.equals("y")|| PtoOrder.equals("Y")) {
					CustomerOrder newTrasc = new CustomerOrder();				// new transaction created when customer want to order new item
					
					int i = 1;				
					while (PtoOrder.equals("y")|| PtoOrder.equals("Y")) {
						
						String tscNo = newOrder + "_" + String.valueOf(i); //transaction number created
						String nt[] = Customer.setOrder();
						int odAmount = Integer.parseInt(nt[3]);
						
						newTrasc.setTransactionNumber(tscNo);
						newTrasc.setOrderType(orderType); // order type assigned
						newTrasc.setOrderNumber(newOrder);
						newTrasc.setFoodType(nt[0]);
						newTrasc.setContent(nt[1]);
						newTrasc.setSize(nt[2]);
						newTrasc.setAmount(odAmount);
						
						Mysql_1Control.newTransaction(newTrasc); // transaction is recorded by the database
						
						i +=1;
						System.out.println("Order another food? \n Yes: order new food.\n No: Check my Cart.");
						Scanner nfOrder =new Scanner(System.in);
						PtoOrder = nfOrder.next();															
					}
					System.out.println("you have below items in your cart");
					Mysql_1Control.checkMyCart(newOrder);
					boolean ordcnf = false;
					System.out.println("plaese confirm you order: \nY: go to payment \nNo: edit the order");
					Scanner cnfored =new Scanner(System.in);
					PtoOrder = cnfored.next();
					while (PtoOrder.equals("n")|| PtoOrder.equals("N")) {
						System.out.println("plaese select the item you want to remove");
						Scanner rmtsc =new Scanner(System.in);
						PtoOrder = rmtsc.next();
						Mysql_1Control.deleteOneTsc(PtoOrder);
						System.out.println("you have below items in your cart");
						Mysql_1Control.checkMyCart(newOrder);
						System.out.println("plaese confirm you order: \nYes: go to payment \nNo: edit the order");
						PtoOrder = cnfored.next();
					}
					
					customerType = setCustomerType();
					Mysql_1Control.confirmCustomerType(newOrder,customerType);
						
					}else {
					nod_test = false;					
				}
					
				}
			}
		}
				

		
			
		
	
	
	public static String[] setOrderType() {
		String OT;
		String pickUpTime ="";
		String dLocation = "";
				
		Scanner sc =new Scanner(System.in);
		System.out.println("Please enter orderType: \ndine-in/ takeaway/ delivery ?");
		OT = sc.next();
				
		//switch statement
		switch (OT){			
			case "dine-in":
				break;
			
			case "takeaway":
				System.out.println("How long (hour) are you expected to pick up? ");
				pickUpTime = sc.next();
				System.out.println("Pick-up time is expected to be in " + pickUpTime+ "hours");
				break;
			
			case "delivery":
				System.out.println("How long (hour) are you expected to pick up? ");
				pickUpTime = sc.next();
				System.out.println("Enter your location or Distance/km :");
				double distance = sc.nextDouble();
				if (distance > 10){
					System.out.println("Sorry, it is a bit far. We cannot take your order.");
					OT = "order_void";
				}else{
					System.out.println("Your meal is expected to be delivered in " + pickUpTime+ "hours");
					dLocation = String.valueOf(distance);
				break;
				}
			default:
				OT = "order_void";
				System.out.println("Sorry, no such order type.");
				break;
			}
			String[] OToutput = {OT,pickUpTime,dLocation};
			return OToutput;
		}

	
	public static String[] setOrder() {
		//enter new transaction
		String ntFType = "";
		String ntContent = "";
		String ntSize = "";
		String ntAmount = "0";
				
		Scanner sc =new Scanner(System.in);
		
		
		
		System.out.println("Please select food type: \npizza / side options ?");
		ntFType = sc.next();
		switch (ntFType) {
			case "pizza":
				System.out.println("Please select the base: \nTraditional/ Wholemeal/ GluteenFree?");
				String pzBase = sc.next();
				System.out.println("Please select the topping: \nSupreme/ SausageSizzle/ Hawaiin / Chicken / VeggieLovers ?");
				String pzTop = sc.next();
				System.out.println("Please select the sauce: \nTomato/ BBQ ?");
				String pzSauce = sc.next();
				System.out.println("Please select the size: \nSmall/ Medium/ Large ?");
				String pzSize = sc.next();
				ntContent = "Base: "+ pzBase + "; Topping: " + pzTop + "; Sauce: " + pzSauce;
				ntSize = pzSize;
				System.out.println("Please select amount: ");
				ntAmount = sc.next();				
				break;
			case ("side"):
				System.out.println("Please select the side options: \n Pasta / ChickenWings / GarlicBread / Drink?");
				ntContent = sc.next();
				System.out.println("Please select amount: ");
				ntAmount = sc.next();				
				break;
				default:
					System.out.println("sorry no such type of food");
					ntContent = "****FoodType not avalable ****";
		}		
		String newTransc[] = {ntFType, ntContent, ntSize, ntAmount};
		return newTransc;
		}
		
	
	
	public static String setCustomerType() {
		//this method will return customer type for discount calculation
		String ctmType;
		String verified;
		Scanner sc =new Scanner(System.in);
	
		System.out.println("please select client type:");
		System.out.println("student/ member/ groupBooking/ staff/ NA");
		ctmType = sc.next();
		switch (ctmType) {
		case "student":
			System.out.println("please show your student card");
			System.out.println("customer showed student card? Y/N");
			verified = sc.next();
			if (verified.equals("y")||verified.equals("Y")) {
				System.out.println("customer type verified.");							
			}else {
				ctmType = "NA";
				System.out.println("customer type is not verified.");
				System.out.println("discount = 0");
			}
			break;
		
		case "member":
			System.out.println("please show your Loyalty card");
			System.out.println("customer showed Loyalty card? Y/N");
			verified = sc.next();
			if (verified.equals("y")||verified.equals("Y")) {
				System.out.println("customer type verified");							
			}else {
				ctmType = "NA";
				System.out.println("customer type is not verified.");
				System.out.println("discount = 0");
			}
			break;
		
		case "groupBooking":
			System.out.println("please provide your phone number");
			System.out.println("customer phone number matched? Y/N");
			verified = sc.next();
			if (verified.equals("y")||verified.equals("Y")) {
				System.out.println("customer type verified");							
			}else {
				ctmType = "NA";
				System.out.println("customer type is not verified.");
				System.out.println("discount = 0");
			}
			break;
		
		case "staff":
			System.out.println("please show your employee discount card");
			System.out.println("customer show employee discount card? Y/N");
			verified = sc.next();
			if (verified.equals("y")||verified.equals("Y")) {
				System.out.println("customer type verified");							
			}else {
				ctmType = "NA";
				System.out.println("customer type is not verified.");
				System.out.println("discount = 0");
			}
			break;
			
		case "NA":
			break;
			
		default:
			ctmType = "NA";
			System.out.println("no such type of customer.");

		}
		System.out.println("The customer type is set to be " + ctmType.toUpperCase());
		return ctmType;
	}

}

