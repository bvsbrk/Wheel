
package com.example.wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import static java.lang.Math.cos;
import static java.lang.Math.min;
import static java.lang.Math.sin;

public class Wheel extends View {

    private Paint ringPaint, circlePaint, arcPaint;
    int padding, bounds;
    float sweepAngle, cx, cy;

    RectF ring, circle, arc;

    public Wheel(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {

        arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        ringPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        padding = 100;
        bounds = 1028;

        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setColor(Color.GRAY);
        ringPaint.setStrokeWidth(20);

        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(Color.parseColor("#FFA500"));

        Log.d("padding is " + padding, bounds + " are bounds");
        ring = new RectF(padding, padding, bounds - padding, bounds - padding);
        circle = new RectF();
        sweepAngle = 0;

        cx = 514 + (float) (514 * sin(sweepAngle * 0.0174533));
        System.out.println("Cx is " + cx);
        cy = (float) (514 * cos(sweepAngle * 0.0174533)) - 514 + padding;
        System.out.println("CY is " + cy);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        bounds = min(w, h);

    }

    public void move(int percent) {
        sweepAngle = (float) ((percent / 100.0) * 360);
        cx = 514 + (float) (514 * sin(sweepAngle * 0.0174533));
        System.out.println("Cx is " + cx);
        cy = (((float) (514 * cos(sweepAngle * 0.0174533))) - 514 + padding) * 1;
        cy = 200 - cy;
        System.out.println("CY is " + (100 + 100 - cy));
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.WHITE);
        canvas.drawOval(ring, ringPaint);




        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(20);
        p.setColor(Color.parseColor("#4CAF50"));
        canvas.drawArc(ring, -90, sweepAngle, false, p);
        canvas.drawCircle(cx, cy, 30, circlePaint);
    }
}
