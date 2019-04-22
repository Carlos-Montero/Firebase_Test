package com.example.carlos.firebase_test.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/*
Class Drug used for ROOM DB

Atributes:
    Id (PK)
    Drug Name
    Quantity of pills
    Days when user has to take medication
 */

@Entity (tableName = "drugs")
public class Drug {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private String id;

    @ColumnInfo(name = "drug_name")
    private String name;
    @ColumnInfo(name = "drug_quantity")
    private Integer quantity;
    @ColumnInfo(name = "days_of_week")
    private String days;

    public Drug(String id, String name, Integer quantity, String days) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }


}
