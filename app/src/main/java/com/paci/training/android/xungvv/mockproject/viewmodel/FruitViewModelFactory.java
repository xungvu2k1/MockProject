package com.paci.training.android.xungvv.mockproject.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.paci.training.android.xungvv.mockproject.model.repository.FruitRepository;

public class FruitViewModelFactory extends AbstractSavedStateViewModelFactory {
    private final FruitRepository repository;
    public FruitViewModelFactory(FruitRepository repository){
        this.repository = repository;
    }
    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    protected <T extends ViewModel> T create(@NonNull String s, @NonNull Class<T> aClass, @NonNull SavedStateHandle savedStateHandle) {
        return (T) new FruitsViewModel(repository, savedStateHandle);
    }
}
