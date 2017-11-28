/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public class Spielstein implements ISpielstein {
	
	private Farbe farbe;
	private String spielerName;

	/**
	 * @param farbe
	 */
	public Spielstein(Farbe farbe, String spielerName) 
	{
		this.spielerName = spielerName;
		this.farbe = farbe;
		
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielstein#getFarbe()
	 */
	@Override
	public Farbe getFarbe() 
	{
		return farbe;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielstein#getSpielerName()
	 */
	@Override
	public String getSpielerName() 
	{
		return spielerName;
	}

}
