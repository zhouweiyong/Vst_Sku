package com.vstecs.android.vst_sku;

import android.app.Activity;
import android.app.Dialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/9
 * class description:sku
 */
public class SkuDialog implements View.OnClickListener {
    private Activity baseAct;
    private Dialog dialog;

    private RelativeLayout dialog_layout_slp;
    private ImageView iv_cancle_slp;
    private ImageView iv_icon_slp;
    private TextView tv_name_slp;
    private TextView tv_price_slp;
    private LinearLayout layout_parameter_slp;

    TestDataUtils testDataUtils = new TestDataUtils();

    public SkuDialog(Activity baseAct) {
        this.baseAct = baseAct;
    }


    public void show() {
        if (dialog == null) {
            init();
        }
        dialog.show();
    }

    private void init() {
        dialog = new Dialog(baseAct, R.style.custom_dialog);
        dialog.setCanceledOnTouchOutside(true);
        //获取对话框的窗口，并设置窗口参数
        Window win = dialog.getWindow();
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        // 不能写成这样,否则Dialog显示不出来
        // LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        //对话框窗口的宽和高
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //对话框窗口显示的位置
        params.x = 120;
        params.y = 100;
        win.setAttributes(params);
        //设置对话框布局
        dialog.setContentView(R.layout.sku_layout_product);
        dialog_layout_slp = (RelativeLayout) dialog.findViewById(R.id.dialog_layout_slp);
        iv_cancle_slp = (ImageView) dialog.findViewById(R.id.iv_cancle_slp);
        iv_icon_slp = (ImageView) dialog.findViewById(R.id.iv_icon_slp);
        tv_name_slp = (TextView) dialog.findViewById(R.id.tv_name_slp);
        tv_price_slp = (TextView) dialog.findViewById(R.id.tv_price_slp);
        layout_parameter_slp = (LinearLayout) dialog.findViewById(R.id.layout_parameter_slp);

        dialog_layout_slp.setOnClickListener(this);
        iv_cancle_slp.setOnClickListener(this);
    }

    public void refreshView() {
        if (dialog == null) {
            init();
        }
        SkuBean skuBean = testDataUtils.getSku();
        //ImageManager.loadImage(iv_icon_slp, skuBean.getImageUrl());
        tv_name_slp.setText(skuBean.getProductName());
        tv_price_slp.setText(String.format("¥ %f", skuBean.getProductPrice()));

        if (layout_parameter_slp.getChildCount() > 0) layout_parameter_slp.removeAllViews();
        int len = skuBean.getParameters().size();
        ArrayList<ParameterBean> parameterBeans = skuBean.getParameters();
        for (int i = 0; i < len; i++) {
            ParameterBean parameterBean = parameterBeans.get(i);
            View view = View.inflate(baseAct, R.layout.sku_item, null);
            TextView tv_title_is = (TextView) view.findViewById(R.id.tv_title_is);
            tv_title_is.setText(parameterBean.getTitle());
            KeywordContainer kc_params_as = (KeywordContainer) view.findViewById(R.id.kc_params_as);
            final int titlePosition = i;
            kc_params_as.setKeywordViewFactory(new KeywordContainer.KeywordViewFactory() {
                @Override
                public TextView makeKeywordView(int position, String text) {
                    CheckBox checkBox = (CheckBox) View.inflate(baseAct, R.layout.sku_checkbox, null);
                    LinearLineWrapLayout.LayoutParams params = new LinearLineWrapLayout.LayoutParams(LinearLineWrapLayout
                            .LayoutParams.WRAP_CONTENT, LinearLineWrapLayout
                            .LayoutParams.WRAP_CONTENT);
                    params.leftMargin = 10;
                    params.rightMargin = 10;
                    params.bottomMargin = 20;
                    checkBox.setLayoutParams(params);
                    checkBox.setTag(R.id.sku_title, titlePosition);
                    checkBox.setTag(R.id.sku_param, position);
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            ViewGroup viewGroup = (ViewGroup) buttonView.getParent();
                            int len = viewGroup.getChildCount();
                            for (int i = 0; i < len; i++) {
                                CompoundButton child = (CompoundButton) viewGroup.getChildAt(i);
//                                if (child!=buttonView&&child.isChecked())child.setChecked(false);
                                child.setChecked(false);
                            }
                            buttonView.setChecked(isChecked);
                            Log.i("zwy", String.format("title=%d   param = %d", buttonView.getTag(R.id.sku_title), buttonView.getTag(R.id.sku_param)));
                        }
                    });
                    return checkBox;
                }
            });
            ArrayList<ParameterValueBean> parameterValueBeans = parameterBean.getValues();
            ArrayList<String> strs = new ArrayList<>();
            for (int j = 0; j < parameterValueBeans.size(); j++) {
                strs.add(parameterValueBeans.get(j).getValue());
            }
            kc_params_as.setKeywords(strs);

//            kc_params_as.setOnClickKeywordListener(new KeywordContainer.OnClickKeywordListener() {
//                @Override
//                public void onClickKeyword(int position, String key) {
//
//                }
//            });
            layout_parameter_slp.addView(view);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_cancle_slp:
                dialog.cancel();
                break;
            case R.id.dialog_layout_slp:
                dialog.cancel();
                break;
        }
    }
}

