package sweng2023.sweng;

import java.io.Serializable;

public class Varianti implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean firstEdition;
    private boolean holo;
    private boolean normal;
    private boolean reverse;
    private boolean wPromo;
    
    public String toString() {
    	String s = "";
    	s += "First edition: " + (firstEdition ? "Si" : "No") + "\n";
    	s += "Holo: " + (holo ? "Si" : "No") + "\n";
    	s += "Normal: " + (normal ? "Si" : "No") + "\n";
    	s += "Reverse: " + (reverse ? "Si" : "No") + "\n";
    	s += "Promo: " + (wPromo ? "Si" : "No");
    	return s;
    }
}
