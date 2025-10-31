package v3;

public class Movie {

	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE};
	
	private String _title;
	private Code _priceCode;
	
	public Movie(String title, Code priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public String getTitle() {
		return _title;
	}

	public Code getPriceCode() {
		return _priceCode;
	}
}
