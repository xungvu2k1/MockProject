package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_popular_fruits);

        // khởi tạo viewModel
//        FruitsViewModel viewModel = new ViewModelProvider(this, new FruitViewModelFactory(new FruitRepository())).get(FruitsViewModel.class);
        FruitRepository repository = new FruitRepository();

        // Khởi tạo FruitViewModelFactory với FruitRepository
        FruitViewModelFactory factory = new FruitViewModelFactory(repository);

        // Sử dụng FruitViewModelFactory để khởi tạo FruitsViewModel
        fruitsViewModel = new ViewModelProvider(this, ViewModelProvider.NewInstanceFactory.getInstance()).get(FruitsViewModel.class);

        fruitImage = findViewById(R.id.image_view_most_popular_fruit);
        textViewDetail = findViewById(R.id.tv_detail_most_popular_fruits);
        RecyclerView mostPopularFruitRecyclerView = findViewById(R.id.rcv_most_popular_fruit);



        mostPopularFruitRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Fruit> fruits = ;

        MostPopularFruitAdapter mostPopularFruitAdapter = new MostPopularFruitAdapter(this, fruits);
        mostPopularFruitRecyclerView.setAdapter(mostPopularFruitAdapter);

        mostPopularFruitAdapter.setOnItemClickListener(new MostPopularFruitAdapter.OnItemClickListener(){

            @Override
            public void onItemClick(int position, Fruit fruit) {
                fruitImage.setImageResource(fruit.getFruitImage());
            }
        });

        textViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MostPopularFruitsActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}