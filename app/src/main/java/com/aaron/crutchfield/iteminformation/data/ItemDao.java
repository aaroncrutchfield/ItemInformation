package com.aaron.crutchfield.iteminformation.data;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

/**
 * Created by Aaron Crutchfield on 6/19/2018.
 */

@Dao
public interface ItemDao {
    @Query("SELECT * FROM itementry ORDER BY item")
    LiveData<List<ItemEntry>> getAllItems();

    @Query("SELECT * FROM itementry WHERE item = :item")
    LiveData<ItemEntry> getByItemNumber(String item);

    @Query("SELECT * FROM itementry WHERE item LIKE + :item ORDER BY item")
    LiveData<List<ItemEntry>> getByLikeItemNumbers(String item);

    @Query("SELECT * FROM itementry WHERE description LIKE + :description ORDER BY item")
    LiveData<List<ItemEntry>> getByLikeDescription(String description);

    @Query("SELECT * FROM itementry WHERE default_location = :defaultLocation ORDER BY item")
    LiveData<List<ItemEntry>> getByDefaultLocation(String defaultLocation);

    @Query("SELECT * FROM itementry WHERE customer = :customer ORDER BY item")
    LiveData<List<ItemEntry>> getByCustomer(String customer);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertItemEntries(List<ItemEntry> itemEntryList);

    @Delete
    void deleteItemEntry(ItemEntry itemEntry);

    @Update
    void updateItemEntry(ItemEntry itemEntry);
}
