package sweng2023.sweng;

import java.io.Serializable;
import java.util.List;

public class Deck implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private List<Miacarta> carte;
	
	public Deck(){
		this.nome = "";
		this.carte = null;
	}
	
	public Deck(String nome, List<Miacarta> carte) {
		this.nome = nome;
		this.carte = carte;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public List<Miacarta> getCarte(){
		return this.carte;
	}
}
