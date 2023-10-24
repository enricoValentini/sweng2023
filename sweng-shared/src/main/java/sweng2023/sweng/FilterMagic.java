package sweng2023.sweng;

import java.util.List;

public class FilterMagic extends CardFilter {

    protected String artist;
    protected String rarity;

    public FilterMagic(String name, String artist, String type, String rarity) {
        super(name,type);
        this.artist = artist;
        this.rarity = rarity;
    }

    public FilterMagic() {
    }


    public String getArtist() {
        return this.artist;
    }

    public String getRarity(){
        return this.rarity;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public boolean passesFilter(Carta carta) {

            if (name != null && !name.isEmpty() && !((CartaMagic) carta).getName().contains(name)) {
                return false;
            }

            if (artist != null && !artist.isEmpty() && !((CartaMagic) carta).getArtist().contains(artist)) {
                return false;
            }

            if (type != null && !type.isEmpty() && !((CartaMagic) carta).getType().contains(type)) {
                return false;
            }

            if (rarity != null && !rarity.isEmpty() && !((CartaMagic) carta).getRarity().contains(rarity)) {
                return false;
            }

            // card passes through the filters
            return true;
        }

}

