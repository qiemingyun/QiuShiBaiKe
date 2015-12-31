package com.my.qiushibaike.tools;

import com.my.qiushibaike.entities.QiuShiResult;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by RACHEL on 2015/12/30.
 */
public class HttpUtils {

    public interface Service{
        @GET("/article/list/{type}")
        Call<QiuShiResult> getQiuShi(@Path("type") String type, @Query("page") int page);
    }

    private static Service service;

    static {
        service = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Service.class);
    }

    public static Service getService() {
        return service;
    }
}
