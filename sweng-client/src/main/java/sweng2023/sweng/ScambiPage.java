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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ScambiPage extends Composite {

	private static ScambiPageUiBinder uiBinder = GWT.create(ScambiPageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);

	interface ScambiPageUiBinder extends UiBinder<Widget, ScambiPage> {
	}
	
	Utente utente;
	
	@UiField
	Button profileBtn;
	@UiField
	Button proponiBtn;
	@UiField
	FlexTable scambiTable;
	@UiField
	Label errorLabel;

	public ScambiPage(Utente utente) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
	}
	
	@Override
	//Visualizza tutti gli scambi ricevuti dall'utente 
	public void onLoad() {
		greetingService.getScambi(this.utente.getEmail(),
                new AsyncCallback<ArrayList<Scambio>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						scambiTable.setText(0, 0,caught.toString());
					}

					@Override
					public void onSuccess(ArrayList<Scambio> result) {
						// TODO Auto-generated method stub
						if (result.size() != 0) {
							scambiTable.setText(0, 0, "Carta da cedere");
							scambiTable.setText(0, 1, "Carta da ricevere");
							scambiTable.setText(0, 2, "Accetta");
							scambiTable.setText(0, 3, "Rifiuta");
							scambiTable.setText(0,4, "Condizione minima");
						}else {
							errorLabel.setText("Nessuno scambio ancora proposto");
						}
						
						for (int i = 1 ; i <= result.size(); i++) {
							scambiTable.setText(i, 0, result.get(i - 1).getDaRicevere().carta.name);
							scambiTable.setText(i, 1, result.get(i - 1).getDaCedere().carta.name);
							
							Scambio scambio = result.get(i - 1);
							Button refuse = new Button("Rifiuta");
							Button accept = new Button("Accetta");
							
							accept.addClickHandler(new ClickHandler() {

								@Override
								//Scambio accettato
								public void onClick(ClickEvent event) {
									aggiornaScambi(true, result.indexOf(scambio));
								}
					        	
					        });
							
							refuse.addClickHandler(new ClickHandler() {

								@Override
								//Scambio rifiutato
								public void onClick(ClickEvent event) {
									aggiornaScambi(false, result.indexOf(scambio));
								}
					        	
					        });
							
							scambiTable.setWidget(i, 2, accept);
							scambiTable.setWidget(i, 3, refuse);
							scambiTable.setText(i, 4, result.get(i - 1).getDaRicevere().stato + "");
						}
						
						
					}


                });	
		
	}
	
	//Chiama RPC per rifiutare lo scambio a accettarlo
	private void aggiornaScambi(Boolean accepted, int indexOf) {
		greetingService.scambiaCarte(this.utente.getEmail(), accepted, indexOf,
                new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Boolean result) {
						RootPanel.get().clear();
						Composite scambi = new ScambiPage(utente);
						RootPanel.get().add(scambi);	
					}

					
                });	
	}
	
	@UiHandler("profileBtn")
	//Torna al profilo
	void backToProfile(ClickEvent e) {
		RootPanel.get().clear();
		Composite profilo = new ProfiloPage(this.utente);
		RootPanel.get().add(profilo);
	}
	
	@UiHandler("proponiBtn")
	//Va alla pagina di proposta scambio
	void proponiScambio(ClickEvent e) {
		RootPanel.get().clear();
		Composite proposta = new ProponiScambioPage(this.utente);
		RootPanel.get().add(proposta);
	}

}
