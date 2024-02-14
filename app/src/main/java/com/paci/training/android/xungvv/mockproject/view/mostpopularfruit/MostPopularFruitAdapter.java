package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;

import java.util.List;

public class MostPopularFruitAdapter extends RecyclerView.Adapter<MostPopularFruitAdapter.FruitViewHolder> {

    private List<Fruit> fruits;
    private Context context;

    public MostPopularFruitAdapter(Context context, List<Fruit> fruits){
        this.context = context;
        this.fruits = fruits;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        return new FruitViewHolder(itemView);
    }

    @Override
//    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
//        Fruit item = fruits.get(position);
//        holder.checkBoxItem.setText(item.getName());
//
//        // Tắt khả năng click vào văn bản khi checkbox không được chọn
//        holder.checkBoxItem.setEnabled(false);
//        holder.checkBoxItem.setFocusable(false);
//        holder.checkBoxItem.setFocusableInTouchMode(false);
//
//        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            // Lưu trạng thái mới vào ContentProvider khi checkbox thay đổi
//
//            // Enable/disable khả năng click vào văn bản tùy thuộc vào trạng thái của checkbox
//            holder.checkBoxItem.setEnabled(isChecked);
//            holder.checkBoxItem.setFocusable(isChecked);
//            holder.checkBoxItem.setFocusableInTouchMode(isChecked);
//
//            // Gọi hành động khi checkbox được chọn hoặc bỏ chọn
//            if (isChecked) {
//                // Thực hiện hành động khi checkbox được chọn
//                Toast.makeText(context, "Checkbox selected at position " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//            } else {
//                // Thực hiện hành động khi checkbox bị bỏ chọn
//                Toast.makeText(context, "Checkbox deselected at position " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit item = fruits.get(position);
        holder.checkBoxItem.setText(item.getName());

        // Tắt khả năng click vào văn bản khi checkbox không được chọn
        holder.checkBoxItem.setFocusable(false);
        holder.checkBoxItem.setFocusableInTouchMode(false);

        // Đặt trạng thái enabled của checkbox
        holder.checkBoxItem.setEnabled(item.isChecked()); // Đặt giá trị tùy thuộc vào trạng thái của mục

        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Lưu trạng thái mới vào ContentProvider khi checkbox thay đổi

            // Enable/disable khả năng click vào văn bản tùy thuộc vào trạng thái của checkbox
            holder.checkBoxItem.setFocusable(isChecked);
            holder.checkBoxItem.setFocusableInTouchMode(isChecked);

            // Gọi hành động khi checkbox được chọn hoặc bỏ chọn
            if (isChecked) {
                // Thực hiện hành động khi checkbox được chọn
                Toast.makeText(context, "Checkbox selected at position " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            } else {
                // Thực hiện hành động khi checkbox bị bỏ chọn
                Toast.makeText(context, "Checkbox deselected at position " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        private final CheckBox checkBoxItem;
        public FruitViewHolder(@NonNull View view) {
            super(view);
            checkBoxItem = (CheckBox) view.findViewById(R.id.check_box_fruit_item);
            view.setBackgroundResource(R.drawable.dashed_border);
        }
    }
}
