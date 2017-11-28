/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public interface ISpalte {
	
	int getIndex();

	void lasseSpielsteinFallen(ISpielstein spielstein);

	boolean istSpalteVoll();

}