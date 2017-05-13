package com.colorhills.all;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class LearnActivity extends AppCompatActivity {
    int wordNum;

    LoaderManager.LoaderCallbacks call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        wordNum = getIntent().getIntExtra("word_id", 1);//TODO save word num witch was last
        showWord();

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v,
//                                    int position, long id) {
//                Toast.makeText(HelloGridView.this, "" + position,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void showWord() {
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

    private int MAX_VAL = 100;
    public void getPrev(View view) {
        if (wordNum != 1) {
            wordNum = wordNum - 1;
        } else {
            wordNum = MAX_VAL;
        }
        showWord();
    }

    public void getNext(View view) {
        if (wordNum != MAX_VAL) {
            wordNum = wordNum + 1;
        } else {
            wordNum = 1;
        }
        showWord();
    }
}
