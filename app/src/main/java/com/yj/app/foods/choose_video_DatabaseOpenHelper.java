package com.yj.app.foods;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static com.chad.library.adapter.base.listener.SimpleClickListener.TAG;

public class choose_video_DatabaseOpenHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="7learn";
    private static final int DATABASE_VERSION=1;
    public static final String POST_TABLE_NAME="tbl_posts";

    public static final String COL_ID="col_id";
    public static final String COL_TITLE="col_title";
    public static final String COL_CONTENT="col_content";
    public static final String COL_POST_IMAGE_URL="col_post_image_url";
    public static final String COL_DATE="col_date";

    private static final String SQL_COMMAND_CREATE_POST_TABLE="CREATE TABLE IF NOT EXISTS "+POST_TABLE_NAME+"("+
            COL_ID+" INTEGER ,"+
            COL_TITLE+" TEXT,"+
            COL_CONTENT+" TEXT, "+
            COL_POST_IMAGE_URL+" TEXT, "+
            COL_DATE+" TEXT);";

    private Context context;

    public choose_video_DatabaseOpenHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(SQL_COMMAND_CREATE_POST_TABLE);
        }catch (SQLException e){
            Log.e(TAG, "onCreate: "+e.toString() );
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addPosts(List<Status> Statuses){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+POST_TABLE_NAME,null);



//
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
//            Log.i(TAG, "addPosts:curserget(0) " + cursor.getInt(0));
//            Log.i(TAG, "addPosts:Statuse.get(0) " + Statuses.get(0).getId());
            if (cursor.getInt(0) != Statuses.get(0).getId()) {
                do {
                    sqLiteDatabase.delete(POST_TABLE_NAME, COL_ID + " = ?", new String[]{String.valueOf(cursor.getInt(0))});
                }while (cursor.moveToNext());
                AddpostTask addPostsTask = new AddpostTask(context, Statuses, this, cursor);
                addPostsTask.execute();

            }
        }
        else
        {
            AddpostTask addPostsTask = new AddpostTask(context, Statuses, this, cursor);
            addPostsTask.execute();
        }




    }

    public List<Status> getPosts(){
        List<Status> Statuses =new ArrayList<>();

        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();

        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "+POST_TABLE_NAME,null);

        cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                Status status = new Status();
                Log.i(TAG, "getPosts: " + cursor.getInt(0));
                status.setId(cursor.getInt(0));
                status.setTitle(cursor.getString(1));
                status.setContent(cursor.getString(2));
                status.setImage_url(cursor.getString(3));
                status.setDate(cursor.getString(4));
                Statuses.add(status);

                cursor.moveToNext();

            }


        cursor.close();
        sqLiteDatabase.close();
        return Statuses;
    }

    private boolean checkPostExists(int postId){
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("SELECT * FROM "
                +POST_TABLE_NAME
                +" WHERE "
                +COL_ID
                +" = ?",new String[]{String.valueOf(postId)});
        return cursor.moveToFirst();
    }


}
