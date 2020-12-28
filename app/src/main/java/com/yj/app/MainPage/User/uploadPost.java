package com.yj.app.MainPage.User;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.BuildConfig;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.yj.app.MainPage.networking.ApiConfigPic;
import com.yj.app.MainPage.networking.ApiConfigVid;
import com.yj.app.MainPage.networking.AppConfig;
import com.yj.app.MainPage.networking.ServerResponseForImageUpload;
import com.yj.app.MainPage.networking.ServerResponseForVidUpload;
import com.yj.app.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.yj.app.MainActivity.UD_ID;

public class uploadPost extends AppCompatActivity{

    private static final String TAG = "uploadPost";
    ImageView imageView;
    Button pickImage, upload;

    private String uploaded_food_image_url;
    private String uploaded_food_video_url = "";
    private String uploaded_food_name;
    private String uploaded_food_content;
    private String uploaded_description;

    // Current playback position (in milliseconds).
    private int mCurrentPosition = 0;

    // Tag for the instance state bundle.
    private static final String PLAYBACK_TIME = "play_time";

    private Uri video;
    private String videoPath;
    private VideoView mVideoView;
    private TextView mBufferingTextView;

    private static final int REQUEST_TAKE_PHOTO = 0;
    private static final int REQUEST_PICK_PHOTO = 2;
    public static final int REQUEST_PICK_VIDEO = 3;
    private Uri mMediaUri;
    private static final int CAMERA_PIC_REQUEST = 1111;

    // private static final String TAG = uploadPost.class.getSimpleName();

    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;

    public static final int MEDIA_TYPE_IMAGE = 1;

    private Uri fileUri;

    private String mediaPath;

    private Button btnCapturePicture;

    private String mImageFileLocation = "";
    public static final String IMAGE_DIRECTORY_NAME = "Android File Upload";
    ProgressDialog pDialog;
    private String postPath;
    private CheckBox dinner;
    private CheckBox lunch;
    private CheckBox breakfast;
    private CheckBox dessert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_post);

        // add materials
        EditText mat1 = (EditText) findViewById(R.id.first_mat);
        TextView mat1txt = (TextView) findViewById(R.id.first_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add1 = (Button) findViewById(R.id.add_one);
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat1.getText().toString() != null) {
                    mat1txt.setText(mat1.getText().toString());
                    mat1txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat2 = (EditText) findViewById(R.id.second_mat);
        TextView mat2txt = (TextView) findViewById(R.id.second_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add2 = (Button) findViewById(R.id.add_two);
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat2.getText().toString() != null) {
                    mat2txt.setText(mat2.getText().toString());
                    mat2txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat3 = (EditText) findViewById(R.id.third_mat);
        TextView mat3txt = (TextView) findViewById(R.id.third_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add3 = (Button) findViewById(R.id.add_three);
        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat3.getText().toString() != null) {
                    mat3txt.setText(mat3.getText().toString());
                    mat3txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat4 = (EditText) findViewById(R.id.fourth_mat);
        TextView mat4txt = (TextView) findViewById(R.id.fourth_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add4 = (Button) findViewById(R.id.add_four);
        add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat4.getText().toString() != null) {
                    mat4txt.setText(mat4.getText().toString());
                    mat4txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat5 = (EditText) findViewById(R.id.fifth_mat);
        TextView mat5txt = (TextView) findViewById(R.id.fifth_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add5 = (Button) findViewById(R.id.add_five);
        add5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat5.getText().toString() != null) {
                    mat5txt.setText(mat5.getText().toString());
                    mat5txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat6 = (EditText) findViewById(R.id.sixth_mat);
        TextView mat6txt = (TextView) findViewById(R.id.sixth_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add6 = (Button) findViewById(R.id.add_six);
        add6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat6.getText().toString() != null) {
                    mat6txt.setText(mat6.getText().toString());
                    mat6txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat7 = (EditText) findViewById(R.id.seventh_mat);
        TextView mat7txt = (TextView) findViewById(R.id.seventh_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add7 = (Button) findViewById(R.id.add_seven);
        add7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat7.getText().toString() != null) {
                    mat7txt.setText(mat7.getText().toString());
                    mat7txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat8 = (EditText) findViewById(R.id.eight_mat);
        TextView mat8txt = (TextView) findViewById(R.id.eight_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add8 = (Button) findViewById(R.id.add_eight);
        add8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat8.getText().toString() != null) {
                    mat8txt.setText(mat8.getText().toString());
                    mat8txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat9 = (EditText) findViewById(R.id.nine_mat);
        TextView mat9txt = (TextView) findViewById(R.id.nine_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add9 = (Button) findViewById(R.id.add_nine);
        add9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat9.getText().toString() != null) {
                    mat9txt.setText(mat9.getText().toString());
                    mat9txt.setTextColor(getRandomColor());
                }
            }
        });

        EditText mat10 = (EditText) findViewById(R.id.ten_mat);
        TextView mat10txt = (TextView) findViewById(R.id.ten_mat_added);
        mat1txt.setText(mat1.getText().toString());
        Button add10 = (Button) findViewById(R.id.add_ten);
        add10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mat10.getText().toString() != null) {
                    mat10txt.setText(mat10.getText().toString());
                    mat10txt.setTextColor(getRandomColor());
                }
            }
        });



        Button back = (Button) findViewById(R.id.back_in_upload);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TextView txt_image_upload = (TextView) findViewById(R.id.image_upload_txt);
        txt_image_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // txt_image_upload.setTextColor(getRandomColor());
                new MaterialDialog.Builder(uploadPost.this)
                        .title("upload image")
                        .items(R.array.uploadImages)
                        .itemsIds(R.array.itemIds)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                switch (which) {
                                    case 0:
                                        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        startActivityForResult(galleryIntent, REQUEST_PICK_PHOTO);
                                        break;
                                    case 1:
                                        captureImage();

                                        break;
                                    case 2:
                                        imageView.setImageResource(R.drawable.ic_launcher_background);
                                        break;
                                }
                            }
                        })
                        .show();
            }
        });

        TextView video_up_txt = (TextView) findViewById(R.id.video_upload_txt);
        video_up_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // video_up_txt.setTextColor(getRandomColor());
                ActivityCompat.requestPermissions(uploadPost.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_PICK_VIDEO);
            }
        });

        EditText food_name = (EditText) findViewById(R.id.food_name_in_upload);
        EditText food_content = (EditText) findViewById(R.id.content_in_upload);
        EditText description = (EditText) findViewById(R.id.description_in_upload);
        description.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                uploaded_description = description.getText().toString();
            }
        });
        food_content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                uploaded_food_content = food_content.getText().toString();
            }
        });
        food_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                uploaded_food_name = food_name.getText().toString();
            }
        });



        Button upload_btn = (Button) findViewById(R.id.upload_image_in_upload);
        upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFileImage();
              //  uploadFileVideo();
            }
        });

        initDialog();

        imageView = (ImageView) findViewById(R.id.image_in_upload);

        Button vid_upload = (Button) findViewById(R.id.upload_video_in_upload);
        vid_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFileVideo();
            }
        });



        mVideoView = (VideoView) findViewById(R.id.video_view_in_upload);
        mBufferingTextView = (TextView) findViewById(R.id.buffering_textview);

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }

        // Set up the media controller widget and attach it to the video view.
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);

        mVideoView.requestFocus();
        mVideoView.start();
        controller.setAnchorView(mVideoView);

        dinner = (CheckBox) findViewById(R.id.dinner);
        lunch = (CheckBox) findViewById(R.id.lunch);
        breakfast = (CheckBox) findViewById(R.id.breakfast);
        dessert = (CheckBox) findViewById(R.id.dessert);

        Button postUpload = (Button) findViewById(R.id.upload_post_in_upload);
        postUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("food_name", uploaded_food_name);
                    jsonObject.put("food_content", uploaded_food_content);
                    jsonObject.put("image_url", uploaded_food_image_url);
                    jsonObject.put("video_url", uploaded_food_video_url);
                    jsonObject.put("user_id", UD_ID);
                    JSONArray jsonArrayCat = new JSONArray();
                    if (dinner.isChecked())
                        jsonArrayCat.put(3);
                    if (lunch.isChecked())
                        jsonArrayCat.put(2);
                    if (breakfast.isChecked())
                        jsonArrayCat.put(1);
                    if (dessert.isChecked())
                        jsonArrayCat.put(4);
                    jsonObject.put("cat_id", jsonArrayCat);
                    jsonObject.put("description", uploaded_description);
                    JSONArray jsonArrayMatTitle = new JSONArray();
                    if (mat1txt != null)
                        jsonArrayMatTitle.put(mat1txt.getText());
                    if (mat2txt != null)
                        jsonArrayMatTitle.put(mat2txt.getText());
                    if (mat3txt != null)
                        jsonArrayMatTitle.put(mat3txt.getText());
                    if (mat4txt != null)
                        jsonArrayMatTitle.put(mat4txt.getText());
                    if (mat5txt != null)
                        jsonArrayMatTitle.put(mat5txt.getText());
                    if (mat6txt != null)
                        jsonArrayMatTitle.put(mat6txt.getText());
                    if (mat7txt != null)
                        jsonArrayMatTitle.put(mat7txt.getText());
                    if (mat8txt != null)
                        jsonArrayMatTitle.put(mat8txt.getText());
                    if (mat9txt != null)
                        jsonArrayMatTitle.put(mat9txt.getText());
                    if (mat10txt != null)
                        jsonArrayMatTitle.put(mat10txt.getText());
                    jsonObject.put("material_title", jsonArrayMatTitle);
                    JSONArray jsonArrayMatColor = new JSONArray();
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonArrayMatColor.put(getRandomColor());
                    jsonObject.put("color", jsonArrayMatColor);
                    Log.i(TAG, "onCreateeeee: " + jsonObject);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(uploadPost.this, "please enter empty fields...!!", Toast.LENGTH_LONG).show();
                }

                if (uploaded_food_name != null && uploaded_food_content != null && uploaded_food_image_url != null){
                    showpDialog();
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://testforandroid.ir/add_new_post_with_material.php", jsonObject, new com.android.volley.Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.i(TAG, "onResponse: allllllllll");
                            Toast.makeText(uploadPost.this, "Food successfully uploaded.", Toast.LENGTH_LONG).show();

                        }
                    }, new com.android.volley.Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.i(TAG, "onErrorResponse: noooooooooooo");
                        }
                    });

                    request.setRetryPolicy(new DefaultRetryPolicy(18000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                    Volley.newRequestQueue(uploadPost.this).add(request);
                    hidepDialog();
                    Toast.makeText(uploadPost.this, "Food successfully uploaded.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(uploadPost.this, "please enter empty fields and upload an image...!!", Toast.LENGTH_LONG).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        food_name.setHintTextColor(getColor(R.color.red));
                    }
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        food_content.setHintTextColor(getColor(R.color.red));
                    }
                }
            }
        });

    }

    private void uploadUrls() {
        /*JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("food_name" , uploaded_food_name);
            jsonObject.put("food_content" , uploaded_food_content);
            jsonObject.put("image_url" , uploaded_food_image_url);
            jsonObject.put("video_url" , " ");
            jsonObject.put("user_id" , UD_ID);
            JSONArray jsonArrayCat = new JSONArray();
            if (dinner.isChecked())
                jsonArrayCat.put(3);
            if (lunch.isChecked())
                jsonArrayCat.put(2);
            if (breakfast.isChecked())
                jsonArrayCat.put(1);
            if (dessert.isChecked())
                jsonArrayCat.put(4);
            jsonObject.put("cat_id" , jsonArrayCat);
            jsonObject.put("description" , description);
            JSONArray jsonArrayMatTitle = new JSONArray();


        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(uploadPost.this, "please enter empty fields...!!", Toast.LENGTH_LONG).show();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "complete it later", jsonObject, new com.android.volley.Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse: allllllllll");
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onErrorResponse: noooooooooooo");
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(18000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT ));
        Volley.newRequestQueue(uploadPost.this).add(request);*/
    }

    private int getRandomColor() {
        // generate the random integers for r, g and b value
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        return Color.rgb(r, g, b);
    }

//    @Override
//    public void onClick(View view) {
//          Log.i(TAG, "onClick: 0" );
//        switch (view.getId()) {
//            case R.id.next_in_upload:
//                Log.i(TAG, "onClick: 0" );
//                new MaterialDialog.Builder(this)
//                        .title("upload image")
//                        .items(R.array.uploadImages)
//                        .itemsIds(R.array.itemIds)
//                        .itemsCallback(new MaterialDialog.ListCallback() {
//                            @Override
//                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
//                                switch (which) {
//                                    case 0:
//                                        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                                        startActivityForResult(galleryIntent, REQUEST_PICK_PHOTO);
//                                        break;
//                                    case 1:
//                                        captureImage();
//
//                                        break;
//                                    case 2:
//                                        imageView.setImageResource(R.drawable.ic_launcher_background);
//                                        break;
//                                }
//                            }
//                        })
//                        .show();
//                break;
//            //case R.id.upload:
//            //    uploadFileImage();
//            //    break;
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == REQUEST_TAKE_PHOTO || requestCode == REQUEST_PICK_PHOTO) {
                if (data != null) {
                    // Get the Image from data
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    assert cursor != null;
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    mediaPath = cursor.getString(columnIndex);
                    // Set the Image in ImageView for Previewing the Media
                    imageView.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
                    cursor.close();


                    postPath = mediaPath;
                }


            }else if (requestCode == CAMERA_PIC_REQUEST){
                if (Build.VERSION.SDK_INT > 21) {

                    Glide.with(this).load(mImageFileLocation).into(imageView);
                    postPath = mImageFileLocation;

                }else{
                    Glide.with(this).load(fileUri).into(imageView);
                    postPath = fileUri.getPath();

                }

            } else if (requestCode == REQUEST_PICK_VIDEO) {
                if (data != null) {
                    video = data.getData();
                    videoPath = getPath(video);
                    initializePlayer(video);
                } else {
                    Toast.makeText(uploadPost.this, "please choose a video", Toast.LENGTH_LONG).show();
                }

            }
    }



    /**
     * Checking device has camera hardware or not
     * */
    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    protected void initDialog() {

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);
    }


    protected void showpDialog() {

        if (!pDialog.isShowing()) pDialog.show();
    }

    protected void hidepDialog() {

        if (pDialog.isShowing()) pDialog.dismiss();
    }


    /**
     * Launching camera app to capture image
     */
    private void captureImage() {
        if (Build.VERSION.SDK_INT > 21) { //use this if Lollipop_Mr1 (API 22) or above
            Intent callCameraApplicationIntent = new Intent();
            callCameraApplicationIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

            // We give some instruction to the intent to save the image
            File photoFile = null;

            try {
                // If the createImageFile will be successful, the photo file will have the address of the file
                photoFile = createImageFile();
                // Here we call the function that will try to catch the exception made by the throw function
            } catch (IOException e) {
                Logger.getAnonymousLogger().info("Exception error in generating the file");
                e.printStackTrace();
            }
            // Here we add an extra file to the intent to put the address on to. For this purpose we use the FileProvider, declared in the AndroidManifest.
            Uri outputUri = FileProvider.getUriForFile(
                    this,
                    BuildConfig.APPLICATION_ID + ".provider",
                    photoFile);
            callCameraApplicationIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);

            // The following is a new line with a trying attempt
            callCameraApplicationIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);

            Logger.getAnonymousLogger().info("Calling the camera App by intent");

            // The following strings calls the camera app and wait for his file in return.
            startActivityForResult(callCameraApplicationIntent, CAMERA_PIC_REQUEST);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

            // start the image capture Intent
            startActivityForResult(intent, CAMERA_PIC_REQUEST);
        }


    }

    File createImageFile() throws IOException {
        Logger.getAnonymousLogger().info("Generating the image - method started");

        // Here we create a "non-collision file name", alternatively said, "an unique filename" using the "timeStamp" functionality
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmSS").format(new Date());
        String imageFileName = "IMAGE_" + timeStamp;
        // Here we specify the environment location and the exact path where we want to save the so-created file
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + "/photo_saving_app");
        Logger.getAnonymousLogger().info("Storage directory set");

        // Then we create the storage directory if does not exists
        if (!storageDirectory.exists()) storageDirectory.mkdir();

        // Here we create the file using a prefix, a suffix and a directory
        File image = new File(storageDirectory, imageFileName + ".jpg");
        // File image = File.createTempFile(imageFileName, ".jpg", storageDirectory);

        // Here the location is saved into the string mImageFileLocation
        Logger.getAnonymousLogger().info("File name and path set");

        mImageFileLocation = image.getAbsolutePath();
        // fileUri = Uri.parse(mImageFileLocation);
        // The file is returned to the previous intent across the camera application
        return image;
    }


    /**
     * Here we store the file url as it will be null after returning from camera
     * app
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on screen orientation
        // changes
        outState.putParcelable("file_uri", fileUri);

        // Save the current playback position (in milliseconds) to the
        // instance state bundle.
        outState.putInt(PLAYBACK_TIME, mVideoView.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        fileUri = savedInstanceState.getParcelable("file_uri");
    }



    /**
     * Receiving activity result method will be called after closing the camera
     * */

    /**
     * ------------ Helper Methods ----------------------
     * */

    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    /**
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(TAG, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + ".jpg");
        }  else {
            return null;
        }

        return mediaFile;
    }

    // Uploading Image/Video
    private void uploadFileImage() {
        if (postPath == null || postPath.equals("")) {
            Toast.makeText(this, "please select an image ", Toast.LENGTH_LONG).show();
            return;
        } else {
            showpDialog();

            // Map is used to multipart the file using okhttp3.RequestBody
            Map<String, RequestBody> map = new HashMap<>();
            File file = new File(postPath);

            // Parsing any Media type file
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
            Log.i(TAG, "uploadFileImage: " + file.getName());
            ApiConfigPic getResponse = AppConfig.getRetrofit().create(ApiConfigPic.class);
            Call<ServerResponseForImageUpload> call = getResponse.upload("token", map);
            call.enqueue(new Callback<ServerResponseForImageUpload>() {
                @Override
                public void onResponse(Call<ServerResponseForImageUpload> call, Response<ServerResponseForImageUpload> response) {
                    if (response.isSuccessful()){
                        if (response.body() != null){
                            hidepDialog();
                            ServerResponseForImageUpload serverResponse = response.body();
                            Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            uploaded_food_image_url = serverResponse.getImage_link() + file.getName();
                            Log.i(TAG, "onResponse: " + uploaded_food_image_url);

                        }
                    }else {
                        hidepDialog();
                        Toast.makeText(getApplicationContext(), "problem uploading image", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServerResponseForImageUpload> call, Throwable t) {
                    hidepDialog();
                    Log.v("Response gotten is", t.getMessage());
                }
            });
        }
    }




    // methods only for upload and show video file


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_PICK_VIDEO) {
            if (grantResults!=null) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");
                startActivityForResult(intent, REQUEST_PICK_VIDEO);
            } else {
                Toast.makeText(getApplicationContext(), "gggggggggg", Toast.LENGTH_LONG).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    private void initializePlayer(Uri uri) {
        // Show the "Buffering..." message while the video loads.
        mBufferingTextView.setVisibility(VideoView.VISIBLE);
        if (uri != null) {
            mVideoView.setVideoURI(uri);
        }
        // Listener for onPrepared() event (runs after the media is prepared).
        mVideoView.setOnPreparedListener(
                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {

                        // Hide buffering message.
                        mBufferingTextView.setVisibility(VideoView.INVISIBLE);

                        // Restore saved position, if available.
                        if (mCurrentPosition > 0) {
                            mVideoView.seekTo(mCurrentPosition);
                        } else {
                            // Skipping to 1 shows the first frame of the video.
                            mVideoView.seekTo(1);
                        }

                        // Start playing!
                        mVideoView.start();
                    }
                });

        // Listener for onCompletion() event (runs after media has finished
        // playing).
        mVideoView.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(uploadPost.this,
                                "completed",
                                Toast.LENGTH_SHORT).show();

                        // Return the video position to the start.
                        mVideoView.seekTo(0);
                    }
                });
    }

    private void releasePlayer() {
        mVideoView.stopPlayback();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Media playback takes a lot of resources, so everything should be
        // stopped and released at this time.
        releasePlayer();
    }

    private void uploadFileVideo() {

        /*StringRequest stringRequest = new StringRequest(Request.Method.POST, "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parms = new HashMap<>();
                parms.put("video", "");
                return parms;
            }
        };*/

        if (video == null || video.equals("")) {
            Toast.makeText(this, "please select a video ", Toast.LENGTH_LONG).show();
            return;
        } else {
            showpDialog();

            // Map is used to multipart the file using okhttp3.RequestBody
            Map<String, RequestBody> map = new HashMap<>();
            File file = new File(videoPath);
            // Parsing any Media type file
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
            ApiConfigVid getResponse = AppConfig.getRetrofit().create(ApiConfigVid.class);
            Call<ServerResponseForVidUpload> call = getResponse.upload("token", map);
            call.enqueue(new Callback<ServerResponseForVidUpload>() {
                @Override
                public void onResponse(Call<ServerResponseForVidUpload> call, retrofit2.Response<ServerResponseForVidUpload> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            hidepDialog();
                            ServerResponseForVidUpload serverResponse = response.body();
                            uploaded_food_video_url = serverResponse.getVideo_link() + file.getName();
                            Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        hidepDialog();
                        Toast.makeText(getApplicationContext(), "problem uploading image", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServerResponseForVidUpload> call, Throwable t) {
                    hidepDialog();
                    Log.v("Response gotten is", t.getMessage());
                    Toast.makeText(getApplicationContext(), "problem uploading image 2 " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }


}
