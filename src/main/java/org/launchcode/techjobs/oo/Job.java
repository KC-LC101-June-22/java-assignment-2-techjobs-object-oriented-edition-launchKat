package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;



public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    @Override
    public String toString(){
    String[] categories = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
    Field[] theFields = Job.class.getDeclaredFields();
    String notAvailable = "Data not available";
    String storedMessage = "\n";
    int index = 0;
        for (Field field : theFields) {
            if (field.getName() == "nextId") {

            } else {
                try {

                    if (field.get(this) instanceof JobField) {

                        if (((JobField) field.get(this)).getValue() == "") {

                            storedMessage = storedMessage + categories[index] + notAvailable + "\n";
                        }  else {

                            storedMessage = storedMessage + categories[index] + field.get(this) + "\n";
                        }
                    }  else if (field.get(this) == null || field.get(this) == "") {

                        storedMessage = storedMessage + categories[index] + notAvailable + "\n";
                    }  else {

                        storedMessage = storedMessage + categories[index] + field.get(this) + "\n";
                    }
                    index++;
                } catch (Exception e) {
                    storedMessage = storedMessage + categories[index] + notAvailable + "\n";
                    index++;
                }
            }
        }
        return storedMessage;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public int getId(){
        return id;
    }

//    private Object getId() {
//        return id;
//    }
    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public String getName(){
        return name;
    }
    public void setName(String value){
        this.name = value;
    }

    public Employer getEmployer(){
        return employer;
    }
    public void setEmployer(Employer value){
        this.employer = value;
    }

    public Location getLocation(){
        return location;
    }
    public void setLocation(Location value){
        this.location = value;
    }

    public PositionType getPositionType(){
        return positionType;
    }
    public void setPositionType(PositionType value){
        this.positionType = value;
    }

    public CoreCompetency getCoreCompetency(){
        return coreCompetency;
    }
    public void setCoreCompetency(CoreCompetency value){
        this.coreCompetency = value;
    }


//    @Override
//    public String toString(){
//        String s = "\nID: " + id +
//                "\nName: " + name +
//                "\nEmployer: " + employer.getValue() +
//                "\nLocation: " + location.getValue() +
//                "\nPosition Type: " + positionType.getValue() +
//                "\nCore Competency: " + coreCompetency.getValue() + "\n";
//        return s;
//    }

}
