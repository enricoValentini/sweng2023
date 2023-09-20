package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class Homepage extends Composite {

	private static HomepageUiBinder uiBinder = GWT.create(HomepageUiBinder.class);

	interface HomepageUiBinder extends UiBinder<Widget, Homepage> {
	}
	
	@UiField
	Button loginBtn;
	@UiField
	Label label;
	
	
	@UiHandler("loginBtn")
	void onClick(ClickEvent e) {
		this.label.setText("Cliccato!");
	}

	public Homepage(Utente u) {
		//this.label.setStyleName("color:red");
		initWidget(uiBinder.createAndBindUi(this));
	}

}
