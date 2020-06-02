package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");
           /* myDatabase.execSQL("INSERT INTO newUsers(name,age) VALUES ('Nick', 28)");
            myDatabase.execSQL("INSERT INTO newUsers(name,age) VALUES ('Nick', 43)");
            myDatabase.execSQL("INSERT INTO newUsers(name,age) VALUES ('Nick', 23)");
            myDatabase.execSQL("INSERT INTO newUsers(name,age) VALUES ('Rob', 14)");*/
            // for all the data
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users", null);
            //for age<18
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE age < 18", null);
            //for name criteria
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name='Nick' ", null);
            //for both name and Age
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name='Nick' AND age =43 ", null);
            //for name starting with a letter
          //  Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'N%' ", null);
            //For containing any letter(here a)
            //Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' ", null);
                //for limiting the search
           // Cursor c = myDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%a%' LIMIT 1 ", null);


            myDatabase.execSQL("DELETE FROM newUsers WHERE id= 2 ");
            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int id_index= c.getColumnIndex("id");
            c.moveToFirst();
            while (!c.isAfterLast()) {
                Log.i("name", c.getString(nameIndex));
                Log.i("age", Integer.toString(c.getInt(ageIndex)));
                Log.i("id", Integer.toString(c.getInt(id_index)));

                c.moveToNext();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
