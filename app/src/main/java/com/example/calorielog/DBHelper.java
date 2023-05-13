package com.example.calorielog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    String Date;
    public static final String CALORIE_TABLE = "CALORIE_TABLE";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TOTAL_CALORIES = "TOTAL_CALORIES";
    public static final String COLUMN_ID = "ID";

    SQLiteDatabase database;

    public DBHelper(@Nullable Context context) {
        super(context, "calorie.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String createTableStatement = "CREATE TABLE  "
                + CALORIE_TABLE + "  ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DATE + " TEXT,  "
                + COLUMN_TOTAL_CALORIES + " TEXT  )";
        database.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(DailyLog dailyLog) {
        SQLiteDatabase database = this.getWritableDatabase();
        calendar = Calendar.getInstance();
        simpleDateFormat= new SimpleDateFormat( "MM-dd-yyyy");
        Date = simpleDateFormat.format(calendar.getTime());
        ContentValues cv = new ContentValues();
        // cv.put(COLUMN_ID,dailyLog.getID());
        cv.put(COLUMN_DATE,Date);
        cv.put(COLUMN_TOTAL_CALORIES, dailyLog.getCalories());//.toString());///dailyLog.getName())
        long insert = database.insert(CALORIE_TABLE, null, cv);

        if (insert == -1) {
            return false;
        } else {
            return true;

        }
    }

    public boolean deleteOne(DailyLog dailyLog) {

        SQLiteDatabase database = this.getWritableDatabase();

        String queryString = "DELETE FROM " + CALORIE_TABLE + " WHERE " + COLUMN_ID + " = " +
                dailyLog.getID();

        Cursor cursor = database.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }

    public List<DailyLog> getEverything(){

        List<DailyLog> returnList = new ArrayList<>();
        String queryString= "SELECT * FROM " + CALORIE_TABLE;

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(queryString,null);

        if (cursor.moveToFirst()){

            do {
                //int ID =  Integer.parseInt(cursor.getString(0));
                int   ID   = cursor.getInt(0);
                String date = cursor.getString(1);
                String dailyCalories = cursor.getString( 2);
                //String customerName = cursor.getString(cursor.getColumnIndex("NAME"));
                DailyLog dailyLog= new DailyLog(ID,date,dailyCalories);

//           System.out.println("this is what daily log looks like right before being added to list");
//           System.out.println(ID);
//           System.out.println(customerName);
//            System.out.println(dailyLog.toString());
//              //  returnList.add(dailyLog);

                returnList.add(dailyLog);
                System.out.println(returnList);
            } while(cursor.moveToNext());

        } else{
            ///failure

        }
        cursor.close();
        database.close();

        return returnList;
    }



}