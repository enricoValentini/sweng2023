package sweng2023.sweng;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Miacarta implements Serializable, IsSerializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected	Carta carta;
	protected String descrizione;
	protected int stato;
	
	public Miacarta() {
		this.carta = null;
		this.descrizione = "";
		this.stato = 0;
	}
	
	public Miacarta(Miacarta miaCarta) {
		this.carta = miaCarta.carta;
		this.descrizione = miaCarta.descrizione;
		this.stato = miaCarta.stato;
	}
	
	public Miacarta(Carta carta, String descrizione, int stato) {
		this.carta = carta;
		this.descrizione = descrizione;
		this.stato = stato;
	}
}
