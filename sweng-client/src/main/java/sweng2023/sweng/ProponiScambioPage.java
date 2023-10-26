package sweng2023.sweng;

import java.util.ArrayList;
import java.util.List;

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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ProponiScambioPage extends Composite {

	private static ProponiScambioPageUiBinder uiBinder = GWT.create(ProponiScambioPageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);
	
	interface ProponiScambioPageUiBinder extends UiBinder<Widget, ProponiScambioPage> {
	}
	
	Utente utente;
	List<Button> buttonsPossedute = new ArrayList<Button>();
	List<Button> buttonsDesiderate = new ArrayList<Button>();
	Miacarta daRicevere;
	Miacarta daCedere;
	
	@UiField
	Button scambiBtn;
	@UiField
	Button proponiBtn;
	@UiField
	Label desiderataLabel;
	@UiField
	Label possedutaLabel;
	@UiField
	Label utenteLabel;
	@UiField
	Label errorLabel;
	@UiField
	FlexTable desiderataTable;
	@UiField
	FlexTable possedutaTable;
	
	@UiField
	ListBox utenteBox;
	

	public ProponiScambioPage(Utente utente) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
	}
	
	@Override
	public void onLoad() {
		//restituisce le carte possedute
		greetingService.getPosseduteDesiderate(this.utente.getEmail(), 0,
                new AsyncCallback<ArrayList<Miacarta>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(ArrayList<Miacarta> result) {
						// TODO Auto-generated method stub	
						popolaTableCartePossedute(result);
							
					}

					
                });
		
		//Restituisci le carte desiderate
		greetingService.getPosseduteDesiderate(this.utente.getEmail(), 1,
                new AsyncCallback<ArrayList<Miacarta>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(ArrayList<Miacarta> result) {
						// TODO Auto-generated method stub
						popolaTableCarteDesiderate(result);
					}

					
                });
		
		//Restituisci tutti gli utenti
		greetingService.getUtenti(new AsyncCallback<ArrayList<String>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<String> result) {
				// TODO Auto-generated method stub
				for (String user : result)
					if (user != utente.getEmail())
					utenteBox.addItem(user);
			}

				
            });
	}
	
	//Visualizza le carte desiderate dall'utente
	private void popolaTableCarteDesiderate(ArrayList<Miacarta> result) {
		desiderataTable.setText(0, 0, "Nome");
		desiderataTable.setText(0, 1, "Descrizione");
		desiderataTable.setText(0, 2, "Stato");
		desiderataTable.setText(0, 3, "Gioco");
		desiderataTable.setText(0, 4, "Scambia");
		
		for (int i = 1 ; i <= result.size(); i++) {
			desiderataTable.setText(i, 0, result.get(i - 1).carta.name);
			desiderataTable.setText(i, 1, result.get(i - 1).descrizione);
			desiderataTable.setText(i, 2, String.valueOf(result.get(i - 1).stato));
			
			if (result.get(i - 1).carta instanceof CartaYugioh)
				desiderataTable.setText(i, 3, "Yu-gi-oh");
			else if (result.get(i - 1).carta instanceof CartaMagic)
				desiderataTable.setText(i, 3, "Magic");
			else
				desiderataTable.setText(i, 3, "Pokemon");
			
			Button selectScambio = new Button("NO");
			Miacarta carta = result.get(i - 1);
			
			buttonsDesiderate.add(selectScambio);
			
			selectScambio.addClickHandler(new ClickHandler() {
		        @Override
		        public void onClick(ClickEvent event) {
		        	daRicevere = carta;
		        	if (selectScambio.getText().equals("NO")) {
		        		selectScambio.setText("YES");
		        		for (Button otherButton : buttonsDesiderate) {
		        			if (otherButton != selectScambio)
		        				otherButton.setText("NO");
		        		}
		        	}
		        }
		    });
			desiderataTable.setWidget(i, 4, selectScambio);
		}
	}
	
	//Visualizza le carte possedute dall'utente
	private void popolaTableCartePossedute(ArrayList<Miacarta> result) {
		possedutaTable.setText(0, 0, "Nome");
		possedutaTable.setText(0, 1, "Descrizione");
		possedutaTable.setText(0, 2, "Stato");
		possedutaTable.setText(0, 3, "Gioco");
		possedutaTable.setText(0, 4, "Scambia");
		
		for (int i = 1 ; i <= result.size(); i++) {
			possedutaTable.setText(i, 0, result.get(i - 1).carta.name);
			possedutaTable.setText(i, 1, result.get(i - 1).descrizione);
			possedutaTable.setText(i, 2, String.valueOf(result.get(i - 1).stato));
			
			if (result.get(i - 1).carta instanceof CartaYugioh)
				possedutaTable.setText(i, 3, "Yu-gi-oh");
			else if (result.get(i - 1).carta instanceof CartaMagic)
				possedutaTable.setText(i, 3, "Magic");
			else
				possedutaTable.setText(i, 3, "Pokemon");
			
			Button selectScambio = new Button("NO");
			Miacarta carta = result.get(i - 1);
			
			buttonsPossedute.add(selectScambio);
			
			selectScambio.addClickHandler(new ClickHandler() {
		        @Override
		        public void onClick(ClickEvent event) {
		        	daCedere = carta;
		        	if (selectScambio.getText().equals("NO")) {
		        		selectScambio.setText("YES");
		        		for (Button otherButton : buttonsPossedute) {
		        			if (otherButton != selectScambio)
		        				otherButton.setText("NO");
		        		}
		        	}
		        }
		    });
			possedutaTable.setWidget(i, 4, selectScambio);
		}
	}
	
	@UiHandler("scambiBtn")
	//Torna alla pagina degli scambi
	void backToProfile(ClickEvent e) {
		RootPanel.get().clear();
		Composite scambi = new ScambiPage(this.utente);
		RootPanel.get().add(scambi);
	}
	
	@UiHandler("proponiBtn")
	//Invia una proposta di scambio all'utente designato
	void proponiScambio(ClickEvent e) {
		
		if (daCedere != null && daRicevere != null) {
			Scambio scambio = new Scambio(daCedere, daRicevere, this.utente.getEmail());
			greetingService.proponiScambio(scambio, this.utenteBox.getSelectedValue(), new AsyncCallback<Boolean>() {
	
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
	
				@Override
				public void onSuccess(Boolean result) {
					// TODO Auto-generated method stub
					errorLabel.setText("Richiesta di scambio effettuata con successo");
				}
	
					
	            });
		}else {
			errorLabel.setText("Devi selezionare le 2 carte");
		}
	}

}
