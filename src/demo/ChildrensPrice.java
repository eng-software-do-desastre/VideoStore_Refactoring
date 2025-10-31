package demo;

public class ChildrensPrice extends Price
{
	public ChildrensPrice()
	{
	}
	
	public ChildrensPrice(boolean blueray)
	{
		super(blueray);
	}

	public double getRentalAmount(int duration)
	{
		return 1.5 + (duration > 3 ? (duration - 3) * 1.5 : 0) + (is_blueray() ? 1 : 0);
	}

	public int getFrequentRentalPoints(int duration)
	{
		return is_blueray() ? 2 : 1;
	}

}
