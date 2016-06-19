package com.cyber.seyun.sppedjapan.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DBInit extends SQLiteOpenHelper {
    private static final String TAG = DBInit.class.getSimpleName();
    private final Context myContext;
    private static String ROOT_DIR = "/data/data/com.cyber.seyun.sppedjapan/databases/";
    private static String DATABASES_NAME = "word.db";
    private static  int _VERSION  = 1;




    public DBInit(Context context) {
        super(context, DATABASES_NAME, null, _VERSION);
        this.myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String selecttable()
    {
        Cursor cursor = null;
        SQLiteDatabase db = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db", null, SQLiteDatabase.OPEN_READWRITE);
        String result =null;
        try {
            String SQL = "select name from sqlite_master where type='table'";
            cursor = db.rawQuery(SQL,null);
            cursor.moveToFirst();
            result =  cursor.getString(0);
            Log.i(TAG,result);
            while (cursor.moveToNext()){
                result =  cursor.getString(0);
                Log.i(TAG,result);
            }
        }
        catch (Exception e)
        {
            Log.i(TAG,e.toString());
        }
        return result;
    }

    public void createDataBase() throws IOException{

        boolean dbExist = checkDataBase();

        if(dbExist){

        }else{
            this.getReadableDatabase();

            try {
                copyDataBase();
                Log.i(TAG,"CopyDatabase Complete");
            }catch (IOException e){

                throw new Error("Error Copying Databases");
            }
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;

        try {
            //String myPath = ROOT_DIR + DATABASES_NAME;
            checkDB = SQLiteDatabase.openDatabase("/data/data/com.cyber.seyun.sppedjapan/databases/word.db",null, SQLiteDatabase.OPEN_READONLY);

        }catch (SQLiteException e){
            //Log.e(TAG,e.toString());
        }

        if(checkDB != null){
            checkDB.close();
        }

        return checkDB !=null ? true : false;
    }

    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DATABASES_NAME);
        String outFileName = ROOT_DIR + DATABASES_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0){
            myOutput.write(buffer,0,length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }





}
