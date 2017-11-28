/**
 * 
 */
package de.viergewinnt.view;

import java.util.ArrayList;
import java.util.List;

import viergewinnt.core.model.ISpalte;
import viergewinnt.core.model.Linie;

/**
 * @author lies
 *
 */
public class MainViewModel implements IMainViewModel {

	private List<SpielerViewModel> spielerViewModel;

	private SpielbrettViewModel spielbrettViewModel;

	private List<Linie> linien;

	/**
	 * @param spielerViewModel
	 * @param spielbrettViewModel
	 */
	public MainViewModel(List<SpielerViewModel> spielerViewModel, SpielbrettViewModel spielbrettViewModel) {
		this.spielerViewModel = spielerViewModel;
		this.spielbrettViewModel = spielbrettViewModel;
		linien = new ArrayList<>();
		linien.addAll(spielbrettViewModel.getSpielbrett().getSpalten());
		linien.addAll(spielbrettViewModel.getSpielbrett().getReihen());
		linien.addAll(spielbrettViewModel.getSpielbrett().getDiagonalen());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IMainViewModel#getSpielerViewModel()
	 */
	@Override
	public List<SpielerViewModel> getSpielerViewModel() {
		return spielerViewModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IMainViewModel#getSpielbrettViewModel()
	 */
	@Override
	public SpielbrettViewModel getSpielbrettViewModel() {
		return spielbrettViewModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.IMainViewModel#spieleZug(viergewinnt.core.model.ISpalte)
	 */
	@Override
	public void spieleZug(ISpalte spalte) {
		SpielerViewModel aktuellesSpielViewModel = aktuellesSpielerViewModel(spielerViewModel);
		aktuellesSpielViewModel.getSpieler().spieleZug(spalte);
		for (SpielerViewModel model : spielerViewModel) {
			model.getSpieler().setIstAnDerReihe(!model.getSpieler().isIstAnDerReihe());
		}
		updateViewWerIstAnDerReihe();
		hatEinSpielergewonnen();
	}

	public void hatEinSpielergewonnen() {
		String gewinner = null;
		for (Linie linie : linien) {
			gewinner = linie.sindVierSpielsteineInEinerLinie();
			if (gewinner != null) {
				for (SpalteCommand command : spielbrettViewModel.getCommands()) {
					command.getButtonActivity().set(true);
				}
				break;
			}

		}
	}

	public void updateViewWerIstAnDerReihe() {
		for (SpielerViewModel viewModel : spielerViewModel) {
			viewModel.getSpielerIstNichtAnDerReihe().set(!viewModel.getSpieler().isIstAnDerReihe());
		}
	}

	public SpielerViewModel aktuellesSpielerViewModel(List<SpielerViewModel> list) {
		SpielerViewModel viewModel = null;
		for (SpielerViewModel model : list) {
			if (model.getSpieler().isIstAnDerReihe()) {
				viewModel = model;
				break;
			}
		}
		return viewModel;
	}

}
