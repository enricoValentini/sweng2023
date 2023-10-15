package sweng2023.sweng;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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

public class UpdatePage extends Composite {

	private static UpdatePageUiBinder uiBinder = GWT.create(UpdatePageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);

	interface UpdatePageUiBinder extends UiBinder<Widget, UpdatePage> {
	}
	
	Utente utente;
	Miacarta carta;
	int tipo;
	ArrayList<Miacarta> carte;
	
	@UiField
	Button backBtn;
	@UiField
	Button updateBtn;
	@UiField
	TextBox descBox;
	@UiField
	ListBox statoBox;
	@UiField
	Label errorLabel;
	@UiField
	Label statoLabel;
	@UiField
	Label descLabel;

	public UpdatePage(Utente utente, Miacarta carta, int tipo, ArrayList<Miacarta> carte) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
		this.carta = carta;
		this.tipo = tipo;
		this.carte = carte;
	}
	
	@Override
	public void onLoad() {
		this.descBox.setText(this.carta.descrizione);
		this.statoBox.setItemSelected(this.carta.stato - 1, true);
	}
	
	@UiHandler("updateBtn")
	void updateCarta(ClickEvent e) {
		String selectedValue = statoBox.getSelectedValue();
		Integer stato = Integer.parseInt(selectedValue);
		String description = descBox.getText() == null || descBox.getText().equals("")? "[no description]" : descBox.getText();
		
		Miacarta updatedCarta = new Miacarta(this.carta.carta, description, stato);
		greetingService.updatePossedutaDesiderata(this.utente.getEmail(), this.tipo, carte.indexOf(carta), updatedCarta,
                new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						errorLabel.setText("Dettagli aggiornati con successo!");
					}


                });
	}
	
	@UiHandler("backBtn")
	void backtoCards(ClickEvent e){
		RootPanel.get().clear();
		Composite posseduteDesiderate = new PosseduteDesideratePage(this.utente, this.tipo);
		RootPanel.get().add(posseduteDesiderate);
	}

}
