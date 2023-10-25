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
	Button PokemonBtn;
	
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
	
	//Visualizza la pagina di login
	@UiHandler("loginBtn")
	void loadLogin(ClickEvent e) {
		RootPanel.get().clear();
		Composite login = new Login();
		RootPanel.get().add(login);
	}
	
	//Esegue il logout
	@UiHandler("logoutBtn")
	void doLogout(ClickEvent e) {
		RootPanel.get().clear();
		Composite homepage = new Homepage(null);
		RootPanel.get().add(homepage);
	}

	//Visualizza la pagina delle carte di Yugioh
	@UiHandler("yugiohBtn")
	void yugioh(ClickEvent e) {
		RootPanel.get().clear();
		Composite yugioh = new YugiohPage(this.user);
		RootPanel.get().add(yugioh);
	}

	//Visualizza la pagina delle carte di Pokemon
	@UiHandler("PokemonBtn")
	void pokemon(ClickEvent e) {
		RootPanel.get().clear();
		Composite pokemon = new PokemonPage(this.user);
		RootPanel.get().add(pokemon);
	}

	//Visualizza la pagina delle carte di MTG
	@UiHandler("magicBtn")
	void magic(ClickEvent e) {
		RootPanel.get().clear();
		Composite magic = new MagicPage(this.user);
		RootPanel.get().add(magic);
	}

	//Visualizza il profilo personale dell'utente loggato
	@UiHandler("profileBtn")
	void openProfile(ClickEvent e) {
		RootPanel.get().clear();
		Composite profilo = new ProfiloPage(this.user);
		RootPanel.get().add(profilo);
	}



	public Homepage(Utente u) {
		initWidget(uiBinder.createAndBindUi(this));
		this.user = u;

	}

}
