package v7;

public class Price
{
	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE}
	
	public Code	_priceCode;

	public Price()
	{
	}

	public double getRentalAmount(Movie movie, int duration)
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
}
