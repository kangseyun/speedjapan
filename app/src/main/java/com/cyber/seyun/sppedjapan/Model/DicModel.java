package com.cyber.seyun.sppedjapan.Model;

import android.support.annotation.NonNull;

import com.github.wrdlbrnft.sortedlistadapter.SortedListAdapter;

/**
 * Created by temp on 2017. 6. 8..
 */

public class DicModel implements SortedListAdapter.ViewModel {
    private final long mId;
    private final int mRank;
    private final String mWord;

    public DicModel(long id, int rank, String word) {
        mId = id;
        mRank = rank;
        mWord = word;
    }

    public long getId() {
        return mId;
    }

    public int getRank() {
        return mRank;
    }

    public String getWord() {
        return mWord;
    }

    @Override
    public <T> boolean isSameModelAs(@NonNull T item) {
        if (item instanceof DicModel) {
            final DicModel wordModel = (DicModel) item;
            return wordModel.mId == mId;
        }
        return false;
    }

    @Override
    public <T> boolean isContentTheSameAs(@NonNull T item) {
        if (item instanceof DicModel) {
            final DicModel other = (DicModel) item;
            if (mRank != other.mRank) {
                return false;
            }
            return mWord != null ? mWord.equals(other.mWord) : other.mWord == null;
        }
        return false;
    }
}
