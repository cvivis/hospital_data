package com.line.domain;

public class Hospital {



    private String id;

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }

    public int getEmergency_room() {
        return emergency_room;
    }

    public String getName() {
        return name;
    }

    private String address;
    private String district;

    public String getDistrict() {
        return district;
    }

    private String category;
    private int emergency_room;
    private String name;


    public Hospital(String id, String address){
        this.id = id;
        this.address = address;
//        this.id = id.replaceAll("\"","");
    }


    public String getId() {
        return id;
    }
}
