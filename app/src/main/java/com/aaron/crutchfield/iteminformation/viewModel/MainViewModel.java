package com.aaron.crutchfield.iteminformation.viewModel;

import android.app.Application;

import com.aaron.crutchfield.iteminformation.data.ItemEntry;
import com.aaron.crutchfield.iteminformation.data.ItemRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Created by Aaron Crutchfield on 6/19/2018.
 */
public class MainViewModel extends AndroidViewModel {

    private LiveData<List<ItemEntry>> itemLiveDataList;
    private ItemRepository repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(this.getApplication());
        itemLiveDataList = repository.getAllItems();
    }

    public LiveData<List<ItemEntry>> getAllItems(){
        return repository.getAllItems();
    }

    public LiveData<ItemEntry> getByItemNumber(String item) {
        return repository.getByItemNumber(item);

    }

    public LiveData<List<ItemEntry>> getByLikeItemNumbers(String item) {
        return repository.getByLikeItemNumbers(item);

    }

    public LiveData<List<ItemEntry>> getByLikeDescription(String description) {
        return repository.getByLikeDescription(description);

    }

    public LiveData<List<ItemEntry>> getByDefaultLocation(String defaultLocation) {
        return repository.getByDefaultLocation(defaultLocation);

    }

    public LiveData<List<ItemEntry>> getByCustomer(String customer) {
        return repository.getByCustomer(customer);

    }

    public void insertItemEntries(List<ItemEntry> itemEntryList) {
        repository.insertItemEntries(itemEntryList);
    }

    public void deleteItemEntry(ItemEntry itemEntry) {
        repository.deleteItemEntry(itemEntry);
    }

    public void updateItemEntry(ItemEntry itemEntry) {
        repository.updateItemEntry(itemEntry);
    }
}
