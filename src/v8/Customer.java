package v8;

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
		// header
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : _rentals)
			result += "\t" + each.getMovie().getTitle() + "\t" + each.getMovie().getPrice().getRentalAmount(each.getDaysRented()) + "\n";

		// add footer lines
		result += "Amount owed is " + getTotalAmount() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	public String htmlStatement()
	{
		// header
		String result = "<font size=\"5\" face=\"Georgia, Arial, Garamond\" color=\"green\">\n";
		result += "<h2>Rental Record for <i>" + getName() + "</i></h2>\n";

		result += "<ul>\n";
		for (Rental each : _rentals)
			result += "\t<li>" + each.getMovie().getTitle() + "\t" +  each.getMovie().getPrice().getRentalAmount(each.getDaysRented()) +"\n";
		result += "</ul>\n";

		// add footer lines
		result += "Amount owed is " + getTotalAmount() + "<br>\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points<br>\n";
		result += "</font>\n";
		
		return result;
	}

	public int getTotalFrequentRenterPoints()
	{
		int frequentRenterPoints = 0;
		for (Rental each : _rentals)
			frequentRenterPoints += each._movie.getPrice().getFrequentRentalPoints(each.getDaysRented());
		return frequentRenterPoints;
	}

	public double getTotalAmount()
	{
		double totalAmount = 0;
		for (Rental each : _rentals)
			totalAmount += each.getMovie().getPrice().getRentalAmount(each.getDaysRented());
		return totalAmount;
	}

}