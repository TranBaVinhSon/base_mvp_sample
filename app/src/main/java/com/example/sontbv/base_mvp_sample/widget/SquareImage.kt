package com.example.sontbv.base_mvp_sample.widget

import android.content.Context
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.widget.ImageView

class SquareImage:ImageView {
    constructor(context:Context) : super(context) {}
    constructor(context:Context, @Nullable attrs:AttributeSet) : super(context, attrs) {}
    constructor(context: Context, @Nullable attrs: AttributeSet, defStyleAttr:Int) : super(context, attrs, defStyleAttr) {}
    override fun onMeasure(widthMeasureSpec:Int, heightMeasureSpec:Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth())
    }
}