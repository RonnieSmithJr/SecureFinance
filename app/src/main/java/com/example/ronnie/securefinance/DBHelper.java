package com.example.ronnie.securefinance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ronnie on 9/28/15.
 */
public class DBHelper extends SQLiteOpenHelper {

    //version
    private static final int DATABASE_VERSION = 4;

    //DB Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_USER = "CREATE TABLE" + UserInfo.TABLE + "("
                + UserInfo.KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + UserInfo.KEY_budget + "INTEGER, "
                + UserInfo.KEY_bills + "INTEGER, "
                + UserInfo.KEY_rent + "INTEGER, "
                + UserInfo.KEY_savings + "INTEGER)";

        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UserInfo.TABLE);

        // Create tables again
        onCreate(db);
    }
}
