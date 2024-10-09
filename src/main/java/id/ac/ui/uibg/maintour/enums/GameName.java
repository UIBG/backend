package id.ac.ui.uibg.maintour.enums;

public enum GameName {
    VALORANT("Valorant"),
    PUBG("PUBG"),
    MOBILE_LEGENDS("Mobile Legends"),
    LOKAPALA("Lokapala");

    private final String gameName;
    GameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return gameName;
    }

}
