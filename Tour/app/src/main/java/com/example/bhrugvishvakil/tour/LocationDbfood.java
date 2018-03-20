package com.example.bhrugvishvakil.tour;

/**
 * Created by shubh on 20-03-2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shubh on 20-03-2018.
 */

public class LocationDbfood extends SQLiteOpenHelper {
    public static final String Dnamefood="food.db";
    public static final String food_Table="food";
    public static final String food_id="ID";
    public static final String food_name="Name";
    public static final String food_type="TYPEOF";

    //public static final String food_nonveg="NON_VEG";




    public LocationDbfood(Context context) {
        super(context, Dnamefood, null, 2);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create TABLE "+food_Table+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,TYPEOF TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists "+food_Table);
        onCreate(sqLiteDatabase);
    }
    public void insertDataFood(String name,String typeof)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(food_name,name);
        cv.put(food_type,typeof);
       // cv.put(food_nonveg,nonveg);


        long result=db.insert(food_Table,null,cv);


    }
    public Cursor getAllDatafood(){
        SQLiteDatabase db=this.getWritableDatabase();
        //String query="select * from food where TYPEOF = 'VEG' ";
        Cursor res=db.rawQuery("select * from "+food_Table,null);
        return res;

    }

}


