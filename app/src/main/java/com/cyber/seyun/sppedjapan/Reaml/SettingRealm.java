package com.cyber.seyun.sppedjapan.Reaml;

import io.realm.RealmObject;

/**
 * Created by vcs-server on 10/13/16.
 */

public class SettingRealm extends RealmObject {
    private boolean ScreenWord = false;
    private int level = 0;

    public int getLevel() { return level;}
    public void setLevel(int level) { this.level = level;}
    public boolean isScreenWord() {
        return ScreenWord;
    }

    public void setScreenWord(boolean screenWord) {
        ScreenWord = screenWord;
    }
}
