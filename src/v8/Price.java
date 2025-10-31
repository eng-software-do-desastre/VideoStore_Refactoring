package v8;

public abstract class Price
{
	public Price()
	{
	}

	public abstract double getRentalAmount(int duration);

	public abstract int getFrequentRentalPoints(int duration);
}

