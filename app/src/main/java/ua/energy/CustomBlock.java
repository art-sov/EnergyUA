package ua.energy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class CustomBlock extends android.support.v7.widget.AppCompatTextView {

    Paint paint;
    Paint paintUnit1;
    Paint paintUnit2;

    Rect rectBlock;
    Rect rectUnit1;
    Rect rectUnit2;


    public CustomBlock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        rectBlock = new Rect();
        rectUnit1 = new Rect();
        rectUnit2 = new Rect();
    }



    @Override
    protected void onDraw(Canvas canvas) {

        int x = canvas.getWidth();
        int y = canvas.getHeight();

        //рисуем заливку первого блока
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        rectUnit1.set(0, 0, x / 100*25, y/2);
        canvas.drawRect(rectUnit1, paint);


        //рисуем заливку второго блока
        paint.setColor(Color.GREEN);
        rectUnit2.set(0, y/2, x/100*25, y);
        canvas.drawRect(rectUnit2, paint);

        //рисуем черные контуры
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(0, 0, x, y, paint);
        canvas.drawRect(rectUnit1, paint);
        canvas.drawRect(rectUnit2, paint);

        paint.setTextSize(7);
        canvas.drawText("568",x /100 * 27, y /2, paint);



    }
}
