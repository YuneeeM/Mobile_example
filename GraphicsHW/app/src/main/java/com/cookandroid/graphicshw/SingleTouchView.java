package com.cookandroid.graphicshw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SingleTouchView extends View {

    // 두 개의 Paint 객체를 생성합니다.
    private Paint drawPaint = new Paint();
    private Paint erasePaint = new Paint();
    private Path path = new Path();
    private boolean erase = false;

    public SingleTouchView(Context context, AttributeSet attr) {
        super(context,attr);

        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(10f);
        drawPaint.setColor(Color.BLACK);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);

        // 지우개용 Paint 객체에 설정을 적용합니다.
        erasePaint.setAntiAlias(true);
        erasePaint.setStrokeWidth(10f);
        erasePaint.setColor(Color.WHITE); // 배경색과 동일하게 설정합니다.
        erasePaint.setStyle(Paint.Style.STROKE);
        erasePaint.setStrokeJoin(Paint.Join.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 지우개 모드가 아니면 drawPaint를, 지우개 모드면 erasePaint를 사용하여 그립니다.
        canvas.drawPath(path, erase ? erasePaint : drawPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                // ACTION_UP 이벤트에서는 path를 그리지 않습니다.
                break;
            default:
                return false;
        }

        // 터치 이벤트가 발생할 때마다 화면을 갱신합니다.
        invalidate();
        return true;
    }

    // 지우개 모드를 설정하는 메서드를 추가합니다.
    public void setErase(boolean isErase){
        erase = isErase;
    }

    // 지우개 모드 확인을 위한 getter
    public boolean isErase(){
        return erase;
    }

    public void changePenColor(int color) {
        drawPaint.setColor(color);
    }
}
