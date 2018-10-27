package com.commonadapter;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.annotation.CallSuper;
import android.view.View;

import com.commonadapter.recycler.RecyclerHeaderFooterAdapter;
import com.commonadapter.recycler.RecyclerHolder;

import java.util.List;

public class CommonAdapter<T, B extends ViewDataBinding> extends RecyclerHeaderFooterAdapter<T, B> {

    private OnItemClickListener mOnItemClickListener;

    public CommonAdapter(Context context, List<T> list, int layoutId) {
        super(context, list, layoutId);
    }

    public List<T> getList() {
        return mList;
    }

    @CallSuper
    @Override
    protected void onBind(RecyclerHolder<B> holder, final int position, final T t) {
        holder.binding.setVariable(com.commonadapter.BR.item, t);

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(v, position, t);
                }
            });
        }
        holder.binding.executePendingBindings();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T t);
    }
}
