
public class Product {

		private String productName;
		private int price;
		private int availableQuantity;
		private int discount;
		public Product(String productName, int price, int availableQuantity,
				int discount) {
			super();
			this.productName = productName;
			this.price = price;
			this.availableQuantity = availableQuantity;
			this.discount = discount;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getAvailableQuantity() {
			return availableQuantity;
		}
		public void setAvailableQuantity(int availableQuantity) {
			this.availableQuantity = availableQuantity;
		}
		public int getDiscount() {
			return discount;
		}
		public void setDiscount(int discount) {
			this.discount = discount;
		}				
}
