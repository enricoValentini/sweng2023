package sweng2023.sweng;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<GreetingResponse> callback);
	void register(String username, String password, AsyncCallback<String> callback);
	void login(String username, String password, AsyncCallback<Boolean> callback);
}
