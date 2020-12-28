package com.yj.app.MainPage.Category;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yj.app.R;
import com.yj.app.base.BaseFragment;
import com.yj.app.utils.AnimationHelper;

public class category extends BaseFragment {

    public static category newInstance() {
        Bundle args = new Bundle();
        category fragment = new category();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.category;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        Data_category data_category = new Data_category(mContext);

        category_Adapter category_adapter = new category_Adapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.Category_recyceler);

        category_adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);

        final GridLayoutManager manager = new GridLayoutManager(mContext, 2);
        recyclerView.setLayoutManager(manager);
        category_adapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return 1;
            }
        });
        category_adapter.isFirstOnly(false);
        recyclerView.setAdapter(category_adapter);


    }

//    @Override
//    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
//        if(enter)
//            return AnimationHelper.createRotate3dEnterAnimation();
//        else
//            return AnimationHelper.createRotate3dExitAnimation();
//    }

}
