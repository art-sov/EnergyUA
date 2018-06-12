package ua.energy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class CustomBlock extends android.support.v7.widget.AppCompatTextView {

    private Paint paint;
    //private String text;

    private Rect rectUnit1;
    private Rect rectUnit2;

    private int colorUnit1 = Color.WHITE;
    private int colorUnit2 = Color.WHITE;

    public CustomBlock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        rectUnit1 = new Rect();
        rectUnit2 = new Rect();
       }

    @Override
    protected void onDraw(Canvas canvas) {

        int x = canvas.getWidth();
        int y = canvas.getHeight();

        //рисуем заливку первого блока
        paint.setColor(colorUnit1);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        rectUnit1.set(0, 0, x / 100*25, y/2);
        canvas.drawRect(rectUnit1, paint);


        //рисуем заливку второго блока
        paint.setColor(colorUnit2);
        rectUnit2.set(0, y/2, x/100*25, y);
        canvas.drawRect(rectUnit2, paint);

        //рисуем черные контуры всего блока
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, x, y, paint);
        canvas.drawRect(rectUnit1, paint);
        canvas.drawRect(rectUnit2, paint);

        //TODO как сетить текст
//        paint.setTextSize(7);
//        canvas.drawText("568",x /100 * 27, y /2, paint);
    }

    public void setColorUnit1 (int colorUnit1) {
        this.colorUnit1 = colorUnit1;
    }

    public void setColorUnit2 (int colorUnit2) {
        this.colorUnit2 = colorUnit2;
    }




}
