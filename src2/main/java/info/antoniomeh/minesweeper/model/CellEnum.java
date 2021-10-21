package info.antoniomeh.minesweeper.model;

/**
 * Nemedus Org.
 * User: amartin
 * Date: 12/09/13
 */
public enum CellEnum {

    CELL_MINE ("CELL_MINE","/images/mine.jpg"),
    CELL_CLOSE("CELL_CLOSE","/images/mine_close.png"),
    CELL_EXPLOSION("CELL_EXPLOSION","/images/mine_explosion.jpg"),
    CELL_FLAG("CELL_FLAG","/images/mine_flag.png"),
    CELL_OPEN("CELL_OPEN","/images/mine_open.png");

    private final String name;
    private final String icon;


    CellEnum(String _name, String _icon) {
        name = _name;
        icon = _icon;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }
}