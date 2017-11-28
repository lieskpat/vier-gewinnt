/**
 * 
 */
package de.viergewinnt.view;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * @author lies
 *
 */
public class MainView extends FXMLView {

	private static final String MAINVIEW_PATH = "/view/MainView.fxml";

	private MainViewModel mainViewModel;

	@FXML
	private Button buttonTest;

	@FXML
	private GridPane playerOneView;

	@FXML
	private GridPane playerTwoView;

	@FXML
	private GridPane gameBoardView;

	/**
	 * @param mainViewModel
	 */
	public MainView(MainViewModel mainViewModel) {
		System.out.println("Main View was createt");
		this.mainViewModel = mainViewModel;
		initFXMLLoader(MAINVIEW_PATH);
	}

	/**
	 * @return the viewModel
	 */
	public MainViewModel getViewModel() {
		return mainViewModel;
	}

	@FXML
	public void initialize() {

		System.out.println("Call initialize Main View");

		// initialize the next controller (SpielerView)
		SpielerView playerOne = new SpielerView(mainViewModel.getSpielerViewModel().get(0));
		Parent rootViewPlayerOne = playerOne.getRootNode();
		this.playerOneView.getChildren().add(rootViewPlayerOne);

		SpielerView playerTwo = new SpielerView(mainViewModel.getSpielerViewModel().get(1));
		Parent rootViewPlayerTwo = playerTwo.getRootNode();
		this.playerTwoView.getChildren().add(rootViewPlayerTwo);

		SpielbrettView boardView = new SpielbrettView(mainViewModel.getSpielbrettViewModel());
		Parent rootBoardView = boardView.getRootNode();
		this.gameBoardView.getChildren().add(rootBoardView);
	}

}
