package sweng2023.sweng;

import java.io.Serializable;

public class CartaMagic extends Carta implements Serializable{
	private String artist;
    private String text;
    private String types;
    private String rarity;
    private boolean hasFoil;
    private boolean isAlternative;
    private boolean isFullArt;
    private boolean isPromo;
    private boolean isReprint;
}
