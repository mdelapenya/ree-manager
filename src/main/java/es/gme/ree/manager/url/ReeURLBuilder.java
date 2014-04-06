package es.gme.ree.manager.url;

/**
 * 
 * @author mdelapenya (http://github.com/mdelapenya)
 *
 */
public interface ReeURLBuilder {

	public String getURL(int month, int year) throws IllegalArgumentException;

}