package sweng2023.sweng;

public class CardFilter {

    protected String name;
    protected String type;


    public CardFilter(String name, String type) {

    }

    public CardFilter(String name) {
    }

    public CardFilter() {}

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

}