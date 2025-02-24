package com.mycompany.prac2;

import java.util.ArrayList;

public class Heretic {
    private String name;
    private String crimes;
    private String lastSeenLocation;
    private String id;
    private String threatLevel;
    private static ArrayList<Heretic> hereticList = new ArrayList<>(); 

    public Heretic(String name, String crimes, String lastSeenLocation, String id, String threatLevel) {
        this.name = name;
        this.crimes = crimes;
        this.lastSeenLocation = lastSeenLocation;
        this.id = id;
        this.threatLevel = threatLevel;
    }

    public String getName() {
        return name;
    }

    public String getCrimes() {
        return crimes;
    }

    public String getLastSeenLocation() {
        return lastSeenLocation;
    }

    public String getId() {
        return id;
    }

    public String getThreatLevel() {
        return threatLevel;
    }
    @Override
    public String toString(){
        return getName() + ",, " +getCrimes() + ",, " + getLastSeenLocation() + ",, " + getId() + ",, " + getThreatLevel();
    }
    
    public void addToList(Heretic ex){
        this.hereticList.add(ex);
    }
    
    public ArrayList<Heretic> getList(){
        return this.hereticList;
    }
    public static void printList(){
        for(Heretic her: Heretic.hereticList){
            System.out.println(her);
        }
    }
}
