package me.chasertw123.minigames.shared.infraction;

import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Chase on 6/30/2017.
 */
public class Infraction {

    private UUID infracted, staff;
    private String reason;
    private int infractionValue;
    private long dateIssued;

    /**
     * Used to create new Infraction Objects when loading them in from MYSQL
     * not recommended for use when applying a new Infraction to a plauer.
     *
     * @param infracted {@link UUID} of player being punished
     * @param staff {@link UUID} of staff member punishing
     * @param infractionValue Value of Infraction
     * @param reason What player did to deserve Infraction
     * @param dateIssued When was Infraction Issued
     */
    public Infraction(UUID infracted, UUID staff, int infractionValue, String reason, long dateIssued) {
        this.infracted = infracted;
        this.staff = staff;
        this.infractionValue = infractionValue;
        this.reason = reason;
        this.dateIssued = dateIssued;
    }

    /**
     * Used to create new Infraction Objects for a player when a staff member
     * applies a new custom Infraction
     *
     * @param punished {@link UUID} of player being punished
     * @param staff {@link UUID} of staff member punishing
     * @param infractionValue Value of Infraction
     * @param reason What player did to deserve Infraction
     */
    public Infraction(UUID punished, UUID staff, int infractionValue, String reason) {
        this(punished, staff, infractionValue, reason, System.currentTimeMillis());
    }

    /**
     * Used to create new Infraction Objects for a player when a staff member
     * applies a new already made {@link InfractionReason}
     *
     * @param punished {@link UUID} of player being punished
     * @param staff {@link UUID} of staff member punishing
     * @param infractionReason Default {@link InfractionReason} of what applied
     */
    public Infraction(UUID punished, UUID staff, InfractionReason infractionReason) {
        this(punished, staff, infractionReason.getPunishmentValue(), infractionReason.getReason(), System.currentTimeMillis());
    }

    /**
     * Get UUID of player who received the Infraction
     * @return UUID of player that received Infraction
     */
    public UUID getInfracted() {
        return infracted;
    }

    /**
     * Get UUID of staff who gave the Infraction
     * @return UUID of staff that gave Infraction
     */
    public UUID getStaff() {
        return staff;
    }

    /**
     * Get the value of the Infraction
     * @return Value of Infraction
     */
    public int getInfractionValue() {
        return infractionValue;
    }

    /**
     * Get the reason why the player received the Infraction
     * @return Reason player received Infraction
     */
    public String getReason() {
        return reason;
    }

    /**
     * Get when Infraction was issued as Long
     * @return Long when Infraction was created
     */
    public long getDateIssued(){
        return dateIssued;
    }

    /**
     * Create a String briefly describing Infraction
     * @return String briefly describing Infraction
     */
    public String toHistoryString() {
        return new SimpleDateFormat("dd/MM/yy").format(new Date(dateIssued)) + " - " + reason;
    }

    @SuppressWarnings("unchecked")
    public static List<Infraction> serializeInfractions(@NotNull UUID uuid, @NotNull Document userInfractionsData) {

        List<Infraction> infractions = new ArrayList<>();
        ((List<String>) userInfractionsData.get("infractions")).forEach(infractionString -> {
            String[] objects = infractionString.split(",, ");
            infractions.add(new Infraction(uuid, UUID.fromString(objects[0]), Integer.valueOf(objects[1]), objects[2], Long.valueOf(objects[3])));
        });

        return infractions;
    }

    public static Document parseInfractions(UUID uuid, List<Infraction> infractions) {

        Document infractionsData = new Document();
        List<String> infractionsStringList = new ArrayList<>();

        infractions.forEach(infraction -> infractionsStringList.add(infraction.getStaff().toString() + ",, " + infraction.getInfractionValue()
                + ",, " + infraction.getReason() + ",, " + infraction.getDateIssued()));

        infractionsData.append("uuid", uuid.toString()).append("infractions", infractionsStringList);

        return infractionsData;
    }
}
