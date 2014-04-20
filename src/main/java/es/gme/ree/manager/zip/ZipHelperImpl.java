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
import java.util.ArrayList;
import java.util.List;

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

	public List<File> extractFilesFromZip(URL zipFileUrl, String... fileNames) throws ArchiveException, IOException {
		InputStream is = null;
		ArchiveInputStream in = null;
		OutputStream out = null;

		List<File> extractedFiles = new ArrayList<File>();

		try {
			File zipFile = new File(zipFileUrl.toURI());

			is = new FileInputStream(zipFile);

			ArchiveStreamFactory archiveStreamFactory = new ArchiveStreamFactory();

			in = archiveStreamFactory.createArchiveInputStream("zip", is);

			ZipArchiveEntry entry = null;

			String[] fullFileNames = _getFullFileNames(fileNames);

			while ((entry = (ZipArchiveEntry)in.getNextEntry()) != null) {
				String zipEntryFileName = entry.getName();

				if (_containsFileName(fullFileNames, zipEntryFileName)) {
					File output = new File(PropsValues.URL_DOWNLOAD_FOLDER, zipEntryFileName);
	
					try {
						out = new FileOutputStream(output);

						IOUtils.copy(in, out);

						extractedFiles.add(output);

						// do not keep searching, as all files were found

						if (extractedFiles.size() == fileNames.length) {
							return extractedFiles;
						}
					}
					finally {
						if (out != null) {
							out.close();
						}
					}
				}
			}

			return extractedFiles;
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

	private boolean _containsFileName(String[] fullFileNames, String currentFileName) {
		for (String fullFileName : fullFileNames) {
			if (fullFileName.equals(currentFileName)) {
				return true;
			}
		}

		return false;
	}

	private String[] _getFullFileNames(String... fileNames) {
		if (fileNames.length == 0) {
			return new String[0];
		}

		String[] fullFileNames = new String[fileNames.length];

		for (int i = 0; i < fileNames.length; i++) {
			fullFileNames[i] = _reeURLContext.getFullFileName(fileNames[i]);
		}

		return fullFileNames;
	}

	private ReeURLContext _reeURLContext;

}