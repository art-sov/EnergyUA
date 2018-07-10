package ua.energy.entity;

import java.util.List;

public class Station {
    private int id;
    private String date;
    private String name;
    private float coalValue;
    private float oilValue;
    private float gasValue;
    private float power;
    private int och;
    private String unitValue;
    private List<Block> blockList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoalValue() {
        return coalValue;
    }

    public void setCoalValue(float coalValue) {
        this.coalValue = coalValue;
    }

    public float getOilValue() {
        return oilValue;
    }

    public void setOilValue(float oilValue) {
        this.oilValue = oilValue;
    }

    public float getGasValue() {
        return gasValue;
    }

    public void setGasValue(float gasValue) {
        this.gasValue = gasValue;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public int getOch() {
        return och;
    }

    public void setOch(int och) {
        this.och = och;
    }

    public String getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(String unitValue) {
        this.unitValue = unitValue;
    }

    public List<Block> getBlockList() {
        return blockList;
    }

    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\ndate: " + date +
                "\nname: " + name +
                "\ncoalValue: " + coalValue +
                "\noilValue: " + oilValue +
                "\ngasValue: " + gasValue +
                "\npower: " + power +
                "\noch: " + och +
                "\nunitValue: " + unitValue;
                //"\nBlocks: " + blockList.toString();
    }
}
