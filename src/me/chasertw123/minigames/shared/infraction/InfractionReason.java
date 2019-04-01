package me.chasertw123.minigames.shared.infraction;

/**
 * Created by Chase on 6/29/2017.
 */
public enum InfractionReason {

    SPAM("Spamming Chat/PMs", "When a player is sending lots of the same message in a short amount of time", 2),
    CAPS("Excessive Caps", "When a player is sending an annoyingly large amount of caps multiple times for no reason", 2),
    PDISRESPECT("Player Disrespect", "When a player is disrespecting another player to the point of a problem occurring", 15),
    SDISRESPECT("Staff Disrespect", "When a player is disrespecting a staff member", 20),
    HACKUSATIONS("Accusing of Hacks", "When a player is accusing a player of hacking an annoying amount of times when it's clear they aren't hacking", 15),
    LANGUAGE("Inappropriate Language", "When a player is using vulgar language in chat", 8),
    OFFENSIVECHARACTER("Offensive Skin/Cape", "When a player's skin/cape is offensive to another player and they won't change it when requested", 8),
    TARGETTING("Targeting Staff/Youtubers", "Intentionally going after staff and youtubers during games", 50),
    IMPERSONATING("Impersonating Staff", "When a player is pretending to be staff", 70),
    ADVERTISING("Advertising", "When a player advertises another server or website deemed not appropriate", 20),
    DISCRIMINATION("Discrimination", "When a player is being racist to another player", 25),
    IRLTHREATS("Threatening Players IRL", "When a player makes threats against a player's actual life or other irl threats", Punishment.PERMANENT_BAN_POINTS),
    DDOSTHREATS("Threatening to DDOS", "When a player makes threats to DDOS the server", Punishment.PERMANENT_BAN_POINTS),
    REVEALINGINFO("Revealing Personal Info", "When a player reveals another person's personal info without their permission", Punishment.PERMANENT_BAN_POINTS),
    PHISHING("Information Phishing", "When a player is trying to obtain information on a player or their account", Punishment.PERMANENT_BAN_POINTS),
    PLOTCONTENT("Inappropriate Plot Content", "When a player's creative plot has content not suitable for other players, and will not change it when asked.", 60),
    EVADING("Ban/Mute Evading", "When a player uses another account to avoid the ban/mute they have on another of their accounts", 60),
    GLITCHES("Exploiting Glitches", "When a player is intentionally exploiting a glitch for their own gain", 60),
    PVP_HACKS("PvP Enhancements", "Hacks used to enhance a players pvp ability giving them an advantage over other players. (Kill Aura/Forcefield, Aimbot, Damage Indicators, Anti Knockback, Regeneration, Speed Hacking, Tracers, Anti Velocity)", 70),
    GAMEPLAY_HACKS("Gameplay Enhancements", "Hacks used to boost a players gameplay giving them advantages outside of pvp. (FastBreak/FastBuild, SafeWalk, FastBridge, Fly Hacking, Jesus Hacks, X-Ray, Spider Hacking, Glide Hacking, Teleport)", 70),
    INVENTORY_HACKS("Inventory Enhancements", "Hacks used to simplify or cut out completely a players use of inventory (Too Many Items, Auto Armor, HoloInventory, Fast Eat)", 60),
    OTHER_HACKS("Other Enhancements", "Any other types of hacks not included in the other categories listed. (Skin Blinker, Derp, Anti-AFK, Etc.)", 50);

    private String reason, description;
    private int punishmentValue;

    InfractionReason(String reason, String description, int punishmentValue) {
        this.reason = reason;
        this.description = description;
        this.punishmentValue = punishmentValue;
    }

    public int getPunishmentValue() {
        return punishmentValue;
    }

    public String getReason() {
        return reason;
    }

    public String getDescription() {
        return description;
    }
}
