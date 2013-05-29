package com.test;

import com.example.database.R;
import com.test.db.StudentDatabaseHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
/**
 * 1. 测试松散类型的数据
 * 2. 
 * */
public class MainActivity extends Activity {

	
	 private SQLiteDatabase mSQLiteDatabase = null;
	
	 private ActivityInfo ai = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		StudentDatabaseHelper dbHelper = new StudentDatabaseHelper(this, "test.db", null, 1);
		
		mSQLiteDatabase = dbHelper.getWritableDatabase();
		
		this.openOrCreateDatabase("test2.db", MODE_PRIVATE, null);
		
		Log.d("harry", "MainActivity ------------oncreate()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
