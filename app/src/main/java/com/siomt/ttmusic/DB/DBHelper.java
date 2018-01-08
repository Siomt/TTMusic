package com.siomt.ttmusic.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建帮助类
 * Created by  Mr.Robot on 2018/1/8.
 * GitHub:https://github.com/Siomt
 */

public class DBHelper extends SQLiteOpenHelper {

    /**
     * 数据库名称常量
     */
    private static final String DATABASE_NAME = "MyMusic.db";

    /**
     * 数据库版本常量
     */

    private static final int DATABASE_VERSION = 1;

    /**
     * 表名称常量
     */

    private static final String TABLES_TABLE_NAME= "File_Table";


    private static final String DATABASE_CREATE = "CREATE TABLE" + FileColumn.TABLE + " ("
            + FileColumn.ID + " integer primary key autoincrement,"
            + FileColumn.NAME + " text,"
            + FileColumn.PATH + " text,"
            + FileColumn.SORT + " integer,"
            + FileColumn.TYPE + " text)";


    /**
     * 构造方法
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        /*Locale l = new Locale("zh","cn");
        db.setLocale;*/
        db.execSQL(DATABASE_CREATE);

    }

    /**
     *版本更新时调用
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //删除表
        db.execSQL("DROP TABLE IF EXISTS File_Table");
        onCreate(db);
    }
}
