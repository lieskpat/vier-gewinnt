/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public class Spalte extends Linie implements ISpalte {
	
	private int index;
	
	/**
	 * @param zelle
	 */
	public Spalte(List<ISpielbrettZelle> zellen, int index) 
	{
		super(zellen);
		this.index = index;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpalte#lasseSpielsteinFallen(viergewinnt.core.model.Spielstein)
	 */
	@Override
	public void lasseSpielsteinFallen(ISpielstein spielstein)
	{
		for (ISpielbrettZelle spielbrettZelle : getZellen()) 
		{
			
			if (spielbrettZelle.getZellenTyp() == ZellenTyp.LEERZELLE)
			{
				spielbrettZelle.setSpielstein(spielstein);
				return;
			}
		}
		throw new UnsupportedOperationException("Die Spalte ist voll.");
	}
	
	@Override
	public boolean istSpalteVoll(){
		int zaehler = 0;
		boolean wert = false;
		for (ISpielbrettZelle spielbrettZelle : getZellen()) 
		{
			if (spielbrettZelle.getZellenTyp() == ZellenTyp.LEERZELLE)
			{
				zaehler++;
			}
		}
		if (zaehler == 0)
		{
			wert = true;
		} else{
			wert = false;
		}
		return wert;
	}

}
