package me.chasertw123.minigames.shared.rank;

public enum RankType {

    MEMBER(0), DONATOR(1), STAFF(2), UPPERSTAFF(3);

    int rankLevel;

    RankType(int level){
        this.rankLevel = level;
    }

    public int getRankLevel() {
        return rankLevel;
    }

}
