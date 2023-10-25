package sweng2023.sweng;

import java.io.Serializable;

public class Scambio implements Serializable{
	private Miacarta daCedere;
	private Miacarta daRicevere;
	private String mittente;
	
	public Scambio() {
		this.daCedere = null;
		this.daRicevere = null;
		this.mittente = "";
	}
	
	public Scambio(Miacarta daCedere, Miacarta daRicevere, String mittente) {
		this.daCedere = daCedere;
		this.daRicevere = daRicevere;
		this.mittente = mittente;
	}
	
	public Miacarta getDaCedere() {
		return this.daCedere;
	}
	
	public Miacarta getDaRicevere() {
		return this.daRicevere;
	}
	
	public String getMittente() {
		return this.mittente;
	}
}
