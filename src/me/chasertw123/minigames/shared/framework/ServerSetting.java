package me.chasertw123.minigames.shared.framework;

/**
 * Created by Chase on 9/10/2017.
 */
public enum ServerSetting {

    LEAF_DECAY(false, false),
    HUNGER(false, true),
    DAMAGE(false, true),
    ITEM_DROPPING(false, true);

    private boolean defaultValue, effectsPlayer;

    ServerSetting(boolean defaultValue, boolean effectsPlayer) {
        this.defaultValue = defaultValue;
        this.effectsPlayer = effectsPlayer;
    }

    public boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    public boolean effectsPlayer() {
        return effectsPlayer;
    }
}
