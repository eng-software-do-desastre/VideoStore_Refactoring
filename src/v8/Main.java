package v8;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import demo.Database;
import v9.*;
import v9.ChildrensPrice;
import v9.Customer;
import v9.Movie;
import v9.NewReleasePrice;
import v9.Price;
import v9.RegularPrice;
import v9.Rental;

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
		Scanner teclado = new Scanner(System.in);
		int response = -1;

		System.out.println("Escolha uma opcao:\n1 - criar objectos e gravar\n2 - fazer load da DB\n");
		response = teclado.nextInt();
		switch (response)
		{
			case 1:
				v9.Customer who = new Customer("Barack Obama");

				v9.Price p1 = new RegularPrice(false);
				v9.Movie m1 = new v9.Movie("Life of Amalia", p1);
				v9.Price p2 = new ChildrensPrice();
				v9.Movie m2 = new v9.Movie("Peter Pan", p2);
				v9.Price p3 = new NewReleasePrice(true);
				v9.Movie m3 = new v9.Movie("Donna del Lago", p3);
				v9.Price p4 = new BestPrice();
				v9.Movie m4 = new v9.Movie("La Belle Epoque", p4);
				Price p5 = new MafiaPrice(true);
				v9.Movie m5 = new Movie("Al Capone 2", new MafiaPrice(true));

				who.addRental(new v9.Rental(m1, 1));
				who.addRental(new v9.Rental(m2, 2));
				who.addRental(new v9.Rental(m3, 3));
				who.addRental(new v9.Rental(m4, 2));
				who.addRental(new Rental(m5, 7));

				Database.store(who);

				Database.close();

				System.out.println(who.statement());

				PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
				html.println(who.htmlStatement());
				html.close();
				break;
			case 2:
				LoadDB();
				break;

			default:
				break;
		}

	}

	// from db
	public static void LoadDB() throws IOException
	{
//		query um customer pelo nome
		vNew.Customer who = Database.get(vNew.Customer.class,  "_name", "Barack Obama");

		System.out.println(who.statement());

		PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
		html.println(who.htmlStatement());
		html.close();

		Database.close();
	}
}
