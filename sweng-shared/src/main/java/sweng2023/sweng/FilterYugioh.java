package sweng2023.sweng;

public class FilterYugioh extends CardFilter {

    protected String race;

    public FilterYugioh(String name, String type, String race) {
        super(name, type);
        this.race = race;
    }

    public FilterYugioh() {
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean passesFilter(Carta carta) {

        if (name != null && !name.isEmpty() && !((CartaYugioh) carta).getName().contains(name)) {
            return false;
        }

        if (race != null && !race.isEmpty() && !((CartaYugioh) carta).getRace().contains(race)) {
            return false;
        }

        if (super.type != null && !super.type.isEmpty() && !((CartaYugioh) carta).getType().contains(super.type)) {
            return false;
        }
        // card passes through the filters
        return true;
    }



}
