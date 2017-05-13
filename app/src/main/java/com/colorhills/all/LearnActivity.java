package com.colorhills.all;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);

//        int wordNum = (Integer) getIntent().getExtras().get(EXTRA_WORD_NUM);//TODO save word num witch was last
        int wordNum = 3;

        try {
            SQLiteOpenHelper wordDatabaseHelper = new WordDatabaseHelper(this);
            SQLiteDatabase db = wordDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("WORDS",
                    new String[]{"NAME", "TRANSLATE"},
                    "_id = ?",
                    new String[]{Integer.toString(wordNum)},
                    null, null, null);
            if (cursor.moveToFirst()) {
                String wordText = cursor.getString(0);
                String tr_wordText = cursor.getString(1);

                TextView word = (TextView) findViewById(R.id.word);
                word.setText(wordText);

                TextView tr_word = (TextView) findViewById(R.id.tr_word);
                tr_word.setText(tr_wordText);
            }
            cursor.close();
            db.close();
        } catch (SQLiteException ex) {
            Toast toast = Toast.makeText(this, "Database unvisible", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
