package com.yj.app.MainPage.Search;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.FrameLayout;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.jkb.fragment.rigger.rigger.Rigger;
import com.yalantis.filter.adapter.FilterAdapter;
import com.yalantis.filter.widget.FilterItem;
import com.yj.app.ApiService;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;
import com.yj.app.foods.choose;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.chad.library.adapter.base.listener.SimpleClickListener.TAG;
import static com.yj.app.foods.choose.mFilter;

public class Search extends BaseFragment{

    public Search() {
    }
    private String search ="" ;

    public static Search newInstance() {
        Bundle args = new Bundle();
        Search fragment = new Search();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.search;
    }

    private FloatingSearchView floatingSearchView ;
    private  List<String> materials_title = new ArrayList<>() ;
    private List<String> materials_color = new ArrayList<>() ;
    //    private int [] a = new
    public static AppBarLayout search_appBarLayout;
    public static FrameLayout frameLayout ;

    @Override
    protected void init(Bundle savedInstanceState) {


        choose fragment = choose.newInstance("");
        Rigger.getRigger(this).showFragment(fragment, R.id.frameee);
        floatingSearchView = (FloatingSearchView) findViewById(R.id.floating_search_view) ;

        floatingSearchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, final String newQuery) {

                Log.i(TAG, "onSearchTextChanged:newQuery " + newQuery);


//                floatingSearchView.swapSuggestions();
            }
        });

        floatingSearchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {

            }

            @Override
            public void onSearchAction(String currentQuery) {
                choose fragment = choose.newInstance(currentQuery);
                search = currentQuery;

                Rigger.getRigger(Search.this).showFragment(fragment, R.id.frameee);
                ApiService apiService = new ApiService(mContext);

                JSONObject requestJsonObject = new JSONObject();
                try {
                    requestJsonObject.put("which","all");
                    requestJsonObject.put("food_title" ,search  );
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                search_appBarLayout = (AppBarLayout) findViewById(R.id.search_AppBarLayout);
                Log.i(TAG, "init: " + requestJsonObject);
                apiService.get_these_materials(requestJsonObject, new ApiService.materialss() {
                    @Override
                    public void material(List<String> materials_title , List<String> material_color) {
                        Search.this.materials_title = materials_title ;
                        Search.this.materials_color = material_color ;

                        Adapter adapter = new Adapter(getTags());
                        mFilter.setAdapter(adapter);
//

                        mFilter.build();
                    }
                });
            }
        });

        ApiService apiService = new ApiService(mContext);

        JSONObject requestJsonObject = new JSONObject();
        try {
            requestJsonObject.put("which","all");
            requestJsonObject.put("food_title" ,search  );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "init: " + requestJsonObject);
        search_appBarLayout = (AppBarLayout) findViewById(R.id.search_AppBarLayout);

        apiService.get_these_materials(requestJsonObject, new ApiService.materialss() {
            @Override
            public void material(List<String> materials_title , List<String> material_color) {
                Search.this.materials_title = materials_title ;
                Search.this.materials_color = material_color ;

                Adapter adapter = new Adapter(getTags());
                mFilter.setAdapter(adapter);
//

                mFilter.build();
            }
        });





        //the text to show when there's no selected items



//        search_appBarLayout = (AppBarLayout)findViewById(R.id.search_AppBarLayout);







    }

    private List<Tag> getTags() {
        List<Tag> tags = new ArrayList<>();

        for (int i = 0; i < materials_title.size()+1; ++i) {
            Tag tag ;
            if (i == 0) {
                tag = new Tag("All Materials" ,  ContextCompat.getColor(mContext, android.R.color.darker_gray));
            }else {

                tag = new Tag(materials_title.get(i-1), Integer.valueOf(materials_color.get(i-1)));

            }

            tags.add(tag);
        }

        return tags;
    }



    class Adapter extends FilterAdapter<Tag> {

        Adapter(@NotNull List<? extends Tag> items) {
            super(items);
        }

        @NotNull
        @Override
        public FilterItem createView(int position, Tag item) {

            Log.i(TAG, "createView: ");
            FilterItem filterItem = new FilterItem(mContext);


            filterItem.setStrokeColor(ContextCompat.getColor(mContext, android.R.color.darker_gray));
            filterItem.setTextColor(ContextCompat.getColor(mContext, android.R.color.darker_gray));
            filterItem.setCheckedTextColor(ContextCompat.getColor(mContext, android.R.color.white));
            filterItem.setColor(ContextCompat.getColor(mContext, android.R.color.white));
            filterItem.setCheckedColor(item.getColor());
            filterItem.setText(item.getText());
            filterItem.deselect();

            return filterItem;
        }
    }


}
