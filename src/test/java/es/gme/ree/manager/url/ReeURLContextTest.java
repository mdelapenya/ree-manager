package es.gme.ree.manager.url;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLContextTest {

	@Test(expected=IllegalArgumentException.class)
	public void testCreateURLContextMonthGreaterThanTwelve() {
		new ReeURLContext(0, 2013);

		Assert.fail("It is not possible to create a ReeURLContext with month grater than twelve");
	}

	@Test
	public void testCreateURLContextMonthIsOne() {
		ReeURLContext urlContext = new ReeURLContext(1, 2013);

		Assert.assertNotNull(urlContext);
	}

	@Test
	public void testCreateURLContextMonthIsTwelve() {
		ReeURLContext urlContext = new ReeURLContext(12, 2013);

		Assert.assertNotNull(urlContext);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCreateURLContextMonthLessThanOne() {
		new ReeURLContext(0, 2013);

		Assert.fail("It is not possible to create a ReeURLContext with month less than one");
	}

	@Test
	public void testGetFullFileName() {
		String expected = "C3_liquicomun_201311";

		ReeURLContext urlContext = new ReeURLContext(11, 2013);

		Assert.assertEquals(expected, urlContext.getFullFileName());
	}

	@Test
	public void testGetFullFileNameByDifferentFileName() {
		String expected = "C3_grcosdnc_20131101_20131130";

		ReeURLContext urlContext = new ReeURLContext(11, 2013);

		Assert.assertEquals(expected, urlContext.getFullFileName("grcosdnc"));
	}

	@Test
	public void testGetFullFileNameBySameFileName() {
		String expected = "C3_liquicomun_201311";

		ReeURLContext urlContext = new ReeURLContext(11, 2013);

		Assert.assertEquals(expected, urlContext.getFullFileName("liquicomun"));
	}

}