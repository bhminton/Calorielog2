package com.example.calorielog;

public class DailyLog {



    private int  ID ;
    private String calories;
    public DailyLog(int ID,String calories) {
        this.ID = ID;
        this.calories = calories;

    }

    @Override
    public String toString() {
        return "DailyLog{" +
                "calories='" + calories + '\'' +
                ", ID=" + ID +
                '}';
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
