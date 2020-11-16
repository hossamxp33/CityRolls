package com.codesroots.osamaomar.shopgate.presentationn.screens.feature.home.productdetailsfragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "mydb";
    public static final int DBVERSION = 1;
    public static final String TBL_CUSTOMER = "customer";
    public static final String TBL_LOT = "lot";


    public static final String COL_CUSTOMER_ID = BaseColumns._ID; //<<<<<<<<<< column name is _id (needed for Cursor Adapter)
    public static final String COL_CUSTOMER_NAME = "customer_name";

    public static final String COL_LOT_ID = BaseColumns._ID; //<<<<<<<<<< column name is _id (needed for Cursor Adapter)
    public static final String COL_LOT_NAME = "lot_name";
    public static final String COL_LOT_CUSTOMERREFERENCE = "customer_refererence";

    SQLiteDatabase mDB;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mDB = this.getWritableDatabase(); //<<<<<<<<<< get the database connection (force create when constructing helper instance)
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String crt_customer_table_sql = "CREATE TABLE IF NOT EXISTS " + TBL_CUSTOMER + "(" +
                COL_CUSTOMER_ID + " INTEGER PRIMARY KEY, " +
                COL_CUSTOMER_NAME + " TEXT UNIQUE " +
                ")";

        String crt_lot_table_sql = "CREATE TABLE IF NOT EXISTS " + TBL_LOT + "(" +
                COL_LOT_ID + " INTEGER PRIMARY KEY, " +
                COL_LOT_NAME + " TEXT, " +
                COL_LOT_CUSTOMERREFERENCE + " INTEGER " +
                /*?????????? OPTIONAL IF FOREIGN KEYS ARE TURNED ON
                "REFERENCES " + TBL_CUSTOMER + "(" +
                COL_CUSTOMER_ID +
                ")" +
                */
                ")";
        db.execSQL(crt_customer_table_sql);
        db.execSQL(crt_lot_table_sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addCustomer(String name) {
        ContentValues cv = new ContentValues();
        cv.put(COL_CUSTOMER_NAME,name);
        return mDB.insert(TBL_CUSTOMER,null,cv);
    }

    public long addLot(String name, long customer_reference) {
        ContentValues cv = new ContentValues();
        cv.put(COL_LOT_NAME,name);
        cv.put(COL_LOT_CUSTOMERREFERENCE,customer_reference);
        return mDB.insert(TBL_LOT,name,cv);
    }

    public Cursor getCustomers() {
        return mDB.query(TBL_CUSTOMER,null,null,null,null,null,COL_CUSTOMER_NAME);
    }

    public Cursor getLotsPerCustomer(long customer_id) {
        String whereclause = COL_LOT_CUSTOMERREFERENCE + "=?";
        String[] whereargs = new String[]{String.valueOf(customer_id)};
        return mDB.query(TBL_LOT,null,whereclause,whereargs,null,null,COL_LOT_NAME);
    }
}