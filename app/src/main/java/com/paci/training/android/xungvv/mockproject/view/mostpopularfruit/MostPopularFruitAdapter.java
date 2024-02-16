package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;

import java.util.List;

public class MostPopularFruitAdapter extends RecyclerView.Adapter<MostPopularFruitAdapter.FruitViewHolder> {

    private static List<Fruit> fruits;
    private Context context;

    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position, Fruit fruit);
    }

    public MostPopularFruitAdapter(Context context, List<Fruit> fruits){
        this.context = context;
        this.fruits = fruits;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit item = fruits.get(position);
        holder.checkBoxTextView.setText(item.getName());
        holder.checkBoxTextView.setEnabled(false);

        holder.checkBoxItem.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Lưu trạng thái mới vào ContentProvider khi checkbox thay đổi
            holder.checkBoxTextView.setEnabled(true);
        });
    }



    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBoxItem;
        TextView checkBoxTextView;

        public FruitViewHolder(@NonNull View view) {
            super(view);
            checkBoxItem = (CheckBox) view.findViewById(R.id.check_box_fruit_item);
            checkBoxTextView = (TextView) view.findViewById(R.id.text_view_fruit_item);

            checkBoxTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null ){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            Fruit clickedFruit = fruits.get(position);
                            listener.onItemClick(position, clickedFruit);
                        }
                    }
                }
            });
        }
    }
}
