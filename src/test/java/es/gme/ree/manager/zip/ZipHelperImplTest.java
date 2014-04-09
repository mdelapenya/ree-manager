package es.gme.ree.manager.zip;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import es.gme.ree.manager.properties.PropsValues;
import es.gme.ree.manager.url.ReeURLContext;

/**
 *
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ZipHelperImplTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
		_reeURLContext = new ReeURLContext(11, 2013);
	}

	@Test(expected=IOException.class)
	public void testExtractFileFromNotValidURLZip() throws Exception {
		URL url = new URL("null");

		ZipHelper zipper = new ZipHelperImpl(_reeURLContext);

		zipper.extractFileFromZip(PropsValues.REE_APPLICATION_FILES_GRCOSDCN, url);
	}

	@Test
	public void testExtractFileFromNotValidZip() throws Exception {
		URL url = this.getClass().getResource("dependencies/notValidZip.txt");

		ZipHelper zipper = new ZipHelperImpl(_reeURLContext);

		File grcosdcn = zipper.extractFileFromZip(PropsValues.REE_APPLICATION_FILES_GRCOSDCN, url);

		Assert.assertNull(grcosdcn);
	}

	@Test
	public void testExtractFileFromZip() throws Exception {
		URL url = this.getClass().getResource("dependencies/" + _reeURLContext.getFullFileName() + ".zip");

		ZipHelper zipper = new ZipHelperImpl(_reeURLContext);

		File grcosdcn = zipper.extractFileFromZip(PropsValues.REE_APPLICATION_FILES_GRCOSDCN, url);

		Assert.assertNotNull(grcosdcn);
	}

	@Test(expected=NullPointerException.class)
	public void testExtractFileFromZipNotFound() throws Exception {
		URL url = this.getClass().getResource("dependencies/notFound.zip");

		ZipHelper zipper = new ZipHelperImpl(_reeURLContext);

		zipper.extractFileFromZip(PropsValues.REE_APPLICATION_FILES_GRCOSDCN, url);

		Assert.fail("A NullPointerException should have been thrown");
	}

	private static ReeURLContext _reeURLContext;

}