package com.grizzly.baseViews;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by FcoPardo on 3/6/16.
 */
public abstract class AbstractConstraintLayout<T> extends BaseConstraintLayout implements BaseView.OnDataDrivenView<T> {

    protected T data;
    protected Class<T> dataClass;

    public AbstractConstraintLayout(Context context) {
        super(context);
    }

    public AbstractConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AbstractConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(T data){
        this.data = data;
        if(data != null)setControls();
    }

    public T getData(){
        return data;
    }

    protected abstract void setControls();
}
