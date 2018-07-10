package ua.energy.entity;

public class Unit {
    private int id;
    private int power;
    private int ti;
    private int blockNumber;
    private int stationCode;
    private String station;
    private String name;
    private String statusShortName;
    private String statusFullName;
    private String repairStartTime;
    private String repairEndTime;
    private String comment;
    private String operator;
    private String editTime;
    private String color;
    private int och;
    private float workUnit;


    @Override
    public String toString() {
        return super.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setTi(int ti) {
        this.ti = ti;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setStationCode(int stationCode) {
        this.stationCode = stationCode;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatusShortName(String statusShortName) {
        this.statusShortName = statusShortName;
    }

    public void setStatusFullName(String statusFullName) {
        this.statusFullName = statusFullName;
    }

    public void setRepairStartTime(String repairStartTime) {
        this.repairStartTime = repairStartTime;
    }

    public void setRepairEndTime(String repairEndTime) {
        this.repairEndTime = repairEndTime;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOch(int och) {
        this.och = och;
    }

    public void setWorkUnit(float workUnit) {
        this.workUnit = workUnit;
    }
}
