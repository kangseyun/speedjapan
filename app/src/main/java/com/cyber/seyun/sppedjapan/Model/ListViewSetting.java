package com.cyber.seyun.sppedjapan.Model;

/**
 * Created by 590 on 2015-12-31.
 */
public class ListViewSetting {
    private String japan;
    private String korean;

    public ListViewSetting(String japan,String korean) {
        this.japan = japan;
        this.korean = korean;
    }

    public String getJapan() {
        return japan;
    }

    public void setJapan(String japan) {
        this.japan = japan;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }
}
