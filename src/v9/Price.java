package v9;

public abstract class Price
{
	boolean _blueray = false;

	public Price()
	{
	}

	public Price(boolean blueray)
	{
		_blueray = blueray;
	}

	public boolean is_blueray()
	{
		return _blueray;
	}

	public abstract double getRentalAmount(int duration);

	public abstract int getFrequentRentalPoints(int duration);
}
