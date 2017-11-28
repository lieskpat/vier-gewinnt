/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public interface ISpielbrettZelle {

	/**
	 * @return the x
	 */
	int getX();

	/**
	 * @return the y
	 */
	int getY();

	/**
	 * @return the spielstein
	 */
	ISpielstein getSpielstein();

	/**
	 * @param spielstein the spielstein to set
	 */
	void setSpielstein(ISpielstein spielstein);

	/**
	 * @return the zellenTyp
	 */
	IZellenTyp getZellenTyp();

	/**
	 * @param zellenTyp the zellenTyp to set
	 */
	void setZellenTyp(IZellenTyp zellenTyp);

}