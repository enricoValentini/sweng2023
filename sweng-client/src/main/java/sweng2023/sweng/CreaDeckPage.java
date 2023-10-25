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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreaDeckPage extends Composite {

	private static CreaDeckPageUiBinder uiBinder = GWT.create(CreaDeckPageUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);

	interface CreaDeckPageUiBinder extends UiBinder<Widget, CreaDeckPage> {
	}
	
	Utente utente;
	ArrayList<Miacarta> addedCards;
	
	@UiField
	Button decksBtn;
	@UiField
	Button createBtn;
	@UiField
	Label nomeLabel;
	@UiField
	FlexTable cardTable;
	@UiField
	TextBox nomeBox;
	@UiField
	Label errorLabel;

	public CreaDeckPage(Utente utente) {
		initWidget(uiBinder.createAndBindUi(this));
		this.utente = utente;
		this.addedCards = new ArrayList<Miacarta>();
	}
	
	@UiHandler("decksBtn")
	//Torna alla lista dei deck
	void backToDecks(ClickEvent e) {
		RootPanel.get().clear();
		Composite deck = new DeckPage(this.utente);
		RootPanel.get().add(deck);
	}
	
	//Popola la tabella delle carte
	public void onLoad() {
		greetingService.getPosseduteDesiderate(this.utente.getEmail(), 0,
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
						cardTable.setText(0, 1, "Gioco");
						cardTable.setText(0, 2, "Aggiungi");
						
						
						for (int i = 1 ; i <= result.size(); i++) {
							cardTable.setText(i, 0, result.get(i - 1).carta.name);
							
							if (result.get(i - 1).carta instanceof CartaYugioh)
								cardTable.setText(i, 1, "Yu-gi-oh");
							else if (result.get(i - 1).carta instanceof CartaMagic)
								cardTable.setText(i, 1, "Magic");
							else
								cardTable.setText(i, 1, "Pokemon");
							
							Button addBtn = new Button("Aggiungi");
							Miacarta carta = result.get(i - 1);
							
							addBtn.addClickHandler(new ClickHandler() {
							    @Override
							    public void onClick(ClickEvent event) {
							        if (addedCards.contains(carta)) {
							            // If the card is already in the list, remove it and change the button label to "Aggiungi"
							            addedCards.remove(carta);
							            addBtn.setText("Aggiungi");
							        } else {
							            // If the card is not in the list, add it and change the button label to "ADDED"
							            addedCards.add(carta);
							            addBtn.setText("Aggiunta");
							        }
							    	
							    }
							});
							
							cardTable.setWidget(i, 2, addBtn);
							
						}
						
						
						
					}

                });
	}
	
	@UiHandler("createBtn")
	//Torna alla lista dei deck
	void createDeck(ClickEvent e) {
		if (nomeBox.getText() == null || nomeBox.getText().equals("")) {
			errorLabel.setText("Devi inserire un nome");
			return;
		}
		Deck deck = new Deck(nomeBox.getText(), addedCards);
		greetingService.addDeck(this.utente.getEmail(), deck, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				errorLabel.setText(caught.toString());
				
			}

			@Override
			public void onSuccess(Boolean result) {
				// TODO Auto-generated method stub
				errorLabel.setText("Deck creato con successo");
			}
			
		});
	}

}
