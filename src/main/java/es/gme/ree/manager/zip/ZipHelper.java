package es.gme.ree.manager.zip;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.compress.archivers.ArchiveException;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public interface ZipHelper {

	public File extractFileFromZip(String fileName, URL zipFileUrl) throws ArchiveException, IOException;

}