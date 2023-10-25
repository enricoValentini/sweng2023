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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}
	
	@UiField
	Label labelEmail;
	@UiField
	TextBox emailBox;
	@UiField
	Label labelPassword;
	@UiField
	TextBox passwordBox;
	
	@UiField
	Button loginBtn;
	@UiField
	Button homeBtn;
	@UiField
	Button registerBtn;
	@UiField
	Label errorLabel;

	String text;
	public Login() {
		this.text = "tests";
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	//Effettua il login
	@UiHandler("loginBtn")
	void doLogin(ClickEvent e) {
		String email = emailBox.getText();
		String password = passwordBox.getText();
		greetingService.login(email, password, new AsyncCallback<Boolean>() {
			public void onFailure(Throwable caught) {
				// Show the RPC error message to the user
			}

			public void onSuccess(Boolean result) {
				if(!result) {
					errorLabel.setText("Email o password non corretti!");
				}else {
					Utente utente = new Utente(email, password);
					RootPanel.get().clear();
					Composite homepage = new Homepage(utente);
					RootPanel.get().add(homepage);
				}
			}
		});
		
	}
	
	//Visualizza la pagina di registrazione
	@UiHandler("registerBtn")
	//Carica la pagina di registrazione
	void openRegister(ClickEvent e) {
		RootPanel.get().clear();
		Composite register = new Register();
		RootPanel.get().add(register);
	}
	
	@UiHandler("homeBtn")
	//Torna alla homepage
	void backToHome(ClickEvent e) {
		RootPanel.get().clear();
		Composite homepage = new Homepage(null);
		RootPanel.get().add(homepage);
	}

}
