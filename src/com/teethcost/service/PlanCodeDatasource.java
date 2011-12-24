package com.teethcost.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.teethcost.R;
import com.teethcost.domain.PlanCodeCost;
import com.teethcost.domain.WizardFields;

/**
 * Class that will look up a procedure and then look up the plan number and cost.
 * @author tchan
 *
 */
public class PlanCodeDatasource extends Activity {
    private static final String DATABASE_NAME = "data";
	private static final String TABLE_NAME = "PLAN_CODE_COST";
	private static final String TEETH_NUM_COL_NAME = "teeth_number";
	private static final String SURFACE_COL_NAME = "surface";
	private static final String FILLING_TYPE_COL_NAME = "filling_type";
	private static final String PLAN_NUMBER = "plan_number";
	private static final int DATABASE_VERSION = 0;
	private static final String PLAN_COST = "plan_cost";

    /**
     * Database creation sql statement
     */
    private static final String DATABASE_CREATE =
        "create table " + TABLE_NAME + " (_id integer primary key autoincrement, "
        		+ TEETH_NUM_COL_NAME + " integer not null, " 
        		+ SURFACE_COL_NAME + " text not null, " 
        		+ FILLING_TYPE_COL_NAME + " text not null, " 
        		+ PLAN_NUMBER + " integer not null,"
        		+ PLAN_COST + " double not null" +
        				")";
    
	private SQLiteOpenHelper helper;
	
	private SQLiteDatabase mDb;

    
    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     * 
     * @param ctx the Context within which to work
     */
    public PlanCodeDatasource(Context ctx) {
        this.helper = new SQLiteOpenHelper(ctx, DATABASE_NAME, null, DATABASE_VERSION) {

            @Override
            public void onCreate(SQLiteDatabase db) {
                db.execSQL(DATABASE_CREATE);
                addBaseData();
            }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                db.execSQL("DROP TABLE IF EXISTS notes");
                onCreate(db);
            }
        };
    }
    
    protected void addBaseData() {
    	
    	BufferedReader reader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.insert)));
    	
    	try {
    		
    		String nextLine = null;
    		while ( (nextLine = reader.readLine()) != null) {
    			mDb.execSQL(nextLine);
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}

	public PlanCodeDatasource open() {
        mDb = helper.getWritableDatabase();
        return this;

    }
    
    public long createPlanCode(WizardFields fields) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(TEETH_NUM_COL_NAME, fields.getTeethNumber());
        initialValues.put(SURFACE_COL_NAME, fields.getSurface());
        initialValues.put(FILLING_TYPE_COL_NAME, fields.getFillingType().name());

        return mDb.insert(TABLE_NAME, null, initialValues);
    }
    
    public PlanCodeCost retreievePlanCodeCost(WizardFields fields) {

        String teethNumber = Integer.toString(fields.getTeethNumber());
		String fillingType = fields.getFillingType().name();
		Cursor mCursor = mDb.query(true, TABLE_NAME, new String[] {PLAN_NUMBER}, createQueryStr(), new String[] { teethNumber, fields.getSurface(), fillingType },
                    null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        
        PlanCodeCost planCodeCost = new PlanCodeCost();
        planCodeCost.setPlanCode(mCursor.getColumnIndex(PLAN_NUMBER));
        planCodeCost.setCost(mCursor.getColumnIndex(PLAN_COST));
        
        return planCodeCost;

    }

	private String createQueryStr() {
		return TEETH_NUM_COL_NAME + " = ?, " +
				SURFACE_COL_NAME + " = ?, " + 
				FILLING_TYPE_COL_NAME + " = ?";
	}
}
 