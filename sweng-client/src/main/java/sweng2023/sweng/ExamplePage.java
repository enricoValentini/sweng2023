package sweng2023.sweng;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ExamplePage extends Composite {

	private static ExamplePageUiBinder uiBinder = GWT.create(ExamplePageUiBinder.class);

	interface ExamplePageUiBinder extends UiBinder<Widget, ExamplePage> {
	}

	public ExamplePage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
