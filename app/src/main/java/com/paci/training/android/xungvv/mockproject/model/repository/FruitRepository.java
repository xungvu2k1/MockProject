package com.paci.training.android.xungvv.mockproject.model.repository;

import com.paci.training.android.xungvv.mockproject.R;
import com.paci.training.android.xungvv.mockproject.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository {
    public List<Fruit> getFruits() {
        List<Fruit> list = new ArrayList<>();
        list.add(new Fruit(1, "Tomato", "No information", false, R.drawable.tomato));
        list.add(new Fruit(2, "Banana", "No information", false, R.drawable.bananas));
        list.add(new Fruit(3, "Apple", "No information", false, R.drawable.apples));
        list.add(new Fruit(4, "Watermelon", "No information", false, R.drawable.watermelon));
        list.add(new Fruit(5, "Orange", "No information", false, R.drawable.oranges));
        list.add(new Fruit(6, "Mango", "No information", false, R.drawable.mango));
        list.add(new Fruit(7, "Pear", "No information", false, R.drawable.pears));
        list.add(new Fruit(8, "Avocado", "No information", false, R.drawable.avocado));
        list.add(new Fruit(9, "Grape", "No information", false, R.drawable.grapes));
        list.add(new Fruit(10, "Pineapple", "No information", false, R.drawable.pineapple));
        list.add(new Fruit(11, "Peach", "No information", false, R.drawable.peach));
        list.add(new Fruit(12, "Pumpkin", "No information", false, R.drawable.pumpkin));
        list.add(new Fruit(13, "Dates", "No information", false, R.drawable.dates));
        list.add(new Fruit(14, "Papaya", "No information", false, R.drawable.papaya));
        list.add(new Fruit(15, "Strawberry","No information", false, R.drawable.strawberry));
        return list;
    }
}
