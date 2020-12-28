package com.yj.app.foods;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import com.yj.app.R;

import static com.yj.app.ApiService.Statuses;

public class postAdapter extends BaseMultiItemQuickAdapter<Status, BaseViewHolder> {


    public postAdapter() {
        super(getData.getSampleData());
        addItemType(3, R.layout.headerpic);
        addItemType(2, R.layout.post_ithem);
    }

    private FrameLayout frameLayout;

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Status item) {


        switch (helper.getItemViewType()) {
            case 2:

                TextView textView1 = (TextView) helper.getView(R.id.mat_1);
                TextView textView2 = (TextView) helper.getView(R.id.mat_2);
                TextView textView3 = (TextView) helper.getView(R.id.mat_3);
                TextView textView4 = (TextView) helper.getView(R.id.mat_4);
                TextView textView5 = (TextView) helper.getView(R.id.mat_5);
                TextView textView6 = (TextView) helper.getView(R.id.mat_6);
                TextView textView7 = (TextView) helper.getView(R.id.mat_7);
                TextView textView8 = (TextView) helper.getView(R.id.mat_8);
                TextView textView9 = (TextView) helper.getView(R.id.mat_9);
                TextView textView10 = (TextView) helper.getView(R.id.mat_10);
                TextView textView11 = (TextView) helper.getView(R.id.mat_11);
                TextView textView12 = (TextView) helper.getView(R.id.mat_12);
                TextView textView13 = (TextView) helper.getView(R.id.mat_13);
                TextView textView14 = (TextView) helper.getView(R.id.mat_14);
                TextView textView15 = (TextView) helper.getView(R.id.mat_15);
                TextView textView16 = (TextView) helper.getView(R.id.mat_16);
                TextView textView17 = (TextView) helper.getView(R.id.mat_17);
                TextView textView18 = (TextView) helper.getView(R.id.mat_18);
                TextView textView19 = (TextView) helper.getView(R.id.mat_19);
                TextView textView20 = (TextView) helper.getView(R.id.mat_20);
//



//                frameLayout = (FrameLayout) helper.getView(R.id.material_in_each_post_ithem);
                item = Statuses.get(helper.getLayoutPosition());
                for (int i = 1; i <= item.getMaterial_title().size(); i++) {

                    if (i == 1) {
                        textView1.setVisibility(View.VISIBLE);
                        textView1.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView1.setBackground(drawable1);
                    }
                    if (i == 2) {
                        textView2.setVisibility(View.VISIBLE);
                        textView2.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView2.setBackground(drawable1);

                    }
                    if (i == 3) {
                        Log.i(TAG, "convert:111 " + helper.getLayoutPosition());
                        textView3.setVisibility(View.VISIBLE);
                        Log.i(TAG, "convert:123 " + item.getMaterial_title());
                        textView3.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView3.setBackground(drawable1);
                    }
                    if (i == 4) {
                        textView4.setVisibility(View.VISIBLE);
                        textView4.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView4.setBackground(drawable1);
                    }
                    if (i == 5) {
                        textView5.setVisibility(View.VISIBLE);
                        textView5.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView5.setBackground(drawable1);
                    }
                    if (i == 6) {
                        textView6.setVisibility(View.VISIBLE);
                        textView6.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView6.setBackground(drawable1);
                    }
                    if (i == 7) {
                        textView7.setVisibility(View.VISIBLE);
                        textView7.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView7.setBackground(drawable1);
                    }
                    if (i == 8) {
                        textView8.setVisibility(View.VISIBLE);
                        textView8.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView8.setBackground(drawable1);
                    }
                    if (i == 9) {
                        textView9.setVisibility(View.VISIBLE);
                        textView9.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView9.setBackground(drawable1);
                    }
                    if (i == 10) {
                        textView10.setVisibility(View.VISIBLE);
                        textView10.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView10.setBackground(drawable1);
                    }
                    if (i == 11) {
                        textView11.setVisibility(View.VISIBLE);
                        textView11.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView11.setBackground(drawable1);
                    }
                    if (i == 12) {
                        textView12.setVisibility(View.VISIBLE);
                        textView12.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView12.setBackground(drawable1);
                    }
                    if (i == 13) {
                        textView13.setVisibility(View.VISIBLE);
                        textView13.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView13.setBackground(drawable1);
                    }
                    if (i == 14) {
                        textView14.setVisibility(View.VISIBLE);
                        textView14.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView14.setBackground(drawable1);
                    }
                    if (i == 15) {
                        textView15.setVisibility(View.VISIBLE);
                        textView15.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView15.setBackground(drawable1);
                    }
                    if (i == 16) {
                        textView16.setVisibility(View.VISIBLE);
                        textView16.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView16.setBackground(drawable1);
                    }
                    if (i == 17) {
                        textView17.setVisibility(View.VISIBLE);
                        textView17.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView17.setBackground(drawable1);
                    }
                    if (i == 18) {
                        textView18.setVisibility(View.VISIBLE);
                        textView18.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView18.setBackground(drawable1);
                    }
                    if (i == 19) {
                        textView19.setVisibility(View.VISIBLE);
                        textView19.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView19.setBackground(drawable1);
                    }
                    if (i == 20) {
                        textView20.setVisibility(View.VISIBLE);
                        textView20.setText(item.getMaterial_title().get(i - 1));
                        Log.i(TAG, "convert: " + item.getMaterial_color());
                        GradientDrawable drawable1 = new GradientDrawable();
                        drawable1.setCornerRadius(1000);
                        drawable1.setColor(Integer.valueOf(item.getMaterial_color().get(i - 1)));
                        textView20.setBackground(drawable1);
                    }


                }

                Picasso.with(mContext).load(item.getImage_url().replace("127.0.0.1", mContext.getString(R.string.localhost)))
                        .placeholder(R.drawable.cloud).error(R.drawable.block).into((ImageView) helper.getView(R.id.item_image));
                helper.setText(R.id.title, item.getTitle());
                helper.setText(R.id.content_ofThePost, item.getContent());
                helper.setText(R.id.date_postContent, item.getDate());
                helper.addOnClickListener(R.id.post_ithem);

                break;
            case 3:
                helper.setImageDrawable(R.id.foodheader, item.getHeader_image());
                helper.addOnClickListener(R.id.foodheader);
                break;
        }
    }


    @Override
    public void onClick(View widget) {

    }
}
