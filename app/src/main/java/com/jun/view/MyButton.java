package com.jun.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Button;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

public class MyButton extends android.support.v7.widget.AppCompatButton {

    private static final String TAG = "MyButton" ;



    public MyButton(Context context) {
        this(context,null);
    }

    public MyButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init() ;
    }

    private void init() {
        setBackgroundColor(Color.GRAY);
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
        return true ;
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN: {
//                getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//            }
//            case MotionEvent.ACTION_MOVE: {
//                getParent().requestDisallowInterceptTouchEvent(false);
//                break;
//            }
//            case MotionEvent.ACTION_UP: {
//                getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//            }
//            default:
//                break;
//        }
//
//        return super.dispatchTouchEvent(event);
//    }
}
