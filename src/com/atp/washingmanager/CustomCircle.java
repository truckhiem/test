package com.atp.washingmanager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CustomCircle extends View {

    private static final int START_ANGLE_POINT = -90;
    private final int strokeWidth = 10;
    private final Paint paint;
    private RectF rect;

    private float angle;
	private int parentWidth = 0;
	private int parentHeight = 0;
	

    public CustomCircle(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        //Circle color
        paint.setColor(Color.GRAY);

        //size 200x200 example
//        rect = new RectF(strokeWidth, strokeWidth, parentWidth/3 + strokeWidth, parentHeight/3 + strokeWidth);

        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    	parentWidth = this.getWidth();
        parentHeight = this.getHeight();
        if(parentWidth != 0 && parentWidth != 0){
	        rect = new RectF(strokeWidth, strokeWidth, parentWidth - strokeWidth, parentHeight - strokeWidth);
        }
        if(rect != null)
        	canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
    
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
////        if(parentWidth == 0 && parentWidth == 0){
//	    	parentWidth = MeasureSpec.getSize(widthMeasureSpec);
//	        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
////        }
//        this.setMeasuredDimension(parentWidth, parentHeight);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }
}