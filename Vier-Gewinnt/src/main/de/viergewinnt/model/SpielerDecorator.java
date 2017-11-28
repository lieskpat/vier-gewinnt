/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;
import java.util.Observable;

/**
 * @author lies
 *
 */
public class SpielerDecorator extends Observable implements ISpieler {
	
	private Spieler spieler;

	/**
	 * @param spieler
	 */
	public SpielerDecorator(Spieler spieler) {
		this.spieler = spieler;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#getName()
	 */
	@Override
	public String getName() {
		
		return spieler.getName();
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#getSpielsteine()
	 */
	@Override
	public List<Spielstein> getSpielsteine() {
		
		return spieler.getSpielsteine();
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#setIstAnDerReihe(boolean)
	 */
	@Override
	public void setIstAnDerReihe(boolean istAnDerReihe) {
		
		spieler.setIstAnDerReihe(istAnDerReihe);
		setChanged();
		notifyObservers(spieler);

	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#isIstAnDerReihe()
	 */
	@Override
	public boolean isIstAnDerReihe() {

		return spieler.isIstAnDerReihe();
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpieler#spieleZug(viergewinnt.core.model.ISpalte)
	 */
	@Override
	public void spieleZug(ISpalte spalte) {
		
		spieler.spieleZug(spalte);

	}

}
