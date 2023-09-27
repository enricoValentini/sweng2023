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

public class Register extends Composite {

	private static RegisterUiBinder uiBinder = GWT.create(RegisterUiBinder.class);
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	interface RegisterUiBinder extends UiBinder<Widget, Register> {
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
	Button registerBtn;
	@UiField
	Label errorLabel;
	@UiField
	Button loginBtn;

	public Register() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("registerBtn")
	//Chiama il service per registrare il nuovo utente
	void doRegister(ClickEvent e) {
		String username = emailBox.getText();
		String password = passwordBox.getText();
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
	
	@UiHandler("loginBtn")
	//Torna alla pagina di login
	void backToLogin(ClickEvent e) {
		RootPanel.get().clear();
		Composite login = new Login();
		RootPanel.get().add(login);
	}

}
