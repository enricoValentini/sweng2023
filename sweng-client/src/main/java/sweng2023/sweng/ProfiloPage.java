package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProfiloPage extends Composite {

	private static ProfiloPageUiBinder uiBinder = GWT.create(ProfiloPageUiBinder.class);

	interface ProfiloPageUiBinder extends UiBinder<Widget, ProfiloPage> {
	}
	
	@UiField
	Button homeBtn;
	@UiField
	Button posseduteBtn;
	@UiField
	Button desiderateBtn;
	
	Utente utente;

	public ProfiloPage(Utente utente) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
	}
	
	@UiHandler("homeBtn")
	//Torna alla homepage
	void backToHome(ClickEvent e) {
		RootPanel.get().clear();
		Composite homepage = new Homepage(this.utente);
		RootPanel.get().add(homepage);
	}
	
	@UiHandler("posseduteBtn")
	//Apri la lista di carte possedute
	void goToPossedute(ClickEvent e) {
		RootPanel.get().clear();
		Composite posseduteDesiderate = new PosseduteDesideratePage(this.utente, 0);
		RootPanel.get().add(posseduteDesiderate);
	}
	
	@UiHandler("desiderateBtn")
	//Apri la lista di carte possedute
	void goToDesiderate(ClickEvent e) {
		RootPanel.get().clear();
		Composite posseduteDesiderate = new PosseduteDesideratePage(this.utente, 1);
		RootPanel.get().add(posseduteDesiderate);
	}

}
