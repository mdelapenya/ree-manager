package es.gme.ree.manager.properties;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class PropsUtilTest {

	@Test
	public void testGet() {
		String actual = PropsUtil.get("ree.application.fileType.param");

		Assert.assertEquals("fileType", actual);
	}

	@Test
	public void testGetInteger() {
		int actual = PropsUtil.getInteger("ree.application.cType.value");

		Assert.assertEquals(3, actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetNotFound() {
		PropsUtil.get("not.found");
	}

	@Test
	public void testGetOverridenProperty() {
		String actual = PropsUtil.get("url.download.folder");

		Assert.assertEquals("/tmp", actual);
	}

}