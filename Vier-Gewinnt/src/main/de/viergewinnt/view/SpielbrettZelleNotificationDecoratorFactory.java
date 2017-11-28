/**
 * 
 */
package de.viergewinnt.view;

import viergewinnt.core.model.ISpielbrettZelle;
import viergewinnt.core.model.ISpielbrettZelleFactory;
import viergewinnt.core.model.SpielbrettZelle;
import viergewinnt.core.model.ZellenTyp;

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
