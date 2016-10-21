package com.cyber.seyun.sppedjapan.Reaml;

import io.realm.RealmObject;

/**
 * Created by vcs-server on 10/13/16.
 */

public class SettingRealm extends RealmObject {
    private boolean ScreenWord = false;

    public boolean isScreenWord() {
        return ScreenWord;
    }

    public void setScreenWord(boolean screenWord) {
        ScreenWord = screenWord;
    }
}
