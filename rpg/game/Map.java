package IHM.rpg.game;

public class Map {
    static final String[][] MAP_TEMPLATE_DEFAULT = {
            {"P", "D", "D", "S"},
            {"", "D", "", ""},
            {"", "D", "", "D"},
            {"", "", "", "D"},
    };

    private String[][] map;

    public Map() {
        this.map = MAP_TEMPLATE_DEFAULT;
    }

    public String[][] getMap() {
        return this.map;
    }



}
