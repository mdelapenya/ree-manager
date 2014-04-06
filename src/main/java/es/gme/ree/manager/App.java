package es.gme.ree.manager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

/**
 * Hello world!
 * 
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		String path =
			"http://www.esios.ree.es/Solicitar?fileName=C3_liquicomun_201311&fileType=zip&idioma=es&" +
			"tipoSolicitar=Publicaciones";

		try {
			File localFile = new File("/tmp/foo");

			FileUtils.copyURLToFile(new URL(path), localFile);
		}
		catch (MalformedURLException mue) {
			mue.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}