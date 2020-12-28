package com.yj.app;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yj.app.foods.Status;
import com.yj.app.foods.materials;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ApiService {

    private Context context;

    public ApiService(Context context) {
        this.context = context;
    }


    public void signUpUser(JSONObject requestJsonObject, final OnSignupComplete onSignupComplete) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/Initial_registration.php"
                , requestJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    String what_should_i_do = response.getString("success");
                    onSignupComplete.onSignUp(what_should_i_do, "there isn't problem");
                } catch (JSONException e) {
                    e.printStackTrace();
                    onSignupComplete.onSignUp("", "no");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onSignupComplete.onSignUp("", "no");
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface OnSignupComplete {
        void onSignUp(String what_should_i_do, String the_problem_is_from_server);
    }


    public void LoginUser(JSONObject requestJsonObject, final OnLoginComplete OnLoginComplete) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/Login_user.php"
                , requestJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(TAG, "onResponse: ");

                try {
                    OnLoginComplete.onLogin(false, response.getString("what_should_i_do"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    OnLoginComplete.onLogin(true, "");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                OnLoginComplete.onLogin(true, "");
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface OnLoginComplete {
        void onLogin(boolean the_problem_is_from_server, String what_should_i_should_do);
    }


    public void what_is_your_UD_ID(JSONObject requestJsonObject, final whatis whatis) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/ud_id.php"
                , requestJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    whatis.what_is_he(response.getString("what_are_you"));
                    Log.i(TAG, "onResponse: " + response.getString("what_are_you"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    whatis.what_is_he("");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onResponse: " + error);
                whatis.what_is_he("");
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(2000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface whatis {
        void what_is_he(String what_is_he);
    }

    public void what_is_your_UD_ID_and_username(JSONObject requestJsonObject, final can_he_get_in1 can_he_get_in1) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/ud_id_exist.php"
                , requestJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    can_he_get_in1.can_he_get_in(response.getString("username exist"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    can_he_get_in1.can_he_get_in("");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onResponse: " + error);
                can_he_get_in1.can_he_get_in("");
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(2000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface can_he_get_in1 {
        void can_he_get_in(String what_is_he);
    }

    private List<String> materials_title_Array = new ArrayList<>();
    private List<String> material_colors = new ArrayList<>();

    public void get_these_materials(JSONObject requestJsonObject, final materialss materials) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/which_material_i_send.php"
                , requestJsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = new JSONArray();
                    //paeen moshkel dare
                    jsonArray = response.getJSONArray("materials");
                    Log.i(TAG, "onResponse:11 " + jsonArray);
                    JSONArray jsonArray_title = (JSONArray) jsonArray.get(0);
                    JSONArray jsonArray1_color = (JSONArray) jsonArray.get(1);
                    for (int i = 0; i < jsonArray_title.length(); i++) {
                        Log.i(TAG, "onResponse:123 " + jsonArray_title.getString(i));
                        materials_title_Array.add(jsonArray_title.getString(i));
                        material_colors.add(jsonArray1_color.getString(i));
                    }
                    materials.material(materials_title_Array, material_colors);


                } catch (JSONException e) {
                    e.printStackTrace();
                    materials.material(materials_title_Array, material_colors);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "onResponse: " + error);
                materials.material(materials_title_Array, material_colors);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(2000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface materialss {
        void material(List<String> material_title, List<String> colors);
    }

    private boolean is = true;

    public static List<Status> Statuses = new ArrayList<>();
    public static List<materials> material_titles_and_color = new ArrayList<>();

    public void getposts(JSONArray requestJsonArray, final OnPostsReceived onPostsReceived) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/getFirstFoodPosts.php"
                , requestJsonArray, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    Log.i(TAG, "onResponse:777 " + response.getJSONArray(1));
                    Log.i(TAG, "onResponse:7778 " + response.getJSONArray(2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                material_titles_and_color.clear();
                Statuses.clear();
                Status status = new Status();
                status.setHeader_image(ResourcesCompat.getDrawable(context.getResources(), R.drawable.food_head, null));
                status.setItemType(3);
                Statuses.add(status);

                try {
                    JSONArray jsonArray0 = response.getJSONArray(0);
                    JSONArray jsonArray1 = response.getJSONArray(1);
                    JSONArray jsonArray2 = response.getJSONArray(2);

                    if (jsonArray1 != null && jsonArray2 != null) {


                        for (int i = 0; i < jsonArray1.length(); i++) {
                            List<String> material_title = new ArrayList<>();
                            JSONArray materials_arraye = (JSONArray) jsonArray1.get(i);
                            materials materials = new materials();
                            materials.setFood_id(materials_arraye.getInt(0));
                            for (int j = 0; j < materials_arraye.length() - 1; j++) {
                                material_title.add(materials_arraye.getString(j + 1));
                            }
                            materials.setMaterial_title(material_title);

                            List<String> material_color = new ArrayList<>();
                            JSONArray materials_arraye1 = (JSONArray) jsonArray2.get(i);
                            for (int j = 0; j < materials_arraye1.length() - 1; j++) {
                                material_color.add(materials_arraye1.getString(j + 1));
                            }
                            materials.setMaterial_color(material_color);

                            material_titles_and_color.add(materials);
                        }


                    }


                    for (int i = 0; i < jsonArray0.length(); i++) {
                        Status status1 = new Status();

                        try {

                            JSONObject jsonObject = jsonArray0.getJSONObject(i);
                            status1.setId(jsonObject.getInt("id"));
                            for (int j = 0; j < material_titles_and_color.size(); j++) {
                                if (status1.getId() == material_titles_and_color.get(j).getFood_id()) {
                                    status1.setMaterial_title(material_titles_and_color.get(j).getMaterial_title());
                                    status1.setMaterial_color(material_titles_and_color.get(j).getMaterial_color());
                                }
                            }

                            status1.setTitle(jsonObject.getString("title"));
                            status1.setContent(jsonObject.getString("content"));
                            status1.setImage_url(jsonObject.getString("image_url"));
                            status1.setDate(jsonObject.getString("date_of_post"));
                            status1.setItemType(2);

                            Statuses.add(status1);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            is = false;
                            Log.i(TAG, "onResponse:error in second try ");
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    is = false;
                    Log.i(TAG, "onResponse:error in first try ");
                }


                Log.i(TAG, "onResponse: " + is);

                if (is)
                    onPostsReceived.onReceived(Statuses, true);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onPostsReceived.onReceived(Statuses, false);
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface OnPostsReceived {
        void onReceived(List<Status> Statuses, boolean is);
    }


    private boolean isIs = true;
    private boolean anymore = true;

    public void canigetposts(JSONArray requestJsonAraye, final Canyougetposts canyougetposts) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/howmanypostiget.php"
                , requestJsonAraye, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    JSONArray jsonArray0 = response.getJSONArray(0);
                    JSONArray jsonArray1 = response.getJSONArray(1);
                    JSONArray jsonArray2 = response.getJSONArray(2);


                    if (jsonArray1 != null && jsonArray2 != null) {


                        for (int i = 0; i < jsonArray1.length(); i++) {
                            List<String> material_title = new ArrayList<>();
                            JSONArray materials_arraye = (JSONArray) jsonArray1.get(i);
                            materials materials = new materials();
                            materials.setFood_id(materials_arraye.getInt(0));
                            for (int j = 0; j < materials_arraye.length() - 1; j++) {
                                material_title.add(materials_arraye.getString(j + 1));
                            }
                            materials.setMaterial_title(material_title);


                            List<String> material_color = new ArrayList<>();
                            JSONArray materials_arraye1 = (JSONArray) jsonArray2.get(i);
                            Log.i(TAG, "onResponse:666 " + materials_arraye1);
                            for (int j = 0; j < materials_arraye1.length() - 1; j++) {
                                material_color.add(materials_arraye1.getString(j + 1));
                            }
                            materials.setMaterial_color(material_color);

                            material_titles_and_color.add(materials);
                        }
                    }

                    if (jsonArray0.length() == 0)
                        anymore = false;
                    for (int i = 0; i < jsonArray0.length(); i++) {
                        Status status = new Status();
                        try {
                            JSONObject jsonObject = jsonArray0.getJSONObject(i);

                            status.setId(jsonObject.getInt("id"));
                            for (int j = material_titles_and_color.size() - 5; j < material_titles_and_color.size(); j++) {
                                if (status.getId() == material_titles_and_color.get(j).getFood_id()) {
                                    status.setMaterial_title(material_titles_and_color.get(j).getMaterial_title());
                                    status.setMaterial_color(material_titles_and_color.get(j).getMaterial_color());
                                    Log.i(TAG, "onResponse:555 " + material_titles_and_color.get(j).getMaterial_color());
                                }
                            }

                            status.setTitle(jsonObject.getString("title"));
                            status.setContent(jsonObject.getString("content"));
                            status.setImage_url(jsonObject.getString("image_url"));
                            status.setDate(jsonObject.getString("date_of_post"));
                            status.setItemType(2);
                            Statuses.add(status);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            isIs = false;
                            anymore = false;
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                if (isIs && anymore)
                    canyougetposts.canI(Statuses, true, true);

                if (!anymore)
                    canyougetposts.canI(Statuses, true, false);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                canyougetposts.canI(Statuses, false, false);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES
                , DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface Canyougetposts {
        void canI(List<Status> posts, boolean success, boolean anymore);
    }

    private List<Status> sta = new ArrayList<>();

    public void show_this_post(JSONArray requestJsonAraye, final show_this Show) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/which_post_i_send.php"
                , requestJsonAraye, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                isIs = true;
                List<Status> statuses = new ArrayList<>();

                Status status = new Status();
                try {

                    Log.i(TAG, "onResponse: " + response.length());
                    JSONObject jsonObject = response.getJSONObject(0);
                    status.setId(jsonObject.getInt("id"));
                    status.setTitle(jsonObject.getString("title"));
                    status.setContent(jsonObject.getString("content"));
                    status.setDescription(jsonObject.getString("description"));
                    status.setImage_url(jsonObject.getString("image_url"));
                    status.setVideo_url(jsonObject.getString("video_url"));
                    status.setView_count(jsonObject.getInt("view_count"));
                    status.setPost_rate(jsonObject.getInt("post_rate"));

                    JSONArray jsonArray1 = response.getJSONArray(1);

                    List<String> lists = new ArrayList<>();
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        lists.add(jsonArray1.getString(i));
                    }
                    status.setMaterial_title(lists);
                    List<String> lists1 = new ArrayList<>();
                    JSONArray jsonArray2 = response.getJSONArray(2);
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        lists1.add(jsonArray2.getString(i));
                    }
                    status.setMaterial_type(lists1);
                    List<String> lists2 = new ArrayList<>();
                    JSONArray jsonArray3 = response.getJSONArray(3);
                    for (int i = 0; i < jsonArray3.length(); i++) {
                        lists2.add(jsonArray3.getString(i));
                    }
                    status.setMaterial_count(lists2);

                    statuses.add(status);

                    Log.i(TAG, "onResponse: " + status.getMaterial_title());


                } catch (JSONException e) {
                    e.printStackTrace();
                    isIs = false;
                }

                Show.Show(statuses, true);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Show.Show(sta, false);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES
                , DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface show_this {
        void Show(List<Status> posts, boolean success);
    }


    public void give_me_these_posts1(JSONArray requestJsonAraye, final give_me_these_posts Show) {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, "http://"+context.getString(R.string.localhost)+"/give_me_these_posts_with_these_materials.php"
                , requestJsonAraye, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.i(TAG, "onResponse: " + response);
                int[] intArray = new int[response.length()];

                for (int i = 0; i < response.length(); i++) {
                    try {
                        Log.i(TAG, "onResponse:555 : " + response.getInt(i));
                        intArray[i] = response.getInt(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }



                Show.posts(intArray);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Show.posts(null);

            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(3000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES
                , DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(context).add(request);
    }

    public interface give_me_these_posts {
        void posts(int[] a);
    }


}
