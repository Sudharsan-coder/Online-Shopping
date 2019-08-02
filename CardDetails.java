
public class CardDetails {

	private int cardNumber;
	private int pinNumber;
	private int cvvNumber;
	private String cardHolderName;
	public CardDetails(int cardNumber, int pinNumber, int cvvNumber,
			String cardHolderName) {
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
		this.cvvNumber = cvvNumber;
		this.cardHolderName = cardHolderName;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public int getCvvNumber() {
		return cvvNumber;
	}
	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", pinNumber="
				+ pinNumber + ", cvvNumber=" + cvvNumber + ", cardHolderName="
				+ cardHolderName + "]";
	}		
}
