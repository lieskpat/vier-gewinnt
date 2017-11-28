/**
 * 
 */
package de.viergewinnt.model.test;

import viergewinnt.core.model.ISpalte;
import viergewinnt.core.model.ISpielstein;

/**
 * @author lies
 *
 */
public class SpalteMock implements ISpalte {
	
	private int lasseSpielsteinFallenAufrufe;

	@Override
	public void lasseSpielsteinFallen(ISpielstein spielstein) {
		
		lasseSpielsteinFallenAufrufe++;
	}
	
	public boolean wurdeLasseSpielsteinFallenNurEinmalAufgerufen(){
		return getLasseSpielsteinFallenAufrufe() == 1;
	}

	/**
	 * @return the lasseSpielsteinFallenAufrufe
	 */
	public int getLasseSpielsteinFallenAufrufe() {
		return lasseSpielsteinFallenAufrufe;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpalte#istSpalteVoll()
	 */
	public boolean istSpalteVoll() {
		
		throw new UnsupportedOperationException();
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

}
