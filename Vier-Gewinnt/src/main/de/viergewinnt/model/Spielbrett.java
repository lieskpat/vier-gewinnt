/**
 * 
 */
package de.viergewinnt.model;

import java.util.List;

/**
 * @author lies
 *
 */
public class Spielbrett {

	private ISpielbrettZelle[][] zweiDimArray;
	private List<Reihe> reiheList;
	private List<Spalte> spalteList;
	private List<Diagonale> diagonale;

	/**
	 * @param zweiDimArray
	 * @param reiheList
	 * @param spalteList
	 * @param diagonaleList
	 */
	public Spielbrett(ISpielbrettZelle[][] zweiDimArray, List<Reihe> reiheList, List<Spalte> spalteList,
			List<Diagonale> diagonaleList) {
		this.zweiDimArray = zweiDimArray;
		this.reiheList = reiheList;
		this.spalteList = spalteList;
		this.diagonale = diagonaleList;
	}

	/**
	 * @return the reihe
	 */
	public List<Reihe> getReihen() {
		return reiheList;
	}

	/**
	 * @return the spalte
	 */
	public List<Spalte> getSpalten() {
		return spalteList;
	}

	/**
	 * @return the zellen
	 */
	public ISpielbrettZelle[][] getZellen() {
		return zweiDimArray;
	}

	/**
	 * @return the diagonale
	 */
	public List<Diagonale> getDiagonalen() {
		return diagonale;
	}

}
