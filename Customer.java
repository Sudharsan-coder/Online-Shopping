import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Customer {
	
	Scanner input = new Scanner(System.in);
	Admin admin = new Admin();
	
	public Map<String,Product> getProductMap(List<Product> productList){
		Map<String,Product> productMap = new HashMap<>();
		for(Product product : productList){
			productMap.put(product.getProductName(), product);
		}		
		return productMap;		
	}
    
	public void displayProductList(List<Product> productList){
		for(Product product : productList){
			System.out.println("Product Name : "+product.getProductName());
			System.out.println("Product Price : "+product.getPrice());
			System.out.println("Available Quantity :"+product.getAvailableQuantity());
		}
	}
	
	public void addProductToCart(List<Product> productListFromCart,List<Product> productList){
		Map<String,Product> productMap = getProductMap(productList);
		System.out.println("Enter the name of product you want to add");
		input.nextLine();
		String productName = input.nextLine();
		
		
		if(productMap.containsKey(productName)){
			productListFromCart.add(productMap.get(productName));
			System.out.println("Product Successfully added to your cart");
		}else{
			System.out.println("Product is not available. Please choose the product which is available");
		}
	}
	
	public void displayProductListFromCart(List<Product> productListFromCart){
		for(Product product : productListFromCart){
			System.out.println("Product Name : "+product.getProductName());
			System.out.println("Product price : "+product.getPrice());
			System.out.println("Product Available Quantity : "+product.getAvailableQuantity());
		}
	}
	
	public void buyProduct(List<Product> productList) {
		Map<String, Product> productMap = getProductMap(productList);
		System.out.println("Enter the product name you want to buy");
		input.nextLine();
		String productName = input.nextLine();
		
		
		if(productMap.containsKey(productName) && productMap.get(productName).getAvailableQuantity()>0){
			System.out.println("true it contains");
			Product product = productMap.get(productName);
			if(makePayment(product)){
				System.out.println("Payment Successfull");
				System.out.println("You have bought the "+productName);
				int availableQuantity = product.getAvailableQuantity()-1;
				product.setAvailableQuantity(availableQuantity);
			}else{
				System.out.println("Invalid Card Details");
				buyProduct(productList);
			}
		}else{
			System.out.println("This product is currently unavailable.please check after some time");
		}

	}
	
	public void buyProductFromCart(List<Product> productListFromCart) {
		Map<String, Product> productMap = getProductMap(productListFromCart);
		System.out.println("Enter the product name you want to buy");
		input.nextLine();
		String productName = input.nextLine();
				
		if(productMap.containsKey(productName) && productMap.get(productName).getAvailableQuantity()>0){
			System.out.println("true it contains");
			Product product = productMap.get(productName);
			if(makePayment(product)){
				System.out.println("Payment Successfull");
				System.out.println("You have bought the "+productName);
				int availableQuantity = product.getAvailableQuantity()-1;
				product.setAvailableQuantity(availableQuantity);
			}else{
				System.out.println("Invalid Card Details");
				buyProduct(productListFromCart);
			}
		}else{
			System.out.println("This product is currently unavailable.please check after some time");
		}

	}
	
	public boolean makePayment(Product product){
		int price = product.getPrice();
		if(product.getDiscount()>0){
			System.out.println("Discount Amount: "+product.getDiscount());
			price -= product.getDiscount();
		}
		System.out.println("Total Price: "+price);
		
		System.out.println("Please Enter the Amount: ");
		int amountNeedsToPay = input.nextInt();
		if(amountNeedsToPay == price){
			return true;
		}
		return false;
	}	
	
}
