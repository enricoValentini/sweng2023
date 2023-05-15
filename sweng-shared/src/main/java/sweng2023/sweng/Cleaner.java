package sweng2023.sweng;

import com.google.gwt.user.client.ui.RootPanel;

public class Cleaner {
	public static void cleanAll(String idPanel) {
		RootPanel.get(idPanel).clear();
		
	}
}
