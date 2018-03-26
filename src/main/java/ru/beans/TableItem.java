package ru.beans;

/**
 * Created by DmSeTimofeev on 22.03.2018.
 */
public class TableItem {
    private int id;
    private String name;
    private int count;
    private double price;

    public TableItem(int id, String name, int count, double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
