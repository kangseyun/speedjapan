package com.cyber.seyun.sppedjapan.Database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cyber.seyun.sppedjapan.Model.ListViewSetting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 590 on 2016-01-04.
 */
public class DBController {
    private String TAG = DBController.class.getSimpleName();
    private Cursor cursor = null;


    public void insert(String kor, String eng) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        try {
            String SQL = "insert into hiragana(num,japan,eng) values(null,'" + kor + "','" + eng + "');";
            db.execSQL(SQL);
            Log.i(TAG, kor + "/" + eng);
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
    }

    public void select(String eng) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        try {
            String SQL = "select num,japan from hiragana where eng = '" + eng + "';";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();

            Log.i("select", "" + cursor.getInt(0) + "/" + cursor.getString(1));
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
    }

    public List<ListViewSetting> selectAll(){
        List<ListViewSetting> word = new ArrayList<ListViewSetting>();

        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        try {
            String SQL = "select eng,japan from hiragana union select eng, japan from Kana;";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();

            word.add(new ListViewSetting(cursor.getString(0), cursor.getString(1)));
            while (cursor.moveToNext()) {
                word.add(new ListViewSetting(cursor.getString(0), cursor.getString(1)));
            }

            Log.i("select", "" + cursor.getInt(0) + "/" + cursor.getString(1));
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }

        return word;
    }
    public List<String> getPuzzle(int level) {
        List<String> obj = new ArrayList<String>();
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);

        try {
            String SQL = "select eng,japan from hiragana union select eng, japan from Kana;";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();

            //obj.add(new ListViewSetting(cursor.getString(0), cursor.getString(1)));
            while (cursor.moveToNext()) {
            //    word.add(new ListViewSetting(cursor.getString(0), cursor.getString(1)));
            }

            Log.i("PuzzleWorld", "");
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }

        return obj;
    }
    public String readWord() {

        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        try {
            String SQL = "select japan from hiragana order by RANDOM() limit 1";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();

        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
        return cursor.getString(0);
    }

    public void FirstSetting(int level, int onoff) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        String SQL = "update myinfo set flag = 1 where num = 1;";
        try {
            db.execSQL(SQL, null);
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
    }

    public int SelectFirst() {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        int result = 0;
        try {
            String SQL = "select num from myinfo;";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();
            result = cursor.getInt(0);
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
        return result;
    }


    public String SelectTable() {

        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        String result = null;
        try {
            String SQL = "select name from sqlite_master where type='table'";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();
            result = cursor.getString(0);
            Log.i(TAG, result);
            while (cursor.moveToNext()) {
                result = cursor.getString(0);
                Log.i(TAG, result);
            }
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
        return result;
    }

    public String ReadWordEng() {

        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        try {
            String SQL = "select eng from hiragana order by RANDOM() limit 1";
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();

        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
        return cursor.getString(0);
    }

    public ArrayList<String> nextView(int fg) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        String SQL = null;

        ArrayList<String> word = new ArrayList();
        if (fg == 1) {
            SQL = "select * from hiragana order by random() limit 3;";
        } else {
            SQL = "select * from Kana order by random() limit 3;";
        }

        Cursor cursor = db.rawQuery(SQL, null);
        cursor.moveToFirst();


        word.add(cursor.getString(1));
        word.add(cursor.getString(2));
        while (cursor.moveToNext()) {
            word.add(cursor.getString(2));
        }


        return word;
    }


    public boolean Check(String Japan, String Eng, int fg) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        boolean flag = false;
        String resultKor;
        String SQL = null;

        if (fg == 1) {
            SQL = "select japan from hiragana where eng = '" + Eng + "';";
        } else {
            SQL = "select japan from Kana where eng = '" + Eng + "';";
        }


        try {
            cursor = db.rawQuery(SQL, null);
            cursor.moveToFirst();
            resultKor = cursor.getString(0);

            if (resultKor.equals(Japan))
                flag = true;
        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }

        return flag;
    }
}
