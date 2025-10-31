package v9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
		Price regularPrice = new RegularPrice();
		Price childrensPrice = new ChildrensPrice();
		Price newReleasePrice = new NewReleasePrice();
		
		Customer who = new Customer("Barack Obama");
		Movie m1 = new Movie("Life of Amalia", regularPrice);
		Movie m2 = new Movie("Peter Pan", childrensPrice);
		Movie m3 = new Movie("Donna del Lago", newReleasePrice);

		who.addRental(new Rental(m1, 1));
		who.addRental(new Rental(m2, 2));
		who.addRental(new Rental(m3, 3));
		System.out.println( who.statement());
		
		PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html")); 
		html.println(who.htmlStatement()); 
		html.close();
	}

}
