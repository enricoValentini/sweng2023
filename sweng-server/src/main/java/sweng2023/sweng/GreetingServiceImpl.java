package sweng2023.sweng;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.mapdb.*;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public GreetingResponse greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid.
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		GreetingResponse response = new GreetingResponse();

		response.setServerInfo(getServletContext().getServerInfo());
		response.setUserAgent(getThreadLocalRequest().getHeader("User-Agent"));

		response.setGreeting("Hello, test!");

		return response;
	}

	@Override
	public String register(String username, String password) {
		
		String message = "";
		DB db = DBMaker.fileDB("utenti.db").make();
		HTreeMap utenti = db.hashMap("utenti")
				  .keySerializer(Serializer.STRING)
				  .valueSerializer(Serializer.STRING)
				  .createOrOpen();	
		
		if(utenti.get(username) == null) {
			utenti.put(username, password);
			message = "Utente registrato con successo";
		}else {
			message="Utente già registrato! Vai al login";
		}
		

		db.close();
		
		return message;
	}

	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		String message = "";
		
		DB db = DBMaker.fileDB("utenti.db").make();
		HTreeMap utenti = db.hashMap("utenti").createOrOpen();	

		if(utenti.get(username) != null)
			if (utenti.get(username).equals(password))
				message = "ok";
			else
				message = "Errato";
		else
			message = "errato";
		
		db.close();
		return message;
	}


}
