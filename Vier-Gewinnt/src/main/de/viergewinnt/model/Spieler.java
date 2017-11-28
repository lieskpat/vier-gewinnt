/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public class Spieler implements ISpieler {
	
	private List<Spielstein> spielsteine;
	
	private String name;

	private boolean istAnDerReihe;

	/**
	 * @param spielsteine
	 * @param name
	 * @param istAnDerReihe 
	 */
	public Spieler(List<Spielstein> spielsteine, String name, boolean istAnDerReihe) {
		
		if(name == null) throw new NullPointerException("name");
		if(spielsteine == null) throw new NullPointerException("spielsteine");
		
		this.spielsteine = spielsteine;
		this.name = name;
		this.istAnDerReihe = istAnDerReihe;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#getSpielsteine()
	 */
	@Override
	public List<Spielstein> getSpielsteine() {
		return spielsteine;
	}
	
	/**
	 * @return the istAnDerReihe
	 */
	public boolean isIstAnDerReihe() {
		return istAnDerReihe;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#setIstAnDerReihe(boolean)
	 */
	@Override
	public void setIstAnDerReihe(boolean istAnDerReihe) {
		this.istAnDerReihe = istAnDerReihe;
	}
	
	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#spieleZug(viergewinnt.core.model.ISpalte)
	 */
	@Override
	public void spieleZug(ISpalte spalte){
		
		if(spalte == null) throw new NullPointerException("spalte");
		
		ISpielstein spielstein = spielsteine.remove(0);
		spalte.lasseSpielsteinFallen(spielstein);
		
	}

	
	
	

}
