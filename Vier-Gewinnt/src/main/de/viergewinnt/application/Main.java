package de.viergewinnt.application;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import viergewinnt.core.model.Farbe;
import viergewinnt.core.model.ISpalte;
import viergewinnt.core.model.ISpielbrettZelleFactory;
import viergewinnt.core.model.Spielbrett;
import viergewinnt.core.model.SpielbrettFactory;
import viergewinnt.core.model.Spieler;
import viergewinnt.core.model.Spielstein;
import view.MainView;
import view.MainViewModel;
import view.SpalteCommand;
import view.SpielbrettViewModel;
import view.SpielbrettZelleNotificationDecoratorFactory;
import view.SpielerViewModel;

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
