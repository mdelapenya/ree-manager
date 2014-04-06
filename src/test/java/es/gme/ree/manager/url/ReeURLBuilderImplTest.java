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

		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl(new ReeURLContext(11, 2013));

		String actualPath = urlBuilder.getURL();

		Assert.assertEquals(expectedPath, actualPath);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetURLMonthGreaterThanTwelve() {
		_testGetWrongURL(new ReeURLContext(13, 2013));
	}

	@Test
	public void testGetURLMonthIsTwelve() {
		String expectedPath =
			"http://www.esios.ree.es/Solicitar?fileName=C3_liquicomun_201312&fileType=zip&idioma=es&" +
			"tipoSolicitar=Publicaciones";

		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl(new ReeURLContext(12, 2013));

		String actualPath = urlBuilder.getURL();

		Assert.assertEquals(expectedPath, actualPath);
	}

	@Test
	public void testGetURLMonthIsOne() {
		String expectedPath =
			"http://www.esios.ree.es/Solicitar?fileName=C3_liquicomun_201301&fileType=zip&idioma=es&" +
			"tipoSolicitar=Publicaciones";

		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl(new ReeURLContext(1, 2013));

		String actualPath = urlBuilder.getURL();

		Assert.assertEquals(expectedPath, actualPath);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetURLMonthLessThanOne() {
		_testGetWrongURL(new ReeURLContext(0, 2013));
	}

	private void _testGetWrongURL(ReeURLContext wrongReeUrlContext) {
		ReeURLBuilder urlBuilder = new ReeURLBuilderImpl(wrongReeUrlContext);

		urlBuilder.getURL();

		Assert.fail("Month is invalid");
	}
}