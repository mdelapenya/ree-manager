package es.gme.ree.manager;

import es.gme.ree.manager.properties.PropsValues;
import es.gme.ree.manager.url.ReeURLBuilder;
import es.gme.ree.manager.url.ReeURLBuilderImpl;
import es.gme.ree.manager.url.ReeURLContext;
import es.gme.ree.manager.zip.ZipHelper;
import es.gme.ree.manager.zip.ZipHelperImpl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.io.FileUtils;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ReeManagerImpl implements ReeManager {

	public ReeManagerImpl(int month, int year) {
		_reeURLContext = new ReeURLContext(month, year);
	}

	public void process() {
		try {
			URL url = new URL(PropsValues.URL_DOWNLOAD_FOLDER + "/" + _reeURLContext.getFullFileName() + ".zip");

			File localFile = new File(url.toURI());

			ReeURLBuilder reeURLBuilder = new ReeURLBuilderImpl(_reeURLContext);

			FileUtils.copyURLToFile(new URL(reeURLBuilder.getURL()), localFile);

			ZipHelper zipHelper = new ZipHelperImpl(_reeURLContext);

			zipHelper.extractFilesFromZip(url, PropsValues.REE_APPLICATION_FILES_GRCOSDCN);
		}
		catch (MalformedURLException mue) {
			mue.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (ArchiveException ce) {
			ce.printStackTrace();
		}
		catch (URISyntaxException use) {
			use.printStackTrace();
		}
	}

	private ReeURLContext _reeURLContext;

}