package demo;

public class MafiaPrice extends Price
{

	public MafiaPrice()
	{
		// TODO Auto-generated constructor stub
	}

	public MafiaPrice(boolean blueray)
	{
		super(blueray);
	}

	@Override
	public double getRentalAmount(int duration)
	{
		return 7 * duration;
	}

	@Override
	public int getFrequentRentalPoints(int duration)
	{
		return 0;
	}

}
