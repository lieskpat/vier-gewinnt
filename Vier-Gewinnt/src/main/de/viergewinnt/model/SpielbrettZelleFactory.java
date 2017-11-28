/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public class SpielbrettZelleFactory implements ISpielbrettZelleFactory {

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelleFactory#create(int, int, viergewinnt.core.model.ZellenTyp)
	 */
	@Override
	public ISpielbrettZelle create(int x, int y, ZellenTyp zellenTyp) {
		
		return new SpielbrettZelle(x, y, zellenTyp);
	}
}
