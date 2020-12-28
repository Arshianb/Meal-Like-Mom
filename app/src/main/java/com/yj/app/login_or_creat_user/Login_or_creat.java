package com.yj.app.login_or_creat_user;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.florent37.shapeofview.shapes.CircleView;
import com.github.florent37.shapeofview.shapes.RoundRectView;
import com.hanks.htextview.base.HTextView;
import com.jkb.fragment.rigger.annotation.Puppet;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.lib.customedittext.CustomEditText;
import com.yj.app.ApiService;
import com.yj.app.MainActivity;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;
import com.yj.app.logo;

import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

//@Swiper
@Puppet
public class Login_or_creat extends BaseFragment {

    public static Login_or_creat newInstance(boolean this_ud_id_exist) {
        Bundle args = new Bundle();
        this_ud_id_exist1 = this_ud_id_exist;
        Login_or_creat fragment = new Login_or_creat();
        fragment.setArguments(args);
        return fragment;
    }

    private static boolean this_ud_id_exist1;
    private CircleView user_image;
    private ProgressBar progressBar_in_welcome;
    private ProgressBar progressBar_in_already;
    public static String what_should_logo_do = "";
    private Button welcome;
    private RoundRectView welcome_relative;
    private RelativeLayout relativeLayout;
    private CustomEditText username;
    private ImageView imageView;
    private RoundRectView frameLayout;
    private Button already_in;
    private RoundRectView already_in_relativ;
    private CustomEditText password;
    private CustomEditText password_confrim;
    private String new_user_username;
    private String new_user_password;
    private String new_user_password_confrim;
    private RelativeLayout password_relativlayout;
    private RelativeLayout password_confrim_relativlayout;
    private RelativeLayout username_relativlayout;
    private Button welcome_already;
    private RelativeLayout relativeLayout_already;
    private CustomEditText username_already;
    private String username_already_String;
    private RelativeLayout username_already_relative;
    private RelativeLayout password_already_relative;
    private CustomEditText password_already;
    private String password_already_String;
    private Button new_in;
    private String phone_ud_id;
    private boolean ignore_the_confrim_of_pass = false;
    private User_in userIn = new User_in();
    private UserSharedPrefManager prefManager;
    private HTextView wrong;
    private Button welcome_in_already_ud_id_button;
    private Button dont_rememmber_button;
    private RelativeLayout already_ud_id_relative;
    private CustomEditText username_ud_id_already;
    private boolean welcome_clicked = false;
    private ProgressBar progressBar_in_exist_ud_id;
    private RelativeLayout username_ud_id_exist_relativ;


    private int f = 0;

    private static boolean username_is_good = false;
    private static boolean password_is_good = false;


    @Override
    protected int getContentView() {
        return R.layout.login_or_creat;
    }


    @Override
    protected void init(Bundle savedInstanceState) {

        username_ud_id_exist_relativ = (RelativeLayout) findViewById(R.id.ud_id_already1);
        progressBar_in_exist_ud_id = (ProgressBar) findViewById(R.id.prograsbar2);
        username_ud_id_already = (CustomEditText) findViewById(R.id.ud_id_already);
        welcome_in_already_ud_id_button = (Button) findViewById(R.id.welcome_in_ud_id_exist);
        dont_rememmber_button = (Button) findViewById(R.id.he_dont_remember_username);
        already_ud_id_relative = (RelativeLayout) findViewById(R.id.relativelayout_with_ud_id);

        progressBar_in_welcome = (ProgressBar) findViewById(R.id.prograsbar);
        progressBar_in_already = (ProgressBar) findViewById(R.id.prograsbar1);
        prefManager = new UserSharedPrefManager(mContext);
        user_image = (CircleView) findViewById(R.id.user_image1);
        password_relativlayout = (RelativeLayout) findViewById(R.id.relativ_password);
        username_relativlayout = (RelativeLayout) findViewById(R.id.relativ_username);
        password_confrim_relativlayout = (RelativeLayout) findViewById(R.id.relativ_password_confrim);
        phone_ud_id = MainActivity.UD_ID;
        welcome_already = (Button) findViewById(R.id.welcome_already);
        new_in = (Button) findViewById(R.id.new_in);
        relativeLayout_already = (RelativeLayout) findViewById(R.id.relativelayout1);
        username_already = (CustomEditText) findViewById(R.id.username_already);
        username_already_relative = (RelativeLayout) findViewById(R.id.username_already1);
        password_already_relative = (RelativeLayout) findViewById(R.id.password_already1);
        password_already = (CustomEditText) findViewById(R.id.password_already);
        already_in = (Button) findViewById(R.id.button2);
        already_in_relativ = (RoundRectView) findViewById(R.id.button22);
        frameLayout = (RoundRectView) findViewById(R.id.frame);
        imageView = (ImageView) findViewById(R.id.user_image);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativelayout);
        welcome = (Button) findViewById(R.id.button);
        welcome_relative = (RoundRectView) findViewById(R.id.button1);
        username = (CustomEditText) findViewById(R.id.username);
        password = (CustomEditText) findViewById(R.id.password);
        password_confrim = (CustomEditText) findViewById(R.id.password_confrim);
        wrong = (HTextView) findViewById(R.id.wrong_content);


        button_animation();
        if (!this_ud_id_exist1) {


            control_username_and_password_edit_text();


            visible_NewIn_relative();
            frameLayout.setVisibility(View.VISIBLE);


            logo.Animation("get in");


            welcome.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    welcome_clicked = true;

                    control_username(0);
                    control_password(0);


                    if (password_is_good) {
                        password.setErrorEnabled(false);
                        password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    }
                    if (username_is_good) {
                        username.setErrorEnabled(false);
                        username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    }
                    if (password_is_good && username_is_good)
                        he_can_creat_account();
                    username_is_good = false;
                    password_is_good = false;
                }
            });

            already_in.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clicked_already();
                }
            });
        } else {
            ud_id_exist();

        }
    }

    private void ud_id_exist() {

        visible_already_ud_id();
        logo.Animation("get in");

        welcome_in_already_ud_id_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar_in_exist_ud_id.setVisibility(View.VISIBLE);

                ApiService apiService = new ApiService(mContext);
                JSONObject requestJsonObject = new JSONObject();
                try {

                    requestJsonObject.put("give_me_ud_id",
                            phone_ud_id);
                    requestJsonObject.put("give_me_usename",
                            username_ud_id_already.getText());


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                apiService.what_is_your_UD_ID_and_username(requestJsonObject, new ApiService.can_he_get_in1() {
                    @Override
                    public void can_he_get_in(String what_should_i_do) {

                        progressBar_in_exist_ud_id.setVisibility(View.GONE);
                        if (what_should_i_do.equals("he can get in")) {
                            userIn.setUD_ID(phone_ud_id);
                            userIn.setUsername(username_already.getText());
                            prefManager.saveUser(userIn);
                            username_ud_id_exist_relativ.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                            username_ud_id_already.setErrorEnabled(false);
                            dont_rememmber_button.setEnabled(false);
                            welcome_in_already_ud_id_button.setEnabled(false);
                            username_ud_id_already.setEnabled(false);

                            clicked_welcom();

                        } else {
                            if (what_should_i_do.equals("")) {
                                Snackbar.make(findViewById(R.id.frame), "there is a problem in server", Snackbar.LENGTH_LONG)
                                        .show();
                            }
                            if (what_should_i_do.equals("he shouldn't get in")) {

                                username_ud_id_exist_relativ.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                                username_ud_id_already.setError("this username isn't exist");
                                YoYo.with(Techniques.Swing)
                                        .duration(500)
                                        .playOn(username_ud_id_exist_relativ);


                            }
                        }

                    }
                });


            }
        });

        dont_rememmber_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forget_clicked();
            }
        });


    }


    private void clicked_welcom() {
        new_in.setEnabled(false);
        already_in.setEnabled(false);
        welcome.setEnabled(false);

        control_username_and_password_edit_text();
        logo.Animation("get out");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                what_should_logo_do = "let him get in";
                Rigger.getRigger(Login_or_creat.this).startFragment(logo.newInstance());

            }
        }, 1000);


    }

    private void forget_clicked() {

        dont_rememmber_button.setEnabled(false);
        welcome_in_already_ud_id_button.setEnabled(false);
        username_ud_id_already.setEnabled(false);
        new_in.setEnabled(false);
        already_in.setEnabled(false);
        welcome.setEnabled(false);

        logo.Animation("scale from 1 to 0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                new_in.setEnabled(true);
                already_in.setEnabled(true);
                welcome.setEnabled(true);

                gone_already_ud_id();
                visible_NewIn_relative();
                logo.Animation("scale from 0 to 1");


            }
        }, 250);

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control_username(0);
                control_password(0);
                welcome_clicked = true;

                if (password_is_good) {
                    password.setErrorEnabled(false);
                    password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                }
                if (username_is_good) {
                    username.setErrorEnabled(false);
                    username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                }
                if (password_is_good && username_is_good)
                    he_can_creat_account();
                username_is_good = false;
                password_is_good = false;
            }
        });


        already_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_already();
            }
        });
    }

    private void clicked_new_in() {

        new_in.setEnabled(false);
        already_in.setEnabled(false);
        welcome.setEnabled(false);

        logo.Animation("move left from x = 0");
        control_username_and_password_edit_text();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new_in.setEnabled(true);
                already_in.setEnabled(true);
                welcome.setEnabled(true);

                gone_already_relativ();
                visible_NewIn_relative();
                logo.Animation("move left from x = 1");
            }
        }, 250);


        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control_username(0);
                control_password(0);
                welcome_clicked = true;

                if (password_is_good) {
                    password.setErrorEnabled(false);
                    password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                }
                if (username_is_good) {
                    username.setErrorEnabled(false);
                    username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                }
                if (password_is_good && username_is_good)
                    he_can_creat_account();
                username_is_good = false;
                password_is_good = false;
            }
        });


        already_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_already();
            }
        });

    }


    private void clicked_already() {

        new_in.setEnabled(false);
        already_in.setEnabled(false);
        welcome.setEnabled(false);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new_in.setEnabled(true);
                already_in.setEnabled(true);
                welcome.setEnabled(true);

            }
        }, 500);

        logo.Animation("move right from x = 0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gone_newIn_relative();
                visible_already_relative();
            }
        }, 250);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.Animation("move right from x = -1");
            }
        }, 250);

        welcome_already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_user();
            }
        });

        new_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_new_in();
            }
        });
    }


    private void login_user() {
        JSONObject requestJsonObject = new JSONObject();
        progressBar_in_already.setVisibility(View.VISIBLE);
        try {

            requestJsonObject.put("UD_ID", phone_ud_id);
            requestJsonObject.put("username", username_already.getText());
            requestJsonObject.put("password", password_already.getText());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        ApiService apiService = new ApiService(mContext);
        apiService.LoginUser(requestJsonObject, new ApiService.OnLoginComplete() {
            @Override
            public void onLogin(boolean the_problem_is_from_server, String what_should_i_should_do) {

                progressBar_in_already.setVisibility(View.GONE);


                Log.i(TAG, "onLogin: " + what_should_i_should_do);
                if (what_should_i_should_do.equals("he can get in")) {

                    password_already_relative.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    username_already_relative.setBackground(mContentView.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    wrong.setVisibility(View.GONE);

                    userIn.setUD_ID(phone_ud_id);
                    userIn.setUsername(username_already.getText());
                    userIn.setPassword(password_already.getText());
                    prefManager.saveUser(userIn);
                    clicked_welcom_already();
                } else {
                    if (the_problem_is_from_server || what_should_i_should_do.equals("check network"))
                        Snackbar.make(findViewById(R.id.frame), "Error in server", Snackbar.LENGTH_LONG)
                                .show();


                    if (what_should_i_should_do.equals("he shouldn't get in")) {
                        password_already_relative.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                        username_already_relative.setBackground(mContentView.getResources().getDrawable(R.drawable.wrong_background));
                        wrong.setVisibility(View.VISIBLE);
                        wrong.animateText("username or password is wrong");
                        YoYo.with(Techniques.Shake)
                                .duration(500)
                                .playOn(password_already_relative);
                        YoYo.with(Techniques.Shake)
                                .duration(500)
                                .playOn(username_already_relative);
                    }
                }

            }
        });
    }

    private void clicked_welcom_already() {
        password_already_String = password_already.getText();
        username_already_String = username_already.getText();
        new_in.setEnabled(false);
        already_in.setEnabled(false);
        welcome.setEnabled(false);
        welcome_already.setEnabled(false);

        logo.Animation("get out");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                what_should_logo_do = "let him get in";
                Rigger.getRigger(Login_or_creat.this).startFragment(logo.newInstance());

            }
        }, 1000);

    }


    private void control_password(int where_this_post_call) {
        ignore_the_confrim_of_pass = false;
        password_is_good = false;
        new_user_password = password.getText();
        new_user_password_confrim = password_confrim.getText();
        int aa;
        if (where_this_post_call == 0)
            aa = new_user_password.length();
        else
            aa = 8;


        if (aa > 7) {

            if (new_user_password.indexOf(' ') == -1) {
                for (int i = 0; i < 33; i++) {
                    char c = (char) i;
                    if (new_user_password.indexOf(c) == -1)
                        f = 1;
                }

                Log.i(TAG, "onClick: " + new_user_password);


                if (f == 1) {
                    f = 0;
                    for (int i = 48; i < 58; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            f = i;
                        }

                    }
                }
                if (f > -1) {
                    int y = 0;
                    int p = 0;
                    char d = (char) f;
                    for (int i = 48; i < 58; i++) {
                        char c = (char) i;
                        Log.i(TAG, "onClick: " + new_user_password.indexOf(d));
                        Log.i(TAG, "onClick: " + y);
                        Log.i(TAG, "onClick: " + p);
                        if (f != 0) {
                            String z = new_user_password.substring(0, new_user_password.indexOf(d));

                            if (z.indexOf(c) > -1) {
                                y = 1;
                            }
                        }
                        String h = new_user_password.substring(new_user_password.indexOf(d) + 1);
                        char c1 = (char) i;
                        if (h.indexOf(c1) > -1) {
                            p = 1;
                        }

                    }
                    if (y == 1 || p == 1) {
                        f = 1;
                    } else
                        f = 0;
                }

                if (f > 0) {
                    f = 0;
                    for (int i = 97; i < 123; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            f = 1;
                        }

                    }
                }

                if (f > 0) {
                    f = 0;
                    for (int i = 65; i < 91; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            f = 1;
                        }

                    }
                }


                if (f == 1) {
                    f = 0;
                    int q = 0;
                    int w = 0;
                    int g = 0;
                    int s = 0;
                    int u = 0;

                    for (int i = 33; i < 47; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            u = 1;
                        }
                    }


                    for (int i = 33; i < 48; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            q = 1;
                        }
                    }
                    for (int i = 58; i < 65; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            w = 1;
                        }
                    }

                    for (int i = 91; i < 97; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            g = 1;
                        }
                    }

                    for (int i = 123; i < 127; i++) {
                        char c = (char) i;
                        if (new_user_password.indexOf(c) > -1) {
                            s = 1;
                        }
                    }


                    if (s == 1 || g == 1 || w == 1 || q == 1 || u == 1)
                        f = 1;
                }


                if (f == 1) {
                    f = 0;
                    if (where_this_post_call == 1) {
                        ignore_the_confrim_of_pass = true;
                        password_is_good = true;
                    }
                    if (new_user_password.equals(new_user_password_confrim)) {
                        password_is_good = true;
                    } else {
                        if (where_this_post_call == 0) {
                            password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                            password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                            password_confrim.setError("password is not confirm");
                            YoYo.with(Techniques.Shake)
                                    .duration(500)
                                    .playOn(password_relativlayout);
                            YoYo.with(Techniques.Shake)
                                    .duration(500)
                                    .playOn(password_confrim_relativlayout);
                        }
                    }


                } else {
                    if (where_this_post_call == 0) {
                        password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                        password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                        password.setError("Your password is not compatible with our minimums ");
                        YoYo.with(Techniques.Shake)
                                .duration(500)
                                .playOn(password_relativlayout);
                        YoYo.with(Techniques.Shake)
                                .duration(500)
                                .playOn(password_confrim_relativlayout);
                    }
                }

            } else {
                if (where_this_post_call == 0) {
                    password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                    password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                    password.setError("your password shouldn't have space ");
                    YoYo.with(Techniques.Shake)
                            .duration(500)
                            .playOn(password_relativlayout);
                    YoYo.with(Techniques.Shake)
                            .duration(500)
                            .playOn(password_confrim_relativlayout);
                }
            }

        } else {
            password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
            password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
            password.setError("your password should have at less 8 character");
            YoYo.with(Techniques.Shake)
                    .duration(500)
                    .playOn(password_relativlayout);
            YoYo.with(Techniques.Shake)
                    .duration(500)
                    .playOn(password_confrim_relativlayout);


        }

    }

    private void control_username(int i) {
        username_is_good = false;
        int s;
        new_user_username = username.getText();
        if (i == 0)
            s = new_user_username.length();
        else
            s = 5;
        if (new_user_username.indexOf(' ') == -1) {

            if (s > 3) {
                if (
                        !new_user_username.contains("*") &&
                                !new_user_username.contains("@") && new_user_username.indexOf('#') == -1 &&
                                !new_user_username.contains("%") && !new_user_username.contains("!") &&
                                !new_user_username.contains("?") && !new_user_username.contains("+") &&
                                new_user_username.indexOf('^') == -1 && new_user_username.indexOf('&') == -1 &&
                                new_user_username.indexOf('*') == -1 && new_user_username.indexOf('(') == -1 &&
                                new_user_username.indexOf(')') == -1 && new_user_username.indexOf('|') == -1 &&
                                new_user_username.indexOf('/') == -1 && new_user_username.indexOf('$') == -1 &&
                                new_user_username.indexOf(':') == -1 &&
                                new_user_username.indexOf('>') == -1 && new_user_username.indexOf('}') == -1 &&
                                new_user_username.indexOf('<') == -1 && new_user_username.indexOf(';') == -1 &&
                                new_user_username.indexOf('[') == -1 && new_user_username.indexOf('=') == -1 &&
                                new_user_username.indexOf(']') == -1 && new_user_username.indexOf('{') == -1) {

                    username_is_good = true;

                } else {

                    if (i == 0) {
                        username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                        username.setError("username Includes characters that are not acceptable for us");
                        YoYo.with(Techniques.Shake)
                                .duration(500)
                                .playOn(username_relativlayout);
                    }
                }
            } else {

                username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                username.setError("username should have 4 char at less");
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .playOn(username_relativlayout);

            }


        } else {
            if (i == 0) {
                username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                username.setError("username shouldn't have space");
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .playOn(username_relativlayout);
            }

        }

    }

    private void button_animation() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), ContextCompat.getColor(mContext,
                R.color.white), ContextCompat.getColor(mContext, R.color.black));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                welcome.setBackgroundColor((int) valueAnimator.getAnimatedValue());
                already_in.setBackgroundColor((int) valueAnimator.getAnimatedValue());
                welcome_already.setBackgroundColor((int) valueAnimator.getAnimatedValue());
                new_in.setBackgroundColor((int) valueAnimator.getAnimatedValue());
                welcome_in_already_ud_id_button.setBackgroundColor((int) valueAnimator.getAnimatedValue());
                dont_rememmber_button.setBackgroundColor((int) valueAnimator.getAnimatedValue());


            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.start();


        ValueAnimator valueAnimator1 = ValueAnimator.ofObject(new ArgbEvaluator(), ContextCompat.getColor(mContext,
                R.color.black), ContextCompat.getColor(mContext, R.color.white));

        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                welcome.setTextColor((int) valueAnimator.getAnimatedValue());
                already_in.setTextColor((int) valueAnimator.getAnimatedValue());
                welcome_already.setTextColor((int) valueAnimator.getAnimatedValue());
                new_in.setTextColor((int) valueAnimator.getAnimatedValue());
                welcome_in_already_ud_id_button.setTextColor((int) valueAnimator.getAnimatedValue());
                dont_rememmber_button.setTextColor((int) valueAnimator.getAnimatedValue());

            }
        });
        valueAnimator1.setDuration(1000);
        valueAnimator1.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator1.start();
    }


    private void he_can_creat_account() {
        progressBar_in_welcome.setVisibility(View.VISIBLE);
        ApiService apiService = new ApiService(mContext);
        JSONObject requestJsonObject = new JSONObject();
        try {

            requestJsonObject.put("UD_ID", phone_ud_id);
            requestJsonObject.put("username", new_user_username);
            requestJsonObject.put("password", new_user_password);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        apiService.signUpUser(requestJsonObject, new ApiService.OnSignupComplete() {
            @Override
            public void onSignUp(String what_should_i_do, String the_problem_is_from_server) {

                progressBar_in_welcome.setVisibility(View.GONE);

                if (what_should_i_do.equals("he can get in")) {
                    clicked_welcom();
                    username.setErrorEnabled(false);
                    password.setErrorEnabled(false);
                    username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                } else {
                    if (the_problem_is_from_server.equals("")) {
                        Snackbar.make(findViewById(R.id.frame), "Error in server", Snackbar.LENGTH_LONG)
                                .show();
                    } else {
                        if (the_problem_is_from_server.equals("no"))
                            Snackbar.make(findViewById(R.id.frame), "please check your network", Snackbar.LENGTH_LONG)
                                    .show();

                    }


                    if (what_should_i_do.equals("this username exist")) {
                        username.setError("this username exist");
                        username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.wrong_background));
                        YoYo.with(Techniques.Swing)
                                .duration(500)
                                .playOn(username_relativlayout);

                    }
                }
            }
        });
    }

    private void control_username_and_password_edit_text() {
        username.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                control_username(1);
                if (!username_is_good) {
                    username.setError("username shouldn't contain (@ , # , % , ! , ? , + , ^ , & , * , ( , ) , | , / , $ , : , > , < , { , } , [ , ] , ; , = , ! , space )");
                } else {
                    if (!welcome_clicked) {
                        username.setErrorEnabled(false);
                        username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    } else {
                        if (username.getText().length() < 4) {
                            username.setError("username should have 4 char at less");
                            username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                        } else {
                            username.setErrorEnabled(false);
                            username_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                        }
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                control_password(1);
                if (!password_is_good) {
                    if (!ignore_the_confrim_of_pass) {
                        password.setError("your password should Consist of a capital letter and Small letter , one char , tow number  ");
                    } else {
                        if (!welcome_clicked) {
                            password.setErrorEnabled(false);
                            password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                        }
                    }
                } else {
                    password.setErrorEnabled(false);
                    password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    if (welcome_clicked) {
                        if (!password.getText().equals(password_confrim.getText())) {
                            password_confrim.setError("password is not confirm");
                            password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                        } else {
                            password_confrim.setErrorEnabled(false);
                            password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                        }
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        password_confrim.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (welcome_clicked) {
                    if (!password.getText().equals(password_confrim.getText())) {
                        password_confrim.setError("password is not confirm");
                        password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    } else {
                        password_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                        password_confrim.setErrorEnabled(false);
                        password_confrim_relativlayout.setBackground(mContext.getResources().getDrawable(R.drawable.selector_default_edit_text));
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }


    private void visible_NewIn_relative() {
        relativeLayout.setVisibility(View.VISIBLE);
        welcome_relative.setVisibility(View.VISIBLE);
        already_in_relativ.setVisibility(View.VISIBLE);
        password_relativlayout.setVisibility(View.VISIBLE);
        password_confrim_relativlayout.setVisibility(View.VISIBLE);
        username_relativlayout.setVisibility(View.VISIBLE);
        user_image.setVisibility(View.VISIBLE);
        welcome.setVisibility(View.VISIBLE);
        already_in.setVisibility(View.VISIBLE);
        imageView.setVisibility(View.VISIBLE);
        username.setVisibility(View.VISIBLE);
        password.setVisibility(View.VISIBLE);
        password_confrim.setVisibility(View.VISIBLE);
    }

    private void gone_newIn_relative() {
        relativeLayout.setVisibility(View.GONE);
        welcome_relative.setVisibility(View.GONE);
        already_in_relativ.setVisibility(View.GONE);
        password_relativlayout.setVisibility(View.GONE);
        password_confrim_relativlayout.setVisibility(View.GONE);
        username_relativlayout.setVisibility(View.GONE);
        user_image.setVisibility(View.GONE);
        welcome.setVisibility(View.GONE);
        already_in.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        username.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        password_confrim.setVisibility(View.GONE);
    }

    private void visible_already_relative() {
        relativeLayout_already.setVisibility(View.VISIBLE);
        welcome_already.setVisibility(View.VISIBLE);
        new_in.setVisibility(View.VISIBLE);
        username_already_relative.setVisibility(View.VISIBLE);
        password_already_relative.setVisibility(View.VISIBLE);
        username_already.setVisibility(View.VISIBLE);
        password_already.setVisibility(View.VISIBLE);

    }


    private void visible_already_ud_id() {
        welcome_in_already_ud_id_button.setVisibility(View.VISIBLE);
        dont_rememmber_button.setVisibility(View.VISIBLE);
        already_ud_id_relative.setVisibility(View.VISIBLE);
        username_ud_id_already.setVisibility(View.VISIBLE);


    }

    private void gone_already_ud_id() {
        welcome_in_already_ud_id_button.setVisibility(View.GONE);
        dont_rememmber_button.setVisibility(View.GONE);
        already_ud_id_relative.setVisibility(View.GONE);
        username_ud_id_already.setVisibility(View.GONE);

    }

    private void gone_already_relativ() {
        relativeLayout_already.setVisibility(View.GONE);
        welcome_already.setVisibility(View.GONE);
        new_in.setVisibility(View.GONE);
        username_already_relative.setVisibility(View.GONE);
        password_already_relative.setVisibility(View.GONE);
        username_already.setVisibility(View.GONE);
        password_already.setVisibility(View.GONE);
    }


}
