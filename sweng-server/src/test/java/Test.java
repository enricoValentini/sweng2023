import static org.junit.jupiter.api.Assertions.*;
import org.mapdb.*;

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

}
