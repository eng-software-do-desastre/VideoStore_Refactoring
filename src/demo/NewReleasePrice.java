package demo;

public class NewReleasePrice extends Price
{

	public NewReleasePrice()
	{
	}
	
	public NewReleasePrice(boolean blueray)
	{
		super(blueray);
	}

	public double getRentalAmount(int duration)
	{
		return duration * 3 + (is_blueray() ? 1 : 0);
	}

	public int getFrequentRentalPoints(int duration)
	{
		return (duration > 1 ? 2 : 1) + (is_blueray() ? 1 : 0);
	}

}
