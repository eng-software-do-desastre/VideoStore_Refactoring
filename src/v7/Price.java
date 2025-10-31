package v7;

public class Price
{
	public enum Code {REGULAR, CHILDRENS, NEW_RELEASE}

	public Price.Code _code;

	public Price(Price.Code code)
	{
		_code = code;
	}

	public Price.Code getCode() {
		return _code;
	}

	public double getRentalAmount(int duration)
	{
		double result = 0;

		switch (_code)
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
		return (_code == Price.Code.NEW_RELEASE) && duration > 1 ? 2 : 1;
	}
}
