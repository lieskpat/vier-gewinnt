/**
 * 
 */
package de.viergewinnt.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import de.viergewinnt.model.Farbe;

/**
 * @author lies
 *
 */
public class SpielerView extends FXMLView {

	private final static String SPIELERVIEW_PATH = "/view/SpielerView.fxml";

	@FXML
	private Label spielerNameLabel;

	@FXML
	private Label spielsteineLabel;

	private SpielerViewModel spielerViewModel;

	/**
	 * @param viewModel
	 */
	public SpielerView(SpielerViewModel viewModel) {
		System.out.println("Spieler View was createt");
		this.spielerViewModel = viewModel;
		initFXMLLoader(SPIELERVIEW_PATH);
	}

	/**
	 * @return the viewModel
	 */
	public ISpielerViewModel getViewModel() {
		return spielerViewModel;
	}

	/**
	 * @return the spielerNameLabel
	 */
	public Label getSpielerNameLabel() {
		return spielerNameLabel;
	}

	@FXML
	public void initialize() {

		System.out.println("Call initialize Spieler View");
		Farbe farbe = spielerViewModel.getSpieler().getSpielsteine().get(0).getFarbe();
		spielerNameLabel.setTextFill(Color.rgb(farbe.getRot(), farbe.getGruen(), farbe.getBlau()));
		spielerNameLabel.disableProperty().bind(spielerViewModel.getSpielerIstNichtAnDerReihe());
		spielerNameLabel.textProperty().bind(spielerViewModel.getSpielerNameProperty());
		spielsteineLabel.textProperty().bind(spielerViewModel.getSpielsteineProperty());
	}

}
