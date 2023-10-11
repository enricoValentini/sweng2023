package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class DettagliPage extends Composite {

	private static DettagliPageUiBinder uiBinder = GWT.create(DettagliPageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	interface DettagliPageUiBinder extends UiBinder<Widget, DettagliPage> {
	}
	
	@UiField
	Label statoLabel;
	@UiField
	Label descLabel;
	@UiField
	Button addBtn;
	@UiField
	TextBox descBox;
	@UiField
	ListBox statoBox;
	@UiField
	Label errorLabel;
	@UiField
	Button backBtn;
	
	String email;
	Carta carta;
	int gioco;
	int tipo;
	Utente utente;

	public DettagliPage(Utente utente, Carta carta, int gioco, int tipo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.email = utente.getEmail();
		this.utente = utente;
		this.carta = carta;
		this.gioco = gioco;
		this.tipo = tipo;
	}
	
	@UiHandler("addBtn")
	void addCarta(ClickEvent e){
		String selectedValue = statoBox.getSelectedValue();
		Integer stato = Integer.parseInt(selectedValue);
		String description = descBox.getText() == null || descBox.getText().equals("")? "[no description]" : descBox.getText();
		
		Miacarta miaCarta = new Miacarta(this.carta, description, stato);
		//Aggiungi alla lista di carte possedute
		greetingService.addPossedutaDesiderata(this.email, miaCarta, this.tipo, new AsyncCallback<Boolean>() {
			public void onFailure(Throwable caught) {
				errorLabel.setText("Errore nel server!");
			}

			public void onSuccess(Boolean result) {
				if(result) {
					errorLabel.setText("Carta aggiutna con successo!");
				}
			}
		});
	}
	
	@UiHandler("backBtn")
	void backToListing(ClickEvent e) {
		RootPanel.get().clear();
		Composite listing;
		
		if (this.gioco == 1)
			listing = new YugiohPage(this.utente);
		else if (this.gioco == 2)
			listing = new MagicPage(this.utente);
		else
			listing = new PokemonPage(this.utente);
		
		RootPanel.get().add(listing);
			
	}

}
