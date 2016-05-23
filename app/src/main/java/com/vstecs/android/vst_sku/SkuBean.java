package com.vstecs.android.vst_sku;

import java.util.ArrayList;


import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/9
 * class description:Sku实体
 */
public class SkuBean {
    private String productName;//:商品名称
    private String imageUrl;//:商品图片(小图)
    private double productPrice;//:商品价格(保留小数点后两位)

    private ArrayList<ParameterBean> parameters;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ArrayList<ParameterBean> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<ParameterBean> parameters) {
        this.parameters = parameters;
    }
}

