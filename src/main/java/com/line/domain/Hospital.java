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


    public Hospital(String id, String address,String category,String emergency_room,String name){
        this.id = id;
        this.address = address;

        String[] splitted = this.address.split(" ");
        this.district = String.format("%s %s",splitted[0], splitted[1]);

        this.category = category;
        this.emergency_room = Integer.parseInt(emergency_room);
        this.name = name;

    }


    public String getId() {
        return id;
    }
}
