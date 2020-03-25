package io.parkersmith.sunverse.shared.user;

import io.parkersmith.sunverse.shared.infraction.Infraction;
import io.parkersmith.sunverse.shared.infraction.Punishment;
import io.parkersmith.sunverse.shared.rank.Rank;

import java.util.List;
import java.util.UUID;

public interface iUser {

    /**
     * Gets the UUID of the ParadisePlayer
     * @return the UUID of the ParadisePlayer
     */
    UUID getUUID();

    /**
     * Gets the Username of the ParadisePlayer. Be warned that if they're online, this may need to be updated.
     * @return The Username of the ParadisePlayer.
     */
    String getUsername();

    /**
     * Gets the {@link Rank} of the ParadisePlayer.
     * @return the Rank of the ParadisePlayer.
     */
    Rank getRank();

    /**
     * Sets the rank of the ParadisePlayer
     * @param rank the Rank that it should be set to
     */
    void setRank(Rank rank);

    /**
     * Returns the time in which the player's deluxe subscription ends.
     * @return The time in which the player's deluxe subscription ends.
     */
    long getDeluxe();

    /**
     * Returns if the player is Deluxe or not. Checks the time left is bigger than the current time.
     * @return if the player is Deluxe or not.
     */
    boolean isDeluxe();

    /**
     * Gets a list of the Player's Infractions.
     * @return the list of Infractions that the player has gained over time.
     */
    List<Infraction> getInfractions();

    /**
     * Gets a list of the Player's Punishments.
     * @return the list of Punishments that the player has gained over time.
     */
    List<Punishment> getPunishments();

}
