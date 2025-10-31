package vNew;

public class BestPrice extends Price
{
	public BestPrice()
	{
	}
	
	public BestPrice(boolean blueray)
	{
		super(blueray);
	}

	@Override
	public double getRentalAmount(int duration)
	{
		return duration + (is_blueray() ? 1 : 0);
	}

	@Override
	public int getFrequentRentalPoints(int duration)
	{
		return is_blueray() ? 1 : 0;
	}

}
