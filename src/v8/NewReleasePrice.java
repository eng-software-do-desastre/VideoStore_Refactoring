package v8;

public class NewReleasePrice extends Price
{

	public NewReleasePrice()
	{
	}

	public double getRentalAmount(int duration)
	{
		return duration * 3;
	}

	public int getFrequentRentalPoints(int duration)
	{
		return duration > 1 ? 2 : 1;
	}

}
