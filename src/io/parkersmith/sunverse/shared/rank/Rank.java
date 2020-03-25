package io.parkersmith.sunverse.shared.rank;

import net.md_5.bungee.api.ChatColor;

public enum Rank {

    // Basic Ranks
    MEMBER(ChatColor.GRAY, ChatColor.GRAY, RankType.MEMBER),
    YOUTUBE(ChatColor.RED, RankType.MEMBER, "&c&lY&f&lT"),

    // Staff Ranks
    HELPER(ChatColor.DARK_GREEN, RankType.STAFF, "&2&lHELPER"),
    BUILDER(ChatColor.DARK_AQUA, RankType.STAFF, "&3&lBUILDER"),
    MOD(ChatColor.LIGHT_PURPLE, RankType.STAFF, "&d&lMOD"),
    ADMIN(ChatColor.RED, RankType.UPPERSTAFF, "&c&lADMIN"),
    DEVADMIN(ChatColor.BLUE, RankType.OVERRIDE, "&9&lADMIN"),
    DEV(ChatColor.BLUE, RankType.UPPERSTAFF, "&9&lDEV"),
    OWNER(ChatColor.RED, RankType.UPPERSTAFF, "&c&lOWNER");

    private ChatColor rankColor, chatColor;
    private String prefix;
    private RankType rankType;

    Rank(ChatColor rankColor, ChatColor chatColor, RankType rankType){
        this.rankColor = rankColor;
        this.chatColor = chatColor;
        this.rankType = rankType;
        this.prefix = "";
    }

    Rank(ChatColor rankColor, RankType rankType, String prefix){
        this.rankColor = rankColor;
        this.chatColor = ChatColor.WHITE;
        this.rankType = rankType;
        this.prefix = ChatColor.translateAlternateColorCodes('&', prefix);
    }

    public RankType getRankType() {
        return rankType;
    }

    @Deprecated
    public ChatColor getColor(){
        return rankColor;
    }

    public ChatColor getRankColor() {
        return rankColor;
    }

    public ChatColor getChatColor() {
        return chatColor;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isStaff() {
        return rankType == RankType.STAFF || rankType == RankType.UPPERSTAFF || rankType == RankType.OVERRIDE;
    }

    @Deprecated
    public String getDisplay(){

        if (this == Rank.MEMBER)
            return rankColor + "";

        return rankColor + "" + ChatColor.BOLD + this.toString().replaceAll("_", " ") + rankColor + " ";
    }

    public static Rank fromString(String s){
        for (Rank r : Rank.values())
            if (r.toString().equalsIgnoreCase(s))
                return r;

        return null;
    }

}