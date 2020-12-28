package com.yj.app.foods;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import static com.chad.library.adapter.base.listener.SimpleClickListener.TAG;
import static com.yj.app.foods.choose_video_DatabaseOpenHelper.POST_TABLE_NAME;

public class AddpostTask extends AsyncTask<Void,Integer,Integer> {


    private Context context;
    private List<com.yj.app.foods.Status> Statuses;
    private choose_video_DatabaseOpenHelper choose_video_DatabaseOpenHelper;
    private ProgressDialog progressDialog;

    private Cursor cursor ;
    public AddpostTask(Context context, List<com.yj.app.foods.Status> Statuses, choose_video_DatabaseOpenHelper openHelper , Cursor cursor){

        this.cursor = cursor;
        Log.i(TAG, "AddpostTask: " + cursor);
        this.context = context;
        this.Statuses = Statuses;
        this.choose_video_DatabaseOpenHelper=openHelper;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("please waite");
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if(cursor.moveToFirst()) {
            cursor.moveToFirst();
            Log.i(TAG, "doInBackground:123" );
            for (int i = 0; i < Statuses.size(); i++) {

                ContentValues cv = new ContentValues();
                com.yj.app.foods.Status status = Statuses.get(i);


                if (cursor.getInt(0) != status.getId()) {
                    cv.put(choose_video_DatabaseOpenHelper.COL_ID, status.getId());
                    cv.put(choose_video_DatabaseOpenHelper.COL_TITLE, status.getTitle());
                    cv.put(choose_video_DatabaseOpenHelper.COL_CONTENT, status.getContent());
                    cv.put(choose_video_DatabaseOpenHelper.COL_POST_IMAGE_URL, status.getImage_url());
                    cv.put(choose_video_DatabaseOpenHelper.COL_DATE, status.getDate());


                    SQLiteDatabase sqLiteDatabase = choose_video_DatabaseOpenHelper.getWritableDatabase();
                    long isInserted = sqLiteDatabase.insert(POST_TABLE_NAME, null, cv);
                    Log.i(TAG, "doInBackground: " + isInserted);
                }
                cursor.moveToNext();
            }
        }else {
            for (int i = 0; i < Statuses.size(); i++) {
                ContentValues cv = new ContentValues();
                com.yj.app.foods.Status status = Statuses.get(i);

                    cv.put(choose_video_DatabaseOpenHelper.COL_ID, status.getId());
                    cv.put(choose_video_DatabaseOpenHelper.COL_TITLE, status.getTitle());
                    cv.put(choose_video_DatabaseOpenHelper.COL_CONTENT, status.getContent());
                    cv.put(choose_video_DatabaseOpenHelper.COL_POST_IMAGE_URL, status.getImage_url());
                    cv.put(choose_video_DatabaseOpenHelper.COL_DATE, status.getDate());

                    SQLiteDatabase sqLiteDatabase = choose_video_DatabaseOpenHelper.getWritableDatabase();
                    long isInserted = sqLiteDatabase.insert(POST_TABLE_NAME, null, cv);
                    Log.i(TAG, "doInBackground: " + isInserted);

            }
        }

        return null;
    }


    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        progressDialog.hide();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }



}
