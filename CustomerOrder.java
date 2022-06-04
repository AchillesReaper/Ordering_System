package orderingSystem;

public class CustomerOrder{
	private String transactionNumber;
//	CustomrOrder is a collection of transactions
//	each transaction is an object of CustomerOrder
//	the operation of this method is simplified
//	the outcome is made directly
	private String orderType;	
	private String orderNumber;
	private String foodType;
	private String content;
	private String size = "null";
	private int amount = 0;
	private double price = 0;

	
	public void setTransactionNumber(String tscNo) {
		this.transactionNumber = tscNo;
	}
	public String getTransactionNumber() {
		return this.transactionNumber;
	}
	
	public void setOrderType (String newOT) {
		this.orderType = newOT;		
	}
	public String getOrderType() {
		return this.orderType;
	}
	
	public void setOrderNumber (String newOrder) {
		this.orderNumber = newOrder;		
	}
	public String getOrderNumber() {
		return this.orderNumber;
	}
	
	public void setFoodType (String ft) {
		this.foodType = ft;
	
	}
	public String getFoodType() {
		return this.foodType;
	}
	
	public void setContent (String c) {
		this.content = c;		
	}
	public String getContent() {
		return this.content;
	}
	
	public void setSize (String s) {
		this.size = s;		
	}
	public String getSize() {
		return this.size;
	}
	
	public void setAmount (int a) {
		this.amount = a;		
	}
	public int getAmount() {
		return this.amount;		
	}
	
	public double getPrice () {
		double sPrice = 0;
		switch (this.foodType) {
			case "pizza":				
				switch (size) {
				case "s":
					sPrice = 16;
					break;
				case "m":
					sPrice = 18;
					break;
				case "l":
					sPrice = 20;
					break;
				}
				break;
			case "side":
				sPrice = 2;
				break;
				default:
					sPrice = 0;
			}
		this.price = sPrice * this.amount;
		return this.price;		
	}			
	

	}
	

	
	
