package vNew;

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
		String result = "Rental Record for " + getName() + "\n\n";
		result += "\tMovie\t\tDays\tCost\tPoints\tBlu-ray\n";
		result += "-----------------------------------------------------------------\n";
		
		for (Rental each : _rentals)
			result += "\t" + each.getMovie().getTitle() + "\t" 
							+ each.getDaysRented() + "\t"
							+ each.getMovie().getPrice().getRentalAmount(each.getDaysRented()) + "\t"
							+ each.getMovie().getPrice().getFrequentRentalPoints(each.getDaysRented()) + "\t"
							+ each.getMovie().getPrice().is_blueray() + "\n";

		// add footer lines
		result += "-----------------------------------------------------------------\n";
		result += "Amount owed is " + getTotalAmount() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	public String htmlStatement()
	{
		// header
		String result = "<font size=\"4\" face=\"Georgia, Arial, Garamond\" color=\"green\">\n";
		result += "<h2>Rental Record for <i>" + getName() + "</i></h2>\n";
		
		// lines
		result += "<table border=\"1\">\n";
		result += "\t<tr>\n\t\t<th>Movie</th>\n" +
						"\t\t<th>Days</th>\n" +
						"\t\t<th>Cost</th>\n" +
						"\t\t<th>Points</th>\n" +
						"\t\t<th>Blu-ray</th>\n" +
						"</tr>\n";
		
		for (Rental each : _rentals)
			result +="\t\t<tr>\n" +
							"\t\t\t<td>" + each.getMovie().getTitle() + "</td>\n" +
							"\t\t\t<td>" + each.getDaysRented() + "</td>\n" +
							"\t\t\t<td>" + each.getMovie().getPrice().getRentalAmount(each.getDaysRented()) + "</td>\n" + 
							"\t\t\t<td>" + each.getMovie().getPrice().getFrequentRentalPoints(each.getDaysRented()) + "</td>\n" +
							"\t\t\t<td>" + each.getMovie().getPrice().is_blueray() + "</td>\n" +
							"\t\t</tr>\n";
		
		result += "</table>\n";

		// footer
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