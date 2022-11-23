package com.example.b2.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.b2.model.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeDao {
    private SQLiteDatabase db;

    public TreeDao(Context context) {
        DBHelper helper = new DBHelper(context, "B2.sqlite", null, 1);
        db = helper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<Tree> get(String sql, String... selectArgs) {
        List<Tree> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()) {
            Tree u = new Tree();
            u.setTenkhoahoc(cursor.getString(cursor.getColumnIndex("tenkhoahoc")));
            u.setTenthuonggoi(cursor.getString(cursor.getColumnIndex("tenthuonggoi")));
            u.setCongdung(cursor.getString(cursor.getColumnIndex("congdung")));
            u.setDactinh(cursor.getString(cursor.getColumnIndex("dactinh")));
            u.setLieudung(cursor.getString(cursor.getColumnIndex("lieudung")));
            u.setLuuy(cursor.getString(cursor.getColumnIndex("luuy")));
            u.setResourceId(cursor.getInt(cursor.getColumnIndex("resoureId")));


            list.add(u);
        }
        return list;
    }

    public List<Tree> getAll() {
        String sql = "select * from Trees";

        return get(sql);
    }

//
//    public long insert(Tree Tree) {
//        ContentValues values = new ContentValues();
//        values.put("name", Tree.getName());
//        values.put("id", Tree.getId());
//        values.put("email", Tree.getEmail());
//        values.put("phone", Tree.getPhone());
//        values.put("resoureId", Tree.getResourceId());
//        values.put("address", Tree.getAddress());
//
//        return db.insert("TreeS", null, values);
//    }
//
//    public long update(Tree Tree) {
//        ContentValues values = new ContentValues();
//        values.put("name", Tree.getName());
//        values.put("id", Tree.getId());
//        values.put("email", Tree.getEmail());
//        values.put("phone", Tree.getPhone());
//        values.put("resoureId", Tree.getResourceId());
//        values.put("address", Tree.getAddress());
//
//        return db.update("TreeS", values, "phone =?", new String[]{Tree.getPhone()});
//    }

}
