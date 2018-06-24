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
    @ColumnInfo
    private String default_location;
    @ColumnInfo
    private String customer;
    @ColumnInfo
    private String primary_production_line;

    ItemEntry() {

    }

    @Ignore
    public ItemEntry(@NonNull String item, String description, int warehouse, int planner, String default_location, String customer, String primary_production_line) {
        this.item = item;
        this.description = description;
        this.warehouse = warehouse;
        this.planner = planner;
        this.default_location = default_location;
        this.customer = customer;
        this.primary_production_line = primary_production_line;
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

    public String getDefault_location() {
        return default_location;
    }

    public void setDefault_location(String default_location) {
        this.default_location = default_location;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getPrimary_production_line() {
        return primary_production_line;
    }

    public void setPrimary_production_line(String primary_production_line) {
        this.primary_production_line = primary_production_line;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ItemEntry{" +
                "item='" + item + '\'' +
                ", description='" + description + '\'' +
                ", warehouse=" + warehouse +
                ", planner=" + planner +
                ", unit='" + unit + '\'' +
                ", default_location='" + default_location + '\'' +
                ", customer='" + customer + '\'' +
                ", primary_production_line='" + primary_production_line + '\'' +
                '}';
    }
}
