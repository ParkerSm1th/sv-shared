package io.parkersmith.sunverse.shared.booster;

/**
 * Created by Scott Hiett on 8/4/2017.
 */
public class NetworkBooster {

    private long endTime, startTime;
    private int multiplier;

    NetworkBooster (long startTime, long endTime, int multiplier) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }

}
