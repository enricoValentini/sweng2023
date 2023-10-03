package sweng2023.sweng;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.*;

public class ListenerImpl implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		File yugioh = new File("yugioh.db");
		//**** Carica carte di Yugioh ****
		if (!yugioh.exists()) {
			Gson gson = new Gson();
			List<CartaYugioh> listaYugioh = null;
			Type type = new TypeToken<ArrayList<CartaYugioh>>() {}.getType();
			try (FileReader reader = new FileReader("yugioh.json")) {
				//Deserializza il file
				listaYugioh = gson.fromJson(reader, type);

			} catch (IOException e) {
				e.printStackTrace();
			}

			DB db = DBMaker.fileDB("yugioh.db").make();
			HTreeMap<Integer, CartaYugioh> cartaMap = db.hashMap("yugioh")
					.keySerializer(org.mapdb.Serializer.INTEGER)
					.valueSerializer(org.mapdb.Serializer.JAVA)
					.createOrOpen();

			for (int i = 0; i < listaYugioh.size(); i++) {
				cartaMap.put(i, listaYugioh.get(i));
				System.out.println(cartaMap.get(i).name);
			}

			db.close();
		}

		//**** Carica carte di Magic ****
		File magic = new File("magic.db");
		if (!magic.exists()) {
			Gson gson = new Gson();
			List<CartaMagic> listaMagic = null;
			Type type = new TypeToken<ArrayList<CartaMagic>>() {}.getType();
			try (FileReader reader = new FileReader("magic.json")) {
				//Deserializza il file
				listaMagic = gson.fromJson(reader, type);

			} catch (IOException e) {
				e.printStackTrace();
			}

			DB db = DBMaker.fileDB("magic.db").make();
			HTreeMap<Integer, CartaMagic> cartaMap = db.hashMap("magic")
					.keySerializer(org.mapdb.Serializer.INTEGER)
					.valueSerializer(org.mapdb.Serializer.JAVA)
					.createOrOpen();

			for (int i = 0; i < listaMagic.size(); i++) {
				cartaMap.put(i, listaMagic.get(i));
				System.out.println(listaMagic.get(i).name);
			}

			db.close();
		}

		this.caricaCartePokemon();
	}

	private void caricaCartePokemon() {
		File pokemon = new File("pokemon.db");
		//**** Carica carte di Pokemon ****
		if (!pokemon.exists()) {
			Gson gson = new Gson();
			List<CartaPokemon> listaPokemon = null;
			Type type = new TypeToken<ArrayList<CartaPokemon>>() {}.getType();
			try (FileReader reader = new FileReader("pokemon.json")) {
				//Deserializza il file
				listaPokemon = gson.fromJson(reader, type);

			} catch (IOException e) {
				e.printStackTrace();
			}

			DB db = DBMaker.fileDB("pokemon.db").make();
			HTreeMap<Integer, CartaPokemon> cartaMap = db.hashMap("pokemon")
					.keySerializer(org.mapdb.Serializer.INTEGER)
					.valueSerializer(org.mapdb.Serializer.JAVA)
					.createOrOpen();

			for (int i = 0; i < listaPokemon.size(); i++) {
				cartaMap.put(i, listaPokemon.get(i));
				System.out.println(listaPokemon.get(i).name);
			}

			db.close();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
