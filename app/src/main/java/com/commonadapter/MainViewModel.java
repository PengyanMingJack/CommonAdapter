package com.commonadapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.commonadapter.recycler.PagingViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Peng YanMing on 2018\10\27 0027
 */
public class MainViewModel extends PagingViewModel<String, CommonAdapter> {

    private List<String> list;

    public MainViewModel(Context context) {
        super(context);
    }

    @Override
    protected void initAdapter() {

        adapter = new CommonAdapter<>(context, mList, R.layout.ilist_tem);
    }

    @Override
    protected void getData(int state, final boolean isMore) {
        Log.e("state", state + "");
        doOnSubscribe(isMore);
        //模拟网络请求
        list = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                list.add("测试1");
                accept(isMore, list);
                doOnComplete(true);
            }
        }, 600);

    }

}
