package sweng2023.sweng;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CardsServiceAsync {
	void test(String input, AsyncCallback<String> callback);
}
