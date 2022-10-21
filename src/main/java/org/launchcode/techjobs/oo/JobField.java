package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    public int id;
    public static int nextId = 1;
    public String value;
//initializing variables for id and nextId and value for the strings
    public JobField() {
        id = nextId;
        nextId++;
        //make id equal to nextId and have nextId increment new id numbers
    }
    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    } //calling toString method from the Job class
    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    //generates hashcode for the input values
    public int getId() {
        return id;
    }
    //method to get value of id

    public String getValue() {
        return value;
    }
    //method to get the value of the string

    public void setValue(String value) {
        this.value = value;
    }
    //method to set value of the string

}
