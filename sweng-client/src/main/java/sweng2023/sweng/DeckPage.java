package sweng2023.sweng;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class DeckPage extends Composite {

	private static DeckPageUiBinder uiBinder = GWT.create(DeckPageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);

	interface DeckPageUiBinder extends UiBinder<Widget, DeckPage> {
	}

	Utente utente;
	
	@UiField
	Button profileBtn;
	@UiField
	Button createBtn;
	@UiField
	FlexTable deckTable;
	@UiField
	Label errorLabel;
	
	public DeckPage(Utente utente) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
	}
	
	@Override
	//Visualizza tutti i deck dell'utente
	public void onLoad() {
		greetingService.getDecks(this.utente.getEmail(), new AsyncCallback<ArrayList<Deck>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList<Deck> result) {
				// TODO Auto-generated method stub
				if (result.size() != 0) {
					deckTable.setText(0, 0, "Nome del deck");
					deckTable.setText(0, 1, "Visualizza carte");
					deckTable.setText(0, 2, "Elimina deck");
				}else {
					errorLabel.setText("Non hai ancora alcun deck");
				}
				
				for (int i = 1 ; i <= result.size(); i++) {
					deckTable.setText(i, 0, result.get(i - 1).getNome());
					
					Button viewCards = new Button("Visualizza");
					Button deleteDeck = new Button("Elimina");
					Deck deck = result.get(i - 1);
					
					viewCards.addClickHandler(new ClickHandler() {
					    @Override
					    //Visualizza le carte contenute nel deck
					    public void onClick(ClickEvent event) {
					    	int clickX = event.getClientX();
			                int clickY = event.getClientY();
					    	showPopup(deck.getCarte(), clickX, clickY);
					    }
					});
					
					deleteDeck.addClickHandler(new ClickHandler() {
					    @Override
					    //Elimina il deck
					    public void onClick(ClickEvent event) {
					    	callDelete(result.indexOf(deck));
					    }
					});
					deckTable.setWidget(i, 1, viewCards);
					deckTable.setWidget(i, 2, deleteDeck);
				}
			}
			
		});
	}
	
	//Chiama il service per eliminare il deck
	private void callDelete(int indexOf) {
		greetingService.deleteDeck(this.utente.getEmail(), indexOf, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Boolean result) {
				RootPanel.get().clear();
				Composite deck = new DeckPage(utente);
				RootPanel.get().add(deck);
			}
			
		});
	}
	
	private void showPopup(List<Miacarta> carte, int clickX, int clickY){
		PopupPanel cartePopup = new PopupPanel(true);
		Button closeButton = new Button("Chiudi");
		VerticalPanel contentPanel = new VerticalPanel();
		
		cartePopup.add(contentPanel);
        closeButton.addClickHandler(event -> cartePopup.hide());
        
        for (Miacarta carta : carte) {
        	contentPanel.add(new HTML(carta.carta.name));
        }
        
        contentPanel.add(closeButton);
        
        int left = clickX - cartePopup.getOffsetWidth() / 2;
        int top = clickY - cartePopup.getOffsetHeight() / 2 + Window.getScrollTop();

        cartePopup.setPopupPosition(left, top);
        cartePopup.show();
	}
	
	@UiHandler("profileBtn")
	//Torna alla pagina del profilo
	void backHome(ClickEvent e) {
		RootPanel.get().clear();
		Composite profilo = new ProfiloPage(this.utente);
		RootPanel.get().add(profilo);
	}
	
	@UiHandler("createBtn")
	//Visualizza la pagina di creazione deck
	void goToCreate(ClickEvent e) {
		RootPanel.get().clear();
		Composite crea = new CreaDeckPage(this.utente);
		RootPanel.get().add(crea);
	}
	
	

}
