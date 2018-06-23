package com.aaron.crutchfield.iteminformation.data;

import android.app.Application;

import com.aaron.crutchfield.iteminformation.AppExecutors;

import java.util.List;

import androidx.lifecycle.LiveData;

/**
 * Created by Aaron Crutchfield on 6/19/2018.
 */
public class ItemRepository {

    private ItemDao itemDao;

    public ItemRepository(Application application) {
        AppDatabase database = AppDatabase.getInstance(application);
        itemDao = database.itemDao();
    }

    public LiveData<List<ItemEntry>> getAllItems(){
        return itemDao.getAllItems();
    }

    public LiveData<ItemEntry> getByItemNumber(String item) {
        return itemDao.getByItemNumber(item);

    }

    public LiveData<List<ItemEntry>> getByLikeItemNumbers(String item) {
        return itemDao.getByLikeItemNumbers(item);

    }

    public LiveData<List<ItemEntry>> getByLikeDescription(String description) {
        return itemDao.getByLikeDescription(description);

    }

    public LiveData<List<ItemEntry>> getByDefaultLocation(String defaultLocation) {
        return itemDao.getByDefaultLocation(defaultLocation);

    }

    public LiveData<List<ItemEntry>> getByCustomer(String customer) {
        return itemDao.getByCustomer(customer);

    }

    public void insertItemEntries(final List<ItemEntry> itemEntryList) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                itemDao.insertItemEntries(itemEntryList);
            }
        });
    }

    public void deleteItemEntry(final ItemEntry itemEntry) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                itemDao.deleteItemEntry(itemEntry);
            }
        });
    }

    public void updateItemEntry(final ItemEntry itemEntry) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                itemDao.updateItemEntry(itemEntry);
            }
        });
    }


}
