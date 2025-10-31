package v9;
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
public class Test_v9
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
	public final void testV9()
	{
		Customer who = new Customer("Barack Obama");
		Movie m1 = new Movie("Life of Amalia", new RegularPrice());
		Movie m2 = new Movie("Peter Pan", new ChildrensPrice());
		Movie m3 = new Movie("Donna del Lago", new NewReleasePrice());

		who.addRental(new Rental(m1, 1));
		who.addRental(new Rental(m2, 2));
		who.addRental(new Rental(m3, 3));
		
		assertEquals(who.statement(), "Rental Record for Barack Obama\n\tLife of Amalia\t2.0\n\tPeter Pan\t1.5\n\tDonna del Lago\t9.0\nAmount owed is 12.5\nYou earned 4 frequent renter points");
	}

}
