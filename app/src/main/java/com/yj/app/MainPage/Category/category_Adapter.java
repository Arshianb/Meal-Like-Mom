package com.yj.app.MainPage.Category;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.github.florent37.shapeofview.shapes.RoundRectView;
import com.yj.app.R;

public class category_Adapter extends BaseQuickAdapter<category_ithem, BaseViewHolder> {


    public category_Adapter() {
        super(R.layout.category_ithem, Data_category.getSampleData1());

        Log.i(TAG, "category_Adapter: " + Data_category.getSampleData1().size());
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, category_ithem item) {
       RoundRectView RoundRectView = (RoundRectView) helper.getView(R.id.roundRect);

//            ValueAnimator valueAnimator = ValueAnimator.ofObject(new ArgbEvaluator(), 100, 30);
//            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                    if(helper.getLayoutPosition() == 0 || helper.getLayoutPosition() == 2 || helper.getLayoutPosition() == 4 ) {
//                        RoundRectView.setBottomLeftRadius((int) valueAnimator.getAnimatedValue());
//                    }else
//                        RoundRectView.setBottomRightRadius((int) valueAnimator.getAnimatedValue());
//                }
//            });
//            valueAnimator.setDuration(600);
//            valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//            valueAnimator.start();




        switch (helper.getLayoutPosition()) {

            case 0:
                helper.setImageDrawable(R.id.pic,Data_category.getSampleData1().get(0).getDrawable() );
                helper.setText(R.id.what_is_it,Data_category.getSampleData1().get(0).getCat_title() );
                break;

                case 1:
                    helper.setImageDrawable(R.id.pic,Data_category.getSampleData1().get(1).getDrawable() );
                    helper.setText(R.id.what_is_it,Data_category.getSampleData1().get(1).getCat_title() );
                    break;
                    case 2:
                        helper.setImageDrawable(R.id.pic,Data_category.getSampleData1().get(2).getDrawable() );
                        helper.setText(R.id.what_is_it,Data_category.getSampleData1().get(2).getCat_title() );
                        break;

                        case 3:
                            helper.setImageDrawable(R.id.pic,Data_category.getSampleData1().get(3).getDrawable() );
                            helper.setText(R.id.what_is_it,Data_category.getSampleData1().get(3).getCat_title() );
                            break;

                            case 4:
                                helper.setImageDrawable(R.id.pic,Data_category.getSampleData1().get(4).getDrawable() );
                                helper.setText(R.id.what_is_it,Data_category.getSampleData1().get(4).getCat_title() );
                                break;

                                case 5:
                                    helper.setImageDrawable(R.id.pic,Data_category.getSampleData1().get(5).getDrawable() );
                                    helper.setText(R.id.what_is_it,Data_category.getSampleData1().get(5).getCat_title() );
                                    break;

        }
    }
}
