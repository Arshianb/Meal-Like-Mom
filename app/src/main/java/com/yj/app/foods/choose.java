package com.yj.app.foods;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hanks.htextview.base.HTextView;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.yalantis.filter.listener.FilterListener;
import com.yalantis.filter.widget.Filter;
import com.yj.app.ApiService;
import com.yj.app.MainPage.Search.Tag;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.chad.library.adapter.base.listener.SimpleClickListener.TAG;
import static com.yj.app.MainPage.Search.Search.search_appBarLayout;

public class choose extends BaseFragment implements FilterListener<Tag> {


    private static String search;

    public static choose newInstance(String search1) {
        Bundle args = new Bundle();
        search = search1;
        choose fragment = new choose();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.choose;
    }

    private choose_video_DatabaseOpenHelper openHelper;
    private RecyclerView recyclerView;
    public static Filter<Tag> mFilter;

    private SlidingUpPanelLayout slidingUpPanelLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private postAdapter postsAdapter;
    private HTextView title;
    private VideoView video;
    private TextView material;
    private TextView description;
    private ImageButton imageButton;
    private TextView description_in_head;
    private ImageView imageView1;
    private TextView toolbar_of_each_post;
    private ImageButton like;
    private MediaController mediaController ; ;
    private boolean in_referesh_listenner_it_get_there = false;

    private boolean is_he_connected = true;
    //    private choose_video_DatabaseOpenHelper openHelper;
    private int i = 1;
    private boolean favorit = false;

    @Override
    protected void init(Bundle savedInstanceState) {


        mFilter = (Filter<Tag>) findViewById(R.id.filter);
        mFilter.setListener(choose.this);
        mFilter.setNoSelectedItemText(getString(R.string.str_all_selected));

        description_in_head = (TextView) findViewById(R.id.description);
        slidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiptoreferesh);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        openHelper = new choose_video_DatabaseOpenHelper(mContext);
        material = (TextView) findViewById(R.id.material);
        title = (HTextView) findViewById(R.id.title_in);
        video = (VideoView) findViewById(R.id.video);
        description = (TextView) findViewById(R.id.repice);
        toolbar_of_each_post = (TextView) findViewById(R.id.content);
        imageView1 = (ImageView) findViewById(R.id.image_in_toolbar);
        toolbar_of_each_post.setSelected(true);
        title.setSelected(true);
        like = (ImageButton) findViewById(R.id.liked);

        mediaController = new MediaController(mContext);
        mediaController.setMediaPlayer(video);
        video.setMediaController(mediaController);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!favorit) {
                    like.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.favorit, null));
                    favorit = true;
                } else {
                    like.setImageDrawable(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.ic_favorite_border_black_24dp, null));
                    favorit = false;
                }

            }
        });
        referesh(null, search);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                i = 1;
                if(a1!=null) {
                    if (a1.length > 0)
                        referesh(a1, search);
                    else
                        referesh(null, search);
                }else {
                    referesh(null, search);
                }
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);


//                slidingUpPanelLayout.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//
//                Log.i(TAG, "onTouch: " + slidingUpPanelLayout.getCurrentParallaxOffset());
//                if(slidingUpPanelLayout.getCurrentParallaxOffset() > -50){
//                    YoYo.with(Techniques.RollIn)
//                            .duration(500)
//                            .playOn(mFilter);
//                    ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
//                    p.setMargins(0, marginInDp, 0,0 );
//                    frameLayout.requestLayout();
//                }
//                return false;
//            }
//        });


    }

    private static int s = 0;


    private void referesh(int[] a, String search1) {


        final ApiService apiService = new ApiService(mContext);
        JSONArray requestJsonArray = new JSONArray();

        Log.i(TAG, "referesh: " + Arrays.toString(a));
        if (a == null) {

            try {

                requestJsonArray.put(0, null);
                requestJsonArray.put(1,search1);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            Log.i(TAG, "referesh: " + a.length);
            try {

                for (int j = 0; j < a.length; j++) {
                    requestJsonArray.put(j, a[j]);
                }
                Log.i(TAG, "referesh: " + requestJsonArray);


            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        Log.i(TAG, "referesh: " +requestJsonArray );


        apiService.getposts(requestJsonArray, new ApiService.OnPostsReceived() {
            @Override
            public void onReceived(List<Status> Statuses, boolean is) {


                if (is) {
                    Log.i(TAG, "onReceived: " + Statuses.size());
                    getData.setPosts(Statuses);
                    openHelper.addPosts(Statuses);
                    is_he_connected = true;

                } else {

                    getPostsFromDatabase();
                    is_he_connected = false;
                    Toast.makeText(mContext, "check your network connection", Toast.LENGTH_SHORT).show();

                }


                postsAdapter = new postAdapter();
//                final GridLayoutManager manager = new GridLayoutManager(mContext, 2 , LinearLayoutManager.HORIZONTAL , false);
                final GridLayoutManager manager = new GridLayoutManager(mContext, 2);
                recyclerView.setLayoutManager(manager);
                postsAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                        if (position > 0) {
                            if (position % 2 == 0)
                                postsAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                            else
                                postsAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
                            return 2;
                        } else {
                            postsAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
                            return 2;

                        }
                    }
                });
                postsAdapter.isFirstOnly(false);
                postsAdapter.setEnableLoadMore(true);

                loadmore(search1);

                postsAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(BaseQuickAdapter adapter, final View view, int position) {

                        search_appBarLayout.setExpanded(false, true);
//                        YoYo.with(Techniques.RollOut)
//                                .duration(500)
//                                .playOn(mFilter);
//                        ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
//                        p.setMargins(0, 0, 0, 0);
//                        frameLayout.requestLayout();
                        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.HIDDEN);

                        if (s == 1) {
                            video.setVisibility(View.GONE);
                            title.animateText("");
                            toolbar_of_each_post.setText("");
                            material.setText("");
                            description_in_head.setVisibility(View.INVISIBLE);
                            description.setVisibility(View.INVISIBLE);
                        }


                        if (position > 0) {


                            ApiService apiService = new ApiService(mContext);
                            JSONObject requestJsonObject = new JSONObject();
                            try {
                                requestJsonObject.put("give_me_this_post", getData.getSampleData().get(position).getId());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            JSONArray givemethispost = new JSONArray();
                            givemethispost.put(requestJsonObject);

                            Log.i(TAG, "onItemChildClick: " + requestJsonObject);

                            apiService.show_this_post(givemethispost, new ApiService.show_this() {
                                @Override
                                public void Show(List<Status> posts, boolean success) {

                                    if (success) {

                                        if (!posts.get(0).getDescription().equals("")) {
                                            description.setText(posts.get(0).getDescription());
                                            description_in_head.setVisibility(View.VISIBLE);
                                            description.setVisibility(View.VISIBLE);
                                        }
                                        s = 1;
                                        video.setVisibility(View.VISIBLE);
//

                                        Uri uri = Uri.parse(posts.get(0).getVideo_url());
                                        video.setVideoURI(uri);
                                        video.requestFocus();
                                        video.start();
                                        mediaController.setAnchorView(video);

//                                        Picasso.with(mContext).load(posts.get(0).getImage_url().replace("127.0.0.1", mContext.getString(R.string.localhost1)))
//                                                .placeholder(R.drawable.cloud).error(R.drawable.block).into(video);
//                                        video.setVideoURI(Uri.parse(posts.get(0).getImage_url().replace("127.0.0.1", mContext.getString(R.string.localhost1))));
                                        Log.i(TAG, "Show: " + posts.get(0).getVideo_url().replace("127.0.0.1", mContext.getString(R.string.localhost1)));

                                        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                                        title.animateText(posts.get(0).getTitle());
                                        toolbar_of_each_post.setText(posts.get(0).getContent());


                                        for (int i = 0; i < posts.get(0).getMaterial_title().size(); i++) {
                                            material.append(i + 1 + "): ");
                                            material.append("\n");
                                            if (!posts.get(0).getMaterial_type().get(i).equals(""))
                                                material.append("name : " + posts.get(0).getMaterial_title().get(i) + " ,  type : "
                                                        + posts.get(0).getMaterial_type().get(i) + " ,  count : " +
                                                        posts.get(0).getMaterial_count().get(i));
                                            else
                                                material.append("name : " + posts.get(0).getMaterial_title().get(i)
                                                        + " ,  count : " + posts.get(0).getMaterial_count().get(i));
                                            material.append("\n");
                                        }
                                    } else
                                        Toast.makeText(mContext, "check your network", Toast.LENGTH_SHORT).show();

                                }
                            });

                        } else {
                            Toast.makeText(mContext, "Image clicked", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                recyclerView.setAdapter(postsAdapter);

            }
        });
    }



    public static int id_last_post_in_database;

    private void loadmore(String search) {
        postsAdapter.setAutoLoadMoreSize(4);
        postsAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {


                Log.i(TAG, "onLoadMoreRequested: " + i);
                ApiService apiService = new ApiService(mContext);
                JSONObject requestJsonObject = new JSONObject();
                try {
                    requestJsonObject.put("give_me_posts", i);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JSONArray howmanyPostI_get = new JSONArray();
                howmanyPostI_get.put(requestJsonObject);
                if (a1 != null)
                    for (int j = 1; j <= a1.length; j++) {
                        try {

                            howmanyPostI_get.put(j, a1[j - 1]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                else {

                    howmanyPostI_get.put(a1);
                    howmanyPostI_get.put(search);
                }


                Log.i(TAG, "onLoadMoreRequested: " + howmanyPostI_get);
                //uiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
                apiService.canigetposts(howmanyPostI_get, new ApiService.Canyougetposts() {
                    @Override
                    public void canI(List<Status> posts, boolean success, boolean anymore) {


                        if (success) {
                            if (!is_he_connected) {
                                if (posts.get(10).getId() == id_last_post_in_database || posts.get(11).getId() == id_last_post_in_database
                                        || posts.get(13).getId() == id_last_post_in_database || posts.get(14).getId() == id_last_post_in_database
                                        || posts.get(15).getId() == id_last_post_in_database || posts.get(16).getId() == id_last_post_in_database)
                                    referesh(null, "");
                            }
                            is_he_connected = true;
                            if (anymore) {
                                i++;
                                getData.setPosts(posts);
                                postsAdapter.loadMoreComplete();
                            } else {
                                postsAdapter.loadMoreEnd(false);
                            }
                        } else {
                            postsAdapter.loadMoreFail();
//                                        postsAdapter.loadMoreComplete();
                        }

                    }
                });
            }
        });
    }


    private void getPostsFromDatabase() {
        openHelper = new choose_video_DatabaseOpenHelper(mContext);
        List<Status> posts = openHelper.getPosts();
        if (posts.size() != 0) {
            id_last_post_in_database = posts.get(10).getId();
            if (posts.get(0).getId() == 0) {
                posts.get(0).setItemType(3);
                posts.get(0).setHeader_image(ResourcesCompat.getDrawable(mContext.getResources(), R.drawable.food_head, null));
            }
        }
        getData.setPosts(posts);
        ApiService.Statuses = posts;
    }


    private void setupToolbar() {

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rigger.getRigger(choose.this).close();
            }
        });
    }

    public int[] getPuppetAnimations() {
        return new int[]{
                R.anim.push_left_in_no_alpha,
                R.anim.push_right_out_no_alpha,
                R.anim.push_right_in_no_alpha,
                R.anim.push_left_out_no_alpha
        };
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }


    @Override
    public void onFilterDeselected(Tag tag) {

    }

    @Override
    public void onPause() {
        super.onPause();
        video.pause();

    }

    @Override
    public void onStop() {
        super.onStop();
        video.stopPlayback();
    }

    @Override
    public void onFilterSelected(Tag tag) {
        if (tag.getText().equals("All Materials")) {
            mFilter.deselectAll();
            mFilter.collapse();
        }
    }

    private List<String> old_materials_title = new ArrayList<>();

    @Override
    public void onFiltersSelected(@NotNull ArrayList<Tag> arrayList) {


        List<String> new_materials_title = new ArrayList<>();

        new_materials_title.clear();
        for (int j = 0; j < arrayList.size(); j++) {
            new_materials_title.add(arrayList.get(j).getText());
        }


        show_me_posts_with_materials(new_materials_title, old_materials_title);

    }

    @Override
    public void onNothingSelected() {
        if (old_materials_title.size() == 1) {
            referesh(null, search);
            old_materials_title.clear();
            a1 = null;
        }

    }

    private int[] a1;

    private void show_me_posts_with_materials(List<String> new_materials_title, List<String> old_materials_title) {


        boolean eqall = true;
        Log.i(TAG, "show_me_posts_with_materials:old " + this.old_materials_title);
        Log.i(TAG, "show_me_posts_with_materials:new " + new_materials_title);

        for (int j = 0; j < new_materials_title.size(); j++) {
            if (new_materials_title.size() == old_materials_title.size()) {
                if (eqall) {
                    for (int k = 0; k < new_materials_title.size(); k++) {


                        if (new_materials_title.get(j).equals(old_materials_title.get(k))) {
                            eqall = true;
                            k = new_materials_title.size();
                        } else
                            eqall = false;
                    }
                } else {
                    j = new_materials_title.size();
                }
            } else {
                eqall = false;
                j = new_materials_title.size();
            }
        }

        if (!eqall) {
            //aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
            ApiService apiService = new ApiService(mContext);
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonObject1 = new JSONObject();

            JSONArray jsonArray = new JSONArray();
            for (int j = 0; j < new_materials_title.size(); j++) {

                jsonArray.put(new_materials_title.get(j));
            }



            try {
                jsonObject.put("materials", jsonArray);
                if (search.equals("")) {
                    jsonObject1.put("title", "");
                } else
                    jsonObject1.put("title", search);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray jsonArray1 = new JSONArray();
            jsonArray1.put(jsonObject);
            jsonArray1.put(jsonObject1);


            Log.i(TAG, "show_me_posts_with_materials: " + jsonArray1);

            apiService.give_me_these_posts1(jsonArray1, new ApiService.give_me_these_posts() {

                @Override
                public void posts(int[] a) {
                    referesh(a, search);
                    a1 = a;
                    Log.i(TAG, "posts: " + Arrays.toString(a1));

                }
            });
            this.old_materials_title.clear();
            this.old_materials_title = new_materials_title;


        }


//        Log.i(TAG, "show_me_posts_with_materials:old " + this.old_materials_title);
//        Log.i(TAG, "show_me_posts_with_materials:new " + new_materials_title);


    }

}