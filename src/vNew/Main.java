package vNew;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import demo.Database;

/***********************************************************
 * Filename: Main.java
 * 
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
				Customer who = new Customer("Barack Obama");

				Price p1 = new RegularPrice(false);
				Movie m1 = new Movie("Life of Amalia", p1);
				Price p2 = new ChildrensPrice();
				Movie m2 = new Movie("Peter Pan", p2);
				Price p3 = new NewReleasePrice(true);
				Movie m3 = new Movie("Donna del Lago", p3);
				Price p4 = new BestPrice();
				Movie m4 = new Movie("La Belle Epoque", p4);
				Price p5 = new MafiaPrice(true);
				Movie m5 = new Movie("Al Capone 2", new MafiaPrice(true));

				who.addRental(new Rental(m1, 1));
				who.addRental(new Rental(m2, 2));
				who.addRental(new Rental(m3, 3));
				who.addRental(new Rental(m4, 2));
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
		Customer who = Database.get(Customer.class,  "_name", "Barack Obama");
		
		System.out.println(who.statement());

		PrintWriter html = new PrintWriter(new FileWriter("webPages/statement.html"));
		html.println(who.htmlStatement());
		html.close();
		
		Database.close();
	}

}
