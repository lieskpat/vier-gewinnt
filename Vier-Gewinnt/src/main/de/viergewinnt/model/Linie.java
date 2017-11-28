/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public abstract class Linie {
	
	private List<ISpielbrettZelle> zellen;

	/**
	 * @param zellen
	 */
	protected Linie(List<ISpielbrettZelle> zellen) 
	{
		if(zellen == null) throw new NullPointerException("zelle");
		this.zellen = zellen;
	}

	/**
	 * @return the zelle
	 */
	public List<ISpielbrettZelle> getZellen() 
	{
		return zellen;
	}
	
	public String sindVierSpielsteineInEinerLinie()
	{
		int zaehler = 0;
		String aktuellerSpielername = "";
		
		for (ISpielbrettZelle spielbrettZelle : zellen) 
		{
			if (spielbrettZelle.getZellenTyp() == ZellenTyp.LEERZELLE) 
			{
				aktuellerSpielername = "";
				zaehler = 0;
				continue;
			}
			if (spielbrettZelle.getZellenTyp() == ZellenTyp.SPIELSTEINZELLE)  
			{
				ISpielstein spielstein = spielbrettZelle.getSpielstein();
				
				if (!spielstein.getSpielerName().equals(aktuellerSpielername))
				{
					aktuellerSpielername = spielstein.getSpielerName();
					zaehler = 1;
					continue;
				}
			}
			zaehler++;
			
			if (zaehler >= 4) 
			{
				return aktuellerSpielername;
			}
		}
		return null;
	}

}
