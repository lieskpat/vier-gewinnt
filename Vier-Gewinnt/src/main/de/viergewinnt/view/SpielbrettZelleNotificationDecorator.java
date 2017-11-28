/**
 * 
 */
package de.viergewinnt.view;

import java.util.Observable;

import viergewinnt.core.model.ISpielbrettZelle;
import viergewinnt.core.model.ISpielstein;
import viergewinnt.core.model.IZellenTyp;

/**
 * @author lies
 *
 */
public class SpielbrettZelleNotificationDecorator extends Observable implements ISpielbrettZelle {

	private ISpielbrettZelle spielbrettZelle;

	/**
	 * @param spielbrettZelle
	 */
	public SpielbrettZelleNotificationDecorator(ISpielbrettZelle spielbrettZelle) {

		this.spielbrettZelle = spielbrettZelle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see viergewinnt.core.model.ISpielbrettZelle#getX()
	 */
	@Override
	public int getX() {
		return spielbrettZelle.getX();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see viergewinnt.core.model.ISpielbrettZelle#getY()
	 */
	@Override
	public int getY() {

		return spielbrettZelle.getY();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see viergewinnt.core.model.ISpielbrettZelle#getSpielstein()
	 */
	@Override
	public ISpielstein getSpielstein() {

		return spielbrettZelle.getSpielstein();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * viergewinnt.core.model.ISpielbrettZelle#setSpielstein(viergewinnt.core.
	 * model.ISpielstein)
	 */
	@Override
	public void setSpielstein(ISpielstein spielstein) {

		spielbrettZelle.setSpielstein(spielstein);
		setChanged();
		notifyObservers(spielbrettZelle);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see viergewinnt.core.model.ISpielbrettZelle#getZellenTyp()
	 */
	@Override
	public IZellenTyp getZellenTyp() {

		return spielbrettZelle.getZellenTyp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * viergewinnt.core.model.ISpielbrettZelle#setZellenTyp(viergewinnt.core.
	 * model.IZellenTyp)
	 */
	@Override
	public void setZellenTyp(IZellenTyp zellenTyp) {

		spielbrettZelle.setZellenTyp(zellenTyp);

	}

}
