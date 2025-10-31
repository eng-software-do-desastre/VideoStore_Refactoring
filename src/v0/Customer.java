package v0;

import java.util.Vector;

public class Customer
{
	private String			_name;
	private Vector<Rental>	_rentals	= new Vector<Rental>();

	public Customer(String _name)
	{
		this._name = _name;
	}

	public void addRental(Rental arg)
	{
		_rentals.addElement(arg);
	}

	public String getName()
	{
		return _name;
	}

	public String statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		// header
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each: _rentals)
		{
			double thisAmount = 0;

			// determine amounts for each line
			switch (each.getMovie().getPriceCode())
			{
				case REGULAR:
					thisAmount += 2;
					if (each.getDaysRented() > 2)
						thisAmount += (each.getDaysRented() - 2) * 1.5;
					break;
				case NEW_RELEASE:
					thisAmount += each.getDaysRented() * 3;
					break;
				case CHILDRENS:
					thisAmount += 1.5;
					if (each.getDaysRented() > 3)
						thisAmount += (each.getDaysRented() - 3) * 1.5;
					break;
			}

			// add frequent renter points
			frequentRenterPoints++;

			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}
}
