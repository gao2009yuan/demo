package com.test.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class StudentDatabaseHelper extends SQLiteOpenHelper {

	
	private final String DB_NAME = "test.db";
	private final String TB_STUDENT_INFO = "student";
	/**创建学生信息数据表*/
	private final String studentInfoTable_create = "CREATE TABLE IF NOT EXISTS " + TB_STUDENT_INFO 
			+ " (" + Student.STU_ID + " INTEGER PRIMARY KEY," 
			+ Student.STU_NAME + " TEXT," 
			+ Student.STU_AGE + " INTEGER)";
	
	private Context mContext = null;
	
	
	public StudentDatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		this.mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.d("harry", "sql:" + studentInfoTable_create);
		db.execSQL(studentInfoTable_create);
		Log.d("harry", "data base ------------oncreate()");
		//Toast.makeText(mContext, "fuck", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}

}
