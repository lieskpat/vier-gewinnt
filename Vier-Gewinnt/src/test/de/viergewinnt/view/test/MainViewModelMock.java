/**
 * 
 */
package de.viergewinnt.view.test;

import java.util.List;

import de.viergewinnt.model.ISpalte;
import de.viergewinnt.view.IMainViewModel;
import de.viergewinnt.view.ISpielbrettViewModel;
import de.viergewinnt.view.SpielerViewModel;

/**
 * @author lies
 *
 */
public class MainViewModelMock implements IMainViewModel {
	
	private List<SpielerViewModel> spielerViewModels;
	
	private ISpielbrettViewModel spielbrettViewModel;
	
	public MainViewModelMock(List<SpielerViewModel> spielerViewModels, 
			ISpielbrettViewModel spielbrettViewModel) {
		this.spielerViewModels =spielerViewModels;
		this.spielbrettViewModel = spielbrettViewModel;
	}

	@Override
	public List<SpielerViewModel> getSpielerViewModel() {
		
		return spielerViewModels;
	}

	@Override
	public ISpielbrettViewModel getSpielbrettViewModel() {
		
		return spielbrettViewModel;
	}

	@Override
	public void spieleZug(ISpalte spalte) {
		// TODO Auto-generated method stub

	}

}
