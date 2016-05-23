package com.vstecs.android.vst_sku;

import java.util.ArrayList;

/**
 * @author zwy
 * @email 16681805@qq.com
 * created on 2016/5/23
 * class description:请输入类描述
 */
public class TestDataUtils {

    public SkuBean getSku() {
        SkuBean skuBean = new SkuBean();
        skuBean.setImageUrl("http://i3.img.969g.com/down/imgx2013/03/28/206_155545_6b858.jpg");
        skuBean.setProductName("台电 X98 AIR 3G(双系统版/32GB) Intel Core i7-5500U(2.4GHz/L3 4M)");
        skuBean.setProductPrice(6388.00);

        ArrayList<ParameterBean> parameterBeans = new ArrayList<>();
        for (int j = 0; j < 6; j++) {
            ParameterBean parameterBean1 = new ParameterBean();
            parameterBean1.setTitle("颜色");
            ArrayList<ParameterValueBean> parameterValueBeans = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                ParameterValueBean parameterValueBean = new ParameterValueBean();
                if (i % 2 == 0) {
                    parameterValueBean.setValue("金色");
                } else {
                    parameterValueBean.setValue("玫瑰金");
                }
                parameterValueBeans.add(parameterValueBean);
            }
            parameterBean1.setValues(parameterValueBeans);
            parameterBeans.add(parameterBean1);
        }
        skuBean.setParameters(parameterBeans);
        return skuBean;
    }

}
