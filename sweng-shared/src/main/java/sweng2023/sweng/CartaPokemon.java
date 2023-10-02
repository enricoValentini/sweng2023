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

    public String getName() {
        return name;
    }

    public String getIllustrator() {
        return illustrator;
    }

    public String getRarity() {
        return rarity;
    }

    public Varianti getVariants() {
        return variants;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getDescription() {
        return description;
    }
}
