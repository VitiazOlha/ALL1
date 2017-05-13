package com.colorhills.all;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class WordDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "words";
    private static final int DB_VERSION = 1;


    WordDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues word1 = new ContentValues();
        word1.put("Name", "word1");
        word1.put("Translate", "tr_word1");

        ContentValues word2 = new ContentValues();
        word1.put("Name", "word2");
        word1.put("Translate", "tr_word2");
        db.execSQL("CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TRANSLATE TEXT);");
        db.insert("WORDS", null, word1);
        db.insert("WORDS", null, word2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
