package com.paci.training.android.xungvv.mockproject.view.mostpopularfruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MostPopularFruitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_popular_fruits);

        RecyclerView mostPopularFruitRecyclerView = findViewById(R.id.rcv_most_popular_fruit);
        mostPopularFruitRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Fruit> fruits = getFruits();

        MostPopularFruitAdapter mostPopularFruitAdapter = new MostPopularFruitAdapter(this, fruits);
        mostPopularFruitRecyclerView.setAdapter(mostPopularFruitAdapter);

        mostPopularFruitRecyclerView.addItemDecoration(new DottedItemDecoration(this));
    }

    private List<Fruit> getFruits() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit(0, "Avocado", "this is apples", false));
        list.add(new Fruit(1, "Avocado", "this is avocado", false));
        list.add(new Fruit(2, "Apples", "this is apples", false));
        list.add(new Fruit(3, "Apples", "this is apples", false));
        list.add(new Fruit(4, "Apples", "this is apples", false));
        return list;
    }
}