/**
 * 
 */
package de.viergewinnt.view.test;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import de.viergewinnt.view.ISpielerViewModel;

/**
 * @author lies
 *
 */
public class SpielerViewMock {

	private StringProperty spielerNameproperty = new SimpleStringProperty();

	public SpielerViewMock(ISpielerViewModel model) {
		this.model = model;
	}

	/**
	 * @return the property
	 */
	public StringProperty getSpielerNameProperty() {
		return spielerNameproperty;
	}

	/**
	 * @param property
	 *            the property to set
	 */
	public void setSpielerNameProperty(StringProperty property) {
		this.spielerNameproperty = property;
	}

	private ISpielerViewModel model;

	/**
	 * @return the model
	 */
	public ISpielerViewModel getModel() {
		return model;
	}

}
