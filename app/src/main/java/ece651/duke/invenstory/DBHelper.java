package ece651.duke.invenstory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Young-hoon Kim on 2/19/2016.
 */
public class DBHelper extends SQLiteOpenHelper{

    //version number to update database version
    //each time you change the database, update the version number
    private static final int DATABASE_VERSION = 1;

    //DATABASE Name
    private static final String DATABASE_NAME = "collection.db";

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_ITEM = "CREATE TABLE " + Item.TABLE + "("
                + Item.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Item.KEY_Title + " TEXT, "
                + Item.KEY_Author + " TEXT, "
                + Item.KEY_Price + " INTEGER )";
        db.execSQL(CREATE_TABLE_ITEM);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!
        db.execSQL("DROP TABLE IF EXISTS " + Item.TABLE);
        // Create tables again
        onCreate(db);
    }
}
