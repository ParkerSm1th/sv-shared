package me.chasertw123.minigames.shared.booster;

import me.chasertw123.minigames.shared.database.Database;
import org.bson.Document;

/**
 * Created by Scott Hiett on 8/4/2017.
 */
public class EventBooster extends NetworkBooster {

    private String reason;

    /**
     * Create an Event Booster from config
     * @param startTime - Time that it started
     * @param endTime - Time that it will end
     * @param multiplier - How much it will times each "score" by
     * @param reason - The reason to have this booster active
     */
    public EventBooster(long startTime, long endTime, int multiplier, String reason) {
        super(startTime, endTime, multiplier);

        this.reason = reason;
    }

    public EventBooster(Database database, long endTime, int multiplier, String reason) {
        this(System.currentTimeMillis(), endTime, multiplier, reason);

        Document document = new Document();
        document.put("endtime", endTime);
        document.put("starttime", getStartTime());
        document.put("multiplier", multiplier);
        document.put("reason", reason);

        database.getMongoCollection(Database.Collection.EVENT_BOOSTERS).insertOne(document);
    }

    public String getReason() {
        return reason;
    }

}
