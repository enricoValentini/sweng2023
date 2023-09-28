package sweng2023.sweng;

import java.io.Serializable;
import java.util.List;

public class CartaPokemon extends Carta implements Serializable{
	private String illustrator;
    private String image;
    private String rarity;
    private Varianti variants; // Include the CardAttributes object
    private List<String> types;
    private String description;
}
