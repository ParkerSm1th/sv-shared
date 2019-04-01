package me.chasertw123.minigames.shared.infraction;

public enum PunishmentTimeScale {

    HOUR(1000 * 60 * 60),
    SIX_HOURS(HOUR.getUnixTime() * 6),
    DAY(SIX_HOURS.getUnixTime() * 4),
    WEEK(DAY.getUnixTime() * 7),
    MONTH(WEEK.getUnixTime() * 4),
    SIX_MONTHS(MONTH.getUnixTime() * 6),
    YEAR(SIX_MONTHS.getUnixTime() * 2),
    PERMANENT(Long.MAX_VALUE);

    private long unixTime;

    PunishmentTimeScale(long unixTime) {
        this.unixTime = unixTime;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public static PunishmentTimeScale fromNumericalValue(long time) {
        for (PunishmentTimeScale punishmentTimeScale : PunishmentTimeScale.values())
            if (punishmentTimeScale.getUnixTime() == time)
                return punishmentTimeScale;

        return PunishmentTimeScale.HOUR;
    }

}
