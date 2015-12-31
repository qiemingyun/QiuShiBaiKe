package com.my.qiushibaike.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.my.qiushibaike.R;
import com.my.qiushibaike.adapters.QiuShiAdapter;
import com.my.qiushibaike.entities.QiuShiResult;
import com.my.qiushibaike.tools.HttpUtils;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by RACHEL on 2015/12/30.
 */
public class QiuShiFragment extends Fragment implements Callback<QiuShiResult> {

    private QiuShiAdapter adapter;
    private String type;

    public QiuShiFragment() {
        // Required empty public constructor
    }

    public static QiuShiFragment newInstance(String type) {

        Bundle args = new Bundle();

        QiuShiFragment fragment = new QiuShiFragment();
        args.putString("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qiushi, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        type = getArguments().getString("type");
        ListView list = (ListView) view.findViewById(R.id.list_qiushi);
        adapter = new QiuShiAdapter(getContext());
        list.setAdapter(adapter);
        Call<QiuShiResult> qiushi = HttpUtils.getService().getQiuShi(type, 1);

        qiushi.enqueue(this);
    }

    @Override
    public void onResponse(Response<QiuShiResult> response, Retrofit retrofit) {
        adapter.addAll(response.body().getList());
    }

    @Override
    public void onFailure(Throwable t) {
        t.printStackTrace();
        Toast.makeText(getContext(), "网络问题", Toast.LENGTH_SHORT).show();
    }
}
