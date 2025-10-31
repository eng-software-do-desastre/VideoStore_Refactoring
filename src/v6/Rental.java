package v6;

public class Rental
{
	private Movie	_movie;
	private int		_daysRented;

	public Rental(Movie m1, int daysRented)
	{
		_movie = m1;
		_daysRented = daysRented;
	}

	public Movie getMovie()
	{
		return _movie;
	}
	
	public int getDaysRented()
	{
		return _daysRented;
	}

	public double getAmount()
	{
		double result = 0;
	
		switch (getMovie().getPriceCode())
		{
			case REGULAR:
				result += 2;
				if (getDaysRented() > 2)
					result += (getDaysRented() - 2) * 1.5;
				break;
			case NEW_RELEASE:
				result += getDaysRented() * 3;
				break;
			case CHILDRENS:
				result += 1.5;
				if (getDaysRented() > 3)
					result += (getDaysRented() - 3) * 1.5;
				break;
		}
		return result;
	}

	public int getFrequentRentalPoints()
	{
		return (getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && getDaysRented() > 1 ? 2 : 1;
	}
}
