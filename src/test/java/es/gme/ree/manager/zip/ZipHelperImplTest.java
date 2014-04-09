package es.gme.ree.manager.zip;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

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

		_zipHelper = new ZipHelperImpl(_reeURLContext);
	}

	@Test(expected=IOException.class)
	public void testExtractFileFromNotValidURLZip() throws Exception {
		URL url = new URL("null");

		_zipHelper.extractFilesFromZip(url, PropsValues.REE_APPLICATION_FILES_GRCOSDNC);
	}

	@Test
	public void testExtractFileFromNotValidZip() throws Exception {
		URL url = this.getClass().getResource("dependencies/notValidZip.txt");

		List<File> grcosdcnFiles = _zipHelper.extractFilesFromZip(url, PropsValues.REE_APPLICATION_FILES_GRCOSDNC);

		Assert.assertEquals(0, grcosdcnFiles.size());
	}

	@Test
	public void testExtractFileFromZip() throws Exception {
		URL url = this.getClass().getResource("dependencies/" + _reeURLContext.getFullFileName() + ".zip");

		List<File> grcosdncFiles = _zipHelper.extractFilesFromZip(url, PropsValues.REE_APPLICATION_FILES_GRCOSDNC);

		Assert.assertEquals(1, grcosdncFiles.size());

		File grcosdnc = grcosdncFiles.get(0);

		Assert.assertTrue(grcosdnc.getName().contains("grcosdnc"));
	}

	@Test(expected=NullPointerException.class)
	public void testExtractFileFromZipNotFound() throws Exception {
		URL url = this.getClass().getResource("dependencies/notFound.zip");

		_zipHelper.extractFilesFromZip(url, PropsValues.REE_APPLICATION_FILES_GRCOSDNC);

		Assert.fail("A NullPointerException should have been thrown");
	}

	private static ReeURLContext _reeURLContext;
	private static ZipHelper _zipHelper;

}