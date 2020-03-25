package io.parkersmith.sunverse.shared.framework;

/**
 * Created by Scott Hiett on 20/08/2017.
 */
public enum GeneralServerStatus {

    LOBBY(1), INGAME(2), RESTARTING(3), DELETE(4);

    private int id;

    GeneralServerStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
