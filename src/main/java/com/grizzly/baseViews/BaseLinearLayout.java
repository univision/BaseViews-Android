package com.grizzly.baseViews;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

/**
 * Created by FcoPardo on 3/6/16.
 *
 * Base class for creating custom views using a LinearLayout.
 */
public abstract class BaseLinearLayout extends LinearLayout {

    protected int layout = 0;
    protected int parentType = BaseView.PARENT_UNKNOW;

    public BaseLinearLayout(Context context) {
        super(context);
        inflateBaseLayout();
    }

    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflateBaseLayout();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateBaseLayout();
    }

    protected void inflateBaseLayout(){
        setContainer();
        if(layout>0)BaseView.inflateLayout(layout, getContext(), this);
        inflateComponents();
    }

    protected abstract void inflateComponents();

    protected abstract void setContainer();

    protected Activity getActivity(){
        return BaseView.getActivity(this);
    }

    public int getParentType() {
        return parentType;
    }

    public <T extends BaseLinearLayout> T setParentType(@BaseView.ParentType int parentType) {
        this.parentType = parentType;
        return (T) this;
    }
}
