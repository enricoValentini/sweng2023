package sweng2023.sweng;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	//GreetingResponse greetServer(String name) throws IllegalArgumentException;
	String register(String username, String password);
	Boolean login(String username, String password);
	ArrayList<Carta> getCarte(String filename, String mapName);
	Boolean addPossedutaDesiderata(String email, Miacarta carta, int tipo);
	ArrayList<Miacarta> getPosseduteDesiderate(String email, int tipo);
	//void deletePossedutaDesiderata(String email, int tipo, ArrayList<Miacarta> mieCarte);
	void deletePossedutaDesiderata(String email, int tipo, int indexOf);
	Boolean updatePossedutaDesiderata(String email, int tipo, int indexOf, Miacarta updatedCarta);
	ArrayList<String> getPossessori(Carta carta, int tipo);
	ArrayList<String> getUtenti();
	Boolean proponiScambio(Scambio scambio, String emailMittente);
	ArrayList<Scambio> getScambi(String email);
	Boolean scambiaCarte(String email, Boolean accepted, int indexOf);
}
