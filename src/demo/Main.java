package demo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/***********************************************************
 * Filename: Main.java
 * @author fba 6 de Mai de 2013
 ***********************************************************/
public abstract class Main
{

	/***********************************************************
	 * @param args
	 * @throws IOException 
	 ***********************************************************/
	public static void main(String[] args) throws IOException
	{
		Customer who = new Customer("Barack Obama");
		System.out.println( who);
		
		Database.store(who);
		
		for (Rental r : allRentals())		
			who.addRental(r);
		
		printStatement(who);
		
	
	}

	private static void saveState()
	{
		// TODO Auto-generated method stub
		
	}

	public static Set<Rental> allRentals()
	{
		Set<Rental> result = new HashSet<Rental>();

		for (Movie m : allMovies())
		{
			Rental r = new Rental(m, 1);
			result.add(r);
			Database.store(m);
			Database.store(r);
		}
		
		return result;
	}
	
	public static Set<Movie> allMovies()
	{
		Set<Movie> result = new HashSet<Movie>();

		result.add(new Movie("Life of Amalia", new RegularPrice(false)));
		result.add(new Movie("Peter Pan", new ChildrensPrice()));
		result.add(new Movie("Donna del Lago", new NewReleasePrice(true)));
		result.add(new Movie("La Belle Epoque", new BestPrice()));
		result.add(new Movie("Al Capone 2", new MafiaPrice(true)));
		
		return result;
	}
	
	/***********************************************************
	* @param who
	* @throws IOException
	***********************************************************/
	public static void printStatement(Customer who) throws IOException
	{
		System.out.println( who.statement());
		
		PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html")); 
		html.println(who.htmlStatement()); 
		html.close();
	}

}
