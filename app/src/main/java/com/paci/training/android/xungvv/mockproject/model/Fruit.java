package com.paci.training.android.xungvv.mockproject.model;

public class Fruit {
    private final int id;
    private final String name;
    private final String detail;
    private boolean isChecked;
    public Fruit(int id, String name, String detail, boolean isChecked){
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.isChecked = isChecked;
    }

    public String getName(){
        return name;
    }

    public String getDetail(){
        return detail;
    }

    public boolean isChecked(){
        return isChecked;
    }

    public void setChecked(boolean checked){
        this.isChecked = checked;
    }

    public int getId(){
        return id;
    }
}
