package me.chasertw123.minigames.shared.booster;

import me.chasertw123.minigames.shared.database.Database;
import org.bson.Document;

import java.util.UUID;

/**
 * Created by Scott Hiett on 8/4/2017.
 */
public class GameBooster extends NetworkBooster {

    private String gameMode;
    private UUID activatorUUID;
    private String activatorName;

    /**
     * Create a Game Booster from config data
     * @param startTime - Start time
     * @param endTime - End time
     * @param multiplier - The amount it will multiply the "score" by
     * @param activatorUUID - Person whom activated the booster
     * @param activatorName - Persno whom activated the booster
     * @param gameMode - The Game Mode it will apply for
     */
    public GameBooster(long startTime, long endTime, int multiplier, UUID activatorUUID, String activatorName, String gameMode) {
        super(startTime, endTime, multiplier);

        this.gameMode = gameMode;
        this.activatorName = activatorName;
        this.activatorUUID = activatorUUID;
    }

    /**
     * Create a new Game Booster at current time
     * @param database - The database that will be saved to
     * @param endTime - End time
     * @param multiplier - The amount it will multiply the "score" by
     * @param activatorUUID - Person whom activated the booster
     * @param activatorName - Person whom activated the booster
     * @param gameMode - The Game Mode it will apply for
     */
    public GameBooster(Database database, long endTime, int multiplier, UUID activatorUUID, String activatorName, String gameMode) {
        this(System.currentTimeMillis(), endTime, multiplier, activatorUUID, activatorName, gameMode);

        Document document = new Document();
        document.put("endtime", endTime);
        document.put("starttime", getStartTime());
        document.put("multiplier", multiplier);
        document.put("activatoruuid", activatorUUID + "");
        document.put("activatorname", activatorName);
        document.put("gamemode", gameMode);

        database.getMongoCollection(Database.Collection.GAME_BOOSTERS).insertOne(document);
    }

    public String getActivatorName() {
        return activatorName;
    }

    public String getGameMode() {
        return gameMode;
    }

    public UUID getActivatorUUID() {
        return activatorUUID;
    }
}
