/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public interface ISpieler {

	/**
	 * @return the name
	 */
	String getName();

	/**
	 * @return the spielsteine
	 */
	List<Spielstein> getSpielsteine();

	/**
	 * @param istAnDerReihe the istAnDerReihe to set
	 */
	void setIstAnDerReihe(boolean istAnDerReihe);
	
	/**
	 * @return
	 */
	boolean isIstAnDerReihe();

	void spieleZug(ISpalte spalte);

	

}