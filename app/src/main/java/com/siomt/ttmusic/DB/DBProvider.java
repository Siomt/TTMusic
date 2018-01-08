package com.siomt.ttmusic.DB;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import javax.security.auth.login.LoginException;

/**
 * Created by  Mr.Robot on 2018/1/8.
 * GitHub:https://github.com/Siomt
 */

public class DBProvider extends ContentProvider {

    private DBHelper dbOpenHelper;

    public static final String AUTHORITY = "MUSIC";
    public static final Uri CONTEMT_URI = Uri.parse("content://" + AUTHORITY + "/" + FileColumn.TABLE);

    @Override
    public boolean onCreate() {

        dbOpenHelper = new DBHelper(getContext());

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        Cursor cur = db.query(FileColumn.TABLE,projection,selection,selectionArgs, null,null,sortOrder);

        return cur;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        long count = 0;
        try {

           count = db.insert(FileColumn.TABLE,null,contentValues) ;

        }catch (Exception ex){
            ex.printStackTrace();
        }
        if(count > 0){
            return uri;
        }else {
            return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();

        try {
            db.delete(FileColumn.TABLE,s,strings);
            Log.e("info","delete");
        }catch (Exception ex){
            ex.printStackTrace();
            Log.e("error","delete");
        }


        return 1;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {

        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
        int i = 0;

        try {
            i = db.update(FileColumn.TABLE,contentValues,s,null);
            return i;
        }catch (Exception ex){
            Log.e("error","update");
        }
        return 0;
    }
}
