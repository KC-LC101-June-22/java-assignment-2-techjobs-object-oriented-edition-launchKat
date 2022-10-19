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
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }
    @Override
    public String toString(){

        String s = "";
        if(name.isEmpty() || name == null || name == ""){
            name = "Data not available";
        }
        if(employer.getValue() == null || employer.getValue() == ""){
            employer.setValue("Data not available");
        }
        if(location.getValue() == null || location.getValue() == "") {
            location.setValue("Data not available");
        }
        if(positionType.getValue() == null || positionType.getValue() == ""){
            positionType.setValue("Data not available");
        }
        if(coreCompetency.getValue() == null || coreCompetency.getValue() == ""){
            coreCompetency.setValue("Data not available");
        }

       s = String.format("\nID: %s\n" +
               "Name: %s\n" +
               "Employer: %s\n" +
               "Location: %s\n" +
               "Position Type: %s\n" +
               "Core Competency: %s\n", id, name, employer, location, positionType, coreCompetency);
       return s;
    }



    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
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
        if(name.isEmpty()){
            return "Data not available";
        }
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


/*
    @Override
    public String toString(){
        String s = "\nID: " + id +
                "\nName: " + name +
                "\nEmployer: " + employer.getValue() +
                "\nLocation: " + location.getValue() +
                "\nPosition Type: " + positionType.getValue() +
                "\nCore Competency: " + coreCompetency.getValue() + "\n";
        return s;
    }
*/

}
