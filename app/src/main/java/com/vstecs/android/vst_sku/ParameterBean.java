package com.vstecs.android.vst_sku;

import java.util.ArrayList;


import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/9
 * class description:请输入类描述
 */
public class ParameterBean {
    private String title;
    private ArrayList<ParameterValueBean> values;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<ParameterValueBean> getValues() {
        return values;
    }

    public void setValues(ArrayList<ParameterValueBean> values) {
        this.values = values;
    }
}

