package es.gme.ree.manager.properties;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class PropsImplTest {

	@Test
	public void testGet() {
		PropsImpl instance = PropsImpl.getInstance();

		String actual = instance.get("ree.application.fileType.param");

		Assert.assertEquals("fileType", actual);
	}

	@Test
	public void testGetInteger() {
		PropsImpl instance = PropsImpl.getInstance();

		int actual = instance.getInteger("ree.application.cType.value");

		Assert.assertEquals(3, actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetNotFound() {
		PropsImpl instance = PropsImpl.getInstance();

		instance.get("not.found");
	}

	@Test
	public void testGetOverridenProperty() {
		PropsImpl instance = PropsImpl.getInstance();

		String actual = instance.get("url.download.folder");

		Assert.assertEquals("/tmp", actual);
	}

	@Test
	public void testGetInstance() {
		PropsImpl instance = PropsImpl.getInstance();

		Assert.assertNotNull(instance);
	}

}