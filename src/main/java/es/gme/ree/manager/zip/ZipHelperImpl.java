package es.gme.ree.manager.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

import es.gme.ree.manager.properties.PropsValues;
import es.gme.ree.manager.url.ReeURLContext;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public class ZipHelperImpl implements ZipHelper {

	public ZipHelperImpl(int month, int year) {
		this(new ReeURLContext(month, year));
	}

	public ZipHelperImpl(ReeURLContext reeURLContext) {
		_reeURLContext = reeURLContext;
	}

	public File extractFileFromZip(String fileName, URL zipFileUrl) throws ArchiveException, IOException {
		InputStream is = null;
		ArchiveInputStream in = null;
		OutputStream out = null;

		try {
			File zipFile = new File(zipFileUrl.toURI());

			is = new FileInputStream(zipFile);

			ArchiveStreamFactory archiveStreamFactory = new ArchiveStreamFactory();

			in = archiveStreamFactory.createArchiveInputStream("zip", is);

			ZipArchiveEntry entry = null;

			String fullFileName = _reeURLContext.getFullFileName(fileName);

			while ((entry = (ZipArchiveEntry)in.getNextEntry()) != null) {
				String zipEntryFileName = entry.getName();

				if (fullFileName.equals(zipEntryFileName)) {
					File output = new File(PropsValues.URL_DOWNLOAD_FOLDER, zipEntryFileName);
	
					try {
						out = new FileOutputStream(output);

						IOUtils.copy(in, out);

						return output;
					}
					finally {
						if (out != null) {
							out.close();
						}
					}
				}
			}

			return null;
		}
		catch (MalformedURLException mue) {
			throw new IOException(mue);
		}
		catch (URISyntaxException use) {
			throw new IOException(use);
		}
		finally {
			if (in != null) {
				in.close();
			}

			if (is != null) {
				is.close();
			}
		}
	}

	private ReeURLContext _reeURLContext;

}