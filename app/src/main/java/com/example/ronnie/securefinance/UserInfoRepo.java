package com.example.ronnie.securefinance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ronnie on 9/28/15.
 */
public class UserInfoRepo {

    private DBHelper dbHelper;

    public UserInfoRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(UserInfo userInfo) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserInfo.KEY_ID, userInfo.user_ID);
        values.put(UserInfo.KEY_budget,userInfo.budget);
        values.put(UserInfo.KEY_bills, userInfo.bills);
        values.put(UserInfo.KEY_rent, userInfo.rent);
        values.put(UserInfo.KEY_savings, userInfo.savings);

        // Inserting Row
        long student_Id = db.insert(UserInfo.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }

    public void delete(int user_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(UserInfo.TABLE, UserInfo.KEY_ID + "= ?", new String[]{String.valueOf(user_Id)});
        db.close(); // Closing database connection
    }

    public void update(UserInfo userInfo) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(UserInfo.KEY_ID, userInfo.user_ID);
        values.put(UserInfo.KEY_budget,userInfo.budget);
        values.put(UserInfo.KEY_bills, userInfo.bills);
        values.put(UserInfo.KEY_rent, userInfo.rent);
        values.put(UserInfo.KEY_savings, userInfo.savings);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(UserInfo.TABLE, values, UserInfo.KEY_ID + "= ?", new String[]{String.valueOf(userInfo.user_ID)});
        db.close(); // Closing database connection
    }
/*
    public ArrayList<HashMap<String, String>> getUserInfoList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                UserInfo.KEY_ID + "," +
                UserInfo.KEY_budget + "," +
                UserInfo.KEY_bills + "," +
                UserInfo.KEY_rent + "," +
                UserInfo.KEY_savings +
                " FROM " + UserInfo.TABLE;

        //UserInfo userInfo = new UserInfo();

        ArrayList<HashMap<String, String>> userInfoList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> userInfo = new HashMap<String, String>();
                userInfo.put("id", cursor.getString(cursor.getColumnIndex(UserInfo.KEY_ID)));
                userInfo.put("name", cursor.getString(cursor.getColumnIndex(UserInfo.KEY_name)));
                userInfoList.add(userInfo);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return studentList;

    }*/

    public UserInfo getUserInfoById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                UserInfo.KEY_ID + "," +
                UserInfo.KEY_budget + "," +
                UserInfo.KEY_bills + "," +
                UserInfo.KEY_rent + "," +
                UserInfo.KEY_savings +
                " FROM " + UserInfo.TABLE
                + " WHERE " +
                UserInfo.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        UserInfo userInfo = new UserInfo();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                userInfo.user_ID =cursor.getInt(cursor.getColumnIndex(UserInfo.KEY_ID));
                userInfo.budget =cursor.getInt(cursor.getColumnIndex(UserInfo.KEY_budget));
                userInfo.bills  =cursor.getInt(cursor.getColumnIndex(UserInfo.KEY_bills));
                userInfo.savings  =cursor.getInt(cursor.getColumnIndex(UserInfo.KEY_savings));
                userInfo.rent  =cursor.getInt(cursor.getColumnIndex(UserInfo.KEY_rent));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userInfo;
    }
}
