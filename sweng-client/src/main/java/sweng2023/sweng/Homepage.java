package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Homepage extends Composite {

	private static HomepageUiBinder uiBinder = GWT.create(HomepageUiBinder.class);

	interface HomepageUiBinder extends UiBinder<Widget, Homepage> {
	}
	
	@UiField
	Button loginBtn;
	@UiField
	Button logoutBtn;
	@UiField
	Button profileBtn;
	@UiField
	Button yugiohBtn;
	@UiField
	Button magicBtn;
	@UiField
	Button pokemonBtn;
	
	Utente user;
	
	@Override
	public void onLoad() {
		if(this.user != null) {
			this.loginBtn.setVisible(false);
		}else {
			this.logoutBtn.setVisible(false);
			this.profileBtn.setVisible(false);
		}
	}
	
	@UiHandler("loginBtn")
	void loadLogin(ClickEvent e) {
		RootPanel.get().clear();
		Composite login = new Login();
		RootPanel.get().add(login);
	}
	
	@UiHandler("logoutBtn")
	void doLogout(ClickEvent e) {
		RootPanel.get().clear();
		Composite homepage = new Homepage(null);
		RootPanel.get().add(homepage);
	}

	public Homepage(Utente u) {
		initWidget(uiBinder.createAndBindUi(this));
		this.user = u;

	}

}
