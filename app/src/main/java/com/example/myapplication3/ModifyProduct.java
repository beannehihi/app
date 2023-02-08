package com.example.myapplication3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ModifyProduct {
    public static final String SQL_CREATE_TABLE = "create table products(id integer primary key autoincrement, quantity integer, thumbnai varchar(200), name varchar(200), cost Double )";

    public static void insert(Product product) {
        SQLiteDatabase sqLiteDatabase = ProcessDatabase.getInstance(null).getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("name", product.getName());
        v.put("quantity", product.getQuantity());
        v.put("thumbnai", product.getThumbnai());
        v.put("cost", product.getCost());
        sqLiteDatabase.insert("products", null, v);

    }

    public static void update(Product product) {
        SQLiteDatabase sqLiteDatabase = ProcessDatabase.getInstance(null).getWritableDatabase();
        ContentValues v = new ContentValues();
        v.put("name", product.getName());
        v.put("quantity", product.getQuantity());
        v.put("thumbnai", product.getThumbnai());
        v.put("cost", product.getCost());
        sqLiteDatabase.update("products", v, "id = " + product.getId(), null);

    }

    public static void delete(int id) {
        SQLiteDatabase sqLiteDatabase = ProcessDatabase.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("products", "id= " + id, null);
    }

    public static List<Product> getProductList() {
        List<Product> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = ProcessDatabase.getInstance(null).getWritableDatabase();
        String sql = "select * from products";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Product product = new Product(cursor.getInt(cursor.getColumnIndex("id")), cursor.getInt(cursor.getColumnIndex("quantity")), cursor.getString(cursor.getColumnIndex("thumbnai")), cursor.getString(cursor.getColumnIndex("name")), cursor.getDouble(cursor.getColumnIndex("cost")));
            list.add(product);
        }
        return list;
    }
}
