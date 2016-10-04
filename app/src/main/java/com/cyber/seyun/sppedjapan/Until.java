package com.cyber.seyun.sppedjapan;

import android.support.v7.widget.Toolbar;

import java.util.Random;

/**
 * Created by 590 on 2015-12-22.
 */
public class Until {

    public int getRandom(int max,int offset) {
        Random mRand = new Random();
        int Result = mRand.nextInt(max) + offset;
        return Result;
    }
}
