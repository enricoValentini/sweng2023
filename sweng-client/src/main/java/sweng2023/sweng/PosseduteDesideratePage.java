package sweng2023.sweng;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.HeadingElement;
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

public class PosseduteDesideratePage extends Composite {

	private static PosseduteDesideratePageUiBinder uiBinder = GWT.create(PosseduteDesideratePageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);
	
	interface PosseduteDesideratePageUiBinder extends UiBinder<Widget, PosseduteDesideratePage> {
	}
	
	Utente utente;
	int tipo;
	@UiField
	FlexTable cardTable;
	@UiField
	Label errorLabel;
	@UiField
	HeadingElement myHeader;
	@UiField
	Button profileBtn;

	public PosseduteDesideratePage(Utente utente, int tipo) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
		this.tipo = tipo;
	}
	
	@Override
	//Popola la tabella delle carte
	public void onLoad() {		
		if (this.tipo == 0)
			this.myHeader.setInnerText("Carte possedute");
		else
			this.myHeader.setInnerText("Carte desiderate");
		
		greetingService.getPosseduteDesiderate(this.utente.getEmail(), this.tipo,
                new AsyncCallback<ArrayList<Miacarta>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						cardTable.setText(0, 0, "error");
					}

					@Override
					public void onSuccess(ArrayList<Miacarta> result) {
						if (result.size() == 0){
							errorLabel.setText("Non hai alcuna carta posseduta ancora");
							return;
						}
						cardTable.setText(0, 0, "Nome");
						cardTable.setText(0, 1, "Descrizione");
						cardTable.setText(0, 2, "Stato");
						cardTable.setText(0, 3, "Gioco");
						cardTable.setText(0, 4, "Elimina");
						cardTable.setText(0, 5, "Aggiorna");
						
						
						for (int i = 1 ; i <= result.size(); i++) {
							cardTable.setText(i, 0, result.get(i - 1).carta.name);
							cardTable.setText(i, 1, result.get(i - 1).descrizione);
							cardTable.setText(i, 2, String.valueOf(result.get(i - 1).stato));
							
							if (result.get(i - 1).carta instanceof CartaYugioh)
								cardTable.setText(i, 3, "Yu-gi-oh");
							else if (result.get(i - 1).carta instanceof CartaMagic)
								cardTable.setText(i, 3, "Magic");
							else
								cardTable.setText(i, 3, "Pokemon");
							
							Button deleteCard = new Button("Elimina");
							Button updateCard = new Button("Aggiorna");
							Miacarta carta = result.get(i - 1);
							
							deleteCard.addClickHandler(new ClickHandler() {

								@Override
								//Elimina la carta
								public void onClick(ClickEvent event) {
									callDelete(result.indexOf(carta));
								}
					        	
					        });
							
							updateCard.addClickHandler(new ClickHandler() {

								@Override
								//Visualizza la pagina di modifica della carta
								public void onClick(ClickEvent event) {
									RootPanel.get().clear();
									Composite update = new UpdatePage(utente, carta, tipo, result);
									RootPanel.get().add(update);
								}
					        	
					        });
							
							cardTable.setWidget(i, 4, deleteCard);
							cardTable.setWidget(i, 5, updateCard);
						}
					}

                });
		
		
	}
	
	//Invoca il service che si occupa di eliminare la carta
	private void callDelete(int indexOf) {
		greetingService.deletePossedutaDesiderata(utente.getEmail(), this.tipo, indexOf,
                new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Void result) {
						RootPanel.get().clear();
						Composite posseduteDesiderate = new PosseduteDesideratePage(utente, tipo);
						RootPanel.get().add(posseduteDesiderate);
					}


        });
	}
	
	@UiHandler("profileBtn")
	//Torna alla home
	void backToProfile(ClickEvent e) {
		RootPanel.get().clear();
		Composite homepage = new Homepage(this.utente);
		RootPanel.get().add(homepage);
	}


}
