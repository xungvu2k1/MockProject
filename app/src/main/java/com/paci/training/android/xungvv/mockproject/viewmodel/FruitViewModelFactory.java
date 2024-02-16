package com.paci.training.android.xungvv.mockproject.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.paci.training.android.xungvv.mockproject.model.repository.FruitRepository;

import java.util.Objects;

public class FruitViewModelFactory implements ViewModelProvider.Factory {
    private final FruitRepository repository;
    public FruitViewModelFactory(FruitRepository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(FruitsViewModel.class)){
            return (T) new FruitsViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
