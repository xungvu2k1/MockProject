package com.paci.training.android.xungvv.mockproject.viewmodel;

import static androidx.lifecycle.SavedStateHandleSupport.createSavedStateHandle;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.ViewModelInitializer;

import com.paci.training.android.xungvv.mockproject.model.Fruit;
import com.paci.training.android.xungvv.mockproject.model.repository.FruitRepository;

import java.util.List;

public class FruitsViewModel extends ViewModel {
    private MutableLiveData<Integer> checkedFruitIDs;
    public MutableLiveData<Integer> getCheckedFruitIDs(){
        if (checkedFruitIDs == null){
            checkedFruitIDs = new MutableLiveData<Integer>();
        }
        return this.checkedFruitIDs;
    }
    private Fruit currentSelectedFruit;
        public Fruit getCurrentSelectedFruit(){
            return currentSelectedFruit;
        }
        public void setCurrentSelectedFruit(Fruit selectedFruit){
            this.currentSelectedFruit = selectedFruit;
        }
    private static FruitRepository repository = new FruitRepository();
    private static SavedStateHandle savedStateHandle;
    public FruitsViewModel(FruitRepository repository, SavedStateHandle savedStateHandle){
        FruitsViewModel.repository = repository;
        FruitsViewModel.savedStateHandle = savedStateHandle;
    }
    public static final ViewModelInitializer<FruitsViewModel> initializer = new ViewModelInitializer<>(
            FruitsViewModel.class,
            creationExtras -> {
                SavedStateHandle savedStateHandle = createSavedStateHandle(creationExtras);
                return new FruitsViewModel(repository, savedStateHandle);
            }
    );
    public List<Fruit> getFruits(){
        return repository.getFruits();
    }
}
