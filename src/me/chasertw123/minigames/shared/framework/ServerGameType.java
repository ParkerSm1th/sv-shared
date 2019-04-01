package me.chasertw123.minigames.shared.framework;

/**
 * Created by Chase on 8/10/2017.
 */
public enum ServerGameType {

    WATER_WARS("Water Wars", "water_wars"),
    MCPARTY("MCParty", "mc_party"),
    EVOLUTION("Evolution", "evolution"),
    SPLEGG("Splegg", "splegg");

    private String display, prefabName;

    ServerGameType(String display, String prefabName) {
        this.display = display;
        this.prefabName = prefabName;
    }

    public String getDisplay() {
        return display;
    }

    public String getPrefabName() {
        return prefabName;
    }

    public static ServerGameType find(String name) {
        for(ServerGameType serverGameType : values())
            if(serverGameType.toString().equalsIgnoreCase(name))
                return serverGameType;

        return null;
    }

}
