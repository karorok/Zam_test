package com.example.karorok.zamtest;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class GestureListener extends GestureDetector.SimpleOnGestureListener {

    DoubleTabListener tabListener;
    int index = -1;

    public GestureListener(DoubleTabListener tabListener) {
        this.tabListener = tabListener;
    }

    public GestureListener(DoubleTabListener tabListener, int index) {
        this.tabListener = tabListener;
        this.index = index;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        if(index != -1) {
            tabListener.onDoubleTab(index);
        }else{
            tabListener.onDoubleTab();
        }
        return true;
    }


    interface DoubleTabListener{
        void onDoubleTab(int index);
        void onDoubleTab();
    }
}
