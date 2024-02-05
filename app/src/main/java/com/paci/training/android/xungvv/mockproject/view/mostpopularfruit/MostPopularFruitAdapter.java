package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;

import java.util.List;

public class MostPopularFruitAdapter extends RecyclerView.Adapter<MostPopularFruitAdapter.FruitViewHolder> {

    private List<Fruit> fruits;

    void setData(List<Fruit> fruits){
        this.fruits = fruits;
        notifyDataSetChanged();
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
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {
        public CheckBox checkBox;
        public FruitViewHolder(View view) {
            super(view);
            checkBox = view.findViewById(R.id.check_box_fruit_item);
        }
    }


}
