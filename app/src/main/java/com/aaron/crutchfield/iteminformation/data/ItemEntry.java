package com.aaron.crutchfield.iteminformation.data;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Aaron Crutchfield on 6/19/2018.
 */

@Entity
public class ItemEntry {
    @NonNull
    @PrimaryKey
    private String item;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private int warehouse;
    @ColumnInfo
    private int planner;
    @ColumnInfo
    private String unit;
    @ColumnInfo(name = "default_location")
    private String defaultLocation;
    @ColumnInfo
    private String customer;
    @ColumnInfo(name = "primary_production_line")
    private String primaryProductionLine;

    ItemEntry() {

    }

    @Ignore
    public ItemEntry(@NonNull String item, String description, int warehouse, int planner, String defaultLocation, String customer, String primaryProductionLine) {
        this.item = item;
        this.description = description;
        this.warehouse = warehouse;
        this.planner = planner;
        this.defaultLocation = defaultLocation;
        this.customer = customer;
        this.primaryProductionLine = primaryProductionLine;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(int warehouse) {
        this.warehouse = warehouse;
    }

    public int getPlanner() {
        return planner;
    }

    public void setPlanner(int planner) {
        this.planner = planner;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPrimaryProductionLine() {
        return primaryProductionLine;
    }

    public void setPrimaryProductionLine(String primaryProductionLine) {
        this.primaryProductionLine = primaryProductionLine;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
