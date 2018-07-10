package ua.energy.entity;

public class Block {

    private int stationCode;
    private int number;
    private int power;
    private Unit unit1;
    private Unit unit2;

    public void setStationCode(int stationCode) {
        this.stationCode = stationCode;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setUnit1(Unit unit1) {
        this.unit1 = unit1;
    }

    public void setUnit2(Unit unit2) {
        this.unit2 = unit2;
    }

    public int getStationCode() {
        return stationCode;
    }

    public int getNumber() {
        return number;
    }

    public int getPower() {
        return power;
    }

    public Unit getUnit1() {
        return unit1;
    }

    public Unit getUnit2() {
        return unit2;
    }

    @Override
    public String toString() {
        return "\nstationCode: " + stationCode +
                "\nnumber: " + number +
                "\npower: " + power +
                "\nunit1: " + unit1 +
                "\nunit2: " + unit2;
    }
}
