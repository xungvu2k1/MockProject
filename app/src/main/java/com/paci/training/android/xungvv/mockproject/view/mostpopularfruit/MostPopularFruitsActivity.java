package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;
import com.paci.training.android.xungvv.mockproject.model.repository.FruitRepository;
import com.paci.training.android.xungvv.mockproject.view.detail.DetailActivity;
import com.paci.training.android.xungvv.mockproject.viewmodel.FruitViewModelFactory;
import com.paci.training.android.xungvv.mockproject.viewmodel.FruitsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MostPopularFruitsActivity extends AppCompatActivity {
    private ImageView fruitImage;
    private TextView textViewDetail;

    private FruitsViewModel fruitsViewModel;
    //global var

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_popular_fruits);


        //lưu lại thông tin của activity này
        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", MODE_PRIVATE);


        FruitsViewModel fruitsViewModel = new ViewModelProvider(
                this,
                ViewModelProvider.Factory.from(FruitsViewModel.initializer)
        ).get(FruitsViewModel.class);

        fruitImage = findViewById(R.id.image_view_most_popular_fruit);
        textViewDetail = findViewById(R.id.tv_detail_most_popular_fruits);


        RecyclerView mostPopularFruitRecyclerView = findViewById(R.id.rcv_most_popular_fruit);
        mostPopularFruitRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Fruit> fruits = fruitsViewModel.getFruits();

        MostPopularFruitAdapter mostPopularFruitAdapter = new MostPopularFruitAdapter(this, fruits);
        mostPopularFruitRecyclerView.setAdapter(mostPopularFruitAdapter);

        mostPopularFruitAdapter.setOnItemClickListener(new MostPopularFruitAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position, Fruit fruit) {
                fruitImage.setImageResource(fruit.getFruitImage());
                fruitsViewModel.setCurrentSelectedFruit(fruit);
            }
        });

        textViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostPopularFruitsActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("current_fruit", fruitsViewModel.getCurrentSelectedFruit());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}