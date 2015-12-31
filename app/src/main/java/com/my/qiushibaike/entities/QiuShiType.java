package com.my.qiushibaike.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RACHEL on 2015/12/30.
 */
public class QiuShiType {

    private String title;
    private String type;

    private QiuShiType(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    private static List<QiuShiType> list;

    // 静态代码块初始化
    static {
        list = new ArrayList<>();
        list.add(new QiuShiType("专享", "suggest"));
        list.add(new QiuShiType("纯文", "text"));
        list.add(new QiuShiType("纯图", "image"));
        list.add(new QiuShiType("视频", "video"));
        list.add(new QiuShiType("最新", "latest"));
    }

    public static List<QiuShiType> getList(){
        return list;
    }
}
