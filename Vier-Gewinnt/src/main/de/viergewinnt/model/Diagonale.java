/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public class Diagonale extends Linie {

	private int startKoordinateX;
	
	private int startKoordinateY;
	
	private DiagonaleRichtung richtung;
	/**
	 * @param zellen
	 * @param startKoordinateX
	 * @param startKoordinateY
	 * @param richtung
	 */
	public Diagonale(List<ISpielbrettZelle> zellen, int startKoordinateX, int startKoordinateY,
					DiagonaleRichtung richtung) {
		
		super(zellen);
		
		if (startKoordinateX < 0) throw new IllegalArgumentException("X darf nicht kleiner 0 sein.");
		if (startKoordinateY < 0) throw new IllegalArgumentException("Y darf nicht kleiner 0 sein.");
		
		this.startKoordinateX = startKoordinateX;
		this.startKoordinateY = startKoordinateY;
		this.richtung = richtung;
	}
	/**
	 * @return the startKoordinateX
	 */
	public int getStartKoordinateX() {
		return startKoordinateX;
	}
	/**
	 * @return the startKoordinateY
	 */
	public int getStartKoordinateY() {
		return startKoordinateY;
	}
	/**
	 * @return the richtung
	 */
	public DiagonaleRichtung getRichtung() {
		return richtung;
	}


}
