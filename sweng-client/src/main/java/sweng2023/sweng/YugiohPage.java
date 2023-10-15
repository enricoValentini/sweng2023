package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import java.util.ArrayList;

import org.eclipse.jetty.util.Promise;

public class YugiohPage extends Composite  {

    private static YugiohUiBinder UiBinder = GWT.create(YugiohUiBinder.class);

    private final GreetingServiceAsync greetingService = GWT
            .create(GreetingService.class);

    interface YugiohUiBinder extends UiBinder<Widget, YugiohPage> {
    }

    ArrayList<Carta> carte = new ArrayList<Carta>();
    ArrayList<String> possessori = new ArrayList<String>();

    @UiField
    Button homeBtn;

    @UiField
    FlexTable cardTable;
    
    Utente utente;


    public YugiohPage(Utente utente) {
        initWidget(UiBinder.createAndBindUi(this));
        this.utente = utente;

    }

    @Override
    public void onLoad() {
        greetingService.getCarte("yugioh.db", "yugioh",
                new AsyncCallback<ArrayList<Carta>>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        homeBtn.setText("error");

                    }

                    @Override
                    public void onSuccess(ArrayList<Carta> result) {
                        //carte.addAll(result);
                        updateTable(result);
                    }
                });
    }
    
    @UiHandler("homeBtn")
    void backHome(ClickEvent e) {
    	RootPanel.get().clear();
		Composite homepage = new Homepage(this.utente);
		RootPanel.get().add(homepage);
    }

    private void updateTable(ArrayList<Carta> carte) {
        cardTable.removeAllRows();

        // max length for each row
        final int MAX_WIDTH = 1000;

        int row = 1;
        HorizontalPanel currentRowPanel = new HorizontalPanel();
        int currentWidth = 0;

        for (Carta carta : carte) {
            CartaYugioh cartayugioh = (CartaYugioh) carta;
            Image thumbnail = new Image(cartayugioh.getSmallImageUrl());

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

    private void showDetailsPopup(Carta carta, int clickX, int clickY) {
        PopupPanel detailsPopup = new PopupPanel(true);
        CartaYugioh cartayugioh = (CartaYugioh) carta;

        VerticalPanel contentPanel = new VerticalPanel();
        contentPanel.add(new HTML("Nome: " + cartayugioh.getName()));
        contentPanel.add(new HTML("Tipo: " + cartayugioh.getType()));
        contentPanel.add(new HTML("Descrizione: " + cartayugioh.getDesc()));
        contentPanel.add(new HTML("Razza: " + cartayugioh.getRace()));

        detailsPopup.setWidget(contentPanel);

        Button closeButton = new Button("Chiudi");
        Button addPossedutaBtn = new Button("Aggiungi posseduta");
        Button addDesiderataBtn = new Button("Aggiungi desiderata");
        Label labelPosseduta = new Label("Utenti che possiedono la carta");
        Label labelDesiderata = new Label("Utenti che desiderano la carta");
        closeButton.addClickHandler(event -> detailsPopup.hide());
        
        contentPanel.add(closeButton);
        
        addPossedutaBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//Carica la pagina di aggiunta della carta
				RootPanel.get().clear();
				Composite dettagli = new DettagliPage(utente, carta, 1, 0);
				RootPanel.get().add(dettagli);
			}
        	
        });
        
        addDesiderataBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				//Carica la pagina di aggiunta della carta
				RootPanel.get().clear();
				Composite dettagli = new DettagliPage(utente, carta, 1 , 1);
				RootPanel.get().add(dettagli);
			}
        	
        });
        

        if(this.utente != null) {
        	contentPanel.add(addPossedutaBtn);
        	contentPanel.add(addDesiderataBtn);
        	//contentPanel.add(labelPosseduta);
        	this.getPossessori(carta, 0, contentPanel);
        	//contentPanel.add(labelDesiderata);
        	this.getPossessori(carta, 1, contentPanel);
        }

        int left = clickX - detailsPopup.getOffsetWidth() / 2;
        int top = clickY - detailsPopup.getOffsetHeight() / 2 + Window.getScrollTop();

        detailsPopup.setPopupPosition(left, top);
        detailsPopup.show();
    }
    
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