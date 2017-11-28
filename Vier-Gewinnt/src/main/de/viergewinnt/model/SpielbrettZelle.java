/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public class SpielbrettZelle implements ISpielbrettZelle {
	
	private int x;
	private int y;
	private ISpielstein spielstein;
	private IZellenTyp zellenTyp;

	/**
	 * @param x
	 * @param y
	 * @param spielstein
	 */
	public SpielbrettZelle(int x, int y, IZellenTyp zellenTyp) {
		this.x = x;
		this.y = y;
		this.zellenTyp = zellenTyp;
		
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelle#getX()
	 */
	@Override
	public int getX() {
		return x;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelle#getY()
	 */
	@Override
	public int getY() {
		return y;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelle#getSpielstein()
	 */
	@Override
	public ISpielstein getSpielstein() {
		return spielstein;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelle#getZellenTyp()
	 */
	@Override
	public IZellenTyp getZellenTyp() {
		return zellenTyp;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelle#setZellenTyp(viergewinnt.core.model.ZellenTyp)
	 */
	@Override
	public void setZellenTyp(IZellenTyp zellenTyp) {
		this.zellenTyp = zellenTyp;
	}

	/* (non-Javadoc)
	 * @see viergewinnt.core.model.ISpielbrettZelle#setSpielstein(viergewinnt.core.model.ISpielstein)
	 */
	@Override
	public void setSpielstein(ISpielstein spielstein) {
		this.spielstein = spielstein;
		setZellenTyp(ZellenTyp.SPIELSTEINZELLE);
		
	}
	
	

}
