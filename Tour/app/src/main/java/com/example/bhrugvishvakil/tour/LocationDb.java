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

public class LocationDb extends SQLiteOpenHelper {
    public static final String Dname="monuments.db";
    public static final String Mon_Table="monuments";
    public static final String mon_id="ID";
    public static final String mon_name="Name";
    public static final String mon_x="Xcord";
    public static final String mon_y="Ycord";




    public LocationDb(Context context) {
        super(context, Dname, null, 6);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create TABLE "+Mon_Table+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Xcord DOUBLE,Ycord DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists "+Mon_Table);
        onCreate(sqLiteDatabase);
    }
    public void insertDataMon(String name,double xcord,double ycord)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(mon_name,name);
        cv.put(mon_x,xcord);
        cv.put(mon_y,ycord);

        long result=db.insert(Mon_Table,null,cv);


    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+Mon_Table,null);
        return res;

    }

    public Cursor SearchData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select Xcord,Ycord from monuments",null);
        return res;
    }

}


