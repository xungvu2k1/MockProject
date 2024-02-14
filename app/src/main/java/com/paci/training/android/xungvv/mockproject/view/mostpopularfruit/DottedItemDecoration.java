package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paci.training.android.xungvv.mockproject.R;

public class DottedItemDecoration extends RecyclerView.ItemDecoration {

    private final Paint paint;
    private final int dividerHeight;

    public DottedItemDecoration(Context context) {
        paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.black)); // Thay R.color.dividerColor bằng màu sắc mong muốn
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.dividerHeight)); // Thay R.dimen.dividerHeight bằng chiều cao mong muốn
        paint.setPathEffect(new android.graphics.DashPathEffect(new float[]{10, 5}, 0));

        dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.dividerHeight); // Thay R.dimen.dividerHeight bằng chiều cao mong muốn
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);

            int position = parent.getChildAdapterPosition(child);

            // Vẽ đường nét đứt ở dưới mỗi item trừ item cuối cùng
            if (position < state.getItemCount() - 1) {
                Path path = new Path();
                path.moveTo(child.getLeft(), child.getBottom());
                path.lineTo(child.getRight(), child.getBottom());

                c.drawPath(path, paint);
            }
        }
    }

    private void drawDivider(Canvas canvas, View child, RecyclerView parent) {
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
        int top = child.getBottom() + params.bottomMargin;
        int bottom = top + dividerHeight;
        canvas.drawLine(child.getLeft(), top, child.getRight(), bottom, paint);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);

        if (position < state.getItemCount() - 1) {
            outRect.bottom = dividerHeight;
        }
    }
}
