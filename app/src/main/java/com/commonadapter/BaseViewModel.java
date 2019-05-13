package com.commonadapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


/**
 * Created by goldze on 2017/6/15.
 */
public class BaseViewModel extends BaseObservable implements IBaseViewModel {
    public Context context;
    protected Fragment fragment;
    public final ObservableBoolean loading = new ObservableBoolean();
    public final ObservableBoolean empty = new ObservableBoolean();
    public final ObservableBoolean error = new ObservableBoolean();
    public final ObservableField<String> msg = new ObservableField<>();

    public BaseViewModel() {
    }


    public BaseViewModel(Context context) {
        this.context = context;
        initDialog();
    }

    public BaseViewModel(Fragment fragment) {
        this(fragment.getContext());
        this.fragment = fragment;
    }

    private void initDialog() {
    }

    public void afterCreate() {
        afterCreate(true);
    }

    public void afterCreate(boolean autoRequest) {
    }


    public void showToast(String msg) {
//        ToastUtils.showDefaultToast(msg);
    }


    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        context.startActivity(new Intent(context, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(context, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }

    public void startActivityForResult(Class<?> clz, int requestCode) {
        Intent intent = new Intent(context, clz);
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void registerRxBus() {
    }

    @Override
    public void removeRxBus() {
    }

    protected void notifyMsg(@Nullable String s) {
        if (s != null && s.equals(msg.get())) {
            msg.notifyChange();
        } else {
            msg.set(s);
        }
    }
}
