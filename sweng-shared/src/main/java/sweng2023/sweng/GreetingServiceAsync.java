package sweng2023.sweng;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<GreetingResponse> callback);
	void register(String username, String password, AsyncCallback<String> callback);
	void login(String username, String password, AsyncCallback<Boolean> callback);
	void getCarte(String filename, String mapName, AsyncCallback<ArrayList<Carta>> callback);
	void addPossedutaDesiderata(String email, Miacarta carta, int tipo, AsyncCallback<Boolean> callback);

}
