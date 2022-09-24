package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {

    //fields
    private int id;
    private static int nextId = 1;
    private String value;

    //constructors
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    //getters/setters
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //custom methods
    @Override
    public String toString() {
        if (value.equals("")) {
            this.value = "Data not available";
        }

        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PositionType)) return false;
        PositionType positionType = (PositionType) o;
        return getId() == positionType.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
