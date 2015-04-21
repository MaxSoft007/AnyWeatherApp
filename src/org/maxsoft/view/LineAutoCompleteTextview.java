package org.maxsoft.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.AutoCompleteTextView;

public class LineAutoCompleteTextview extends AutoCompleteTextView {

	private Paint mPaint;

	public LineAutoCompleteTextview(Context context) {
		super(context);
		mPaint = new Paint();

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
	}
	
   @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // »­µ×Ïß
        canvas.drawLine(0, this.getHeight() - 1, this.getWidth() - 1, this.getHeight() - 1, mPaint);
    }
}
