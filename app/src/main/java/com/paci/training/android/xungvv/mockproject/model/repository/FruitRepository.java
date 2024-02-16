package com.paci.training.android.xungvv.mockproject.model.repository;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository {
    public List<Fruit> getFruits() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit(0, "Avocado", "this is apples", false, R.drawable.apples));
        list.add(new Fruit(1, "Avocado", "this is avocado", false, R.drawable.bananas));
        list.add(new Fruit(2, "Apples", "this is apples", false, R.drawable.grapes));
        list.add(new Fruit(3, "Apples", "this is apples", false, R.drawable.apples));
        list.add(new Fruit(4, "Apples", "this is apples", false, R.drawable.apples));
        list.add(new Fruit(5, "abcs", "Cacs", true, R.drawable.apples));
        return list;
    }
}
