package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Loader {
	
	private final static GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	
	public static void loadRegister(String idPanel) {
		final Button registerButton = new Button("Registrati");
		final Button backLoginButton = new Button("Torna al login");
		final TextBox usernameField = new TextBox();
		final TextBox passwordField = new TextBox();
		final Label errorLabel = new Label();
		
		HTML labelsSpace = new HTML("<br>");
		HTML buttonSpace = new HTML("<br>");
		HTML errorLabelSpace = new HTML("<br>");
		
		RootPanel.get(idPanel).add(usernameField);
		RootPanel.get(idPanel).add(labelsSpace);
		RootPanel.get(idPanel).add(passwordField);
		RootPanel.get(idPanel).add(buttonSpace);
		RootPanel.get(idPanel).add(registerButton);
		RootPanel.get(idPanel).add(backLoginButton);
		RootPanel.get(idPanel).add(errorLabelSpace);
		RootPanel.get(idPanel).add(errorLabel);
		
		registerButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				greetingService.register(username, password, new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								errorLabel.setText("error");
							}

							public void onSuccess(String result) {
								errorLabel.setText(result);
							}
						});
			}
		});
		
		backLoginButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {				
				Cleaner.cleanAll(idPanel);
				Loader.loadLogin("login");
			}
		});
	}
	
	public static void loadLogin(String idPanel) {
		final Button loginButton = new Button("Login");
		final Button registerButton = new Button("Registrati");
		final TextBox usernameField = new TextBox();
		final TextBox passwordField = new TextBox();
		final Label errorLabel = new Label();

		HTML labelsSpace = new HTML("<br>");
		HTML buttonsSpace = new HTML("<br>");
		HTML errorLabelSpace = new HTML("<br>");

		RootPanel.get(idPanel).add(usernameField);
		RootPanel.get(idPanel).add(labelsSpace);
		RootPanel.get(idPanel).add(passwordField);
		RootPanel.get(idPanel).add(buttonsSpace);
		RootPanel.get(idPanel).add(loginButton);
		RootPanel.get(idPanel).add(registerButton);
		RootPanel.get(idPanel).add(errorLabelSpace);
		RootPanel.get(idPanel).add(errorLabel);

		registerButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Cleaner.cleanAll(idPanel);
				Loader.loadRegister("register");
			}
		});
		
		loginButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				greetingService.login(username, password, new AsyncCallback<Boolean>() {
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						errorLabel.setText("error");
					}

					public void onSuccess(Boolean result) {
						if(!result) {
							errorLabel.setText("Email o password errate!");
						}else {
							Utente utente = new Utente(username, password);
							Cleaner.cleanAll("login");
						    Loader.loadMainMenu("main-menu", utente);
						}
					}
				});
				/*Cleaner.cleanAll("login");
				Loader.loadRegister("register");*/
			}
		});
	}
	
	public static void loadMainMenu(String idPanel, Utente utente) {
		final Button logoutButton = new Button("Logout");
		final Button yugi = new Button("Yu-gi-oh");
		final Button pokemon = new Button("Pokemon");
		final Button magic = new Button("Magic");
		HTML space1 = new HTML("<br><br>");
		HTML space2 = new HTML("<br>");
		HTML space3 = new HTML("<br>");
		
		
		RootPanel.get(idPanel).add(logoutButton);
		RootPanel.get(idPanel).add(space1);
		RootPanel.get(idPanel).add(yugi);
		RootPanel.get(idPanel).add(space2);
		RootPanel.get(idPanel).add(pokemon);
		RootPanel.get(idPanel).add(space3);
		RootPanel.get(idPanel).add(magic);
		
		logoutButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				utente.destroy();
				Cleaner.cleanAll(idPanel);
				Loader.loadLogin("login");
			}
		});
	}
	
}
