package com.jun.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class MyFrameLayout extends FrameLayout {
    private static final String TAG = "MyFrameLayout" ;


    public MyFrameLayout(@NonNull Context context) {
        this(context,null);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case ACTION_DOWN:
                Log.e(TAG,"ACTION_DOWN") ;
                break ;
            case ACTION_MOVE:
                Log.e(TAG,"ACTION_MOVE") ;
                break;
            case ACTION_UP:
                Log.e(TAG,"ACTION_UP") ;
                break ;
            default:
                break ;
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean intercepted = false;
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                intercepted = false;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                intercepted = true;
                break;
            }
            case MotionEvent.ACTION_UP: {
                intercepted = false;
                break;
            }
            default:
                break;
        }
        return intercepted;
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//
//        int action = event.getAction();
//        if (action == MotionEvent.ACTION_DOWN) {
//            return false;
//        } else {
//            return true;
//        }
//    }



}
