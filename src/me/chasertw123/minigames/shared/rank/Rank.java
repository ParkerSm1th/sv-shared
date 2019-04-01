package me.chasertw123.minigames.shared.rank;

import net.md_5.bungee.api.ChatColor;

public enum Rank {

    // Basic Ranks
    MEMBER(ChatColor.GRAY, ChatColor.GRAY, RankType.MEMBER),
    BUILDER(ChatColor.BLUE, RankType.MEMBER),
    HELPER(ChatColor.DARK_AQUA, RankType.MEMBER),
    YOUTUBE(ChatColor.LIGHT_PURPLE, RankType.MEMBER),

    // Staff Ranks
    MOD(ChatColor.DARK_GREEN, RankType.STAFF),
    ADMIN(ChatColor.RED, RankType.STAFF),
    DEV(ChatColor.RED, RankType.UPPERSTAFF),
    OWNER(ChatColor.RED, RankType.STAFF);

    private ChatColor rankColor, chatColor;
    private RankType rankType;

    Rank(ChatColor rankColor, ChatColor chatColor, RankType rankType){
        this.rankColor = rankColor;
        this.chatColor = chatColor;
        this.rankType = rankType;
    }

    Rank(ChatColor rankColor, RankType rankType){
        this.rankColor = rankColor;
        this.chatColor = ChatColor.WHITE;
        this.rankType = rankType;
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

    public boolean isStaff() {
        return rankType == RankType.STAFF || rankType == RankType.UPPERSTAFF;
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