package com.cyber.seyun.sppedjapan.Model;

/**
 * Created by 590 on 2016-01-05.
 */
public class FirstSettingModel {
    public static int FistView = 0;  // 0 - 끔, 1 - 킴
    public static int FistViewLevel = 1;  // 1 - 초급, 2 - 중급, 3 - 고급
    public static void FistViewInit(){
        FistView = 0;
    }

    public void FistViewLevelInit(){
        FistViewLevel = 1;
    }
}
