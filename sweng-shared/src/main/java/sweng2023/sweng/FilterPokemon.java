package sweng2023.sweng;


public class FilterPokemon extends CardFilter{
    protected String types; // Modifica il tipo del campo "types" a List<String>
    protected String rarity;

    // Costruttore
    public FilterPokemon(String name, String types, String rarity) {
        super(name);
        this.types = types;
        this.rarity = rarity;
    }

    public FilterPokemon(){}


    public String getTypes() {
        return this.types;
    }

    public String getRarity() {
        return this.rarity;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public boolean passesFilter(Carta carta) {

        if (name != null && !name.isEmpty() && !((CartaPokemon) carta).getName().contains(name)) {
            return false;
        }


        if (types != null && !types.isEmpty() && ((CartaPokemon) carta).getTypes() != null
                && !((CartaPokemon) carta).getTypes().contains(types)) {
            return false;
        }




        if (rarity != null && !rarity.isEmpty() && !((CartaPokemon) carta).getRarity().contains(rarity)) {
            return false;
        }

        // card passes through the filters
        return true;
    }
}
