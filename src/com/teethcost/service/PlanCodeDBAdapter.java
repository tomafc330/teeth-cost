package com.teethcost.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Class that will look up a procedure and then look up the plan number and cost.
 * @author tchan
 *
 */
public class PlanCodeDBAdapter {
	private static final String DATABASE_NAME = "PLAN_CODE";
	private static final int DATABASE_VERSION = 0;

    /**
     * Database creation sql statement
     */
    private static final String DATABASE_CREATE =
        "create table " + DATABASE_NAME + " (_id integer primary key autoincrement, "
        + "teeth_number integer not null, surface text not null, filling_type text not null);";
    
	private SQLiteOpenHelper helper;
	
	private Context context;

    
    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     * 
     * @param ctx the Context within which to work
     */
    public PlanCodeDBAdapter(Context ctx) {
        this.context = ctx;
        this.helper = new SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(DATABASE_CREATE);
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS notes");
                onCreate(db);
            }
        };
    }
    
    public void open() {
    	
    }
}
