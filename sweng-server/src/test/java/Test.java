import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.mapdb.*;

import sweng2023.sweng.Carta;
import sweng2023.sweng.Deck;
import sweng2023.sweng.Miacarta;

class Test {
	
	@org.junit.jupiter.api.Test
	//Test della funzione di login
	void login() {		
		DB db = DBMaker.fileDB("utenti.db").make();
		HTreeMap utenti = db.hashMap("utenti").createOrOpen();	

		assertTrue(utenti.get("test@test.com") != null);
		assertTrue(utenti.get("test@test.com").equals("test"));
		
		db.close();
	}
	
	@org.junit.jupiter.api.Test
	//Test funzione di registrazione
	void register() {
		DB db = DBMaker.fileDB("utenti.db").make();
		HTreeMap utenti = db.hashMap("utenti").createOrOpen();	

		assertTrue(utenti.get("test@test.com") != null);
		
		db.close();
	}
	
	//Test visualizzazione carte
	@org.junit.jupiter.api.Test
	void getCarte() {
		DB db = DBMaker.fileDB("yugioh.db").make();
		HTreeMap<Integer, Carta> carteMap = db.hashMap("yugioh")
				.keySerializer(Serializer.INTEGER)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();

		ArrayList<Carta> carte = new ArrayList<>();
		carte.addAll(carteMap.values());	
		
		db.close();
		
		assertEquals(carte.size(), 200);
	}
	
	@org.junit.jupiter.api.Test
	void addDecks() {
		DB db = DBMaker.fileDB("deck.db").make();
		
		HTreeMap<String, List<Deck>> deck = db.hashMap("deck")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Deck> mieiDeck = new ArrayList<Deck>();
		if (deck.get("test1@test.com") != null) {
			mieiDeck.addAll(deck.get("test1@test.com"));
		}
		
		db.close();
		
		assertEquals(mieiDeck.size(), 1);
		
		
	}
	
	@org.junit.jupiter.api.Test
	void deleteDeck() {
		DB db = DBMaker.fileDB("deck.db").make();
		
		HTreeMap<String, List<Deck>> deck = db.hashMap("deck")
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Deck> mieiDeck = new ArrayList<Deck>();
		if (deck.get("test1@test.com") != null) {
			mieiDeck.addAll(deck.get("test1@test.com"));
		}
		
		db.close();
		
		assertEquals(mieiDeck.size(), 0);
	}
	
	@org.junit.jupiter.api.Test
	void getCartePossedute() {
		String dbName;
		DB db;
		
		db = DBMaker.fileDB("possedute.db").make();
		dbName = "possedute";
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Miacarta> mieCarte = new ArrayList<Miacarta>();
		
		if (carte.get("test1@test.com") != null) {
			mieCarte.addAll(carte.get("test1@test.com"));
		}
		
		db.close();
		
		assertEquals(4, mieCarte.size());
	}
	
	@org.junit.jupiter.api.Test
	void getCarteDesiderate() {
		String dbName;
		DB db;
		
		db = DBMaker.fileDB("desiderate.db").make();
		dbName = "desiderate";
		
		HTreeMap<String, List<Miacarta>> carte = db.hashMap(dbName)
				.keySerializer(Serializer.STRING)
				.valueSerializer(Serializer.JAVA)
				.createOrOpen();
		
		ArrayList<Miacarta> mieCarte = new ArrayList<Miacarta>();
		
		if (carte.get("test1@test.com") != null) {
			mieCarte.addAll(carte.get("test1@test.com"));
		}
		
		db.close();
		
		assertEquals(1, mieCarte.size());
	}
	
	

}
