package com.smilehacker.lego;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.smilehacker.lego.util.LegoComponentManager;

import java.util.List;

/**
 * Created by zhouquan on 17/2/18.
 */

public abstract class LegoComponent<V extends RecyclerView.ViewHolder, M> {

    public abstract V getViewHolder(ViewGroup container);

    public abstract void onBindData(V viewHolder, M model);

    private Class mModelClass;

    public void onBindData(V viewHolder, M model, List<Object> payloads) {
        onBindData(viewHolder, model);
    }

    public int getViewType() {
        return this.getClass().hashCode();
    }

    public Object getChangePayload(M oldModel, M newModel) {
        return null;
    }

    public Class getModelClass() {
        if (mModelClass == null) {
            mModelClass = LegoComponentManager.getInstance().getModel(this);
        }
        return mModelClass;
    }
}
