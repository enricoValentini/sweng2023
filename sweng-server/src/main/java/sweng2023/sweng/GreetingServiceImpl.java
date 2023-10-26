package sweng2023.sweng;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.mapdb.*;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	@Override
	//Aggiunge l'utente al db, se non è gia presente
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
	//Effettua il login sulla piattaforma
	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Boolean success = false;

		DB db = DBMaker.fileDB("utenti.db").make();
		HTreeMap utenti = db.hashMap("utenti").createOrOpen();

		if(utenti.get(username) != null)
			if (utenti.get(username).equals(password))
				success = true;
			else
				success = false;
		else
			success = false;

		db.close();
		return success;
	}

	@Override
	//Restituisce la lista di carte di un determinato tipo di gioco
	public ArrayList<Carta> getCarte(String filename, String mapName) {
		DB db = DBMaker.fileDB(filename).make();

		HTreeMap<Integer, Carta> carteMap = db.hashMap(mapName)
				.keySerializer(Serializer.INTEGER)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();

		ArrayList<Carta> carte = new ArrayList<>();
		carte.addAll(carteMap.values());

		db.close();
		return carte;
	}

	@Override
	//Aggiunge una carta alla lista di possedute o desiderate
	public Boolean addPossedutaDesiderata(String email,Miacarta carta, int tipo) {
		String dbName;
		DB db;
		
		if (tipo == 0) {
			db = DBMaker.fileDB("possedute.db").make();
			dbName = "possedute";
		}else {
			db = DBMaker.fileDB("desiderate.db").make();
			dbName = "desiderate";
		}
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		if (carte.get(email) == null) {
			List<Miacarta> owned = new ArrayList<Miacarta>();
			owned.add(carta);
			carte.put(email, owned);
		}else {
			List<Miacarta> mieCarte = carte.get(email);
			mieCarte.add(carta);
			carte.put(email, mieCarte);
		}
		
		db.close();
		return true;
	}

	@Override
	//Restituisce la lista di carte possedute o desiderate
	public ArrayList<Miacarta> getPosseduteDesiderate(String email, int tipo) {
		String dbName;
		DB db;
		
		if (tipo == 0) {
			db = DBMaker.fileDB("possedute.db").make();
			dbName = "possedute";
		}else {
			db = DBMaker.fileDB("desiderate.db").make();
			dbName = "desiderate";
		}
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Miacarta> mieCarte = new ArrayList<Miacarta>();
		
		if (carte.get(email) != null) {
			mieCarte.addAll(carte.get(email));
		}
		
		db.close();
		return mieCarte;
	}

	@Override
	//Elimina una carta posseduta o desiderata
	public void deletePossedutaDesiderata(String email, int tipo, int indexOf) {
		// TODO Auto-generated method stub
		String dbName;
		DB db;
		
		if (tipo == 0) {
			db = DBMaker.fileDB("possedute.db").make();
			dbName = "possedute";
		}else {
			db = DBMaker.fileDB("desiderate.db").make();
			dbName = "desiderate";
		}
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Miacarta> mieCarte = carte.get(email);
		mieCarte.remove(indexOf);
		carte.put(email, mieCarte);
		
		db.close();
	}

	@Override
	//Aggiorna i dettagli di una carta posseduta o desiderata
	public Boolean updatePossedutaDesiderata(String email, int tipo, int indexOf, Miacarta updatedCarta) {
		// TODO Auto-generated method stub
		String dbName;
		DB db;
		
		if (tipo == 0) {
			db = DBMaker.fileDB("possedute.db").make();
			dbName = "possedute";
		}else {
			db = DBMaker.fileDB("desiderate.db").make();
			dbName = "desiderate";
		}
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Miacarta> mieCarte = carte.get(email);
		mieCarte.remove(indexOf);
		mieCarte.add(indexOf, updatedCarta);
		carte.put(email, mieCarte);
		
		db.close();
		
		return true;
	}

	@Override
	//Restituisce gli utenti che possiedono o desiderano una certa carta
	public ArrayList<String> getPossessori(Carta carta, int tipo) {
		String dbName;
		DB db;
		
		if (tipo == 0) {
			db = DBMaker.fileDB("possedute.db").make();
			dbName = "possedute";
		}else {
			db = DBMaker.fileDB("desiderate.db").make();
			dbName = "desiderate";
		}
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<String> possessori = new ArrayList<String>();
		for (Entry<String, List<Miacarta>> entry : carte.entrySet()) {
            String key = entry.getKey();
            List<Miacarta> value = entry.getValue();
            for (Miacarta miaCarta : value) {
            	if (miaCarta.carta.name.equals(carta.name)) {
            		possessori.add(key);
            		break;
            	}
            		
            }
        }
		
		db.close();

		return possessori;
	}

	@Override
	//Restituisce una lista di utenti 
	public ArrayList<String> getUtenti() {
		DB db = DBMaker.fileDB("utenti.db").make();

		HTreeMap<String, String> utenti = db.hashMap("utenti")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.STRING)
				.createOrOpen();
		
		ArrayList<String> allUsers = new ArrayList<String>();
		for (Entry<String, String> entry : utenti.entrySet()) {
			allUsers.add(entry.getKey());
		}
		
		db.close();
		
		return allUsers;
	}

	@Override
	//Invia una proposta di scambio ad un altro utente
	public Boolean proponiScambio(Scambio scambio, String emailMittente) {
		DB db = DBMaker.fileDB("scambi.db").make();

		HTreeMap<String, List<Scambio>> scambi = db.hashMap("scambi")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Scambio> mieiScambi = null;
		if (scambi.get(emailMittente) == null) {
			mieiScambi = new ArrayList<Scambio>();
			mieiScambi.add(scambio);
			scambi.put(emailMittente, mieiScambi);
		}else {
			mieiScambi = scambi.get(emailMittente);
			mieiScambi.add(scambio);
			scambi.put(emailMittente, mieiScambi);
		}
		
		db.close();
		return true;
	}

	@Override
	//Restituisce dutti gli scambi ricevuti per un certo utente
	public ArrayList<Scambio> getScambi(String email) {
		DB db = DBMaker.fileDB("scambi.db").make();

		HTreeMap<String, List<Scambio>> scambi = db.hashMap("scambi")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Scambio> mieiScambi = new ArrayList<Scambio>();
		
		if (scambi.get(email) != null)
			mieiScambi.addAll(scambi.get(email));
		
		db.close();
		
		return mieiScambi;
	}

	@Override
	//Gestisce lo scambio delle carte
	public Boolean scambiaCarte(String email, Boolean accepted, int indexOf) {
		DB db = DBMaker.fileDB("scambi.db").make();
		Boolean success = true;
		
		HTreeMap<String, List<Scambio>> scambi = db.hashMap("scambi")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Scambio> mieiScambi = scambi.get(email);
		Scambio scambio = mieiScambi.get(indexOf);
		
		if (accepted) {
			success = scambiaProprietari(scambio.getMittente(), email, 
					scambio.getDaRicevere().carta.name, scambio.getDaCedere().carta.name, scambio.getDaRicevere().stato);
			
			if (success) {
				mieiScambi.remove(indexOf);
				scambi.put(email, mieiScambi);
			}
			
		}else {
			mieiScambi.remove(indexOf);
			scambi.put(email, mieiScambi);
		}
		
		db.close();
		
		return success;
	}
	
	//Scambia i proprietari delle carte
	private boolean scambiaProprietari(String mittente, String destinatario, String daCedere, String daRicevere, int stato) {
		DB db = DBMaker.fileDB("possedute.db").make();
		Boolean success = false;
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap("possedute")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Miacarta> posseduteDestinatario = carte.get(destinatario);
		List<Miacarta> posseduteMittente = carte.get(mittente);
		Miacarta cartaCeduta = null;
		
		if (posseduteDestinatario != null) {
			for (Miacarta carta : posseduteDestinatario) {
				if (carta.carta.name.equals(daCedere) && carta.stato >= stato) {
					// Create a copy of 'posseduteDestinatario' without the item to remove
			        List<Miacarta> newPosseduteDestinatario = new ArrayList<Miacarta>(posseduteDestinatario);
			        newPosseduteDestinatario.remove(carta);

			        // Update the 'carte' map for the 'mittente' key
			        posseduteMittente.add(carta);

			        // Update the 'carte' map with the modified lists
			        carte.put(destinatario, newPosseduteDestinatario);
			        carte.put(mittente, posseduteMittente);

			        success = true;
			        break;
				}
			}
		}
		
		db.close();
		
		return success;
		
	}

	@Override
	//restituisce la lista di deck
	public ArrayList<Deck> getDecks(String email) {
		DB db = DBMaker.fileDB("deck.db").make();
		
		HTreeMap<String, List<Deck>> deck = db.hashMap("deck")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Deck> mieiDeck = new ArrayList<Deck>();
		
		if (deck.get(email) != null) {
			mieiDeck.addAll(deck.get(email));
		}
		
		db.close();
		
		return mieiDeck;
	}

	@Override
	//Aggiunge un deck alla lista dei deck
	public Boolean addDeck(String email, Deck deck) {
		DB db = DBMaker.fileDB("deck.db").make();
		
		HTreeMap<String, List<Deck>> decks = db.hashMap("deck")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Deck> mieiDeck = null;
		if (decks.get(email) == null) {
			mieiDeck = new ArrayList<Deck>();
			mieiDeck.add(deck);
			decks.put(email, mieiDeck);
		}else {
			mieiDeck= decks.get(email);
			mieiDeck.add(deck);
			decks.put(email, mieiDeck);
		}
		
		db.close();
		return true;
	}

	@Override
	public Boolean deleteDeck(String email, int indexOf) {
		DB db = DBMaker.fileDB("deck.db").make();
		
		HTreeMap<String, List<Deck>> decks = db.hashMap("deck")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		List<Deck> mieiDeck = decks.get(email);
		mieiDeck.remove(indexOf);
		decks.put(email, mieiDeck);
		
		db.close();
		
		return true;
	}
}
