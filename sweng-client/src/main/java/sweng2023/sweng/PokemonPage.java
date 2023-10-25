package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PokemonPage extends Composite  {

    private static PokemonUiBinder UiBinder = GWT.create(PokemonUiBinder.class);

    private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);

    interface PokemonUiBinder extends UiBinder<Widget, PokemonPage> {
    }

    ArrayList<Carta> carte = new ArrayList<Carta>();
    private Set<String> uniqueTypes = new HashSet<>();
    private Set<String> uniqueRarities = new HashSet<>();

    @UiField
    Button homeBtn;

    @UiField
    TextBox nameFilter;

    @UiField
    ListBox  typesFilter;

    @UiField
    ListBox  rarityFilter;

    @UiField
    Button searchButton;

    @UiField
    FlexTable cardTable;
    
    Utente utente;


    public PokemonPage(Utente utente) {
        initWidget(UiBinder.createAndBindUi(this));
        this.utente = utente;

    }
    
    //Torna alla homepage
    @UiHandler("homeBtn")
    void backHome(ClickEvent e) {
    	RootPanel.get().clear();
		Composite homepage = new Homepage(this.utente);
		RootPanel.get().add(homepage);
    }

    //Effettua la ricerca applicando dei filtri
    @UiHandler("searchButton")
    void onClick(ClickEvent e) {

        FilterPokemon filter = new FilterPokemon();
        filter.setName(nameFilter.getValue());
        filter.setTypes(typesFilter.getSelectedValue());
        filter.setRarity(rarityFilter.getSelectedValue());

        updateTable(carte, filter);



    }

    @Override
    public void onLoad() {
        greetingService.getCarte("pokemon.db", "pokemon",
                new AsyncCallback<ArrayList<Carta>>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        homeBtn.setText("error");

                    }

                    @Override
                    public void onSuccess(ArrayList<Carta> result) {
                        carte.addAll(result);
                        carte = result;
                        updateTable(result,null);
                        uniqueTypes.add("");
                        uniqueRarities.add("");
                        for (Carta carta : carte) {
                            CartaPokemon CartaPokemon = (CartaPokemon) carta;
                            if(CartaPokemon.getTypes()!=null){
                                for(String type : CartaPokemon.getTypes()){
                                    uniqueTypes.add(type);
                                }
                            }

                            uniqueRarities.add(CartaPokemon.getRarity());
                        }
                        // Popola le listbox con elementi unici
                        populateListBox(rarityFilter, uniqueRarities);
                        populateListBox(typesFilter, uniqueTypes);
                    }
                });
    }

    //Popola i listbox 
    private void populateListBox(ListBox listBox, Set<String> items) {
        listBox.clear();
        for (String item : items) {
            listBox.addItem(item);
        }
    }

    //Popola la tabella con i risultati della ricerca
    private void updateTable(ArrayList<Carta> carte, FilterPokemon filter) {
        ArrayList<Carta> filtered;
        cardTable.removeAllRows();
        if (filter == null) {
            filtered = carte;
        } else {
            //applica il filtro
            filtered = new ArrayList<>();
            for (Carta carta : carte) {
                if (filter.passesFilter(carta)) {
                    filtered.add(carta);
                }
            }
        }

        // max length for each row
        final int MAX_WIDTH = 1000;

        int row = 1;
        HorizontalPanel currentRowPanel = new HorizontalPanel();
        int currentWidth = 0;

        for (Carta carta : filtered) {
            Image thumbnail = new Image("https://i.pinimg.com/236x/bb/e0/b1/bbe0b1c06a432360d773b4895bffbb51.jpg");
            thumbnail.addClickHandler(event -> {
                int clickX = event.getClientX();
                int clickY = event.getClientY();
                showDetailsPopup(carta, clickX, clickY);
            });

            int imageWidth = thumbnail.getWidth();
            if (currentWidth + imageWidth <= MAX_WIDTH) {
                currentRowPanel.add(thumbnail);
                currentWidth += imageWidth;
            } else {
                cardTable.setWidget(row, 0, currentRowPanel);
                row++;
                currentRowPanel = new HorizontalPanel();
                currentWidth = imageWidth;
                currentRowPanel.add(thumbnail);
            }
        }
        // Aggiungi l'ultima riga se necessario
        if (currentWidth > 0) {
            cardTable.setWidget(row, 0, currentRowPanel);
        }
    }

    //Visualizza il popup dei dettagli e la lista di utenti
    //che possiedono o desiderano la carta
    private void showDetailsPopup(Carta carta, int clickX, int clickY) {

        CartaPokemon cartaPokemon = (CartaPokemon) carta;
        PopupPanel detailsPopup = new PopupPanel(true);

        VerticalPanel contentPanel = new VerticalPanel();
        contentPanel.add(new HTML("Nome: " + cartaPokemon.getName()));
        contentPanel.add(new HTML("Illustratore: " + cartaPokemon.getIllustrator()));
        contentPanel.add(new HTML("Rarità: " + cartaPokemon.getRarity()));
        contentPanel.add(new HTML("Tipi: " + cartaPokemon.getTypes()));
        contentPanel.add(new HTML("Variants: " + cartaPokemon.getVariants()));
        contentPanel.add(new HTML("Descrizione: " + cartaPokemon.getDescription()));



        detailsPopup.setWidget(contentPanel);

        Button closeButton = new Button("Chiudi");
        Button addPossedutaBtn = new Button("Aggiungi posseduta");
        Button addDesiderataBtn = new Button("Aggiungi desiderata");
        closeButton.addClickHandler(event -> detailsPopup.hide());

        contentPanel.add(closeButton);
        addPossedutaBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//Carica la pagina di aggiunta della carta posseduta
				RootPanel.get().clear();
				Composite dettagli = new DettagliPage(utente, carta, 3, 0);
				RootPanel.get().add(dettagli);
			}
        	
        });
        
        addDesiderataBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//Carica la pagina di aggiunta della carta desiderata
				RootPanel.get().clear();
				Composite dettagli = new DettagliPage(utente, carta, 3 , 1);
				RootPanel.get().add(dettagli);
			}
        	
        });
        
        if(this.utente != null) {
        	contentPanel.add(addPossedutaBtn);
        	contentPanel.add(addDesiderataBtn);
        	this.getPossessori(carta, 0, contentPanel);
        	this.getPossessori(carta, 1, contentPanel);
        }

        int left = clickX - detailsPopup.getOffsetWidth() / 2;
        int top = clickY - detailsPopup.getOffsetHeight() / 2 + Window.getScrollTop();

        detailsPopup.setPopupPosition(left, top);
        detailsPopup.show();


    }
    
  //Visualizza gli utenti che possiedono o desiderano una carta
    private void getPossessori(Carta carta, int tipo, VerticalPanel panel){
    	greetingService.getPossessori(carta, tipo, 
    			new AsyncCallback<ArrayList<String>>(){

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(ArrayList<String> result) {
						for (String possessore: result) {
							if (tipo == 0)
								panel.add(new Label("Posseduta da: " + possessore));
							else
								panel.add(new Label("Desiderata da: " + possessore));
						}
					}
    		
    	});
    }


}