/**
 * 
 */
package de.viergewinnt.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lies
 *
 */
public class SpielbrettFactory implements ISpielbrettFactory {

	private ISpielbrettZelleFactory zellenFactory;

	/**
	 * @param zellenFactory
	 */
	public SpielbrettFactory(ISpielbrettZelleFactory zellenFactory) {

		this.zellenFactory = zellenFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see viergewinnt.core.model.ISpielbrettFactory#create(int, int)
	 */
	@Override
	public Spielbrett create(int anzahlSpalten, int anzahlReihen) {

		// Erstelle zweidimensionales Array aus SpielbrettZellen
		ISpielbrettZelle[][] zweiDimArray = new ISpielbrettZelle[anzahlSpalten][anzahlReihen];
		for (int i = 0; i < anzahlSpalten; i++) {

			for (int j = 0; j < anzahlReihen; j++) {
				zweiDimArray[i][j] = zellenFactory.create(i, j, ZellenTyp.LEERZELLE);
			}
		}

		// Erstelle Liste von Spalten
		List<Spalte> spalteList = new ArrayList<>();
		for (int i = 0; i < anzahlSpalten; i++) {

			List<ISpielbrettZelle> spielbrettZelle = new ArrayList<>();
			Spalte spalte = new Spalte(spielbrettZelle, i);
			spalteList.add(spalte);

			// Spalten müssen unten anfangen, da sonst view des Spielbretts
			// inkorrekt
			for (int j = anzahlReihen - 1; j >= 0; j--) {
				spielbrettZelle.add(zweiDimArray[i][j]);
			}
		}

		// Erstelle Liste von Reihen
		List<Reihe> reiheList = new ArrayList<>();
		for (int i = 0; i < anzahlReihen; i++) {

			List<ISpielbrettZelle> spielbrettZelle = new ArrayList<>();
			Reihe reihe = new Reihe(spielbrettZelle);
			reiheList.add(reihe);

			for (int j = 0; j < anzahlSpalten; j++) {

				spielbrettZelle.add(zweiDimArray[j][i]);
			}
		}

		// Erstelle Liste von Diagonalen
		// Richtung von Links oben nach rechts unten
		List<Diagonale> diagonaleList = new ArrayList<>();

		// Diagonalen nach rechts unten (Spalten)
		for (int i = 0; i < anzahlSpalten; i++) {

			int spaltenIndex = i;
			int reihenIndex = 0;

			List<ISpielbrettZelle> zellenList = new ArrayList<>();

			while (spaltenIndex < anzahlSpalten && reihenIndex < anzahlReihen) {

				zellenList.add(zweiDimArray[spaltenIndex][reihenIndex]);
				spaltenIndex++;
				reihenIndex++;
			}
			if (zellenList.size() >= 4) {
				diagonaleList.add(new Diagonale(zellenList, i, 0, DiagonaleRichtung.NACHRECHTSUNTEN));
			}
		}
		// Diagonalen nach rechts unten (Reihen)
		for (int i = 1; i < anzahlReihen; i++) {

			int spaltenIndex = 0;
			int reihenIndex = i;

			List<ISpielbrettZelle> zellenList = new ArrayList<>();

			while (reihenIndex < anzahlReihen && spaltenIndex < anzahlSpalten) {

				zellenList.add(zweiDimArray[spaltenIndex][reihenIndex]);
				reihenIndex++;
				spaltenIndex++;
			}

			if (zellenList.size() >= 4) {
				diagonaleList.add(new Diagonale(zellenList, 0, i, DiagonaleRichtung.NACHRECHTSUNTEN));
			}

		}

		// Diagonalen nach links unten (Spalten)

		for (int i = anzahlSpalten; i >= 0; i--) {

			int spaltenIndex = i - 1;
			int reihenIndex = 0;

			List<ISpielbrettZelle> zellenList = new ArrayList<>();

			while (spaltenIndex >= 0 && reihenIndex < anzahlReihen) {

				zellenList.add(zweiDimArray[spaltenIndex][reihenIndex]);
				spaltenIndex--;
				reihenIndex++;
			}

			if (zellenList.size() >= 4) {
				diagonaleList.add(new Diagonale(zellenList, i - 1, 0, DiagonaleRichtung.NACHLINKSUNTEN));
			}
		}

		// Diagonalen nach links unten (Reihen)

		for (int i = 1; i < anzahlReihen; i++) {

			int spaltenIndex = anzahlSpalten - 1;
			int reihenIndex = i;

			List<ISpielbrettZelle> zellenList = new ArrayList<>();

			while (spaltenIndex >= 0 && reihenIndex < anzahlReihen) {

				zellenList.add(zweiDimArray[spaltenIndex][reihenIndex]);
				spaltenIndex--;
				reihenIndex++;
			}

			if (zellenList.size() >= 4) {
				diagonaleList.add(new Diagonale(zellenList, anzahlSpalten - 1, i, DiagonaleRichtung.NACHLINKSUNTEN));
			}
		}

		// Gib fertiges Spielbrett zurück
		return new Spielbrett(zweiDimArray, reiheList, spalteList, diagonaleList);
	}

}
