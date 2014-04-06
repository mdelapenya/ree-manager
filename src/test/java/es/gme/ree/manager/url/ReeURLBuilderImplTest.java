package es.gme.ree.manager.url;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeURLBuilderImplTest {

	@Test
	public void testGetURL() {
		String expectedPath =
			"http://www.esios.ree.es/Solicitar?fileName=C3_liquicomun_201311&fileType=zip&idioma=es&" +
			"tipoSolicitar=Publicaciones";

		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl();

		String actualPath = urlBuilder.getURL(11, 2013);

		Assert.assertEquals(expectedPath, actualPath);
	}

	@Test
	public void testGetURLMonthGreaterThanTwelve() {
		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl();

		try {
			urlBuilder.getURL(13, 2013);

			Assert.fail("Month is invalid");
		}
		catch (IllegalArgumentException iae) {
		}
	}

	@Test
	public void testGetURLMonthIsTwelve() {
		String expectedPath =
			"http://www.esios.ree.es/Solicitar?fileName=C3_liquicomun_201312&fileType=zip&idioma=es&" +
			"tipoSolicitar=Publicaciones";

		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl();

		String actualPath = urlBuilder.getURL(12, 2013);

		Assert.assertEquals(expectedPath, actualPath);
	}

	@Test
	public void testGetURLMonthIsOne() {
		String expectedPath =
			"http://www.esios.ree.es/Solicitar?fileName=C3_liquicomun_201301&fileType=zip&idioma=es&" +
			"tipoSolicitar=Publicaciones";

		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl();

		String actualPath = urlBuilder.getURL(1, 2013);

		Assert.assertEquals(expectedPath, actualPath);
	}

	@Test
	public void testGetURLMonthLessThanOne() {
		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl();

		try {
			urlBuilder.getURL(0, 2013);

			Assert.fail("Month is invalid");
		}
		catch (IllegalArgumentException iae) {
		}
	}

	
}