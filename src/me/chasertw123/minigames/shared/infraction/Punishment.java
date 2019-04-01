package me.chasertw123.minigames.shared.infraction;

import me.chasertw123.minigames.shared.utils.StringUtil;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Punishment {

    public static final int PERMANENT_BAN_POINTS = 100;
    public static final int BASE_MUTE_POINTS = 15;

    private PunishmentType punishmentType;
    private PunishmentTimeScale timeScale;
    private long dateIssued;

    /**
     * Used to load a active or past Punishment from the Database. Do not use for
     * creating a new Punishment for a player
     *
     * @param punishmentType {@link PunishmentType} determining how they are punished
     * @param timeScale {@link PunishmentTimeScale} determining how long they are punished
     * @param dateIssued When the Punishment was issued
     */
    public Punishment(PunishmentType punishmentType, PunishmentTimeScale timeScale, long dateIssued) {
        this.punishmentType = punishmentType;
        this.timeScale = timeScale;
        this.dateIssued = dateIssued;
    }

    /**
     * Used to create a new Punishment for a player. Do not use to load past Punishments.
     *
     * @param punishmentType {@link PunishmentType} determining how they are punished
     * @param timeScale {@link PunishmentTimeScale} determining how long they are punished
     */
    public Punishment(PunishmentType punishmentType, PunishmentTimeScale timeScale) {
        this(punishmentType, timeScale, System.currentTimeMillis());
    }

    /**
     * Gets {@link PunishmentType}
     * @return PunishmentType determining if ban or mute
     */
    public PunishmentType getType() {
        return punishmentType;
    }

    /**
     * Gets {@link PunishmentTimeScale}
     * @return PunishmentTimeScale determining duration of punishment
     */
    public PunishmentTimeScale getTimeScale() {
        return timeScale;
    }

    /**
     * Gets when the Punishment was issued as a long
     * @return Long when punishment was created
     */
    public long getDateIssued() {
        return dateIssued;
    }

    /**
     * Gets a friendly String that tells how long till date punishment expires
     * @return Punishment time left
     */
    public String getTimeRemaining() {
        return StringUtil.toFriendlyTimeFormat((int) ((dateIssued + timeScale.getUnixTime()) - System.currentTimeMillis()) / 1000);
    }

    /**
     * Create a String briefly describing Punishment
     * @return String briefly describing Punishment
     */
    public String toHistoryString() {
        return new SimpleDateFormat("dd/MM/yy").format(new Date(dateIssued)) + " - " + punishmentType.toString() + " for " + timeScale.toString().replaceAll("_", " ");
    }

    @SuppressWarnings("unchecked")
    public static List<Punishment> serializePunishments(UUID uuid, Document userPunishmentsData) {

        List<Punishment> punishments = new ArrayList<>();
        ((List<String>) userPunishmentsData.get("punishments")).forEach(punishmentString -> {
            String[] objects = punishmentString.split(",, ");
            punishments.add(new Punishment(PunishmentType.valueOf(objects[0]), PunishmentTimeScale.valueOf(objects[1]), Long.valueOf(objects[2])));
        });

        return punishments;
    }

    public static Document parsePunishments(UUID uuid, List<Punishment> punishments) {

        Document punishmentsData = new Document();
        List<String> punishmentsStringList = new ArrayList<>();

        punishments.forEach(punishment -> punishmentsStringList.add(punishment.getType().toString() + ",, " + punishment.getTimeScale().toString() + ",, " + punishment.getDateIssued()));
        punishmentsData.append("uuid", uuid.toString()).append("punishments", punishmentsStringList);

        return punishmentsData;
    }
}
