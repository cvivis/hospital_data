package com.line.domain;

public class Hospital {



    private String id;
    private String subdivision;

    public String getSubdivision() {
        String[] subdivisionList = {"내과", "소아", "피부", "성형", "정형외과", "척추", "교정", "산부인과", "관절", "봉합", "화상", "골절", "영유아", "안과", "가정의학과", "비뇨기과", "치과","외과"};
        for(String subd:subdivisionList){
            if(this.name.contains(subd)){
                return subd;
            }
        }
        return "없음";


    }

    public String getAddress() {
        if(address.contains("'")){
            address = address.replace("'","''");
        }
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
