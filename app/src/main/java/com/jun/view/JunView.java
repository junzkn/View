package com.jun.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class JunView extends View {

    private Bitmap switchBackground;
    private boolean switchState = false;
    private Bitmap slideButton;
    private Paint paint ;
    private float currentX;
    private boolean isTouch = false;
    private JunView.onSwitchListener onSwitchListener;



    /**
     * Activity中的onResume()后才执行
     * measure测量 --> layout摆放(ViewGroup才有)  -->draw绘制
     *
     *
     */
    //指定自己的宽高
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(switchBackground.getWidth(),switchBackground.getHeight()) ;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(switchBackground,0,0,paint);
        if(isTouch){
            float x =  (currentX-slideButton.getWidth()/2.0f )>0 ? (currentX-slideButton.getWidth()/2.0f ):0;
            x =  x>switchBackground.getWidth()-slideButton.getWidth() ? switchBackground.getWidth()-slideButton.getWidth():x;
            canvas.drawBitmap(slideButton,x,0,paint);
        }else {
            if(switchState){
                canvas.drawBitmap(slideButton,switchBackground.getWidth()-slideButton.getWidth(),0,paint);
            } else {
                canvas.drawBitmap(slideButton,0,0,paint);
            }
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                isTouch = true ;
                currentX = event.getX();
                break ;
            case MotionEvent.ACTION_MOVE:
                currentX = event.getX();
                break ;
            case MotionEvent.ACTION_UP:
                boolean mState =  currentX>switchBackground.getWidth()/2 ;

                if(switchState != mState && onSwitchListener!=null){
                    onSwitchListener.onStatueUpdate(switchState);
                }
                switchState = mState ;
                isTouch = false ;
                break ;
            default :
                break ;
        }

        invalidate(); //调用onDraw()
        return true;
    }

    private void init() {
        paint = new Paint() ;
    }




    //用于代码创建控件
    public JunView(Context context) {
        super(context);
        init() ;
    }


    // 用于在xml中使用，可指定自定义属性
    public JunView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init() ;
        boolean state = attrs.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "state", false);
        int switch_background = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "switch_background", -1);
        int slide_button = attrs.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "slide_button", -1);
        switchState = state ;
        this.setSwitchBackground(switch_background);
        this.setSlideButton(slide_button);
    }










    public void setSwitchBackground(int switchBackground) {
        this.switchBackground = BitmapFactory.decodeResource(getResources(),switchBackground);
    }

    public void setSwitchState(boolean switchState) {
        this.switchState = switchState;
    }

    public void setSlideButton(int slideButton) {
        this.slideButton =  BitmapFactory.decodeResource(getResources(),slideButton);

    }

    public void setOnSwitchListener(onSwitchListener onSwitchListener) {
        this.onSwitchListener = onSwitchListener;
    }

    public interface onSwitchListener{
        void onStatueUpdate(boolean state) ;
    }

}
