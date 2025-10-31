package v8;

public class Movie {

	private String _title;
	private Price	_price;

	public Movie(String title, Price price) {
		_title = title;
		_price = price;
	}

	public String getTitle() {
		return _title;
	}

	public Price getPrice()
	{
		return _price;
	}
}
