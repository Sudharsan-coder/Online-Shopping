import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OnlineShopping {

	Scanner scanner = new Scanner(System.in);
	static List<Product> productList = new ArrayList<Product>();
	List<Product> productListFromCart = new ArrayList<>();
	public String doLogin(){
		String user = new String();
		System.out.println("Enter the Username: ");
		String username = scanner.nextLine();
		System.out.println("Enter the Password: ");
		String password = scanner.nextLine();

		if(username.equals("Admin1") && password.equals("admin1")){
			user = "Sudharsan";
			System.out.println("Welcome Admin");
		}else if(username.equalsIgnoreCase("Customer") && password.equalsIgnoreCase("customer")){
			user = "Customer";
			System.out.println("Welcome Customer");
		}

		return user;	
	}
	
	public void displayCustomerFunctionalities(List<Product> productList,List<Product> productListFromCart){
		Customer customer = new Customer();
		boolean temp = true;
		while(temp){
			System.out.println("1.Display Product List");
			System.out.println("2.Buy Product");
			System.out.println("3.Add Product To Cart");
			System.out.println("4.Display Product List From Cart");
			System.out.println("5.Buy Product From Cart");
			System.out.println("6.Exit");
			int choice = scanner.nextInt();
			switch(choice){
			case 1 : customer.displayProductList(productList);
					 break;
			
			case 2 : customer.buyProduct(productList);
					 break;
			
			case 3 : customer.addProductToCart(productListFromCart, productList);
					 break;
			
		    case 4 : customer.displayProductListFromCart(productListFromCart);
		    		 break;
		    		 
		    case 5 : customer.buyProductFromCart(productListFromCart);
		    		 break;
		    		 
		    default : temp = false;
		    		  break;
			}			
		}
	}
	
	public void displayAdminFunctionalities(List<Product> productList) throws SQLException{
		Admin admin = new Admin();
		boolean temp=true;
		while(temp){
			System.out.println("1.Add Product");
			System.out.println("2.Remove Product");
			System.out.println("3.Display Product List");
			System.out.println("4.Apply Discount for Product");
			System.out.println("5.Add Card Details");
			System.out.println("6.Exit");

			System.out.println("Please enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice){

			case 1 : admin.addProduct(productList);    
			break;

			case 2 : System.out.println("Enter the product name you want to remove");
			String proName = scanner.nextLine();
			admin.removeProduct(proName,productList);
			break;

			case 3 : admin.displayProductList(productList);
			break;

			case 4 : System.out.println("Enter the name of the product to set discount");
			String productName = scanner.nextLine();

			System.out.println("Enter the Discount Amount");
			int discountAmount = scanner.nextInt();

			admin.applyDiscountForProduct(productName, productList, discountAmount);
			break;

			case 5 : admin.addCardDetails();
			break;	

			default :
				temp=false;
				break;
			}
		}
	}

	public static void main(String[] args) throws SQLException{
		ShoppingDB shoppingdb=new ShoppingDB();
		shoppingdb.getProduct();
		Scanner scanner = new Scanner(System.in);      
		OnlineShopping onlineShopping = new OnlineShopping();
		
		
		while(true){		
			System.out.print("1.Admin ");
			System.out.print("2.Customer ");
			System.out.println("3.Exit");
			System.out.println("Please enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice){
                                  
			case 1 : String user = onlineShopping.doLogin();
			if(user.equals("Sudharsan")){ 
				onlineShopping.displayAdminFunctionalities(OnlineShopping.productList);
				break;
			}		

			case 2 : String user1 = onlineShopping.doLogin(); 
			if(user1.equals("Customer")){
				onlineShopping.displayCustomerFunctionalities(OnlineShopping.productList,onlineShopping.productListFromCart);
				break;
			}
			
			default: System.out.println("Thank You!!");
				System.exit(0);
				break;
			}
		}
	}

}
