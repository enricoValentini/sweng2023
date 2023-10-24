package sweng2023.sweng;

import java.io.Serializable;

public class CartaMagic extends Carta implements Serializable{
	private String artist;
    private String text;
    private String type;
    private String rarity;
    private boolean hasFoil;
    private boolean isAlternative;
    private boolean isFullArt;
    private boolean isPromo;
    private boolean isReprint;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getRarity() {
        return rarity;
    }

    public String hasFoil() {
        return hasFoil ? "Sì" : "No";
    }

    public String isAlternative() {
        return isAlternative ? "Sì" : "No";
    }

    public String isFullArt() {
        return isFullArt ? "Sì" : "No";
    }

    public String isPromo() {
        return isPromo ? "Sì" : "No";
    }

    public String isReprint() {
        return isReprint ? "Sì" : "No";
    }

}
