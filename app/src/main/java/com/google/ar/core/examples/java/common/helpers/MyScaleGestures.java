package com.google.ar.core.examples.java.common.helpers;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import com.google.ar.core.examples.java.common.helpers.GlobalClass;

public class MyScaleGestures implements View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener {
    //region..생략..
    private View view;
    private ScaleGestureDetector gestureScale;
    private float scaleFactor = 1;
    private boolean inScale;
    private static final String TAG = "MyScaleGestures";

    public MyScaleGestures(Context c) {
        gestureScale = new ScaleGestureDetector(c, this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        this.view = view;
        gestureScale.onTouchEvent(event);
        return true;
    }
    //endregion..생략..
    @Override
    public boolean onScale(ScaleGestureDetector detector) {

        scaleFactor *= detector.getScaleFactor();

        scaleFactor = (scaleFactor < 1 ? 1 : scaleFactor);
        scaleFactor = ((float) ((int) (scaleFactor * 100))) / 100;
        GlobalClass.scaleFactor = scaleFactor;
//        GlobalClass.scaleFactor = scaleFactor + 0.02f*scaleFactor;
        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        inScale = true;
        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        inScale = false;
    }
}