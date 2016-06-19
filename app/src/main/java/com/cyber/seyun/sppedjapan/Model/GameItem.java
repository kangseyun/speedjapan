package com.cyber.seyun.sppedjapan.Model;

/**
 * Created by 590 on 2015-12-22.
 */
public class GameItem {

    public static int WinCount;
    public static int Flag = 0;
    public static Boolean Timer = false;
    public static int TimerCount = 0;


    public static void TimerCount_init(){
        TimerCount = 0;
    }
    public static void init()
    {
        WinCount = 0;
    }
    public static void timer_init(){
        Timer = false;
    }
}
