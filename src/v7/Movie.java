package v7;

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

	public double getRentalAmount(int duration)
	{
		double result = 0;
	
		switch (_priceCode)
		{
			case REGULAR:
				result += 2;
				if (duration > 2)
					result += (duration - 2) * 1.5;
				break;
			case NEW_RELEASE:
				result += duration * 3;
				break;
			case CHILDRENS:
				result += 1.5;
				if (duration > 3)
					result += (duration - 3) * 1.5;
				break;
		}
		return result;
	}

	public int getFrequentRentalPoints(int duration)
	{
		return (_priceCode == Code.NEW_RELEASE) && duration > 1 ? 2 : 1;
	}		
}
