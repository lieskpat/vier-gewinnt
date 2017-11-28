/**
 * 
 */
package de.viergewinnt.model;

/**
 * @author lies
 *
 */
public class Farbe {
	
	private int rot;
	
	private int gruen;
	
	private int blau;

	/**
	 * @param rot
	 * @param gruen
	 * @param blau
	 */
	public Farbe(int rot, int gruen, int blau) {
		if(rot > 255 || rot < 0) throw new IllegalArgumentException();
		if(gruen > 255 || gruen < 0) throw new IllegalArgumentException();
		if(blau > 255 || blau < 0) throw new IllegalArgumentException();
		this.rot = rot;
		this.gruen = gruen;
		this.blau = blau;
	}

	/**
	 * @return the rot
	 */
	public int getRot() {
		return rot;
	}

	/**
	 * @return the gruen
	 */
	public int getGruen() {
		return gruen;
	}

	/**
	 * @return the blau
	 */
	public int getBlau() {
		return blau;
	}

	

}
