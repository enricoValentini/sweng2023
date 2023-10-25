package sweng2023.sweng;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	//void greetServer(String input, AsyncCallback<GreetingResponse> callback);
	void register(String username, String password, AsyncCallback<String> callback);
	void login(String username, String password, AsyncCallback<Boolean> callback);
	void getCarte(String filename, String mapName, AsyncCallback<ArrayList<Carta>> callback);
	void addPossedutaDesiderata(String email, Miacarta carta, int tipo, AsyncCallback<Boolean> callback);
	void getPosseduteDesiderate(String email, int tipo, AsyncCallback<ArrayList<Miacarta>> callback);
	void deletePossedutaDesiderata(String email, int tipo, int indexOf, AsyncCallback<Void> callback);
	void updatePossedutaDesiderata(String email, int tipo, int indexOf, Miacarta updatedCarta, AsyncCallback<Boolean> callback);
	void getPossessori(Carta carta, int tipo, AsyncCallback<ArrayList<String>> callback);
	void getUtenti(AsyncCallback<ArrayList<String>> callback);
	void proponiScambio(Scambio scambio, String emailMittente, AsyncCallback<Boolean> callback);
	void getScambi(String email, AsyncCallback<ArrayList<Scambio>> callback);
	void scambiaCarte(String email, Boolean accepted, int indexOf, AsyncCallback<Boolean> callback);
	void getDecks(String email, AsyncCallback<ArrayList<Deck>> callback);
	void addDeck(String email, Deck deck, AsyncCallback<Boolean> callback);
	void deleteDeck(String email, int indexOf, AsyncCallback<Boolean> callback);
}
