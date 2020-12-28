package com.yj.app.login_or_creat_user;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Saeed shahini on 8/23/2016.
 */
public class UserSharedPrefManager {

    private static final String USER_SHARED_PREF_NAME = "user_shared_pref";



    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_UD_ID= "UD_ID";

    private SharedPreferences sharedPreferences;

    public UserSharedPrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences(USER_SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public void saveUser(User_in userIn) {
        if (userIn != null) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USERNAME, userIn.getUsername());
            editor.putString(KEY_PASSWORD, userIn.getPassword());
            editor.putString(KEY_UD_ID, userIn.getUD_ID());

            editor.apply();
        }
    }

    public User_in getUser() {
        User_in userIn = new User_in();
        userIn.setUsername(sharedPreferences.getString(KEY_USERNAME, ""));
        userIn.setPassword(sharedPreferences.getString(KEY_PASSWORD, ""));
        userIn.setUD_ID(sharedPreferences.getString(KEY_UD_ID, ""));

        return userIn;
    }
}
