import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Admin {

	Scanner scanner = new Scanner(System.in);
	private static List<CardDetails> cardDetailsList = new ArrayList<>();


	public void addProduct(List<Product> productList) throws SQLException{
		System.out.println("Product Name: ");
		String productName  = scanner.nextLine();
		System.out.println("Product Price: ");
		int productPrice = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Available Quantity: ");
		int availableQuantity = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Discount Amount: ");
		int discountAmount = scanner.nextInt();
		scanner.nextLine();

		Product product = new Product(productName,productPrice,availableQuantity,discountAmount);
		productList.add(product);
		ShoppingDB.addProduct(product);
		System.out.println("Product has been added successfully");		 
	}

	public Map<String,Product> getProductMap(List<Product> productList){
		Map<String,Product> productMap = new HashMap<>();
		for(Product product : productList){
			productMap.put(product.getProductName(), product);
		}
		return productMap;
	}
	

	public void removeProduct(String productName,List<Product> productList) throws SQLException{
		Map<String,Product> productMap = getProductMap(productList);		
		if(productMap.containsKey(productName)){
			productList.remove(productMap.get(productName));
			System.out.println("product has been removed successfully");   
		}else{
			System.out.println("product is not available to remove");
		}
		ShoppingDB.removeProduct(productName);
	}

	public void displayProductList(List<Product> productList){
		int count = 1;
		System.out.println("The List of Products are: ");
		
		for(Product product : productList){
			System.out.println("No:"+count+"- Name: "+product.getProductName()+" Price: "+product.getPrice());
			count++;
		}

	}

	public void applyDiscountForProduct(String productName,List<Product> productList,int discountAmount){
		Map<String,Product> productMap = getProductMap(productList);
		productMap.get(productName).setDiscount(discountAmount);
	}

	public void addCardDetails(){
		System.out.println("Card Number ");
		int cardNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Pin Number ");
		int pinNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("CVV Number ");
		int cvvNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Card Holder Name");
		String cardHolderName = scanner.nextLine();
		CardDetails cardDetail = new CardDetails(cardNumber,pinNumber,cvvNumber,cardHolderName);
		cardDetailsList.add(cardDetail);
		Iterator list = cardDetailsList.iterator();
		while(list.hasNext()){
			System.out.println(list.next());
		}
		System.out.println("Card Details successfully added");
	}

	public static boolean isCardDetailsValid(CardDetails cardDetails){
		boolean iscardDetailsValid=false;
		System.out.println("method works");
		for(CardDetails cardDetail : cardDetailsList){
			if(cardDetail.getCardNumber() == cardDetails.getCardNumber() && cardDetail.getPinNumber() == cardDetails.getPinNumber())
				if( cardDetail.getCvvNumber() == cardDetails.getCvvNumber() && cardDetail.getCardHolderName().equals(cardDetails.getCardHolderName())){
					iscardDetailsValid=true;
					break;
				}
		}
		return iscardDetailsValid;
	}
}
