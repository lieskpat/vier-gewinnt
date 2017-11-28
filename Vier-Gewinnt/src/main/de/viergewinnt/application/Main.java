package de.viergewinnt.application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import de.viergewinnt.model.Farbe;
import de.viergewinnt.model.ISpalte;
import de.viergewinnt.model.ISpielbrettZelleFactory;
import de.viergewinnt.model.Spielbrett;
import de.viergewinnt.model.SpielbrettFactory;
import de.viergewinnt.model.Spieler;
import de.viergewinnt.model.Spielstein;
import de.viergewinnt.view.MainView;
import de.viergewinnt.view.MainViewModel;
import de.viergewinnt.view.SpalteCommand;
import de.viergewinnt.view.SpielbrettViewModel;
import de.viergewinnt.view.SpielbrettZelleNotificationDecoratorFactory;
import de.viergewinnt.view.SpielerViewModel;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {

			// composition root start

			Farbe spielerFarbeA = new Farbe(255, 0, 0);
			Farbe spielerFarbeB = new Farbe(0, 0, 255);

			Spieler spielerA = erstelleSpieler("Spieler A", spielerFarbeA, true);
			Spieler spielerB = erstelleSpieler("Spieler B", spielerFarbeB, false);

			List<SpalteCommand> commands = new ArrayList<>();

			ISpielbrettZelleFactory zellenFactory = new SpielbrettZelleNotificationDecoratorFactory();
			Spielbrett spielbrett = new SpielbrettFactory(zellenFactory).create(7, 6);
			SpielbrettViewModel spielbrettViewModel = new SpielbrettViewModel(spielbrett, commands);

			@SuppressWarnings("serial")
			List<SpielerViewModel> spielerViewModelList = new ArrayList<SpielerViewModel>() {
				{
					add(new SpielerViewModel(spielerA));
					add(new SpielerViewModel(spielerB));
				}
			};

			MainViewModel mainViewModel = new MainViewModel(spielerViewModelList, spielbrettViewModel);

			for (ISpalte spalte : spielbrett.getSpalten()) {
				commands.add(new SpalteCommand(mainViewModel, spalte));
			}

			MainView controller = new MainView(mainViewModel);

			// composition root end

			primaryStage.setTitle("Vier-Gewinnt");
			primaryStage.setScene(new Scene(controller.getRootNode()));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("serial")
	private static Spieler erstelleSpieler(String spielerName, Farbe spielerFarbe, boolean anDerReihe) {
		List<Spielstein> spielsteine = new ArrayList<Spielstein>() {
			{
				for (int i = 0; i < 21; i++) {
					add(new Spielstein(spielerFarbe, spielerName));
				}
			}
		};
		ObservableList<Spielstein> observableList = FXCollections.observableList(spielsteine);
		return new Spieler(observableList, spielerName, anDerReihe);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
