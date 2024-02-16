package com.paci.training.android.xungvv.mockproject.viewmodel;

import androidx.lifecycle.ViewModel;

import com.paci.training.android.xungvv.mockproject.model.Fruit;
import com.paci.training.android.xungvv.mockproject.model.repository.FruitRepository;

import java.util.List;

public class FruitsViewModel extends ViewModel {
    private final FruitRepository repository;
    private List<Fruit> fruits;

    public FruitsViewModel(FruitRepository repository){
        this.repository = repository;
    }

    public List<Fruit> getFruits(){
        return fruits;
    }

    public void setFruits(List<Fruit> fruits){
        this.fruits = repository.getFruits();
    }
}
