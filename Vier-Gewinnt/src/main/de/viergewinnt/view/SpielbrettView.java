/**
 * 
 */
package de.viergewinnt.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import de.viergewinnt.model.ISpielbrettZelle;

/**
 * @author lies
 *
 */
public class SpielbrettView extends FXMLView implements Observer {

	private final static String SPIELERBRETTVIEW_PATH = "/de/viergewinnt/view/SpielbrettView.fxml";

	@FXML
	private GridPane spielbrettGridPane;

	@FXML
	private Button buttonSpalte0;

	@FXML
	private Button buttonSpalte1;

	@FXML
	private Button buttonSpalte2;

	@FXML
	private Button buttonSpalte3;

	@FXML
	private Button buttonSpalte4;

	@FXML
	private Button buttonSpalte5;

	@FXML
	private Button buttonSpalte6;

	private SpielbrettViewModel spielbrettViewModel;

	/**
	 * @param spielbrettViewModel
	 */
	public SpielbrettView(SpielbrettViewModel spielbrettViewModel) {
		System.out.println("Spielbrett View was createt");
		this.spielbrettViewModel = spielbrettViewModel;
		initFXMLLoader(SPIELERBRETTVIEW_PATH);

		List<ISpielbrettZelle> zellenList = Arrays.stream(spielbrettViewModel.getSpielbrett().getZellen())
				.flatMap(Arrays::stream).collect(Collectors.toList());
		for (ISpielbrettZelle zelle : zellenList) {
			((Observable) zelle).addObserver(this);
		}
	}

	/**
	 * @return the spielbrettViewModel
	 */
	public ISpielbrettViewModel getSpielbrettViewModel() {
		return spielbrettViewModel;
	}

	@SuppressWarnings("serial")
	@FXML
	public void initialize() {

		System.out.println("Call initialize Spielbrett View");
		List<Button> buttonList = new ArrayList<Button>() {
			{
				add(buttonSpalte0);
				add(buttonSpalte1);
				add(buttonSpalte2);
				add(buttonSpalte3);
				add(buttonSpalte4);
				add(buttonSpalte5);
				add(buttonSpalte6);
			}
		};

		for (int i = 0; i < buttonList.size(); i++) {
			buttonList.get(i).disableProperty()
					.bind(spielbrettViewModel.getSpalteCommandInIndex(i).getButtonActivity());

			buttonList.get(i).setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					spielbrettViewModel.handleButtonEvent(e, buttonList);
				}
			});
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		spielbrettViewModel.spielbrettUpdate(arg, spielbrettGridPane);
	}

}
