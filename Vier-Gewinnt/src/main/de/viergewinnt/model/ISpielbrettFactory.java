/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public interface ISpielbrettFactory {

	Spielbrett create(int anzahlSpalten, int anzahlReihen);
}
