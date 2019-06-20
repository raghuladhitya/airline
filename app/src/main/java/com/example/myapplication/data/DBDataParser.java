package com.example.myapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDataParser  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "shelter.db";

    private static final int DATABASE_VERSION = 1;

    public DBDataParser(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table pets (id INTEGER PRIMARY KEY ,name TEXT,weight INTEGER);
        //Create a String That contains The SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE ="CREATE TABLE " + VisaEntry.TABLE_NAME + "("
                + VisaEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + VisaEntry.VISATYPE + "TEXT NOT NULL, "
                + VisaEntry.VISACATEGORY + "TEXT, "
                + VisaEntry.PURPOSEOFVISIT + "TEXT NOT NULL, "
                + VisaEntry.COUNTRY + "TEXT NOT NULL, "
                + VisaEntry.PROCESSPRIORITY + "TEXT NOT NULL, "
                + VisaEntry.NATIONALITY + "TEXT NOT NULL, "
                + VisaEntry.NOOFAPPLICANTS +"TEXT NOT NULL, "
                + VisaEntry.ORIGINCITY + "TEXT , "
                + VisaEntry.AIRLINENAME1 +"TEXT , "
                + VisaEntry.FLIGHTNO1 + "TEXT , "
                + VisaEntry.ARRDATE + "TEXT , "
                + VisaEntry.PNR1 + "TEXT , "
                + VisaEntry.DESTINATIONCITY + "TEXT , "
                + VisaEntry.AIRLINENAME2 + "TEXT, "
                + VisaEntry.FLIGHTNO2 + "TEXT , "
                + VisaEntry.DEPARTUREDATE + "TEXT , "
                + VisaEntry.FIRSTNAME + "TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
