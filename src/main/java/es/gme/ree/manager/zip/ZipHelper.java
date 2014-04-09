package es.gme.ree.manager.zip;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.apache.commons.compress.archivers.ArchiveException;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public interface ZipHelper {

	public List<File> extractFilesFromZip(URL zipFileUrl, String... fileNames) throws ArchiveException, IOException;

}