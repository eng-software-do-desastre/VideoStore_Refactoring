package vNew;
/***********************************************************
* Filename: Test_vNew.java
* Created:  6 de Mai de 2013
***********************************************************/


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/***********************************************************
 * @author fba
 * 6 de Mai de 2013
 *
 ***********************************************************/
public class Test_vNew
{

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@Before
	public void setUp() throws Exception
	{
	}

	/***********************************************************
	 * @throws java.lang.Exception
	 ***********************************************************/
	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public final void testVnew()
	{
		Customer who = new Customer("Barack Obama");
		Movie m1 = new Movie("Life of Amalia", new RegularPrice(true));
		Movie m2 = new Movie("Peter Pan", new ChildrensPrice());
		Movie m3 = new Movie("Donna del Lago", new NewReleasePrice(false));
		Movie m4 = new Movie("La Belle Epoque", new BestPrice());

		who.addRental(new Rental(m1, 1));
		who.addRental(new Rental(m2, 2));
		who.addRental(new Rental(m3, 3));
		who.addRental(new Rental(m4, 2));
		
		assertEquals(15.5, who.getTotalAmount(), 1E-5);
		assertEquals(5, who.getTotalFrequentRenterPoints());
	}
}
