package com.colorhills.all;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class WordDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "words";
    private static final int DB_VERSION = 1;


    WordDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TRANSLATE TEXT);");
//        String myLine = null;
//        try {
//            File data = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator);
//            File file = new File(data, "dictionary.txt");
//            FileReader input = new FileReader(file);
//            BufferedReader bufRead = new BufferedReader(input);
//
//            while ((myLine = bufRead.readLine()) != null) {
//                System.out.println(myLine);
//                String[] arr = myLine.split("-");
//                ContentValues word = new ContentValues();
//                word.put("NAME", arr[1]);
//                word.put("TRANSLATE", arr[0]);
//                db.insert("WORDS", null, word);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
String words = "abolish-отменять\n" +
        "addiction-зависимость\n" +
        "agriculture-сельское хозяйство\n" +
        "amateur-любитель \n" +
        "ambassador-посол\n" +
        "ambulance-скорая помощь\n" +
        "anger-злость\n" +
        "approve-одобрять\n" +
        "apron-фартук\n" +
        "arrange-организовывать\n" +
        "arrogant-высокомерный\n" +
        "boast-хвастаться\n" +
        "bodyguard-телохранитель\n" +
        "canteen-столовая \n" +
        "celebrity-знаменитость\n" +
        "childhood-детство\n" +
        "civilian-штатский\n" +
        "collapse-разрушаться\n" +
        "commercial-рекламный ролик\n" +
        "commission-комиссия\n" +
        "confidence-уверенность\n" +
        "contemptuous-презрительный\n" +
        "contribute-делать пожертвования\n" +
        "convenient-удобный\n" +
        "correspondence-переписка\n" +
        "courage-смелость\n" +
        "craving-страстное желание\n" +
        "crawl-ползать\n" +
        "creative-творческий \n" +
        "dedication-верность\n" +
        "deliver-доставлять\n" +
        "depth-глубина\n" +
        "descend-спускаться \n" +
        "destination-назначение\n" +
        "deteriorate-ухудшать \n" +
        "disappointment-разочарование\n" +
        "dismiss-отпускать\n" +
        "dissolve-разрушать\n" +
        "distribute-распространять\n" +
        "district-район\n" +
        "elaborate-разрабатывать\n" +
        "eligible-имеющий п-раво\n" +
        "embarrassment-затруднение \n" +
        "emergency-критическое положение \n" +
        "entourage-окружение \n" +
        "evidence-доказательство\n" +
        "extinction-вымирание\n" +
        "famine-голод\n" +
        "flood-потоп\n" +
        "generosity-щедрость\n" +
        "gluttony-обжорство\n" +
        "hiccup-икота\n" +
        "honesty-честность\n" +
        "household-быт\n" +
        "humanity-человечество\n" +
        "humiliate-унижать\n" +
        "interpret-толковать\n" +
        "investigate-исследовать\n" +
        "justice-справедливость \n" +
        "kindness-доброта\n" +
        "knowledge-знание\n" +
        "landlord-землевладелец\n" +
        "liberty-свобода\n" +
        "maintain-поддерживать\n" +
        "mature-зрелый\n" +
        "mirror-зеркало\n" +
        "naughty-непослушный\n" +
        "patience-терпение\n" +
        "persuade-убеждать\n" +
        "petrol-бензин\n" +
        "pleasure-удовольствие \n" +
        "prejudice-предубеждение\n" +
        "prescription-рекомендация\n" +
        "profit-выгода\n" +
        "promotion-продвижение\n" +
        "prosecutor-прокурор\n" +
        "quarrel-ссора \n" +
        "rapport-хорошие отношения \n" +
        "referee-судья\n" +
        "reference book-справочник\n" +
        "rehearsal-репетиция\n" +
        "remarkable-значительный\n" +
        "resentment-негодование\n" +
        "ruthless-безжалостный\n" +
        "satchel-сумка\n" +
        "software-программное обеспечение\n" +
        "spokesman-представитель\n" +
        "squeeze-сжимать\n" +
        "stationary-неизменный\n" +
        "sufficient-достаточный\n" +
        "superstition-суеверие\n" +
        "surgeon-хирург\n" +
        "surveyor-землемер\n" +
        "suspect-подозревать\n" +
        "vacancy-свободное место\n" +
        "vain-тщеславный\n" +
        "valuable-ценный\n" +
        "walkie_talkie-портативная рация\n" +
        "whistle-свистеть\n" +
        "withdraw-извлекать";


        db.execSQL("CREATE TABLE WORDS (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, TRANSLATE TEXT);");
        String[] strs = words.split("\n");
        for (int i = 0; i < strs.length; i++) {
            String[] arr = strs[i].split("-");
            ContentValues word = new ContentValues();
            word.put("NAME", arr[1]);
            word.put("TRANSLATE", arr[0]);
            db.insert("WORDS", null, word);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
