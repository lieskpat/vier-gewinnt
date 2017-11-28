/**
 * 
 */
package de.viergewinnt.view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import de.viergewinnt.model.ISpieler;
import de.viergewinnt.model.Spielstein;

/**
 * @author lies
 *
 */
public class SpielerViewModel implements ISpielerViewModel {

	private ISpieler spieler;

	private StringProperty spielerNameProperty = new SimpleStringProperty();

	private StringProperty spielsteineProperty = new SimpleStringProperty();

	private BooleanProperty spielerIstNichtAnDerReihe = new SimpleBooleanProperty();

	/**
	 * @param spieler
	 */
	public SpielerViewModel(ISpieler spieler) {
		this.spieler = spieler;
		spielerNameProperty.set(spieler.getName());
		spielsteineProperty.set(String.valueOf(spieler.getSpielsteine().size()));
		spielerIstNichtAnDerReihe.set(!spieler.isIstAnDerReihe());
		// Verstehe nicht warum cast, eine ObservableList ist eine List
		ObservableList<Spielstein> list = (ObservableList<Spielstein>) this.spieler.getSpielsteine();
		list.addListener(new ListChangeListener<Spielstein>() {

			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Spielstein> c) {
				spielsteineProperty.set(String.valueOf(spieler.getSpielsteine().size()));

			}

		});
	}

	/**
	 * @return the spielerIstNichtAnDerReihe
	 */
	public BooleanProperty getSpielerIstNichtAnDerReihe() {
		return spielerIstNichtAnDerReihe;
	}

	/**
	 * @return the spielerName
	 */
	public StringProperty getSpielerNameProperty() {
		return spielerNameProperty;
	}

	/**
	 * @return the spielsteineProperty
	 */
	public StringProperty getSpielsteineProperty() {
		return spielsteineProperty;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.ISpielerViewModel#getSpieler()
	 */
	@Override
	public ISpieler getSpieler() {
		return spieler;
	}

}
