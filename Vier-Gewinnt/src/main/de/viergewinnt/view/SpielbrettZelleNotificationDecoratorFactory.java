/**
 * 
 */
package de.viergewinnt.view;

import de.viergewinnt.model.ISpielbrettZelle;
import de.viergewinnt.model.ISpielbrettZelleFactory;
import de.viergewinnt.model.SpielbrettZelle;
import de.viergewinnt.model.ZellenTyp;

/**
 * @author lies
 *
 */
public class SpielbrettZelleNotificationDecoratorFactory implements ISpielbrettZelleFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see viergewinnt.core.model.ISpielbrettZelleFactory#create(int, int,
	 * viergewinnt.core.model.ZellenTyp)
	 */
	@Override
	public ISpielbrettZelle create(int x, int y, ZellenTyp zellenTyp) {

		return new SpielbrettZelleNotificationDecorator(new SpielbrettZelle(x, y, zellenTyp));
	}

}
