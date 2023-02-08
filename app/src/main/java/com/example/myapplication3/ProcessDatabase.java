package com.example.myapplication3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ProcessDatabase extends SQLiteOpenHelper {
    private static final String DBNAME = "D04";
    private static final int DBVERSION = 1;
    private static ProcessDatabase instance = null;
    private ProcessDatabase(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }
    public synchronized static ProcessDatabase getInstance(Context context) {
        if (instance == null) {
            Toast.makeText(context, "Chua khoi tao", Toast.LENGTH_LONG).show();
            instance = new ProcessDatabase(context);//tao moi
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        ham nay goi duy nhat khi cai dat ung dung tren may ao
        sqLiteDatabase.execSQL(ModifyProduct.SQL_CREATE_TABLE);//tien hanh tao bang
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
