package com.dett.mvvmdemo.bean;

import java.util.List;

public class ForecastBean {

    /**
     * code : 1
     * serviceCode : null
     * data : [{"id":1,"title":"测试","imgUrl":"https://shylh1d3.oss-cn-hangzhou.aliyuncs.com/images/a894a7a5-1a76-4788-9830-88e5ac8bb2fc1594889716088.png","links":"","remark":"","orderIndex":null,"deleted":"100002","createDate":1594889708000},{"id":2,"title":"测试","imgUrl":"https://shylh1d3.oss-cn-hangzhou.aliyuncs.com/images/416f40f3-492f-49eb-9f83-87ba843256741594889746330.jpg","links":"","remark":"","orderIndex":null,"deleted":"100002","createDate":1594889743000}]
     * msg :
     * field : null
     */

    public int code;
    public Object serviceCode;
    public String msg;
    public Object field;
    public List<DataBean> data;

    public static class DataBean {
        /**
         * id : 1
         * title : 测试
         * imgUrl : https://shylh1d3.oss-cn-hangzhou.aliyuncs.com/images/a894a7a5-1a76-4788-9830-88e5ac8bb2fc1594889716088.png
         * links :
         * remark :
         * orderIndex : null
         * deleted : 100002
         * createDate : 1594889708000
         */
       public int id;
       public String title;
       public String imgUrl;
       public String links;
       public String remark;
       public Object orderIndex;
       public String deleted;
       public long createDate;


    }
}

