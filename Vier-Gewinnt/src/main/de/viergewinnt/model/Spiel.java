/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public class Spiel {
	
	private Spielbrett spielbrett;
	
	private List<Spieler> spieler;

	/**
	 * @param spielbrett
	 * @param spieler
	 */
	public Spiel(Spielbrett spielbrett, List<Spieler> spieler) {
		this.spielbrett = spielbrett;
		this.spieler = spieler;
	}

	/**
	 * @return the spielbrett
	 */
	public Spielbrett getSpielbrett() {
		return spielbrett;
	}

	/**
	 * @return the spieler
	 */
	public List<Spieler> getSpieler() {
		return spieler;
	}
	
	public void starteSpiel(){
		throw new UnsupportedOperationException();
	}

}
