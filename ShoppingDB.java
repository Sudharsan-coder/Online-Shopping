import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ShoppingDB {

	private static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/shopping";
	private static String username = "sudharsan";
	private static String password = "password";
	private static PreparedStatement pst=null;
	private static String query;
	private static ResultSet resultSet=null;
	private static Statement statement;

	static{

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			statement = connection.createStatement();

			query = "CREATE TABLE IF NOT EXISTS Product(product_name varchar(20),product_price int,available_Quantity int,discount int)";
			pst = connection.prepareStatement(query);
			pst.executeUpdate();		
		}
		catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		catch(SQLException e){
			System.out.println(e);
		}

	}

	/*static
	{
		try{
			pst = connection.prepareStatement("SELECT * FROM Product");
			resultSet = pst.executeQuery();
			while(resultSet.next()){

			}
		}
	}*/

	public static boolean addProduct(Product product) throws SQLException{
		query = "INSERT INTO Product(product_name,product_price,available_quantity,discount)VALUES('"+product.getProductName()+"','"+product.getPrice()+"','"+product.getAvailableQuantity()+"','"+product.getDiscount()+"')";
		int result = statement.executeUpdate(query);
		return (result>0) ? true : false;
	}

	public static void removeProduct(String productName) throws SQLException{

		query = "DELETE FROM Product where product_name = '"+productName+"'";
		int result = statement.executeUpdate(query);
	}

	public static void getProduct() throws SQLException{

		query = "SELECT * FROM Product";
		resultSet = statement.executeQuery(query);

		while(resultSet.next()){
			getProductDetails(resultSet);
		}
	}
	
	public static void getProductDetails(ResultSet resultSet) throws SQLException{

		String productName = resultSet.getString(1);
		int price = resultSet.getInt(2);
		int availableQuantity = resultSet.getInt(3);
		int discount = resultSet.getInt(4);
		
		Product product = new Product(productName,price,availableQuantity,discount);
		
		OnlineShopping.productList.add(product);
	}
}
